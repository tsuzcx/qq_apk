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
  
  protected abstract void ajC(int paramInt);
  
  protected abstract void ajD(int paramInt);
  
  public final void ajH(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ajC(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204647);
        MigrateResultCallback.this.ajC(paramInt);
        AppMethodBeat.o(204647);
      }
    });
  }
  
  public final void ajI(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ajD(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204649);
        MigrateResultCallback.this.ajD(paramInt);
        AppMethodBeat.o(204649);
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
        AppMethodBeat.i(204650);
        MigrateResultCallback.this.a(paramInt, paramExtStorageMigrateException);
        AppMethodBeat.o(204650);
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected abstract void gwH();
  
  protected abstract void gwI();
  
  public final void gxi()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      gwI();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204651);
        MigrateResultCallback.this.gwI();
        AppMethodBeat.o(204651);
      }
    });
  }
  
  protected abstract void kI(int paramInt1, int paramInt2);
  
  public final void kJ(final int paramInt1, final int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      kI(paramInt1, paramInt2);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204652);
        MigrateResultCallback.this.kI(paramInt1, paramInt2);
        AppMethodBeat.o(204652);
      }
    });
  }
  
  public final void mN(final String paramString1, final String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      gwH();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(204648);
        MigrateResultCallback.this.gwH();
        AppMethodBeat.o(204648);
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