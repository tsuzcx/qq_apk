package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;

public final class h
  extends d
{
  public final void a(b paramb)
  {
    AppMethodBeat.i(126390);
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = c(paramb);
    int i;
    int j;
    if ((localObject instanceof j))
    {
      localObject = (j)localObject;
      if (localObject == null) {
        break label191;
      }
      i = ((g)localObject).lN();
      if ((i != paramb.epE()) && (paramb.epB().BvU))
      {
        paramb.epB().stopPlay();
        if (localObject != null) {
          paramb.epx().i(((j)localObject).Brz);
        }
      }
      paramb.epu();
      j = 0;
      label103:
      if (j >= localRecyclerView.getChildCount()) {
        break label207;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (j)paramb.getRecyclerView().bh((View)localObject);
        if (((g)localObject).lN() != i) {
          break label196;
        }
        ((j)localObject).ept();
        if (!paramb.epB().BvU) {
          ((g)localObject).BwT.epS();
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label103;
      AppMethodBeat.o(126390);
      return;
      label191:
      i = -1;
      break;
      label196:
      ((g)localObject).BwT.epT();
    }
    label207:
    AppMethodBeat.o(126390);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126391);
    com.tencent.mm.plugin.topstory.ui.video.h localh = c(paramb);
    if ((localh instanceof j)) {
      if (!paramb.epB().BvU)
      {
        if (!paramb.epw().isConnected()) {
          break label75;
        }
        localh.sJ(true);
      }
    }
    for (;;)
    {
      localh.ept();
      paramb.SY(localh.epv());
      paramb.epx().eqy();
      AppMethodBeat.o(126391);
      return;
      label75:
      localh.eqh().epW();
      paramb.epB().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.h
 * JD-Core Version:    0.7.0.1
 */