package com.tencent.mm.plugin.recordvideo.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"})
public final class a
{
  public static final a HLt;
  private static int displayHeight;
  private static int displayWidth;
  
  static
  {
    AppMethodBeat.i(75395);
    HLt = new a();
    displayWidth = ax.au(MMApplicationContext.getContext()).x;
    displayHeight = ax.au(MMApplicationContext.getContext()).y;
    AppMethodBeat.o(75395);
  }
  
  public static void Fd(int paramInt)
  {
    displayHeight = paramInt;
  }
  
  public static void acj(int paramInt)
  {
    displayWidth = paramInt;
  }
  
  public static int fvZ()
  {
    return displayWidth;
  }
  
  public static MMHandler fwa()
  {
    AppMethodBeat.i(75394);
    Object localObject = h.aHJ();
    p.j(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getWorkerHandler();
    p.j(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(75394);
    return localObject;
  }
  
  public static int getDisplayHeight()
  {
    return displayHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a
 * JD-Core Version:    0.7.0.1
 */