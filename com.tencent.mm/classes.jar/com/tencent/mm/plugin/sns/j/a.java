package com.tencent.mm.plugin.sns.j;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public ListView hbO;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public SnsHeader zIf;
  public boolean zIg = false;
  
  public final a b(bh parambh)
  {
    AppMethodBeat.i(96173);
    int i = f.iqk;
    if (i == 2)
    {
      AppMethodBeat.o(96173);
      return null;
    }
    if ((i == 4) && (!this.zIg))
    {
      AppMethodBeat.o(96173);
      return null;
    }
    long l = System.nanoTime();
    a locala = new a();
    locala.zIh = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.zIf.getTop();
    int j = this.zIf.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.zIj = i;
    j = this.hbO.getFirstVisiblePosition() - 1;
    int m = this.hbO.getLastVisiblePosition() - 1;
    locala.zIi = j;
    locala.afo = m;
    int n = parambh.getCount();
    boolean bool = false;
    if (this.hbO.getChildAt(0) != null) {
      bool = this.hbO.getChildAt(0) instanceof SnsHeader;
    }
    ae.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.hbO.getChildCount();
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
          ae.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i1) });
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
      if (locala.zIk == null) {
        locala.zIk = new LinkedList();
      }
      b localb = new b();
      locala.zIk.add(localb);
      Object localObject = this.hbO.getChildAt(i);
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
        p localp = parambh.RA(j);
        localb.zIp = r.o(localp);
        localb.zIn = localp.field_type;
        localb.zIo = localp.Rt(32);
        localb.zIl = i;
        localb.zIm = i2;
        localb.aYT = i3;
        localb.aYS = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).AMP) && (((BaseTimeLineItem.BaseViewHolder)localObject).Afr != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).Afr.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).Afr.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).AMG.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).AMG.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).AMI.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).AMI.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).AMI.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).AMI.getWidth();
          ae.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.zIr = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.zIs = i;
            localb.zIt = i2;
            localb.zIu = i4;
            localb.zIv = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.zIq = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.zIx = (i6 + i2);
            localb.zIw = (i5 + i);
            localb.zIy = i8;
            localb.zIz = i7;
          }
        }
      }
    }
    label736:
    ae.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - l));
    AppMethodBeat.o(96173);
    return locala;
  }
  
  public static final class a
  {
    public int afo;
    public int mScreenHeight;
    public int mScreenWidth;
    public long zIh;
    public int zIi;
    public int zIj;
    public List<a.b> zIk;
  }
  
  public static final class b
  {
    public int aYS;
    public int aYT;
    public int zIl;
    public int zIm;
    public int zIn;
    public boolean zIo;
    public String zIp;
    public int zIq;
    public int zIr;
    public int zIs;
    public int zIt;
    public int zIu;
    public int zIv;
    public int zIw;
    public int zIx;
    public int zIy;
    public int zIz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */