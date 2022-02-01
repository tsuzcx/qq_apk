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
  private final Status JH;
  private volatile ParcelFileDescriptor UW;
  private volatile InputStream UX;
  private volatile boolean mClosed = false;
  
  public h(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.JH = paramStatus;
    this.UW = paramParcelFileDescriptor;
  }
  
  public final Status gM()
  {
    return this.JH;
  }
  
  public final InputStream getInputStream()
  {
    if (this.mClosed) {
      throw new IllegalStateException("Cannot access the input stream after release().");
    }
    if (this.UW == null) {
      return null;
    }
    if (this.UX == null) {
      this.UX = new ParcelFileDescriptor.AutoCloseInputStream(this.UW);
    }
    return this.UX;
  }
  
  public final void release()
  {
    if (this.UW == null) {
      return;
    }
    if (this.mClosed) {
      throw new IllegalStateException("releasing an already released result.");
    }
    try
    {
      if (this.UX != null) {
        this.UX.close();
      }
      for (;;)
      {
        this.mClosed = true;
        this.UW = null;
        this.UX = null;
        return;
        this.UW.close();
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