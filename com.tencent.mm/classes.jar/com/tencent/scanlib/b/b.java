package com.tencent.scanlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static b LPk;
  public Map<Long, String> LKC;
  public Map<Long, Object> LKD;
  public Map<String, List<Long>> LKE;
  private int[] LKG;
  private a LPl;
  public Object ylo;
  private ExecutorService ylq;
  
  static
  {
    AppMethodBeat.i(3557);
    LPk = new b();
    AppMethodBeat.o(3557);
  }
  
  private b()
  {
    AppMethodBeat.i(3556);
    this.LKG = new int[] { 2, 1 };
    this.LKC = new HashMap();
    this.LKD = new HashMap();
    this.LKE = new HashMap();
    this.ylo = new Object();
    this.LPl = new a("FileDecodeQueue");
    this.ylq = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(3556);
  }
  
  public static b fUs()
  {
    return LPk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.scanlib.b.b
 * JD-Core Version:    0.7.0.1
 */