package com.tencent.scanlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static b Zrk;
  public Object Brg;
  private ExecutorService IIs;
  public Map<Long, String> ZmK;
  public Map<Long, Object> ZmL;
  public Map<String, List<Long>> ZmM;
  private int[] ZmP;
  private a Zrl;
  
  static
  {
    AppMethodBeat.i(3557);
    Zrk = new b();
    AppMethodBeat.o(3557);
  }
  
  private b()
  {
    AppMethodBeat.i(3556);
    this.ZmP = new int[] { 2, 1 };
    this.ZmK = new HashMap();
    this.ZmL = new HashMap();
    this.ZmM = new HashMap();
    this.Brg = new Object();
    this.Zrl = new a("FileDecodeQueue");
    this.IIs = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(3556);
  }
  
  public static b ioB()
  {
    return Zrk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.scanlib.b.b
 * JD-Core Version:    0.7.0.1
 */