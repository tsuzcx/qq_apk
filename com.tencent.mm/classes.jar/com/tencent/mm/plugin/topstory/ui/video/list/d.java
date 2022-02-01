package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.u;
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
      RecyclerView.v localv = paramb.getRecyclerView().aQ(localView);
      if ((localView.getTag() != null) && (localView.getTag().equals("video")) && (localView.getTop() > 0) && (localv.md() >= 0))
      {
        AppMethodBeat.o(126420);
        return localView;
      }
      i += 1;
    }
    AppMethodBeat.o(126420);
    return null;
  }
  
  public static RecyclerView.v f(b paramb)
  {
    AppMethodBeat.i(207163);
    View localView = e(paramb);
    if (localView != null)
    {
      paramb = paramb.getRecyclerView().aQ(localView);
      AppMethodBeat.o(207163);
      return paramb;
    }
    AppMethodBeat.o(207163);
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
      i = ((h)localObject).gqw();
      if ((i != paramb.gqE()) && (paramb.gqC().NaM)) {
        paramb.gqC().stopPlay();
      }
      paramb.gqv();
      j = 0;
      label84:
      if (j >= localRecyclerView.getChildCount()) {
        break label198;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (h)paramb.getRecyclerView().aQ((View)localObject);
        if (((h)localObject).gqw() != i) {
          break label182;
        }
        ((h)localObject).grS();
        ((h)localObject).gqu();
        if (!paramb.gqC().NaM) {
          ((h)localObject).NcB.gqU();
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
      ((h)localObject).dCA();
      ((h)localObject).NcB.gqV();
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
      paramb.getRecyclerView();
      localView2 = localView1;
      if (RecyclerView.bh(localView1) == paramInt) {
        break;
      }
      i += 1;
    }
    if (localView2 != null)
    {
      paramInt = paramb.gqD().aZ(localView2);
      i = paramb.gqK();
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
      if (!paramb.gqC().NaM)
      {
        if (!paramb.gqx().isConnected()) {
          break label86;
        }
        ((h)localObject).Ah(true);
      }
    }
    for (;;)
    {
      ((h)localObject).gqu();
      paramb.ajB(((h)localObject).gqw());
      paramb.gqy().grC();
      AppMethodBeat.o(126418);
      return;
      AppMethodBeat.o(126418);
      return;
      label86:
      ((h)localObject).NcB.gqY();
      paramb.gqC().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.d
 * JD-Core Version:    0.7.0.1
 */