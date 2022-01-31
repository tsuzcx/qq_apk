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
  private final int GT;
  private final String Sk;
  private final int Sl;
  private final boolean Sm;
  private boolean Sn;
  private String So;
  private boolean Sp;
  private String Sq;
  private final String mName;
  
  ConnectionConfiguration(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, boolean paramBoolean3, String paramString4)
  {
    this.mName = paramString1;
    this.Sk = paramString2;
    this.GT = paramInt1;
    this.Sl = paramInt2;
    this.Sm = paramBoolean1;
    this.Sn = paramBoolean2;
    this.So = paramString3;
    this.Sp = paramBoolean3;
    this.Sq = paramString4;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ConnectionConfiguration)) {}
    do
    {
      return false;
      paramObject = (ConnectionConfiguration)paramObject;
    } while ((!b.b(this.mName, paramObject.mName)) || (!b.b(this.Sk, paramObject.Sk)) || (!b.b(Integer.valueOf(this.GT), Integer.valueOf(paramObject.GT))) || (!b.b(Integer.valueOf(this.Sl), Integer.valueOf(paramObject.Sl))) || (!b.b(Boolean.valueOf(this.Sm), Boolean.valueOf(paramObject.Sm))) || (!b.b(Boolean.valueOf(this.Sp), Boolean.valueOf(paramObject.Sp))));
    return true;
  }
  
  public final String getAddress()
  {
    return this.Sk;
  }
  
  public final String getName()
  {
    return this.mName;
  }
  
  public final int getRole()
  {
    return this.Sl;
  }
  
  public final int getType()
  {
    return this.GT;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { this.mName, this.Sk, Integer.valueOf(this.GT), Integer.valueOf(this.Sl), Boolean.valueOf(this.Sm), Boolean.valueOf(this.Sp) });
  }
  
  public final boolean isConnected()
  {
    return this.Sn;
  }
  
  public final boolean isEnabled()
  {
    return this.Sm;
  }
  
  public final String kq()
  {
    return this.Sq;
  }
  
  public final String ks()
  {
    return this.So;
  }
  
  public final boolean kt()
  {
    return this.Sp;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ConnectionConfiguration[ ");
    String str = String.valueOf(this.mName);
    if (str.length() != 0)
    {
      str = "mName=".concat(str);
      localStringBuilder.append(str);
      str = String.valueOf(this.Sk);
      if (str.length() == 0) {
        break label314;
      }
      str = ", mAddress=".concat(str);
      label62:
      localStringBuilder.append(str);
      int i = this.GT;
      localStringBuilder.append(19 + ", mType=" + i);
      i = this.Sl;
      localStringBuilder.append(19 + ", mRole=" + i);
      boolean bool = this.Sm;
      localStringBuilder.append(16 + ", mEnabled=" + bool);
      bool = this.Sn;
      localStringBuilder.append(20 + ", mIsConnected=" + bool);
      str = String.valueOf(this.So);
      if (str.length() == 0) {
        break label327;
      }
      str = ", mPeerNodeId=".concat(str);
      label219:
      localStringBuilder.append(str);
      bool = this.Sp;
      localStringBuilder.append(21 + ", mBtlePriority=" + bool);
      str = String.valueOf(this.Sq);
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