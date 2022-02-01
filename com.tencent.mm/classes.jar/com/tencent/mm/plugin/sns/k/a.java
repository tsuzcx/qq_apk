package com.tencent.mm.plugin.sns.k;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.be;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public ListView izP;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public SnsHeader wOn;
  public boolean wOo = false;
  
  public final a a(be parambe)
  {
    AppMethodBeat.i(96173);
    int i = e.htt;
    if (i == 2)
    {
      AppMethodBeat.o(96173);
      return null;
    }
    if ((i == 4) && (!this.wOo))
    {
      AppMethodBeat.o(96173);
      return null;
    }
    long l = System.nanoTime();
    a locala = new a();
    locala.wOp = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.wOn.getTop();
    int j = this.wOn.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.wOr = i;
    j = this.izP.getFirstVisiblePosition() - 1;
    int m = this.izP.getLastVisiblePosition() - 1;
    locala.wOq = j;
    locala.acD = m;
    int n = parambe.getCount();
    boolean bool = false;
    if (this.izP.getChildAt(0) != null) {
      bool = this.izP.getChildAt(0) instanceof SnsHeader;
    }
    ad.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.izP.getChildCount();
      label232:
      if (j > m) {
        break label736;
      }
      k = i;
      if (j < n)
      {
        k = i;
        if (j >= 0)
        {
          if (i < i1) {
            break label304;
          }
          ad.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i1) });
          k = i;
        }
      }
    }
    for (;;)
    {
      j += 1;
      i = k;
      break label232;
      i = 0;
      break;
      label304:
      if (locala.wOs == null) {
        locala.wOs = new LinkedList();
      }
      b localb = new b();
      locala.wOs.add(localb);
      Object localObject = this.izP.getChildAt(i);
      k = i + 1;
      int i2;
      int i3;
      int i4;
      if (localObject != null)
      {
        i = ((View)localObject).getTop();
        i2 = ((View)localObject).getLeft();
        i3 = ((View)localObject).getHeight();
        i4 = ((View)localObject).getWidth();
        p localp = parambe.Ni(j);
        localb.wOx = q.l(localp);
        localb.wOv = localp.field_type;
        localb.wOw = localp.Nb(32);
        localb.wOt = i;
        localb.wOu = i2;
        localb.aNJ = i3;
        localb.aNI = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).xQT) && (((BaseTimeLineItem.BaseViewHolder)localObject).xkf != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).xkf.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).xkf.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).xQK.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).xQK.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).xQM.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).xQM.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).xQM.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).xQM.getWidth();
          ad.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.wOz = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.wOA = i;
            localb.wOB = i2;
            localb.wOC = i4;
            localb.wOD = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.wOy = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.wOF = (i6 + i2);
            localb.wOE = (i5 + i);
            localb.wOG = i8;
            localb.wOH = i7;
          }
        }
      }
    }
    label736:
    ad.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - l));
    AppMethodBeat.o(96173);
    return locala;
  }
  
  public static final class a
  {
    public int acD;
    public int mScreenHeight;
    public int mScreenWidth;
    public long wOp;
    public int wOq;
    public int wOr;
    public List<a.b> wOs;
  }
  
  public static final class b
  {
    public int aNI;
    public int aNJ;
    public int wOA;
    public int wOB;
    public int wOC;
    public int wOD;
    public int wOE;
    public int wOF;
    public int wOG;
    public int wOH;
    public int wOt;
    public int wOu;
    public int wOv;
    public boolean wOw;
    public String wOx;
    public int wOy;
    public int wOz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */