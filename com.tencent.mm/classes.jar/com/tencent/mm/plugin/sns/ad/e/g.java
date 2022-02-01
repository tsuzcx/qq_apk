package com.tencent.mm.plugin.sns.ad.e;

import android.os.CountDownTimer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class g
{
  protected final long DsM;
  final int DsN;
  public b DsO;
  public a DsP;
  protected final long mStartTime;
  
  public g(long paramLong1, long paramLong2)
  {
    this(paramLong1, paramLong2, (byte)0);
  }
  
  private g(long paramLong1, long paramLong2, byte paramByte)
  {
    this.mStartTime = paramLong1;
    this.DsM = paramLong2;
    this.DsN = 1000;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(201928);
    if (isValid())
    {
      if ((this.DsO != null) && (!this.DsO.mFinished))
      {
        this.DsO.cancel();
        this.DsO = null;
      }
      this.DsP = parama;
      l = eWP();
      if (l < this.mStartTime) {
        break label100;
      }
    }
    label100:
    for (long l = this.DsM - l;; l = -1L)
    {
      if (l > 0L)
      {
        this.DsO = new b(this, l);
        this.DsO.start();
      }
      AppMethodBeat.o(201928);
      return;
    }
  }
  
  protected long eWP()
  {
    AppMethodBeat.i(201927);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(201927);
    return l;
  }
  
  protected boolean isValid()
  {
    AppMethodBeat.i(201926);
    if ((eWP() <= this.DsM) && (this.DsM > this.mStartTime) && (this.mStartTime >= 0L))
    {
      AppMethodBeat.o(201926);
      return true;
    }
    AppMethodBeat.o(201926);
    return false;
  }
  
  final void onTick(long paramLong)
  {
    AppMethodBeat.i(201929);
    Log.d("SnsAd.CountDownTimer", "the millisUntilFinished is ".concat(String.valueOf(paramLong)));
    a locala = this.DsP;
    if (locala != null) {
      locala.IO(paramLong);
    }
    AppMethodBeat.o(201929);
  }
  
  public static abstract interface a
  {
    public abstract void IO(long paramLong);
  }
  
  public static final class b
    extends CountDownTimer
  {
    g DsQ;
    boolean mFinished = false;
    
    private b(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    b(g paramg, long paramLong)
    {
      this(paramLong, paramg.DsN);
      AppMethodBeat.i(201923);
      this.DsQ = paramg;
      AppMethodBeat.o(201923);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(201925);
      this.mFinished = true;
      g localg = this.DsQ;
      if (localg != null) {
        localg.onTick(0L);
      }
      AppMethodBeat.o(201925);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(201924);
      g localg = this.DsQ;
      if (localg != null) {
        localg.onTick(paramLong);
      }
      AppMethodBeat.o(201924);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.e.g
 * JD-Core Version:    0.7.0.1
 */