package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.t;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.wearable.Channel;

public class zzu
  extends zza
  implements Channel
{
  public static final Parcelable.Creator<zzu> CREATOR = new cp();
  private final String Uf;
  private final String VH;
  private final String Vv;
  
  public zzu(String paramString1, String paramString2, String paramString3)
  {
    this.VH = ((String)d.D(paramString1));
    this.Uf = ((String)d.D(paramString2));
    this.Vv = ((String)d.D(paramString3));
  }
  
  public final t<Status> a(p paramp)
  {
    paramp.a(new ci(paramp) {});
  }
  
  public final t<Status> a(p paramp, final Uri paramUri)
  {
    d.g(paramp, "client is null");
    d.g(this.VH, "token is null");
    d.g(paramUri, "uri is null");
    if (0L >= 0L)
    {
      bool = true;
      d.a(bool, "startOffset is negative: %s", new Object[] { Long.valueOf(0L) });
      if ((-1L < 0L) && (-1L != -1L)) {
        break label112;
      }
    }
    label112:
    for (boolean bool = true;; bool = false)
    {
      d.a(bool, "invalid length: %s", new Object[] { Long.valueOf(-1L) });
      paramp.a(new ci(paramp) {});
      bool = false;
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzu)) {
        return false;
      }
      paramObject = (zzu)paramObject;
    } while ((this.VH.equals(paramObject.VH)) && (b.c(paramObject.Uf, this.Uf)) && (b.c(paramObject.Vv, this.Vv)));
    return false;
  }
  
  public final String getPath()
  {
    return this.Vv;
  }
  
  public int hashCode()
  {
    return this.VH.hashCode();
  }
  
  public final String kz()
  {
    return this.Uf;
  }
  
  public final String lh()
  {
    return this.VH;
  }
  
  public String toString()
  {
    String str1 = this.VH;
    String str2 = this.Uf;
    String str3 = this.Vv;
    return String.valueOf(str1).length() + 43 + String.valueOf(str2).length() + String.valueOf(str3).length() + "ChannelImpl{, token='" + str1 + "', nodeId='" + str2 + "', path='" + str3 + "'}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    cp.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzu
 * JD-Core Version:    0.7.0.1
 */