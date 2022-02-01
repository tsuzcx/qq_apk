package com.tencent.mm.plugin.sns.statistics;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public SnsHeader QCY;
  public boolean QCZ = false;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public ListView nlI;
  
  public final a b(bn parambn)
  {
    AppMethodBeat.i(96173);
    int i = m.oUs;
    if (i == 2)
    {
      AppMethodBeat.o(96173);
      return null;
    }
    if ((i == 4) && (!this.QCZ))
    {
      AppMethodBeat.o(96173);
      return null;
    }
    long l = System.nanoTime();
    a locala = new a();
    locala.QDa = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.QCY.getTop();
    int j = this.QCY.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.QDc = i;
    j = this.nlI.getFirstVisiblePosition() - 1;
    int m = this.nlI.getLastVisiblePosition() - 1;
    locala.QDb = j;
    locala.mI = m;
    int n = parambn.getCount();
    boolean bool = false;
    if (this.nlI.getChildAt(0) != null) {
      bool = this.nlI.getChildAt(0) instanceof SnsHeader;
    }
    Log.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.nlI.getChildCount();
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
      if (locala.QDd == null) {
        locala.QDd = new LinkedList();
      }
      b localb = new b();
      locala.QDd.add(localb);
      Object localObject = this.nlI.getChildAt(i);
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
        SnsInfo localSnsInfo = parambn.alF(j);
        localb.QDi = t.x(localSnsInfo);
        localb.QDg = localSnsInfo.field_type;
        localb.QDh = localSnsInfo.isAd();
        localb.QDe = i;
        localb.QDf = i2;
        localb.mViewHeight = i3;
        localb.mViewWidth = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).RLc) && (((BaseTimeLineItem.BaseViewHolder)localObject).RaE != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).RaE.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).RaE.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).RKU.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).RKU.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).RKV.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).RKV.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).RKV.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).RKV.getWidth();
          Log.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.QDk = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.QDl = i;
            localb.QDm = i2;
            localb.QDn = i4;
            localb.QDo = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.QDj = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.QDq = (i6 + i2);
            localb.QDp = (i5 + i);
            localb.QDr = i8;
            localb.QDs = i7;
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
    public long QDa;
    public int QDb;
    public int QDc;
    public List<a.b> QDd;
    public int mI;
    public int mScreenHeight;
    public int mScreenWidth;
  }
  
  public static final class b
  {
    public int QDe;
    public int QDf;
    public int QDg;
    public boolean QDh;
    public String QDi;
    public int QDj;
    public int QDk;
    public int QDl;
    public int QDm;
    public int QDn;
    public int QDo;
    public int QDp;
    public int QDq;
    public int QDr;
    public int QDs;
    public int mViewHeight;
    public int mViewWidth;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.statistics.a
 * JD-Core Version:    0.7.0.1
 */