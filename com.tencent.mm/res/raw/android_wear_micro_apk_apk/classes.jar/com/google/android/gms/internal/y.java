package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.s;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class y
  extends p
{
  private final UnsupportedOperationException Pg;
  
  public y(String paramString)
  {
    this.Pg = new UnsupportedOperationException(paramString);
  }
  
  public final ConnectionResult a(TimeUnit paramTimeUnit)
  {
    throw this.Pg;
  }
  
  public final void a(s params)
  {
    throw this.Pg;
  }
  
  public final void b(s params)
  {
    throw this.Pg;
  }
  
  public final void connect()
  {
    throw this.Pg;
  }
  
  public final void disconnect()
  {
    throw this.Pg;
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    throw this.Pg;
  }
  
  public final boolean isConnected()
  {
    throw this.Pg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.y
 * JD-Core Version:    0.7.0.1
 */