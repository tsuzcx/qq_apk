package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;

public final class ConnectionResult
  extends zza
{
  public static final Parcelable.Creator<ConnectionResult> CREATOR = new f();
  public static final ConnectionResult Hb = new ConnectionResult(0);
  final int Hc;
  private final int Hd;
  private final PendingIntent He;
  private final String Hf;
  
  public ConnectionResult(int paramInt)
  {
    this(paramInt, null, (byte)0);
  }
  
  ConnectionResult(int paramInt1, int paramInt2, PendingIntent paramPendingIntent, String paramString)
  {
    this.Hc = paramInt1;
    this.Hd = paramInt2;
    this.He = paramPendingIntent;
    this.Hf = paramString;
  }
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramPendingIntent, (byte)0);
  }
  
  private ConnectionResult(int paramInt, PendingIntent paramPendingIntent, byte paramByte)
  {
    this(1, paramInt, paramPendingIntent, null);
  }
  
  static String aY(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 31 + "UNKNOWN_ERROR_CODE(" + paramInt + ")";
    case 0: 
      return "SUCCESS";
    case 1: 
      return "SERVICE_MISSING";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED";
    case 3: 
      return "SERVICE_DISABLED";
    case 4: 
      return "SIGN_IN_REQUIRED";
    case 5: 
      return "INVALID_ACCOUNT";
    case 6: 
      return "RESOLUTION_REQUIRED";
    case 7: 
      return "NETWORK_ERROR";
    case 8: 
      return "INTERNAL_ERROR";
    case 9: 
      return "SERVICE_INVALID";
    case 10: 
      return "DEVELOPER_ERROR";
    case 11: 
      return "LICENSE_CHECK_FAILED";
    case 13: 
      return "CANCELED";
    case 14: 
      return "TIMEOUT";
    case 15: 
      return "INTERRUPTED";
    case 16: 
      return "API_UNAVAILABLE";
    case 17: 
      return "SIGN_IN_FAILED";
    case 18: 
      return "SERVICE_UPDATING";
    case 19: 
      return "SERVICE_MISSING_PERMISSION";
    case 20: 
      return "RESTRICTED_PROFILE";
    case 21: 
      return "API_VERSION_UPDATE_REQUIRED";
    case 1500: 
      return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
    case 99: 
      return "UNFINISHED";
    }
    return "UNKNOWN";
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ConnectionResult)) {
        return false;
      }
      paramObject = (ConnectionResult)paramObject;
    } while ((this.Hd == paramObject.Hd) && (b.b(this.He, paramObject.He)) && (b.b(this.Hf, paramObject.Hf)));
    return false;
  }
  
  public final int getErrorCode()
  {
    return this.Hd;
  }
  
  public final boolean gl()
  {
    return (this.Hd != 0) && (this.He != null);
  }
  
  public final boolean gm()
  {
    return this.Hd == 0;
  }
  
  public final PendingIntent gn()
  {
    return this.He;
  }
  
  public final String go()
  {
    return this.Hf;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.Hd), this.He, this.Hf });
  }
  
  public final String toString()
  {
    return b.t(this).a("statusCode", aY(this.Hd)).a("resolution", this.He).a("message", this.Hf).toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * JD-Core Version:    0.7.0.1
 */