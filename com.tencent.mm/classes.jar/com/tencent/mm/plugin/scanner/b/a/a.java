package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a IIo;
  private static float IIp;
  private Object Brg;
  private Map IIq;
  private Object IIr;
  private ExecutorService IIs;
  private Rect IIt;
  private Rect kXj;
  
  static
  {
    AppMethodBeat.i(118321);
    IIo = new a();
    IIp = 1.15F;
    AppMethodBeat.o(118321);
  }
  
  public a()
  {
    AppMethodBeat.i(118320);
    this.IIq = new HashMap();
    this.Brg = new Object();
    this.IIr = new Object();
    this.IIs = Executors.newSingleThreadExecutor();
    this.IIt = new Rect();
    this.kXj = new Rect();
    AppMethodBeat.o(118320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.a
 * JD-Core Version:    0.7.0.1
 */