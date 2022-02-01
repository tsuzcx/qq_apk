package com.google.android.gms.wearable;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PutDataRequest
  extends zza
{
  public static final Parcelable.Creator<PutDataRequest> CREATOR = new ak();
  private static final long Uj = TimeUnit.MINUTES.toMillis(30L);
  private static final Random Uk = new SecureRandom();
  private final Uri Kv;
  private byte[] TW;
  private final Bundle Ul;
  private long Um;
  
  private PutDataRequest(Uri paramUri)
  {
    this(paramUri, new Bundle(), null, Uj);
  }
  
  PutDataRequest(Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte, long paramLong)
  {
    this.Kv = paramUri;
    this.Ul = paramBundle;
    this.Ul.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
    this.TW = paramArrayOfByte;
    this.Um = paramLong;
  }
  
  public static PutDataRequest d(Uri paramUri)
  {
    return new PutDataRequest(paramUri);
  }
  
  public static PutDataRequest w(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("An empty path was supplied.");
    }
    if (!paramString.startsWith("/")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    if (paramString.startsWith("//")) {
      throw new IllegalArgumentException("A path must start with a single / .");
    }
    return d(new Uri.Builder().scheme("wear").path(paramString).build());
  }
  
  public final PutDataRequest b(String paramString, Asset paramAsset)
  {
    d.D(paramString);
    d.D(paramAsset);
    this.Ul.putParcelable(paramString, paramAsset);
    return this;
  }
  
  public final PutDataRequest f(byte[] paramArrayOfByte)
  {
    this.TW = paramArrayOfByte;
    return this;
  }
  
  public final byte[] getData()
  {
    return this.TW;
  }
  
  public final Uri getUri()
  {
    return this.Kv;
  }
  
  public final Map<String, Asset> kE()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.Ul.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, (Asset)this.Ul.getParcelable(str));
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public final Bundle kM()
  {
    return this.Ul;
  }
  
  public final long kN()
  {
    return this.Um;
  }
  
  public final boolean kO()
  {
    return this.Um == 0L;
  }
  
  public final PutDataRequest kP()
  {
    this.Um = 0L;
    return this;
  }
  
  public String toString()
  {
    boolean bool = Log.isLoggable("DataMap", 3);
    StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
    if (this.TW == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.TW.length))
    {
      localObject = String.valueOf(localObject);
      localStringBuilder.append(String.valueOf(localObject).length() + 7 + "dataSz=" + (String)localObject);
      int i = this.Ul.size();
      localStringBuilder.append(23 + ", numAssets=" + i);
      localObject = String.valueOf(this.Kv);
      localStringBuilder.append(String.valueOf(localObject).length() + 6 + ", uri=" + (String)localObject);
      long l = this.Um;
      localStringBuilder.append(35 + ", syncDeadline=" + l);
      if (bool) {
        break;
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    localStringBuilder.append("]\n  assets: ");
    localObject = this.Ul.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = String.valueOf(this.Ul.getParcelable(str1));
      localStringBuilder.append(String.valueOf(str1).length() + 7 + String.valueOf(str2).length() + "\n    " + str1 + ": " + str2);
    }
    localStringBuilder.append("\n  ]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ak.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataRequest
 * JD-Core Version:    0.7.0.1
 */