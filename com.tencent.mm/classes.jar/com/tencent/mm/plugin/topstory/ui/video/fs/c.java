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
      i = ((g)localObject).lN();
      if ((i != paramb.etl()) && (paramb.eti().BNs))
      {
        paramb.eti().stopPlay();
        if (localObject != null) {
          paramb.ete().i(((g)localObject).BIY);
        }
      }
      paramb.etb();
      j = 0;
      label103:
      if (j >= localRecyclerView.getChildCount()) {
        break label207;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (g)paramb.getRecyclerView().bh((View)localObject);
        if (((g)localObject).lN() != i) {
          break label196;
        }
        ((g)localObject).eta();
        if (!paramb.eti().BNs) {
          ((g)localObject).BOr.etz();
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
      ((g)localObject).BOr.etA();
    }
    label207:
    AppMethodBeat.o(126245);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126246);
    h localh = c(paramb);
    if ((localh != null) && ((localh instanceof g))) {
      if (!paramb.eti().BNs)
      {
        if (!paramb.etd().isConnected()) {
          break label89;
        }
        paramb.a(localh.BIY);
        localh.sQ(true);
      }
    }
    for (;;)
    {
      localh.eta();
      paramb.TF(localh.etc());
      paramb.ete().euf();
      AppMethodBeat.o(126246);
      return;
      label89:
      localh.etO().etD();
      paramb.eti().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.c
 * JD-Core Version:    0.7.0.1
 */