package com.tencent.mm.plugin.sns.k;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public SnsHeader DSh;
  public boolean DSi = false;
  public ListView hUI;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  
  public final a b(bk parambk)
  {
    AppMethodBeat.i(96173);
    int i = l.jlv;
    if (i == 2)
    {
      AppMethodBeat.o(96173);
      return null;
    }
    if ((i == 4) && (!this.DSi))
    {
      AppMethodBeat.o(96173);
      return null;
    }
    long l = System.nanoTime();
    a locala = new a();
    locala.DSj = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.DSh.getTop();
    int j = this.DSh.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.DSl = i;
    j = this.hUI.getFirstVisiblePosition() - 1;
    int m = this.hUI.getLastVisiblePosition() - 1;
    locala.DSk = j;
    locala.afB = m;
    int n = parambk.getCount();
    boolean bool = false;
    if (this.hUI.getChildAt(0) != null) {
      bool = this.hUI.getChildAt(0) instanceof SnsHeader;
    }
    Log.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.hUI.getChildCount();
      label232:
      if (j > m) {
        break label734;
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
          Log.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i1) });
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
      if (locala.DSm == null) {
        locala.DSm = new LinkedList();
      }
      b localb = new b();
      locala.DSm.add(localb);
      Object localObject = this.hUI.getChildAt(i);
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
        SnsInfo localSnsInfo = parambk.Zv(j);
        localb.DSr = r.v(localSnsInfo);
        localb.DSp = localSnsInfo.field_type;
        localb.DSq = localSnsInfo.isAd();
        localb.DSn = i;
        localb.DSo = i2;
        localb.aYO = i3;
        localb.aYN = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).EXa) && (((BaseTimeLineItem.BaseViewHolder)localObject).EnO != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).EnO.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).EnO.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).EWR.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).EWR.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).EWT.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).EWT.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).EWT.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).EWT.getWidth();
          Log.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.DSt = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.DSu = i;
            localb.DSv = i2;
            localb.DSw = i4;
            localb.DSx = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.DSs = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.DSz = (i6 + i2);
            localb.DSy = (i5 + i);
            localb.DSA = i8;
            localb.DSB = i7;
          }
        }
      }
    }
    label734:
    Log.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - l));
    AppMethodBeat.o(96173);
    return locala;
  }
  
  public static final class a
  {
    public long DSj;
    public int DSk;
    public int DSl;
    public List<a.b> DSm;
    public int afB;
    public int mScreenHeight;
    public int mScreenWidth;
  }
  
  public static final class b
  {
    public int DSA;
    public int DSB;
    public int DSn;
    public int DSo;
    public int DSp;
    public boolean DSq;
    public String DSr;
    public int DSs;
    public int DSt;
    public int DSu;
    public int DSv;
    public int DSw;
    public int DSx;
    public int DSy;
    public int DSz;
    public int aYN;
    public int aYO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */