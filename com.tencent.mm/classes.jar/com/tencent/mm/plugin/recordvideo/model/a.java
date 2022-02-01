package com.tencent.mm.plugin.recordvideo.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"})
public final class a
{
  private static int bjX;
  private static int bjY;
  public static final a xyR;
  
  static
  {
    AppMethodBeat.i(75395);
    xyR = new a();
    bjX = ar.ci(aj.getContext()).x;
    bjY = ar.ci(aj.getContext()).y;
    AppMethodBeat.o(75395);
  }
  
  public static void NF(int paramInt)
  {
    bjX = paramInt;
  }
  
  public static int dFK()
  {
    return bjX;
  }
  
  public static ap dFL()
  {
    AppMethodBeat.i(75394);
    Object localObject = g.ajF();
    p.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((aq)localObject).cWY();
    p.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(75394);
    return localObject;
  }
  
  public static int getDisplayHeight()
  {
    return bjY;
  }
  
  public static void xT(int paramInt)
  {
    bjY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a
 * JD-Core Version:    0.7.0.1
 */