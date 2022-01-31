package com.tencent.mm.plugin.sns.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskTextView;
import com.tencent.mm.plugin.sns.ui.SnsHeader;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  public ListView gMh;
  public int mScreenHeight = 0;
  public int mScreenWidth = 0;
  public SnsHeader rmc;
  public boolean rmd = false;
  
  public final a.a a(av paramav)
  {
    AppMethodBeat.i(36842);
    int i = c.fQM;
    if (i == 2)
    {
      AppMethodBeat.o(36842);
      return null;
    }
    if ((i == 4) && (!this.rmd))
    {
      AppMethodBeat.o(36842);
      return null;
    }
    long l = System.nanoTime();
    a.a locala = new a.a();
    locala.rme = System.currentTimeMillis();
    locala.mScreenHeight = this.mScreenHeight;
    locala.mScreenWidth = this.mScreenWidth;
    int k = this.rmc.getTop();
    int j = this.rmc.getHeight();
    i = j;
    if (k < 0) {
      i = j + k;
    }
    locala.rmg = i;
    j = this.gMh.getFirstVisiblePosition() - 1;
    int m = this.gMh.getLastVisiblePosition() - 1;
    locala.rmf = j;
    locala.Vy = m;
    int n = paramav.getCount();
    boolean bool = false;
    if (this.gMh.getChildAt(0) != null) {
      bool = this.gMh.getChildAt(0) instanceof SnsHeader;
    }
    ab.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m), Boolean.valueOf(bool) });
    if (bool)
    {
      i = 1;
      int i1 = this.gMh.getChildCount();
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
          ab.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(i1) });
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
      if (locala.rmh == null) {
        locala.rmh = new LinkedList();
      }
      a.b localb = new a.b();
      locala.rmh.add(localb);
      Object localObject = this.gMh.getChildAt(i);
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
        n localn = paramav.EE(j);
        localb.rmm = i.j(localn);
        localb.rmk = localn.field_type;
        localb.rml = localn.Ex(32);
        localb.rmi = i;
        localb.rmj = i2;
        localb.asZ = i3;
        localb.asY = i4;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseTimeLineItem.BaseViewHolder)))
      {
        localObject = (BaseTimeLineItem.BaseViewHolder)((View)localObject).getTag();
        if ((((BaseTimeLineItem.BaseViewHolder)localObject).shn) && (((BaseTimeLineItem.BaseViewHolder)localObject).rEv != null))
        {
          i = ((BaseTimeLineItem.BaseViewHolder)localObject).rEv.getTop();
          i2 = ((BaseTimeLineItem.BaseViewHolder)localObject).rEv.getLeft();
          i3 = ((BaseTimeLineItem.BaseViewHolder)localObject).shf.getHeight();
          i4 = ((BaseTimeLineItem.BaseViewHolder)localObject).shf.getWidth();
          int i5 = ((BaseTimeLineItem.BaseViewHolder)localObject).shg.getTop();
          int i6 = ((BaseTimeLineItem.BaseViewHolder)localObject).shg.getLeft();
          int i7 = ((BaseTimeLineItem.BaseViewHolder)localObject).shg.getHeight();
          int i8 = ((BaseTimeLineItem.BaseViewHolder)localObject).shg.getWidth();
          ab.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[] { Integer.valueOf(((BaseTimeLineItem.BaseViewHolder)localObject).position), Integer.valueOf(j), Integer.valueOf(k) });
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount != 0)
          {
            localb.rmo = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.LikeCount;
            localb.rmp = i;
            localb.rmq = i2;
            localb.rmr = i4;
            localb.rms = i3;
          }
          if (((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount != 0)
          {
            localb.rmn = ((BaseTimeLineItem.BaseViewHolder)localObject).snsobj.CommentCount;
            localb.rmu = (i6 + i2);
            localb.rmt = (i5 + i);
            localb.rmv = i8;
            localb.rmw = i7;
          }
        }
      }
    }
    label736:
    ab.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - l));
    AppMethodBeat.o(36842);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.a
 * JD-Core Version:    0.7.0.1
 */