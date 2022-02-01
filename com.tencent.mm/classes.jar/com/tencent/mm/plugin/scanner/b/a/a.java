package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a yBk;
  private static float yBl;
  private Rect hpa;
  private Map yBm;
  private Object yBn;
  private Object yBo;
  private ExecutorService yBp;
  private Rect yBq;
  
  static
  {
    AppMethodBeat.i(118321);
    yBk = new a();
    yBl = 1.15F;
    AppMethodBeat.o(118321);
  }
  
  public a()
  {
    AppMethodBeat.i(118320);
    this.yBm = new HashMap();
    this.yBn = new Object();
    this.yBo = new Object();
    this.yBp = Executors.newSingleThreadExecutor();
    this.yBq = new Rect();
    this.hpa = new Rect();
    AppMethodBeat.o(118320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.a
 * JD-Core Version:    0.7.0.1
 */