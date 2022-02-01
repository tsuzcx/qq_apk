package com.tencent.mm.plugin.topstory.ui.video.list;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;

public final class d
  extends com.tencent.mm.plugin.topstory.ui.video.d
{
  private static View e(b paramb)
  {
    AppMethodBeat.i(126420);
    int i = 0;
    while (i < paramb.getRecyclerView().getChildCount())
    {
      View localView = paramb.getRecyclerView().getChildAt(i);
      RecyclerView.w localw = paramb.getRecyclerView().bh(localView);
      if ((localView.getTag() != null) && (localView.getTag().equals("video")) && (localView.getTop() > 0) && (localw.lN() >= 0))
      {
        AppMethodBeat.o(126420);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(126420);
    return null;
  }
  
  public static RecyclerView.w f(b paramb)
  {
    AppMethodBeat.i(126421);
    View localView = e(paramb);
    if (localView != null)
    {
      paramb = paramb.getRecyclerView().bh(localView);
      AppMethodBeat.o(126421);
      return paramb;
    }
    AppMethodBeat.o(126421);
    return null;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(126417);
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = f(paramb);
    int i;
    int j;
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (localObject == null) {
        break label177;
      }
      i = ((h)localObject).etc();
      if ((i != paramb.etl()) && (paramb.eti().BNs)) {
        paramb.eti().stopPlay();
      }
      paramb.etb();
      j = 0;
      label84:
      if (j >= localRecyclerView.getChildCount()) {
        break label198;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (h)paramb.getRecyclerView().bh((View)localObject);
        if (((h)localObject).etc() != i) {
          break label182;
        }
        ((h)localObject).eux();
        ((h)localObject).eta();
        if (!paramb.eti().BNs) {
          ((h)localObject).BPi.etz();
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label84;
      AppMethodBeat.o(126417);
      return;
      label177:
      i = -1;
      break;
      label182:
      ((h)localObject).euw();
      ((h)localObject).BPi.etA();
    }
    label198:
    AppMethodBeat.o(126417);
  }
  
  public final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(126419);
    int i = 0;
    View localView1 = null;
    View localView2;
    for (;;)
    {
      localView2 = localView1;
      if (i >= paramb.getRecyclerView().getChildCount()) {
        break;
      }
      localView1 = paramb.getRecyclerView().getChildAt(i);
      localView2 = localView1;
      if (RecyclerView.bw(localView1) == paramInt) {
        break;
      }
      i += 1;
    }
    if (localView2 != null)
    {
      paramInt = paramb.etk().bn(localView2);
      i = paramb.etr();
      paramb.getRecyclerView().a(0, paramInt - i, null);
    }
    AppMethodBeat.o(126419);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126418);
    Object localObject = f(paramb);
    if ((localObject instanceof h))
    {
      localObject = (h)localObject;
      if (!paramb.eti().BNs)
      {
        if (!paramb.etd().isConnected()) {
          break label86;
        }
        ((h)localObject).sQ(true);
      }
    }
    for (;;)
    {
      ((h)localObject).eta();
      paramb.TF(((h)localObject).etc());
      paramb.ete().euf();
      AppMethodBeat.o(126418);
      return;
      AppMethodBeat.o(126418);
      return;
      label86:
      ((h)localObject).BPi.etD();
      paramb.eti().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.d
 * JD-Core Version:    0.7.0.1
 */