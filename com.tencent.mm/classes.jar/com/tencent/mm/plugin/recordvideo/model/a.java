package com.tencent.mm.plugin.recordvideo.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"})
public final class a
{
  private static int aYQ;
  private static int aYR;
  public static final a viq;
  
  static
  {
    AppMethodBeat.i(75395);
    viq = new a();
    aYQ = com.tencent.mm.ui.ap.cf(aj.getContext()).x;
    aYR = com.tencent.mm.ui.ap.cf(aj.getContext()).y;
    AppMethodBeat.o(75395);
  }
  
  public static void Ki(int paramInt)
  {
    aYQ = paramInt;
  }
  
  public static int dhH()
  {
    return aYQ;
  }
  
  public static com.tencent.mm.sdk.platformtools.ap dhI()
  {
    AppMethodBeat.i(75394);
    Object localObject = g.afE();
    k.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((aq)localObject).cBt();
    k.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(75394);
    return localObject;
  }
  
  public static int getDisplayHeight()
  {
    return aYR;
  }
  
  public static void wv(int paramInt)
  {
    aYR = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a
 * JD-Core Version:    0.7.0.1
 */