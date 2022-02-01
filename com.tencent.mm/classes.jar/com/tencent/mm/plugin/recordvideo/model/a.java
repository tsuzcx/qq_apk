package com.tencent.mm.plugin.recordvideo.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"})
public final class a
{
  public static final a BOO;
  private static int displayHeight;
  private static int displayWidth;
  
  static
  {
    AppMethodBeat.i(75395);
    BOO = new a();
    displayWidth = au.az(MMApplicationContext.getContext()).x;
    displayHeight = au.az(MMApplicationContext.getContext()).y;
    AppMethodBeat.o(75395);
  }
  
  public static void BC(int paramInt)
  {
    displayHeight = paramInt;
  }
  
  public static void VA(int paramInt)
  {
    displayWidth = paramInt;
  }
  
  public static int eJO()
  {
    return displayWidth;
  }
  
  public static MMHandler eJP()
  {
    AppMethodBeat.i(75394);
    Object localObject = g.aAk();
    p.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((MMHandlerThread)localObject).getWorkerHandler();
    p.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(75394);
    return localObject;
  }
  
  public static int getDisplayHeight()
  {
    return displayHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a
 * JD-Core Version:    0.7.0.1
 */