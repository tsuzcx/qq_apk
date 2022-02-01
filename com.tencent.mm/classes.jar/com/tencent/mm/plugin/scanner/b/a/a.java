package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a vNf;
  private static float vNg;
  private Rect gtE;
  private Map vNh;
  private Object vNi;
  private Object vNj;
  private ExecutorService vNk;
  private Rect vNl;
  
  static
  {
    AppMethodBeat.i(118321);
    vNf = new a();
    vNg = 1.15F;
    AppMethodBeat.o(118321);
  }
  
  public a()
  {
    AppMethodBeat.i(118320);
    this.vNh = new HashMap();
    this.vNi = new Object();
    this.vNj = new Object();
    this.vNk = Executors.newSingleThreadExecutor();
    this.vNl = new Rect();
    this.gtE = new Rect();
    AppMethodBeat.o(118320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.a
 * JD-Core Version:    0.7.0.1
 */