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
  
  public abstract void finish();
  
  public abstract void gOI();
  
  public abstract GoogleApiClient gOJ();
  
  public abstract HashSet<String> gOK();
  
  public abstract boolean gOL();
  
  public abstract void gOM();
  
  public abstract boolean isAvailable();
  
  public abstract boolean l(Uri paramUri);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.b
 * JD-Core Version:    0.7.0.1
 */