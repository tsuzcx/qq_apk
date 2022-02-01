package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
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
      i = ((g)localObject).KJ();
      if ((i != paramb.hND()) && (paramb.hNB().TNv))
      {
        paramb.hNB().stopPlay();
        if (localObject != null) {
          paramb.hNx().j(((g)localObject).TIW);
        }
      }
      paramb.hNu();
      j = 0;
      label103:
      if (j >= localRecyclerView.getChildCount()) {
        break label207;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (g)paramb.getRecyclerView().bj((View)localObject);
        if (((g)localObject).KJ() != i) {
          break label196;
        }
        ((g)localObject).hNt();
        if (!paramb.hNB().TNv) {
          ((g)localObject).TOt.hNS();
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
      ((g)localObject).TOt.hNT();
    }
    label207:
    AppMethodBeat.o(126245);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126246);
    h localh = c(paramb);
    if ((localh != null) && ((localh instanceof g))) {
      if (!paramb.hNB().TNv)
      {
        if (!paramb.hNw().isConnected()) {
          break label89;
        }
        paramb.a(localh.TIW);
        localh.FD(true);
      }
    }
    for (;;)
    {
      localh.hNt();
      paramb.aoU(localh.hNv());
      paramb.hNx().hOC();
      AppMethodBeat.o(126246);
      return;
      label89:
      localh.hOi().hNW();
      paramb.hNB().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.c
 * JD-Core Version:    0.7.0.1
 */