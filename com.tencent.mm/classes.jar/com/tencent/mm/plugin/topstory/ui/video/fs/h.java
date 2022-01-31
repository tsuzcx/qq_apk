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
    AppMethodBeat.i(2004);
    RecyclerView localRecyclerView = paramb.getRecyclerView();
    Object localObject = c(paramb);
    int i;
    int j;
    if ((localObject instanceof j))
    {
      localObject = (j)localObject;
      if (localObject == null) {
        break label193;
      }
      i = ((g)localObject).jN();
      if ((i != paramb.cJk()) && (paramb.cJh().tjS))
      {
        paramb.cJh().stopPlay();
        if (localObject != null) {
          paramb.cJd().f(((j)localObject).tfm);
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
        localObject = (j)paramb.getRecyclerView().bb((View)localObject);
        if (((g)localObject).jN() != i) {
          break label198;
        }
        ((j)localObject).cIZ();
        if (!paramb.cJh().tjS) {
          ((g)localObject).tkK.cJz();
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label104;
      AppMethodBeat.o(2004);
      return;
      label193:
      i = -1;
      break;
      label198:
      ((g)localObject).tkK.cJA();
    }
    label209:
    AppMethodBeat.o(2004);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(2005);
    com.tencent.mm.plugin.topstory.ui.video.h localh = c(paramb);
    if ((localh instanceof j)) {
      if (!paramb.cJh().tjS)
      {
        if (!paramb.cJc().isConnected()) {
          break label77;
        }
        localh.mA(true);
      }
    }
    for (;;)
    {
      localh.cIZ();
      paramb.GA(localh.cJb());
      paramb.cJd().cKd();
      AppMethodBeat.o(2005);
      return;
      label77:
      localh.cJM().cJD();
      paramb.cJh().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.h
 * JD-Core Version:    0.7.0.1
 */