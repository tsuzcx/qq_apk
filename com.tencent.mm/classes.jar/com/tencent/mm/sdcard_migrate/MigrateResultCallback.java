package com.tencent.mm.sdcard_migrate;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;

public abstract class MigrateResultCallback
  extends d.a
  implements Parcelable
{
  public static final Parcelable.Creator<MigrateResultCallback> CREATOR = new Parcelable.Creator() {};
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  
  protected abstract void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException);
  
  protected abstract void aah(int paramInt);
  
  protected abstract void aai(int paramInt);
  
  public final void aam(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aah(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211101);
        MigrateResultCallback.this.aah(paramInt);
        AppMethodBeat.o(211101);
      }
    });
  }
  
  public final void aan(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aai(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211103);
        MigrateResultCallback.this.aai(paramInt);
        AppMethodBeat.o(211103);
      }
    });
  }
  
  public final void b(final int paramInt, final ExtStorageMigrateException paramExtStorageMigrateException)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramInt, paramExtStorageMigrateException);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211104);
        MigrateResultCallback.this.a(paramInt, paramExtStorageMigrateException);
        AppMethodBeat.o(211104);
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void fjE()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      fjd();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211105);
        MigrateResultCallback.this.fjd();
        AppMethodBeat.o(211105);
      }
    });
  }
  
  protected abstract void fjc();
  
  protected abstract void fjd();
  
  protected abstract void js(int paramInt1, int paramInt2);
  
  public final void jt(final int paramInt1, final int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      js(paramInt1, paramInt2);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211106);
        MigrateResultCallback.this.js(paramInt1, paramInt2);
        AppMethodBeat.o(211106);
      }
    });
  }
  
  public final void lI(final String paramString1, final String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      fjc();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211102);
        MigrateResultCallback.this.fjc();
        AppMethodBeat.o(211102);
      }
    });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(asBinder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.MigrateResultCallback
 * JD-Core Version:    0.7.0.1
 */