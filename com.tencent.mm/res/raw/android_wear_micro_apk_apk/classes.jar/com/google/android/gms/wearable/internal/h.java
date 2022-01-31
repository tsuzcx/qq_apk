package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.i;
import java.io.IOException;
import java.io.InputStream;

public final class h
  implements i
{
  private final Status HS;
  private volatile ParcelFileDescriptor Th;
  private volatile InputStream Ti;
  private volatile boolean mClosed = false;
  
  public h(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.HS = paramStatus;
    this.Th = paramParcelFileDescriptor;
  }
  
  public final Status gC()
  {
    return this.HS;
  }
  
  public final InputStream getInputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Cannot access the input stream after release().");
    }
    if (this.Th == null) {
      return null;
    }
    if (this.Ti == null) {
      this.Ti = new ParcelFileDescriptor.AutoCloseInputStream(this.Th);
    }
    return this.Ti;
  }
  
  public final void release()
  {
    if (this.Th == null) {
      return;
    }
    if (this.mClosed) {
      throw new IllegalStateException("releasing an already released result.");
    }
    try
    {
      if (this.Ti != null) {
        this.Ti.close();
      }
      for (;;)
      {
        this.mClosed = true;
        this.Th = null;
        this.Ti = null;
        return;
        this.Th.close();
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.h
 * JD-Core Version:    0.7.0.1
 */