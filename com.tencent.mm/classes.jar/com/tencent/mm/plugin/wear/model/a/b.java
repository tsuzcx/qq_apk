package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public abstract interface b
{
  public abstract b.a B(String paramString, byte[] paramArrayOfByte);
  
  public abstract b.a C(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] a(Asset paramAsset);
  
  public abstract void cYG();
  
  public abstract GoogleApiClient cYH();
  
  public abstract HashSet<String> cYI();
  
  public abstract boolean cYJ();
  
  public abstract void cYK();
  
  public abstract void finish();
  
  public abstract boolean isAvailable();
  
  public abstract boolean j(Uri paramUri);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.b
 * JD-Core Version:    0.7.0.1
 */