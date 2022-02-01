package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.s;
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
      RecyclerView.v localv = paramb.getRecyclerView().bj(localView);
      if ((localView.getTag() != null) && (localView.getTag().equals("video")) && (localView.getTop() > 0) && (localv.KJ() >= 0))
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
    AppMethodBeat.i(271825);
    View localView = e(paramb);
    if (localView != null)
    {
      paramb = paramb.getRecyclerView().bj(localView);
      AppMethodBeat.o(271825);
      return paramb;
    }
    AppMethodBeat.o(271825);
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
      i = ((h)localObject).hNv();
      if ((i != paramb.hND()) && (paramb.hNB().TNv)) {
        paramb.hNB().stopPlay();
      }
      paramb.hNu();
      j = 0;
      label84:
      if (j >= localRecyclerView.getChildCount()) {
        break label198;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (h)paramb.getRecyclerView().bj((View)localObject);
        if (((h)localObject).hNv() != i) {
          break label182;
        }
        ((h)localObject).hOT();
        ((h)localObject).hNt();
        if (!paramb.hNB().TNv) {
          ((h)localObject).TPl.hNS();
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
      ((h)localObject).esa();
      ((h)localObject).TPl.hNT();
    }
    label198:
    AppMethodBeat.o(126417);
  }
  
  public final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(126419);
    View localView1 = null;
    int i = 0;
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
      if (RecyclerView.bA(localView1) == paramInt) {
        break;
      }
      i += 1;
    }
    if (localView2 != null)
    {
      paramInt = paramb.hNC().bs(localView2);
      i = paramb.hNJ();
      paramb.getRecyclerView().br(0, paramInt - i);
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
      if (!paramb.hNB().TNv)
      {
        if (!paramb.hNw().isConnected()) {
          break label86;
        }
        ((h)localObject).FD(true);
      }
    }
    for (;;)
    {
      ((h)localObject).hNt();
      paramb.aoU(((h)localObject).hNv());
      paramb.hNx().hOC();
      AppMethodBeat.o(126418);
      return;
      AppMethodBeat.o(126418);
      return;
      label86:
      ((h)localObject).TPl.hNW();
      paramb.hNB().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.d
 * JD-Core Version:    0.7.0.1
 */