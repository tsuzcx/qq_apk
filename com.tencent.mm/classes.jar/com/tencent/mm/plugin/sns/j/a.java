package com.tencent.mm.plugin.sns.j;

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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public ListView gFr;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public SnsHeader yaU;
  public boolean yaV = false;
  
  public final a a(be parambe)
  {
    AppMethodBeat.i(96173);
    int i = e.hTV;
    if (i == 2)
    {
      AppMethodBeat.o(96173);
      return null;
    }
    if ((i == 4) && (!this.yaV))
    {
      AppMethodBeat.o(96173);
      return null;
    }
    long l = System.nanoTime();
    a locala = new a();
    locala.yaW = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.yaU.getTop();
    int j = this.yaU.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.yaY = i;
    j = this.gFr.getFirstVisiblePosition() - 1;
    int m = this.gFr.getLastVisiblePosition() - 1;
    locala.yaX = j;
    locala.adx = m;
    int n = parambe.getCount();
    boolean bool = false;
    if (this.gFr.getChildAt(0) != null) {
      bool = this.gFr.getChildAt(0) instanceof SnsHeader;
    }
    ac.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.gFr.getChildCount();
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
          ac.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i1) });
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
      if (locala.yaZ == null) {
        locala.yaZ = new LinkedList();
      }
      b localb = new b();
      locala.yaZ.add(localb);
      Object localObject = this.gFr.getChildAt(i);
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
        p localp = parambe.Pl(j);
        localb.ybe = q.l(localp);
        localb.ybc = localp.field_type;
        localb.ybd = localp.Pe(32);
        localb.yba = i;
        localb.ybb = i2;
        localb.aOz = i3;
        localb.aOy = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).zdJ) && (((BaseTimeLineItem.BaseViewHolder)localObject).ywY != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).ywY.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).ywY.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).zdA.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).zdA.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).zdC.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).zdC.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).zdC.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).zdC.getWidth();
          ac.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.ybg = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.ybh = i;
            localb.ybi = i2;
            localb.ybj = i4;
            localb.ybk = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.ybf = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.ybm = (i6 + i2);
            localb.ybl = (i5 + i);
            localb.ybn = i8;
            localb.ybo = i7;
          }
        }
      }
    }
    label736:
    ac.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - l));
    AppMethodBeat.o(96173);
    return locala;
  }
  
  public static final class a
  {
    public int adx;
    public int mScreenHeight;
    public int mScreenWidth;
    public long yaW;
    public int yaX;
    public int yaY;
    public List<a.b> yaZ;
  }
  
  public static final class b
  {
    public int aOy;
    public int aOz;
    public int yba;
    public int ybb;
    public int ybc;
    public boolean ybd;
    public String ybe;
    public int ybf;
    public int ybg;
    public int ybh;
    public int ybi;
    public int ybj;
    public int ybk;
    public int ybl;
    public int ybm;
    public int ybn;
    public int ybo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.a
 * JD-Core Version:    0.7.0.1
 */