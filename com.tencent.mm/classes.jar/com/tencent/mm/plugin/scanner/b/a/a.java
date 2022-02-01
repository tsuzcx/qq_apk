package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a OOm;
  private static float OOn;
  private Object GXz;
  private Rect Gl;
  private Map OOo;
  private Object OOp;
  private ExecutorService OOq;
  private Rect OOr;
  
  static
  {
    AppMethodBeat.i(118321);
    OOm = new a();
    OOn = 1.15F;
    AppMethodBeat.o(118321);
  }
  
  public a()
  {
    AppMethodBeat.i(118320);
    this.OOo = new HashMap();
    this.GXz = new Object();
    this.OOp = new Object();
    this.OOq = Executors.newSingleThreadExecutor();
    this.OOr = new Rect();
    this.Gl = new Rect();
    AppMethodBeat.o(118320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.a
 * JD-Core Version:    0.7.0.1
 */