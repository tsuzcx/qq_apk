package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a yll;
  private static float ylm;
  private Rect hmm;
  private Map yln;
  private Object ylo;
  private Object ylp;
  private ExecutorService ylq;
  private Rect ylr;
  
  static
  {
    AppMethodBeat.i(118321);
    yll = new a();
    ylm = 1.15F;
    AppMethodBeat.o(118321);
  }
  
  public a()
  {
    AppMethodBeat.i(118320);
    this.yln = new HashMap();
    this.ylo = new Object();
    this.ylp = new Object();
    this.ylq = Executors.newSingleThreadExecutor();
    this.ylr = new Rect();
    this.hmm = new Rect();
    AppMethodBeat.o(118320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.a
 * JD-Core Version:    0.7.0.1
 */