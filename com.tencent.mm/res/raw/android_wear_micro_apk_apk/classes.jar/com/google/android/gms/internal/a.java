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
  private final SparseArray<b> LX = new SparseArray();
  
  private a(az paramaz)
  {
    super(paramaz);
    this.OR.a("AutoManageHelper", this);
  }
  
  public static a a(ax paramax)
  {
    if (paramax.iY()) {}
    for (paramax = bo.a(paramax.ja());; paramax = ba.b(paramax.iZ()))
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
    d.e(paramp, "GoogleApiClient instance cannot be null");
    if (this.LX.indexOfKey(paramInt) < 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      d.a(bool1, 54 + "Already managing a GoogleApiClient with id " + paramInt);
      bool1 = this.ej;
      boolean bool2 = this.Mk;
      Log.d("AutoManageHelper", 54 + "starting AutoManage for client " + paramInt + " " + bool1 + " " + bool2);
      params = new b(this, paramInt, paramp, params);
      this.LX.put(paramInt, params);
      if ((this.ej) && (!this.Mk))
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
        localObject = (b)this.LX.get(paramInt);
      } while (localObject == null);
      b localb = (b)this.LX.get(paramInt);
      this.LX.remove(paramInt);
      if (localb != null)
      {
        localb.LZ.b(localb);
        localb.LZ.disconnect();
      }
      localObject = ((b)localObject).Ma;
    } while (localObject == null);
    ((s)localObject).a(paramConnectionResult);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i = 0;
    while (i < this.LX.size())
    {
      b localb = (b)this.LX.valueAt(i);
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(localb.LY);
      paramPrintWriter.println(":");
      localb.LZ.dump(String.valueOf(paramString).concat("  "), paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      i += 1;
    }
  }
  
  protected final void hY()
  {
    int i = 0;
    while (i < this.LX.size())
    {
      ((b)this.LX.valueAt(i)).LZ.connect();
      i += 1;
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    boolean bool = this.ej;
    String str = String.valueOf(this.LX);
    Log.d("AutoManageHelper", String.valueOf(str).length() + 14 + "onStart " + bool + " " + str);
    if (!this.Mk)
    {
      int i = 0;
      while (i < this.LX.size())
      {
        ((b)this.LX.valueAt(i)).LZ.connect();
        i += 1;
      }
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    int i = 0;
    while (i < this.LX.size())
    {
      ((b)this.LX.valueAt(i)).LZ.disconnect();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.a
 * JD-Core Version:    0.7.0.1
 */