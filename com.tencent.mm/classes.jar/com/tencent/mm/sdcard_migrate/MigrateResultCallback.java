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
  
  protected abstract void axZ(int paramInt);
  
  protected abstract void aya(int paramInt);
  
  public final void aye(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      axZ(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257083);
        MigrateResultCallback.this.axZ(paramInt);
        AppMethodBeat.o(257083);
      }
    });
  }
  
  public final void ayf(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      aya(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257081);
        MigrateResultCallback.this.aya(paramInt);
        AppMethodBeat.o(257081);
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
        AppMethodBeat.i(257080);
        MigrateResultCallback.this.a(paramInt, paramExtStorageMigrateException);
        AppMethodBeat.o(257080);
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected abstract void iSL();
  
  protected abstract void iSM();
  
  public final void iTn()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      iSM();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257074);
        MigrateResultCallback.this.iSM();
        AppMethodBeat.o(257074);
      }
    });
  }
  
  protected abstract void nP(int paramInt1, int paramInt2);
  
  public final void nQ(final int paramInt1, final int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      nP(paramInt1, paramInt2);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257076);
        MigrateResultCallback.this.nP(paramInt1, paramInt2);
        AppMethodBeat.o(257076);
      }
    });
  }
  
  public final void pA(final String paramString1, final String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      iSL();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(257085);
        MigrateResultCallback.this.iSL();
        AppMethodBeat.o(257085);
      }
    });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(asBinder());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdcard_migrate.MigrateResultCallback
 * JD-Core Version:    0.7.0.1
 */