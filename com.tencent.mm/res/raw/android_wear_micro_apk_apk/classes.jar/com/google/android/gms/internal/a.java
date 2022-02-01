package com.google.android.gms.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.s;
import com.google.android.gms.common.internal.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class a
  extends i
{
  private final SparseArray<b> NM = new SparseArray();
  
  private a(az paramaz)
  {
    super(paramaz);
    this.QG.a("AutoManageHelper", this);
  }
  
  public static a a(ax paramax)
  {
    if (paramax.jh()) {}
    for (paramax = bo.a(paramax.jj());; paramax = ba.b(paramax.ji()))
    {
      a locala = (a)paramax.a("AutoManageHelper", a.class);
      if (locala == null) {
        break;
      }
      return locala;
    }
    return new a(paramax);
  }
  
  public final void a(int paramInt, p paramp, s params)
  {
    d.g(paramp, "GoogleApiClient instance cannot be null");
    if (this.NM.indexOfKey(paramInt) < 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      d.a(bool1, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      bool1 = this.hO;
      boolean bool2 = this.NZ;
      Log.d("AutoManageHelper", 54 + "starting AutoManage for client " + paramInt + " " + bool1 + " " + bool2);
      params = new b(this, paramInt, paramp, params);
      this.NM.put(paramInt, params);
      if ((this.hO) && (!this.NZ))
      {
        params = String.valueOf(paramp);
        Log.d("AutoManageHelper", String.valueOf(params).length() + 11 + "connecting " + params);
        paramp.connect();
      }
      return;
    }
  }
  
  protected final void a(ConnectionResult paramConnectionResult, int paramInt)
  {
    Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
    if (paramInt < 0) {
      Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (b)this.NM.get(paramInt);
      } while (localObject == null);
      b localb = (b)this.NM.get(paramInt);
      this.NM.remove(paramInt);
      if (localb != null)
      {
        localb.NO.b(localb);
        localb.NO.disconnect();
      }
      localObject = ((b)localObject).NP;
    } while (localObject == null);
    ((s)localObject).a(paramConnectionResult);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < this.NM.size())
    {
      b localb = (b)this.NM.valueAt(i);
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(localb.NN);
      paramPrintWriter.println(":");
      localb.NO.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
    }
  }
  
  protected final void ig()
  {
    int i = 0;
    while (i < this.NM.size())
    {
      ((b)this.NM.valueAt(i)).NO.connect();
      i += 1;
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    boolean bool = this.hO;
    String str = String.valueOf(this.NM);
    Log.d("AutoManageHelper", String.valueOf(str).length() + 14 + "onStart " + bool + " " + str);
    if (!this.NZ)
    {
      int i = 0;
      while (i < this.NM.size())
      {
        ((b)this.NM.valueAt(i)).NO.connect();
        i += 1;
      }
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    int i = 0;
    while (i < this.NM.size())
    {
      ((b)this.NM.valueAt(i)).NO.disconnect();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.a
 * JD-Core Version:    0.7.0.1
 */