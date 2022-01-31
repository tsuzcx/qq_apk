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
    AppMethodBeat.i(1871);
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = c(paramb);
    int i;
    int j;
    if ((localObject instanceof g))
    {
      localObject = (g)localObject;
      if (localObject == null) {
        break label193;
      }
      i = ((g)localObject).jN();
      if ((i != paramb.cJk()) && (paramb.cJh().tjS))
      {
        paramb.cJh().stopPlay();
        if (localObject != null) {
          paramb.cJd().f(((g)localObject).tfm);
        }
      }
      paramb.cJa();
      j = 0;
      label104:
      if (j >= localRecyclerView.getChildCount()) {
        break label209;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (g)paramb.getRecyclerView().bb((View)localObject);
        if (((g)localObject).jN() != i) {
          break label198;
        }
        ((g)localObject).cIZ();
        if (!paramb.cJh().tjS) {
          ((g)localObject).tkK.cJz();
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label104;
      AppMethodBeat.o(1871);
      return;
      label193:
      i = -1;
      break;
      label198:
      ((g)localObject).tkK.cJA();
    }
    label209:
    AppMethodBeat.o(1871);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(1872);
    h localh = c(paramb);
    if ((localh != null) && ((localh instanceof g))) {
      if (!paramb.cJh().tjS)
      {
        if (!paramb.cJc().isConnected()) {
          break label87;
        }
        paramb.cJq();
        localh.mA(true);
      }
    }
    for (;;)
    {
      localh.cIZ();
      paramb.GA(localh.cJb());
      paramb.cJd().cKd();
      AppMethodBeat.o(1872);
      return;
      label87:
      localh.cJM().cJD();
      paramb.cJh().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.c
 * JD-Core Version:    0.7.0.1
 */