package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.Arrays;

public class ConnectionConfiguration
  extends zza
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new aj();
  private final int II;
  private final String TZ;
  private final int Ua;
  private final boolean Ub;
  private boolean Uc;
  private String Ud;
  private boolean Ue;
  private String Uf;
  private final String mName;
  
  ConnectionConfiguration(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.mName = paramString1;
    this.TZ = paramString2;
    this.II = paramInt1;
    this.Ua = paramInt2;
    this.Ub = paramBoolean1;
    this.Uc = paramBoolean2;
    this.Ud = paramString3;
    this.Ue = paramBoolean3;
    this.Uf = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!b.c(this.mName, paramObject.mName)) || (!b.c(this.TZ, paramObject.TZ)) || (!b.c(Integer.valueOf(this.II), Integer.valueOf(paramObject.II))) || (!b.c(Integer.valueOf(this.Ua), Integer.valueOf(paramObject.Ua))) || (!b.c(Boolean.valueOf(this.Ub), Boolean.valueOf(paramObject.Ub))) || (!b.c(Boolean.valueOf(this.Ue), Boolean.valueOf(paramObject.Ue))));
    return true;
  }
  
  public final String getAddress()
  {
    return this.TZ;
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final int getRole()
  {
    return this.Ua;
  }
  
  public final int getType()
  {
    return this.II;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.mName, this.TZ, Integer.valueOf(this.II), Integer.valueOf(this.Ua), Boolean.valueOf(this.Ub), Boolean.valueOf(this.Ue) });
  }
  
  public final boolean isConnected()
  {
    return this.Uc;
  }
  
  public final boolean isEnabled()
  {
    return this.Ub;
  }
  
  public final String kB()
  {
    return this.Ud;
  }
  
  public final boolean kC()
  {
    return this.Ue;
  }
  
  public final String kz()
  {
    return this.Uf;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    String str = String.valueOf(this.mName);
    if (str.length() != 0)
    {
      str = "mName=".concat(str);
      localStringBuilder.append(str);
      str = String.valueOf(this.TZ);
      if (str.length() == 0) {
        break label314;
      }
      str = ", mAddress=".concat(str);
      label62:
      localStringBuilder.append(str);
      int i = this.II;
      localStringBuilder.append(19 + ", mType=" + i);
      i = this.Ua;
      localStringBuilder.append(19 + ", mRole=" + i);
      boolean bool = this.Ub;
      localStringBuilder.append(16 + ", mEnabled=" + bool);
      bool = this.Uc;
      localStringBuilder.append(20 + ", mIsConnected=" + bool);
      str = String.valueOf(this.Ud);
      if (str.length() == 0) {
        break label327;
      }
      str = ", mPeerNodeId=".concat(str);
      label219:
      localStringBuilder.append(str);
      bool = this.Ue;
      localStringBuilder.append(21 + ", mBtlePriority=" + bool);
      str = String.valueOf(this.Uf);
      if (str.length() == 0) {
        break label340;
      }
    }
    label314:
    label327:
    label340:
    for (str = ", mNodeId=".concat(str);; str = new String(", mNodeId="))
    {
      localStringBuilder.append(str);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str = new String("mName=");
      break;
      str = new String(", mAddress=");
      break label62;
      str = new String(", mPeerNodeId=");
      break label219;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    aj.a(this, paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.wearable.ConnectionConfiguration
 * JD-Core Version:    0.7.0.1
 */