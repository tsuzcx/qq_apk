package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;

public final class Status
  extends zza
  implements w, ReflectedParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new af();
  public static final Status JA = new Status(0);
  public static final Status JB = new Status(14);
  public static final Status JC = new Status(8);
  public static final Status JD = new Status(15);
  public static final Status JE = new Status(16);
  public static final Status JF = new Status(17);
  public static final Status JG = new Status(18);
  final int IR;
  private final int IS;
  private final PendingIntent IT;
  private final String IU;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.IR = paramInt1;
    this.IS = paramInt2;
    this.IU = paramString;
    this.IT = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    do
    {
      return false;
      paramObject = (Status)paramObject;
    } while ((this.IR != paramObject.IR) || (this.IS != paramObject.IS) || (!b.c(this.IU, paramObject.IU)) || (!b.c(this.IT, paramObject.IT)));
    return true;
  }
  
  public final Status gM()
  {
    return this;
  }
  
  final PendingIntent gP()
  {
    return this.IT;
  }
  
  public final String gQ()
  {
    return this.IU;
  }
  
  public final int getStatusCode()
  {
    return this.IS;
  }
  
  public final boolean gw()
  {
    return this.IS <= 0;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.IR), Integer.valueOf(this.IS), this.IU, this.IT });
  }
  
  public final String toString()
  {
    c localc = b.C(this);
    if (this.IU != null) {}
    for (String str = this.IU;; str = o.bw(this.IS)) {
      return localc.a("statusCode", str).a("resolution", this.IT).toString();
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    af.a(this, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.7.0.1
 */