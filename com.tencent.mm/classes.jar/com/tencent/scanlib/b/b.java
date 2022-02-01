package com.tencent.scanlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static b Mmh;
  public Map<Long, String> MhB;
  public Map<Long, Object> MhC;
  public Map<String, List<Long>> MhD;
  private int[] MhF;
  private a Mmi;
  public Object yBn;
  private ExecutorService yBp;
  
  static
  {
    AppMethodBeat.i(3557);
    Mmh = new b();
    AppMethodBeat.o(3557);
  }
  
  private b()
  {
    AppMethodBeat.i(3556);
    this.MhF = new int[] { 2, 1 };
    this.MhB = new HashMap();
    this.MhC = new HashMap();
    this.MhD = new HashMap();
    this.yBn = new Object();
    this.Mmi = new a("FileDecodeQueue");
    this.yBp = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(3556);
  }
  
  public static b fYR()
  {
    return Mmh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.scanlib.b.b
 * JD-Core Version:    0.7.0.1
 */