package com.tencent.mm.plugin.multitask.animation.swipeahead;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
public final class b$c
  implements Runnable
{
  public b$c(b paramb) {}
  
  public final void run()
  {
    Object localObject3 = null;
    AppMethodBeat.i(200429);
    if (this.Aan.Aaj != null) {}
    label104:
    Object localObject2;
    for (;;)
    {
      try
      {
        Object localObject1 = this.Aan.Aaj;
        if (localObject1 == null) {
          break label104;
        }
        localObject1 = ((FloatMultiTaskIndicatorView)localObject1).getParent();
        if (localObject1 != null)
        {
          FloatMultiTaskIndicatorView localFloatMultiTaskIndicatorView = this.Aan.Aaj;
          localObject1 = localObject3;
          if (localFloatMultiTaskIndicatorView != null) {
            localObject1 = localFloatMultiTaskIndicatorView.getParent();
          }
          if (localObject1 != null) {
            break;
          }
          localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(200429);
          throw ((Throwable)localObject1);
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.FloatMultiTaskIndicatorController", (Throwable)localException, "detachFloatIndicatorView exception:%s", new Object[] { localException });
      }
      AppMethodBeat.o(200429);
      return;
      localObject2 = null;
    }
    ((ViewGroup)localObject2).removeView((View)this.Aan.Aaj);
    AppMethodBeat.o(200429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.animation.swipeahead.b.c
 * JD-Core Version:    0.7.0.1
 */