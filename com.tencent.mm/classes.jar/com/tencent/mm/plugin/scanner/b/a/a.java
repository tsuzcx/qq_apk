package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a wXA;
  private static float wXB;
  private Rect gUl;
  private Map wXC;
  private Object wXD;
  private Object wXE;
  private ExecutorService wXF;
  private Rect wXG;
  
  static
  {
    AppMethodBeat.i(118321);
    wXA = new a();
    wXB = 1.15F;
    AppMethodBeat.o(118321);
  }
  
  public a()
  {
    AppMethodBeat.i(118320);
    this.wXC = new HashMap();
    this.wXD = new Object();
    this.wXE = new Object();
    this.wXF = Executors.newSingleThreadExecutor();
    this.wXG = new Rect();
    this.gUl = new Rect();
    AppMethodBeat.o(118320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.a
 * JD-Core Version:    0.7.0.1
 */