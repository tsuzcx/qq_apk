package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public abstract interface b
{
  public abstract byte[] a(Asset paramAsset);
  
  public abstract void fVZ();
  
  public abstract GoogleApiClient fWa();
  
  public abstract HashSet<String> fWb();
  
  public abstract boolean fWc();
  
  public abstract void fWd();
  
  public abstract void finish();
  
  public abstract boolean isAvailable();
  
  public abstract boolean u(Uri paramUri);
  
  public abstract b.a w(String paramString, byte[] paramArrayOfByte);
  
  public abstract b.a x(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.a.b
 * JD-Core Version:    0.7.0.1
 */