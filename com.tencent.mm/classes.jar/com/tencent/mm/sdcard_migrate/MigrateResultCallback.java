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
  
  protected abstract void arU(int paramInt);
  
  protected abstract void arV(int paramInt);
  
  public final void arZ(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      arU(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191762);
        MigrateResultCallback.this.arU(paramInt);
        AppMethodBeat.o(191762);
      }
    });
  }
  
  public final void asa(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      arV(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192199);
        MigrateResultCallback.this.arV(paramInt);
        AppMethodBeat.o(192199);
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
        AppMethodBeat.i(191827);
        MigrateResultCallback.this.a(paramInt, paramExtStorageMigrateException);
        AppMethodBeat.o(191827);
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected abstract void hsG();
  
  protected abstract void hsH();
  
  public final void hth()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      hsH();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191563);
        MigrateResultCallback.this.hsH();
        AppMethodBeat.o(191563);
      }
    });
  }
  
  protected abstract void ma(int paramInt1, int paramInt2);
  
  public final void mb(final int paramInt1, final int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ma(paramInt1, paramInt2);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192355);
        MigrateResultCallback.this.ma(paramInt1, paramInt2);
        AppMethodBeat.o(192355);
      }
    });
  }
  
  public final void nE(final String paramString1, final String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      hsG();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192471);
        MigrateResultCallback.this.hsG();
        AppMethodBeat.o(192471);
      }
    });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(asBinder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.MigrateResultCallback
 * JD-Core Version:    0.7.0.1
 */