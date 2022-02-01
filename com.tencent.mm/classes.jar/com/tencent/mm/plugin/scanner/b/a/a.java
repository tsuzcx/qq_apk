package com.tencent.mm.plugin.scanner.b.a;

import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a CDM;
  private static float CDN;
  private Object CCt;
  private Map CDO;
  private Object CDP;
  private ExecutorService CDQ;
  private Rect CDR;
  private Rect iiw;
  
  static
  {
    AppMethodBeat.i(118321);
    CDM = new a();
    CDN = 1.15F;
    AppMethodBeat.o(118321);
  }
  
  public a()
  {
    AppMethodBeat.i(118320);
    this.CDO = new HashMap();
    this.CCt = new Object();
    this.CDP = new Object();
    this.CDQ = Executors.newSingleThreadExecutor();
    this.CDR = new Rect();
    this.iiw = new Rect();
    AppMethodBeat.o(118320);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.b.a.a
 * JD-Core Version:    0.7.0.1
 */