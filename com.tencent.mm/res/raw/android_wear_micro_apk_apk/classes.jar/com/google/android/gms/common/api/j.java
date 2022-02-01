package com.google.android.gms.common.api;

import android.content.Intent;
import com.google.android.gms.common.internal.ak;
import com.google.android.gms.common.internal.r;
import java.io.PrintWriter;
import java.util.Set;

public abstract interface j
  extends g
{
  public abstract void a(ak paramak, Set<Scope> paramSet);
  
  public abstract void a(r paramr);
  
  public abstract void a(String paramString, PrintWriter paramPrintWriter);
  
  public abstract void disconnect();
  
  public abstract boolean gC();
  
  public abstract boolean gD();
  
  public abstract Intent gE();
  
  public abstract boolean isConnected();
  
  public abstract boolean isConnecting();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.j
 * JD-Core Version:    0.7.0.1
 */