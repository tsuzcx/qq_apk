package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract interface av
{
  public abstract <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT);
  
  public abstract ConnectionResult b(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT);
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public abstract void ik();
  
  public abstract boolean isConnected();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.av
 * JD-Core Version:    0.7.0.1
 */