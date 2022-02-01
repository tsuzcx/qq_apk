package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public abstract interface b
{
  public abstract byte[] a(Asset paramAsset);
  
  public abstract void ehi();
  
  public abstract GoogleApiClient ehj();
  
  public abstract HashSet<String> ehk();
  
  public abstract boolean ehl();
  
  public abstract void ehm();
  
  public abstract void finish();
  
  public abstract boolean isAvailable();
  
  public abstract boolean t(Uri paramUri);
  
  public abstract b.a v(String paramString, byte[] paramArrayOfByte);
  
  public abstract b.a w(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.b
 * JD-Core Version:    0.7.0.1
 */