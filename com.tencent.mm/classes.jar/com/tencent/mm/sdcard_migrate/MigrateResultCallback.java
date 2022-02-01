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
  
  protected abstract void VU(int paramInt);
  
  protected abstract void VV(int paramInt);
  
  public final void VY(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      VU(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196846);
        MigrateResultCallback.this.VU(paramInt);
        AppMethodBeat.o(196846);
      }
    });
  }
  
  public final void VZ(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      VV(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196848);
        MigrateResultCallback.this.VV(paramInt);
        AppMethodBeat.o(196848);
      }
    });
  }
  
  protected abstract void a(int paramInt, ExtStorageMigrateException paramExtStorageMigrateException);
  
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
        AppMethodBeat.i(196849);
        MigrateResultCallback.this.a(paramInt, paramExtStorageMigrateException);
        AppMethodBeat.o(196849);
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final void eEH()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      eEg();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196850);
        MigrateResultCallback.this.eEg();
        AppMethodBeat.o(196850);
      }
    });
  }
  
  protected abstract void eEf();
  
  protected abstract void eEg();
  
  protected abstract void iT(int paramInt1, int paramInt2);
  
  public final void iU(final int paramInt1, final int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      iT(paramInt1, paramInt2);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196851);
        MigrateResultCallback.this.iT(paramInt1, paramInt2);
        AppMethodBeat.o(196851);
      }
    });
  }
  
  public final void kM(final String paramString1, final String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      eEf();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(196847);
        MigrateResultCallback.this.eEf();
        AppMethodBeat.o(196847);
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