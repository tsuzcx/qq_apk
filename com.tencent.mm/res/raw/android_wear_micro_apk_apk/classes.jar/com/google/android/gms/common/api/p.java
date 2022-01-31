package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.bp;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public abstract class p
{
  private static final Set<p> Hs = Collections.newSetFromMap(new WeakHashMap());
  
  public abstract ConnectionResult a(TimeUnit paramTimeUnit);
  
  public <A extends g, R extends w, T extends com.google.android.gms.internal.g<R, A>> T a(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void a(s params);
  
  public void a(bp parambp)
  {
    throw new UnsupportedOperationException();
  }
  
  public <A extends g, T extends com.google.android.gms.internal.g<? extends w, A>> T b(T paramT)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void b(s params);
  
  public void b(bp parambp)
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract void connect();
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public Looper getLooper()
  {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean isConnected();
  
  public <L> bb<L> s(L paramL)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.p
 * JD-Core Version:    0.7.0.1
 */