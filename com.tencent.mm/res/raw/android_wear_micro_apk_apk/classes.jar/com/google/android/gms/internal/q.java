package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class q
  implements aw
{
  private q(p paramp) {}
  
  public final void e(int paramInt, boolean paramBoolean)
  {
    p.a(this.MV).lock();
    try
    {
      if ((p.c(this.MV)) || (p.d(this.MV) == null) || (!p.d(this.MV).gm()))
      {
        p.a(this.MV, false);
        p.a(this.MV, paramInt, paramBoolean);
        return;
      }
      p.a(this.MV, true);
      p.e(this.MV).bd(paramInt);
      return;
    }
    finally
    {
      p.a(this.MV).unlock();
    }
  }
  
  public final void g(ConnectionResult paramConnectionResult)
  {
    p.a(this.MV).lock();
    try
    {
      p.a(this.MV, paramConnectionResult);
      p.b(this.MV);
      return;
    }
    finally
    {
      p.a(this.MV).unlock();
    }
  }
  
  public final void j(Bundle paramBundle)
  {
    p.a(this.MV).lock();
    try
    {
      p.a(this.MV, paramBundle);
      p.a(this.MV, ConnectionResult.Hb);
      p.b(this.MV);
      return;
    }
    finally
    {
      p.a(this.MV).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.q
 * JD-Core Version:    0.7.0.1
 */