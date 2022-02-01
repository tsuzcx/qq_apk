package com.tencent.mm.plugin.sns.ad.d;

import android.os.CountDownTimer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class k
{
  final int JzA;
  public b JzB;
  public a JzC;
  protected final long Jzz;
  protected final long mStartTime;
  
  public k(long paramLong1, long paramLong2)
  {
    this(paramLong1, paramLong2, (byte)0);
  }
  
  private k(long paramLong1, long paramLong2, byte paramByte)
  {
    this.mStartTime = paramLong1;
    this.Jzz = paramLong2;
    this.JzA = 1000;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(248676);
    if (isValid())
    {
      if ((this.JzB != null) && (!this.JzB.mFinished))
      {
        this.JzB.cancel();
        this.JzB = null;
      }
      this.JzC = parama;
      l = fJZ();
      if (l < this.mStartTime) {
        break label100;
      }
    }
    label100:
    for (long l = this.Jzz - l;; l = -1L)
    {
      if (l > 0L)
      {
        this.JzB = new b(this, l);
        this.JzB.start();
      }
      AppMethodBeat.o(248676);
      return;
    }
  }
  
  protected long fJZ()
  {
    AppMethodBeat.i(248673);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(248673);
    return l;
  }
  
  protected boolean isValid()
  {
    AppMethodBeat.i(248670);
    if ((fJZ() <= this.Jzz) && (this.Jzz > this.mStartTime) && (this.mStartTime >= 0L))
    {
      AppMethodBeat.o(248670);
      return true;
    }
    AppMethodBeat.o(248670);
    return false;
  }
  
  final void onTick(long paramLong)
  {
    AppMethodBeat.i(248679);
    Log.d("SnsAd.CountDownTimer", "the millisUntilFinished is ".concat(String.valueOf(paramLong)));
    a locala = this.JzC;
    if (locala != null) {
      locala.Qh(paramLong);
    }
    AppMethodBeat.o(248679);
  }
  
  public static abstract interface a
  {
    public abstract void Qh(long paramLong);
  }
  
  public static final class b
    extends CountDownTimer
  {
    k JzD;
    boolean mFinished = false;
    
    private b(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    b(k paramk, long paramLong)
    {
      this(paramLong, paramk.JzA);
      AppMethodBeat.i(266750);
      this.JzD = paramk;
      AppMethodBeat.o(266750);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(266752);
      this.mFinished = true;
      k localk = this.JzD;
      if (localk != null) {
        localk.onTick(0L);
      }
      AppMethodBeat.o(266752);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(266751);
      k localk = this.JzD;
      if (localk != null) {
        localk.onTick(paramLong);
      }
      AppMethodBeat.o(266751);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.k
 * JD-Core Version:    0.7.0.1
 */