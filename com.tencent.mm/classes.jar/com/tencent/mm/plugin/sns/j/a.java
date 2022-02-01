package com.tencent.mm.plugin.sns.j;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.SnsLikesTextView;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public ListView gZb;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public SnsHeader zqQ;
  public boolean zqR = false;
  
  public final a b(bh parambh)
  {
    AppMethodBeat.i(96173);
    int i = f.inq;
    if (i == 2)
    {
      AppMethodBeat.o(96173);
      return null;
    }
    if ((i == 4) && (!this.zqR))
    {
      AppMethodBeat.o(96173);
      return null;
    }
    long l = System.nanoTime();
    a locala = new a();
    locala.zqS = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.zqQ.getTop();
    int j = this.zqQ.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.zqU = i;
    j = this.gZb.getFirstVisiblePosition() - 1;
    int m = this.gZb.getLastVisiblePosition() - 1;
    locala.zqT = j;
    locala.afo = m;
    int n = parambh.getCount();
    boolean bool = false;
    if (this.gZb.getChildAt(0) != null) {
      bool = this.gZb.getChildAt(0) instanceof SnsHeader;
    }
    ad.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.gZb.getChildCount();
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
      if (locala.zqV == null) {
        locala.zqV = new LinkedList();
      }
      b localb = new b();
      locala.zqV.add(localb);
      Object localObject = this.gZb.getChildAt(i);
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
        p localp = parambh.QT(j);
        localb.zra = q.n(localp);
        localb.zqY = localp.field_type;
        localb.zqZ = localp.QM(32);
        localb.zqW = i;
        localb.zqX = i2;
        localb.aYT = i3;
        localb.aYS = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).Avz) && (((BaseTimeLineItem.BaseViewHolder)localObject).zOk != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).zOk.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).zOk.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).Avq.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).Avq.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).Avs.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).Avs.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).Avs.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).Avs.getWidth();
          ad.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.zrc = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.zrd = i;
            localb.zre = i2;
            localb.zrf = i4;
            localb.zrg = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.zrb = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.zri = (i6 + i2);
            localb.zrh = (i5 + i);
            localb.zrj = i8;
            localb.zrk = i7;
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
    public int afo;
    public int mScreenHeight;
    public int mScreenWidth;
    public long zqS;
    public int zqT;
    public int zqU;
    public List<a.b> zqV;
  }
  
  public static final class b
  {
    public int aYS;
    public int aYT;
    public int zqW;
    public int zqX;
    public int zqY;
    public boolean zqZ;
    public String zra;
    public int zrb;
    public int zrc;
    public int zrd;
    public int zre;
    public int zrf;
    public int zrg;
    public int zrh;
    public int zri;
    public int zrj;
    public int zrk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */