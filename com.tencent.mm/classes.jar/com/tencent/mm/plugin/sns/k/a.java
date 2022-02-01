package com.tencent.mm.plugin.sns.k;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public SnsHeader Kfp;
  public boolean Kfq = false;
  public ListView kJh;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  
  public final a b(bm parambm)
  {
    AppMethodBeat.i(96173);
    int i = m.mbx;
    if (i == 2)
    {
      AppMethodBeat.o(96173);
      return null;
    }
    if ((i == 4) && (!this.Kfq))
    {
      AppMethodBeat.o(96173);
      return null;
    }
    long l = System.nanoTime();
    a locala = new a();
    locala.Kfr = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.Kfp.getTop();
    int j = this.Kfp.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.Kft = i;
    j = this.kJh.getFirstVisiblePosition() - 1;
    int m = this.kJh.getLastVisiblePosition() - 1;
    locala.Kfs = j;
    locala.lL = m;
    int n = parambm.getCount();
    boolean bool = false;
    if (this.kJh.getChildAt(0) != null) {
      bool = this.kJh.getChildAt(0) instanceof SnsHeader;
    }
    Log.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.kJh.getChildCount();
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
      if (locala.Kfu == null) {
        locala.Kfu = new LinkedList();
      }
      b localb = new b();
      locala.Kfu.add(localb);
      Object localObject = this.kJh.getChildAt(i);
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
        SnsInfo localSnsInfo = parambm.agM(j);
        localb.Kfz = t.w(localSnsInfo);
        localb.Kfx = localSnsInfo.field_type;
        localb.Kfy = localSnsInfo.isAd();
        localb.Kfv = i;
        localb.Kfw = i2;
        localb.aIk = i3;
        localb.aIj = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).Llo) && (((BaseTimeLineItem.BaseViewHolder)localObject).KAX != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).KAX.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).KAX.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).Llf.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).Llf.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).Llh.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).Llh.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).Llh.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).Llh.getWidth();
          Log.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.KfB = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.KfC = i;
            localb.KfD = i2;
            localb.KfE = i4;
            localb.KfF = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.KfA = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.KfH = (i6 + i2);
            localb.KfG = (i5 + i);
            localb.KfI = i8;
            localb.KfJ = i7;
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
    public long Kfr;
    public int Kfs;
    public int Kft;
    public List<a.b> Kfu;
    public int lL;
    public int mScreenHeight;
    public int mScreenWidth;
  }
  
  public static final class b
  {
    public int KfA;
    public int KfB;
    public int KfC;
    public int KfD;
    public int KfE;
    public int KfF;
    public int KfG;
    public int KfH;
    public int KfI;
    public int KfJ;
    public int Kfv;
    public int Kfw;
    public int Kfx;
    public boolean Kfy;
    public String Kfz;
    public int aIj;
    public int aIk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.a
 * JD-Core Version:    0.7.0.1
 */