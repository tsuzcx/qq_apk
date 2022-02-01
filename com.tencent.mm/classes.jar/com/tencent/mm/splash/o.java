package com.tencent.mm.splash;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class o
{
  public final ArrayList<String> Vam;
  public final ArrayList<long[]> iOE;
  long mStartTimestamp;
  
  public o()
  {
    AppMethodBeat.i(40690);
    this.iOE = new ArrayList();
    this.Vam = new ArrayList();
    this.mStartTimestamp = 0L;
    AppMethodBeat.o(40690);
  }
  
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(40691);
    this.iOE.add(new long[] { paramLong1, paramLong2, paramLong3 });
    AppMethodBeat.o(40691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.splash.o
 * JD-Core Version:    0.7.0.1
 */