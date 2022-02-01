package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.d;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.o;
import com.tencent.mm.plugin.topstory.ui.video.r;

public final class c
  extends d
{
  public final void a(b paramb)
  {
    AppMethodBeat.i(126245);
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = c(paramb);
    int i;
    int j;
    if ((localObject instanceof g))
    {
      localObject = (g)localObject;
      if (localObject == null) {
        break label191;
      }
      i = ((g)localObject).lR();
      if ((i != paramb.fyH()) && (paramb.fyF().GnZ))
      {
        paramb.fyF().stopPlay();
        if (localObject != null) {
          paramb.fyB().j(((g)localObject).GjH);
        }
      }
      paramb.fyy();
      j = 0;
      label103:
      if (j >= localRecyclerView.getChildCount()) {
        break label207;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (g)paramb.getRecyclerView().bi((View)localObject);
        if (((g)localObject).lR() != i) {
          break label196;
        }
        ((g)localObject).fyx();
        if (!paramb.fyF().GnZ) {
          ((g)localObject).GoY.fyV();
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label103;
      AppMethodBeat.o(126245);
      return;
      label191:
      i = -1;
      break;
      label196:
      ((g)localObject).GoY.fyW();
    }
    label207:
    AppMethodBeat.o(126245);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126246);
    h localh = c(paramb);
    if ((localh != null) && ((localh instanceof g))) {
      if (!paramb.fyF().GnZ)
      {
        if (!paramb.fyA().isConnected()) {
          break label89;
        }
        paramb.a(localh.GjH);
        localh.wu(true);
      }
    }
    for (;;)
    {
      localh.fyx();
      paramb.abV(localh.fyz());
      paramb.fyB().fzB();
      AppMethodBeat.o(126246);
      return;
      label89:
      localh.fzk().fyZ();
      paramb.fyF().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.c
 * JD-Core Version:    0.7.0.1
 */