package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.w;

public abstract interface al
{
  public abstract <A extends com.google.android.gms.common.api.g, R extends w, T extends g<R, A>> T a(T paramT);
  
  public abstract void a(ConnectionResult paramConnectionResult, a<?> parama, boolean paramBoolean);
  
  public abstract <A extends com.google.android.gms.common.api.g, T extends g<? extends w, A>> T b(T paramT);
  
  public abstract void bd(int paramInt);
  
  public abstract void begin();
  
  public abstract void connect();
  
  public abstract boolean disconnect();
  
  public abstract void h(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.internal.al
 * JD-Core Version:    0.7.0.1
 */