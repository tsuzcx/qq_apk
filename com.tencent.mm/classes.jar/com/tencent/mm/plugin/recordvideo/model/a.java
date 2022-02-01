package com.tencent.mm.plugin.recordvideo.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a NIt;
  private static int displayHeight;
  private static int displayWidth;
  
  static
  {
    AppMethodBeat.i(75395);
    NIt = new a();
    displayWidth = bf.bf(MMApplicationContext.getContext()).x;
    displayHeight = bf.bf(MMApplicationContext.getContext()).y;
    AppMethodBeat.o(75395);
  }
  
  public static void FE(int paramInt)
  {
    displayHeight = paramInt;
  }
  
  public static void agw(int paramInt)
  {
    displayWidth = paramInt;
  }
  
  public static int gHH()
  {
    return displayWidth;
  }
  
  public static MMHandler gHI()
  {
    AppMethodBeat.i(75394);
    MMHandler localMMHandler = h.baH().getWorkerHandler();
    s.s(localMMHandler, "getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(75394);
    return localMMHandler;
  }
  
  public static int getDisplayHeight()
  {
    return displayHeight;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a
 * JD-Core Version:    0.7.0.1
 */