package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public abstract interface b
{
  public abstract b.a E(String paramString, byte[] paramArrayOfByte);
  
  public abstract b.a F(String paramString, byte[] paramArrayOfByte);
  
  public abstract byte[] a(Asset paramAsset);
  
  public abstract void finish();
  
  public abstract void inW();
  
  public abstract GoogleApiClient inX();
  
  public abstract HashSet<String> inY();
  
  public abstract boolean inZ();
  
  public abstract void ioa();
  
  public abstract boolean isAvailable();
  
  public abstract boolean n(Uri paramUri);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.b
 * JD-Core Version:    0.7.0.1
 */