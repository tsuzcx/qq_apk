package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class q
  implements aw
{
  private q(p paramp) {}
  
  public final void f(int paramInt, boolean paramBoolean)
  {
    p.a(this.OK).lock();
    try
    {
      if ((p.c(this.OK)) || (p.d(this.OK) == null) || (!p.d(this.OK).gw()))
      {
        p.a(this.OK, false);
        p.a(this.OK, paramInt, paramBoolean);
        return;
      }
      p.a(this.OK, true);
      p.e(this.OK).bx(paramInt);
      return;
    }
    finally
    {
      p.a(this.OK).unlock();
    }
  }
  
  public final void g(ConnectionResult paramConnectionResult)
  {
    p.a(this.OK).lock();
    try
    {
      p.a(this.OK, paramConnectionResult);
      p.b(this.OK);
      return;
    }
    finally
    {
      p.a(this.OK).unlock();
    }
  }
  
  public final void j(Bundle paramBundle)
  {
    p.a(this.OK).lock();
    try
    {
      p.a(this.OK, paramBundle);
      p.a(this.OK, ConnectionResult.IQ);
      p.b(this.OK);
      return;
    }
    finally
    {
      p.a(this.OK).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.q
 * JD-Core Version:    0.7.0.1
 */