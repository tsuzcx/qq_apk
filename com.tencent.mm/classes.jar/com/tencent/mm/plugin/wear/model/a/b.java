package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public abstract interface b
{
  public abstract byte[] a(Asset paramAsset);
  
  public abstract void bYT();
  
  public abstract GoogleApiClient bYU();
  
  public abstract HashSet<String> bYV();
  
  public abstract boolean bYW();
  
  public abstract void bYX();
  
  public abstract void finish();
  
  public abstract boolean h(Uri paramUri);
  
  public abstract boolean isAvailable();
  
  public abstract b.a t(String paramString, byte[] paramArrayOfByte);
  
  public abstract b.a u(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.b
 * JD-Core Version:    0.7.0.1
 */