package com.tencent.scanlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static b ROE;
  public Object CCt;
  private ExecutorService CDQ;
  public Map<Long, String> RKc;
  public Map<Long, Object> RKd;
  public Map<String, List<Long>> RKe;
  private int[] RKg;
  private a ROF;
  
  static
  {
    AppMethodBeat.i(3557);
    ROE = new b();
    AppMethodBeat.o(3557);
  }
  
  private b()
  {
    AppMethodBeat.i(3556);
    this.RKg = new int[] { 2, 1 };
    this.RKc = new HashMap();
    this.RKd = new HashMap();
    this.RKe = new HashMap();
    this.CCt = new Object();
    this.ROF = new a("FileDecodeQueue");
    this.CDQ = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(3556);
  }
  
  public static b hlc()
  {
    return ROE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.scanlib.b.b
 * JD-Core Version:    0.7.0.1
 */