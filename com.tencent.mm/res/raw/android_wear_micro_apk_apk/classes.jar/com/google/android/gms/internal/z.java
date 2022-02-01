package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.w;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class z
  implements al
{
  private final am Ph;
  private boolean Pi = false;
  
  public z(am paramam)
  {
    this.Ph = paramam;
  }
  
  public final <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT)
  {
    return b(paramT);
  }
  
  public final void a(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean) {}
  
  public final <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT)
  {
    try
    {
      this.Ph.Oy.PS.b(paramT);
      Object localObject1 = this.Ph.Oy;
      Object localObject2 = paramT.gB();
      localObject2 = (j)((ai)localObject1).PM.get(localObject2);
      d.g(localObject2, "Appropriate Api was not requested.");
      if ((!((j)localObject2).isConnected()) && (this.Ph.PY.containsKey(paramT.gB())))
      {
        paramT.a(new Status(17));
        return paramT;
      }
      localObject1 = localObject2;
      if ((localObject2 instanceof i)) {
        localObject1 = ((i)localObject2).hm();
      }
      paramT.a((com.google.android.gms.common.api.g)localObject1);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.Ph.a(new an(this)
      {
        public final void iC()
        {
          z.this.bx(1);
        }
      });
    }
    return paramT;
  }
  
  public final void begin() {}
  
  public final void bx(int paramInt)
  {
    this.Ph.k(null);
    this.Ph.Qc.f(paramInt, this.Pi);
  }
  
  public final void connect()
  {
    if (this.Pi)
    {
      this.Pi = false;
      this.Ph.a(new an(this)
      {
        public final void iC()
        {
          z.a(z.this).Qc.j(null);
        }
      });
    }
  }
  
  public final boolean disconnect()
  {
    if (this.Pi) {
      return false;
    }
    if (this.Ph.Oy.iK())
    {
      this.Pi = true;
      Iterator localIterator = this.Ph.Oy.PR.iterator();
      while (localIterator.hasNext()) {
        ((bp)localIterator.next()).jo();
      }
      return false;
    }
    this.Ph.k(null);
    return true;
  }
  
  public final void h(Bundle paramBundle) {}
  
  final void iB()
  {
    if (this.Pi)
    {
      this.Pi = false;
      this.Ph.Oy.PS.release();
      disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.z
 * JD-Core Version:    0.7.0.1
 */