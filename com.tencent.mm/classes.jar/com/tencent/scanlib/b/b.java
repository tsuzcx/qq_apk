package com.tencent.scanlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static b ItG;
  public Map<Long, String> Ipf;
  public Map<Long, Object> Ipg;
  public Map<String, List<Long>> Iph;
  private int[] Ipj;
  private a ItH;
  public Object vNi;
  private ExecutorService vNk;
  
  static
  {
    AppMethodBeat.i(3557);
    ItG = new b();
    AppMethodBeat.o(3557);
  }
  
  private b()
  {
    AppMethodBeat.i(3556);
    this.Ipj = new int[] { 2, 1 };
    this.Ipf = new HashMap();
    this.Ipg = new HashMap();
    this.Iph = new HashMap();
    this.vNi = new Object();
    this.ItH = new a("FileDecodeQueue");
    this.vNk = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(3556);
  }
  
  public static b fmK()
  {
    return ItG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.scanlib.b.b
 * JD-Core Version:    0.7.0.1
 */