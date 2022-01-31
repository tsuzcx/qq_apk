package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.d;

public abstract class g<R extends w, A extends com.google.android.gms.common.api.g>
  extends k<R>
  implements h<R>
{
  private final a<?> HU;
  private final com.google.android.gms.common.api.h<A> Mj;
  
  protected g(a<?> parama, p paramp)
  {
    super((p)d.e(paramp, "GoogleApiClient must not be null"));
    this.Mj = parama.gr();
    this.HU = parama;
  }
  
  private void a(RemoteException paramRemoteException)
  {
    a(new Status(8, paramRemoteException.getLocalizedMessage(), null));
  }
  
  public final void a(Status paramStatus)
  {
    if (!paramStatus.gm()) {}
    for (boolean bool = true;; bool = false)
    {
      d.b(bool, "Failed result must not be success");
      b(c(paramStatus));
      return;
    }
  }
  
  public final void a(A paramA)
  {
    try
    {
      b(paramA);
      return;
    }
    catch (DeadObjectException paramA)
    {
      a(paramA);
      throw paramA;
    }
    catch (RemoteException paramA)
    {
      a(paramA);
    }
  }
  
  protected abstract void b(A paramA);
  
  public final a<?> gI()
  {
    return this.HU;
  }
  
  public final com.google.android.gms.common.api.h<A> gr()
  {
    return this.Mj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.g
 * JD-Core Version:    0.7.0.1
 */