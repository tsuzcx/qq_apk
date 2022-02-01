package com.tencent.scanlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class b
{
  private static b ahvZ;
  public Object GXz;
  private ExecutorService OOq;
  public Map<Long, String> ahrh;
  public Map<Long, Object> ahri;
  public Map<String, List<Long>> ahrj;
  private int[] ahrm;
  private a ahwa;
  
  static
  {
    AppMethodBeat.i(3557);
    ahvZ = new b();
    AppMethodBeat.o(3557);
  }
  
  private b()
  {
    AppMethodBeat.i(3556);
    this.ahrm = new int[] { 2, 1 };
    this.ahrh = new HashMap();
    this.ahri = new HashMap();
    this.ahrj = new HashMap();
    this.GXz = new Object();
    this.ahwa = new a("FileDecodeQueue");
    this.OOq = Executors.newSingleThreadExecutor();
    AppMethodBeat.o(3556);
  }
  
  public static b jXO()
  {
    return ahvZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.scanlib.b.b
 * JD-Core Version:    0.7.0.1
 */