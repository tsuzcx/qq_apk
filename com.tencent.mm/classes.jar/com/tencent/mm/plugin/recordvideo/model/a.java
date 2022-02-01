package com.tencent.mm.plugin.recordvideo.model;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/model/RecordVideoManager;", "", "()V", "displayHeight", "", "getDisplayHeight", "()I", "setDisplayHeight", "(I)V", "displayWidth", "getDisplayWidth", "setDisplayWidth", "getWorkingHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "plugin-recordvideo_release"})
public final class a
{
  private static int bjX;
  private static int bjY;
  public static final a xON;
  
  static
  {
    AppMethodBeat.i(75395);
    xON = new a();
    bjX = com.tencent.mm.ui.ar.ck(ak.getContext()).x;
    bjY = com.tencent.mm.ui.ar.ck(ak.getContext()).y;
    AppMethodBeat.o(75395);
  }
  
  public static void Ol(int paramInt)
  {
    bjX = paramInt;
  }
  
  public static int dJb()
  {
    return bjX;
  }
  
  public static aq dJc()
  {
    AppMethodBeat.i(75394);
    Object localObject = g.ajU();
    p.g(localObject, "MMKernel.getPizzaWorkerThread()");
    localObject = ((com.tencent.mm.sdk.platformtools.ar)localObject).cZF();
    p.g(localObject, "MMKernel.getPizzaWorkerThread().workerHandler");
    AppMethodBeat.o(75394);
    return localObject;
  }
  
  public static int getDisplayHeight()
  {
    return bjY;
  }
  
  public static void xX(int paramInt)
  {
    bjY = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.model.a
 * JD-Core Version:    0.7.0.1
 */