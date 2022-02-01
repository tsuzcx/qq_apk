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
  
  protected abstract void Yd(int paramInt);
  
  protected abstract void Ye(int paramInt);
  
  public final void Yh(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Yd(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195866);
        MigrateResultCallback.this.Yd(paramInt);
        AppMethodBeat.o(195866);
      }
    });
  }
  
  public final void Yi(final int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Ye(paramInt);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195868);
        MigrateResultCallback.this.Ye(paramInt);
        AppMethodBeat.o(195868);
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
        AppMethodBeat.i(195869);
        MigrateResultCallback.this.a(paramInt, paramExtStorageMigrateException);
        AppMethodBeat.o(195869);
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  protected abstract void eTA();
  
  protected abstract void eTz();
  
  public final void eUb()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      eTA();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195870);
        MigrateResultCallback.this.eTA();
        AppMethodBeat.o(195870);
      }
    });
  }
  
  protected abstract void jg(int paramInt1, int paramInt2);
  
  public final void jh(final int paramInt1, final int paramInt2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      jg(paramInt1, paramInt2);
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195871);
        MigrateResultCallback.this.jg(paramInt1, paramInt2);
        AppMethodBeat.o(195871);
      }
    });
  }
  
  public final void lj(final String paramString1, final String paramString2)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      eTz();
      return;
    }
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(195867);
        MigrateResultCallback.this.eTz();
        AppMethodBeat.o(195867);
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