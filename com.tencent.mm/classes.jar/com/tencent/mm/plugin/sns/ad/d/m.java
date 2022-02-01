package com.tencent.mm.plugin.sns.ad.d;

import android.os.CountDownTimer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class m
{
  protected final long POg;
  final int POh;
  public b POi;
  public a POj;
  protected final long mStartTime;
  
  public m(long paramLong1, long paramLong2)
  {
    this(paramLong1, paramLong2, (byte)0);
  }
  
  private m(long paramLong1, long paramLong2, byte paramByte)
  {
    this.mStartTime = paramLong1;
    this.POg = paramLong2;
    this.POh = 1000;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(309971);
    if (isValid())
    {
      if ((this.POi != null) && (!this.POi.mFinished))
      {
        this.POi.cancel();
        this.POi = null;
      }
      this.POj = parama;
      l = gZR();
      if (l < this.mStartTime) {
        break label100;
      }
    }
    label100:
    for (long l = this.POg - l;; l = -1L)
    {
      if (l > 0L)
      {
        this.POi = new b(this, l);
        this.POi.start();
      }
      AppMethodBeat.o(309971);
      return;
    }
  }
  
  protected long gZR()
  {
    AppMethodBeat.i(309963);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(309963);
    return l;
  }
  
  protected boolean isValid()
  {
    AppMethodBeat.i(309956);
    if ((gZR() <= this.POg) && (this.POg > this.mStartTime) && (this.mStartTime >= 0L))
    {
      AppMethodBeat.o(309956);
      return true;
    }
    AppMethodBeat.o(309956);
    return false;
  }
  
  final void onTick(long paramLong)
  {
    AppMethodBeat.i(309975);
    Log.d("SnsAd.CountDownTimer", "the millisUntilFinished is ".concat(String.valueOf(paramLong)));
    a locala = this.POj;
    if (locala != null) {
      locala.uo(paramLong);
    }
    AppMethodBeat.o(309975);
  }
  
  public static abstract interface a
  {
    public abstract void uo(long paramLong);
  }
  
  public static final class b
    extends CountDownTimer
  {
    m POk;
    boolean mFinished = false;
    
    private b(long paramLong1, long paramLong2)
    {
      super(paramLong2);
    }
    
    b(m paramm, long paramLong)
    {
      this(paramLong, paramm.POh);
      AppMethodBeat.i(309979);
      this.POk = paramm;
      AppMethodBeat.o(309979);
    }
    
    public final void onFinish()
    {
      AppMethodBeat.i(309989);
      this.mFinished = true;
      m localm = this.POk;
      if (localm != null) {
        localm.onTick(0L);
      }
      AppMethodBeat.o(309989);
    }
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(309984);
      m localm = this.POk;
      if (localm != null) {
        localm.onTick(paramLong);
      }
      AppMethodBeat.o(309984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.m
 * JD-Core Version:    0.7.0.1
 */