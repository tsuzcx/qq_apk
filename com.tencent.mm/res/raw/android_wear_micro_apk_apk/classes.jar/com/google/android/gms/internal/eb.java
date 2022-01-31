package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.b.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.ab;

abstract class eb
  extends ea
{
  protected final c<Void> RP;
  
  public eb(c<Void> paramc)
  {
    super(4);
    this.RP = paramc;
  }
  
  public void a(w paramw, boolean paramBoolean) {}
  
  public final void c(ar<?> paramar)
  {
    try
    {
      d(paramar);
      return;
    }
    catch (DeadObjectException paramar)
    {
      i(ea.b(paramar));
      throw paramar;
    }
    catch (RemoteException paramar)
    {
      i(ea.b(paramar));
    }
  }
  
  protected abstract void d(ar<?> paramar);
  
  public void i(Status paramStatus)
  {
    this.RP.b(new ab(paramStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.eb
 * JD-Core Version:    0.7.0.1
 */