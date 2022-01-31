package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JsapiPermissionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<JsapiPermissionWrapper> CREATOR = new JsapiPermissionWrapper.1();
  public static final JsapiPermissionWrapper spm = new JsapiPermissionWrapper(1);
  public static final JsapiPermissionWrapper spn = new JsapiPermissionWrapper(2);
  public static final JsapiPermissionWrapper spo = new JsapiPermissionWrapper(3);
  public static final JsapiPermissionWrapper spp = new JsapiPermissionWrapper(4);
  public byte[] spq = null;
  private int spr = 0;
  private Set<Integer> sps;
  private Set<Integer> spt;
  
  public JsapiPermissionWrapper()
  {
    this.spq = null;
  }
  
  public JsapiPermissionWrapper(int paramInt)
  {
    this.spr = paramInt;
    this.spq = new byte[0];
  }
  
  private JsapiPermissionWrapper(Parcel paramParcel)
  {
    this.spq = paramParcel.createByteArray();
    this.spr = paramParcel.readInt();
    t(paramParcel.createIntArray());
    u(paramParcel.createIntArray());
  }
  
  public JsapiPermissionWrapper(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.spq = null;
      return;
    }
    this.spq = paramArrayOfByte;
  }
  
  public static boolean cpa()
  {
    return true;
  }
  
  private int[] cpb()
  {
    if (this.sps != null)
    {
      int[] arrayOfInt = new int[this.sps.size()];
      Iterator localIterator = this.sps.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger == null) {}
        for (int j = 0;; j = localInteger.intValue())
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
      return arrayOfInt;
    }
    return new int[0];
  }
  
  private int[] cpc()
  {
    if (this.spt != null)
    {
      int[] arrayOfInt = new int[this.spt.size()];
      Iterator localIterator = this.spt.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger == null) {}
        for (int j = 0;; j = localInteger.intValue())
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
      return arrayOfInt;
    }
    return new int[0];
  }
  
  private void t(int[] paramArrayOfInt)
  {
    if (this.sps == null) {
      this.sps = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.sps.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.sps.clear();
    }
  }
  
  private void u(int[] paramArrayOfInt)
  {
    if (this.spt == null) {
      this.spt = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.spt.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.spt.clear();
    }
  }
  
  public final int ED(int paramInt)
  {
    int i;
    if ((this.spt != null) && (this.spt.contains(Integer.valueOf(paramInt))))
    {
      i = 1;
      if (i == 0) {
        break label36;
      }
    }
    label36:
    label112:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return 1;
              i = 0;
              break;
              if ((this.sps != null) && (this.sps.contains(Integer.valueOf(paramInt)))) {}
              for (i = 1; i != 0; i = 0) {
                return 0;
              }
              if (this.spr != 1) {
                break label112;
              }
            } while ((paramInt != 34) && (paramInt != 75));
            y.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
            return 0;
            if (this.spr != 2) {
              break label128;
            }
          } while (paramInt == -3);
          return 0;
          if (this.spr != 3) {
            break label174;
          }
        } while ((paramInt != 34) && (paramInt != 75) && (paramInt != 23));
        y.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        return 0;
        if (this.spr != 4) {
          break label214;
        }
      } while ((paramInt != 34) && (paramInt != 75));
      y.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
      return 0;
    } while ((paramInt == -2) || (paramInt == -3));
    label128:
    label174:
    label214:
    if ((this.spq == null) || (paramInt < 0) || (paramInt >= this.spq.length)) {
      return 0;
    }
    return this.spq[paramInt];
  }
  
  public final void a(int paramInt, byte paramByte)
  {
    int i = 0;
    if ((this.spq == null) || (paramInt < 0) || (paramInt >= this.spq.length))
    {
      if (this.spq == null) {}
      for (;;)
      {
        y.e("MicroMsg.JsapiPermissionWrapper", "setPermission pos out of range, %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        return;
        i = this.spq.length;
      }
    }
    this.spq[paramInt] = paramByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof JsapiPermissionWrapper)) {}
    do
    {
      return false;
      paramObject = (JsapiPermissionWrapper)paramObject;
      if (this.spq == paramObject.spq) {
        return true;
      }
    } while ((this.spq == null) || (paramObject.spq == null) || (this.spq.length != paramObject.spq.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.spq.length) {
        break label87;
      }
      if (this.spq[i] != paramObject.spq[i]) {
        break;
      }
      i += 1;
    }
    label87:
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    this.spq = paramBundle.getByteArray("jsapi_perm_wrapper_bytes");
    this.spr = paramBundle.getInt("jsapi_perm_wrapper_hardcodePermission");
    t(paramBundle.getIntArray("jsapi_perm_wrapper_blacklist"));
    u(paramBundle.getIntArray("jsapi_perm_wrapper_whitelist"));
  }
  
  public final boolean hi(int paramInt)
  {
    return ED(paramInt) == 1;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    paramBundle.putByteArray("jsapi_perm_wrapper_bytes", this.spq);
    paramBundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.spr);
    paramBundle.putIntArray("jsapi_perm_wrapper_blacklist", cpb());
    paramBundle.putIntArray("jsapi_perm_wrapper_whitelist", cpc());
  }
  
  public String toString()
  {
    if (this.spq == null) {
      return "null";
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder(180);
    byte[] arrayOfByte = this.spq;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfByte[i]);
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    y.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.spq);
    paramParcel.writeInt(this.spr);
    paramParcel.writeIntArray(cpb());
    paramParcel.writeIntArray(cpc());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.JsapiPermissionWrapper
 * JD-Core Version:    0.7.0.1
 */