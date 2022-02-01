package com.tencent.scanlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static b JVp;
  public Map<Long, String> JQP;
  public Map<Long, Object> JQQ;
  public Map<String, List<Long>> JQR;
  private int[] JQT;
  private a JVq;
  public Object wXD;
  private ExecutorService wXF;
  
  static
  {
    AppMethodBeat.i(3557);
    JVp = new b();
    AppMethodBeat.o(3557);
  }
  
  private b()
  {
    AppMethodBeat.i(3556);
    this.JQT = new int[] { 2, 1 };
    this.JQP = new HashMap();
    this.JQQ = new HashMap();
    this.JQR = new HashMap();
    this.wXD = new Object();
    this.JVq = new a("FileDecodeQueue");
    this.wXF = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(3556);
  }
  
  public static b fDa()
  {
    return JVp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.scanlib.b.b
 * JD-Core Version:    0.7.0.1
 */