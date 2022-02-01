package com.tencent.mm.plugin.recordvideo.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"})
public final class a
{
  private static int aZC;
  private static int aZD;
  public static final a wra;
  
  static
  {
    AppMethodBeat.i(75395);
    wra = new a();
    aZC = com.tencent.mm.ui.ap.cl(ai.getContext()).x;
    aZD = com.tencent.mm.ui.ap.cl(ai.getContext()).y;
    AppMethodBeat.o(75395);
  }
  
  public static void Mg(int paramInt)
  {
    aZC = paramInt;
  }
  
  public static int dvp()
  {
    return aZC;
  }
  
  public static ao dvq()
  {
    AppMethodBeat.i(75394);
    Object localObject = g.agU();
    k.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((com.tencent.mm.sdk.platformtools.ap)localObject).cOC();
    k.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(75394);
    return localObject;
  }
  
  public static int getDisplayHeight()
  {
    return aZD;
  }
  
  public static void xn(int paramInt)
  {
    aZD = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a
 * JD-Core Version:    0.7.0.1
 */