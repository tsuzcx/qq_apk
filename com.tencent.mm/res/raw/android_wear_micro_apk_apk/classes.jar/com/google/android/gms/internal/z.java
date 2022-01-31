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
  private final am Ns;
  private boolean Nt = false;
  
  public z(am paramam)
  {
    this.Ns = paramam;
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
      this.Ns.MJ.Od.b(paramT);
      Object localObject1 = this.Ns.MJ;
      Object localObject2 = paramT.gr();
      localObject2 = (j)((ai)localObject1).NX.get(localObject2);
      d.e(localObject2, "Appropriate Api was not requested.");
      if ((!((j)localObject2).isConnected()) && (this.Ns.Oj.containsKey(paramT.gr())))
      {
        paramT.a(new Status(17));
        return paramT;
      }
      localObject1 = localObject2;
      if ((localObject2 instanceof i)) {
        localObject1 = ((i)localObject2).hc();
      }
      paramT.a((com.google.android.gms.common.api.g)localObject1);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.Ns.a(new an(this)
      {
        public final void iu()
        {
          z.this.bd(1);
        }
      });
    }
    return paramT;
  }
  
  public final void bd(int paramInt)
  {
    this.Ns.j(null);
    this.Ns.On.e(paramInt, this.Nt);
  }
  
  public final void begin() {}
  
  public final void connect()
  {
    if (this.Nt)
    {
      this.Nt = false;
      this.Ns.a(new an(this)
      {
        public final void iu()
        {
          z.a(z.this).On.j(null);
        }
      });
    }
  }
  
  public final boolean disconnect()
  {
    if (this.Nt) {
      return false;
    }
    if (this.Ns.MJ.iC())
    {
      this.Nt = true;
      Iterator localIterator = this.Ns.MJ.Oc.iterator();
      while (localIterator.hasNext()) {
        ((bp)localIterator.next()).jf();
      }
      return false;
    }
    this.Ns.j(null);
    return true;
  }
  
  public final void h(Bundle paramBundle) {}
  
  final void it()
  {
    if (this.Nt)
    {
      this.Nt = false;
      this.Ns.MJ.Od.release();
      disconnect();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.z
 * JD-Core Version:    0.7.0.1
 */