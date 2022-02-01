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
  
  protected abstract void aaN(int paramInt);
  
  protected abstract void aaO(int paramInt);
  
  public final void aaS(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aaN(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211885);
        MigrateResultCallback.this.aaN(paramInt);
        AppMethodBeat.o(211885);
      }
    });
  }
  
  public final void aaT(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aaO(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211887);
        MigrateResultCallback.this.aaO(paramInt);
        AppMethodBeat.o(211887);
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
        AppMethodBeat.i(211888);
        MigrateResultCallback.this.a(paramInt, paramExtStorageMigrateException);
        AppMethodBeat.o(211888);
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected abstract void fmU();
  
  protected abstract void fmV();
  
  public final void fnw()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      fmV();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211889);
        MigrateResultCallback.this.fmV();
        AppMethodBeat.o(211889);
      }
    });
  }
  
  protected abstract void jw(int paramInt1, int paramInt2);
  
  public final void jx(final int paramInt1, final int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      jw(paramInt1, paramInt2);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211890);
        MigrateResultCallback.this.jw(paramInt1, paramInt2);
        AppMethodBeat.o(211890);
      }
    });
  }
  
  public final void lP(final String paramString1, final String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      fmU();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(211886);
        MigrateResultCallback.this.fmU();
        AppMethodBeat.o(211886);
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