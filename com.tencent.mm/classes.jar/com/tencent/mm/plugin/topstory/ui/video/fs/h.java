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
      i = ((g)localObject).lv();
      if ((i != paramb.edm()) && (paramb.edj().Aei))
      {
        paramb.edj().stopPlay();
        if (localObject != null) {
          paramb.edf().i(((j)localObject).zZN);
        }
      }
      paramb.edc();
      j = 0;
      label103:
      if (j >= localRecyclerView.getChildCount()) {
        break label207;
      }
      localObject = localRecyclerView.getChildAt(j);
      if (((View)localObject).getTag() != null)
      {
        localObject = (j)paramb.getRecyclerView().bh((View)localObject);
        if (((g)localObject).lv() != i) {
          break label196;
        }
        ((j)localObject).edb();
        if (!paramb.edj().Aei) {
          ((g)localObject).Afh.edA();
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
      ((g)localObject).Afh.edB();
    }
    label207:
    AppMethodBeat.o(126390);
  }
  
  public final void b(b paramb)
  {
    AppMethodBeat.i(126391);
    com.tencent.mm.plugin.topstory.ui.video.h localh = c(paramb);
    if ((localh instanceof j)) {
      if (!paramb.edj().Aei)
      {
        if (!paramb.ede().isConnected()) {
          break label75;
        }
        localh.sd(true);
      }
    }
    for (;;)
    {
      localh.edb();
      paramb.Ro(localh.edd());
      paramb.edf().eeh();
      AppMethodBeat.o(126391);
      return;
      label75:
      localh.edP().edE();
      paramb.edj().stopPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.h
 * JD-Core Version:    0.7.0.1
 */