package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JsapiPermissionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<JsapiPermissionWrapper> CREATOR;
  public static final JsapiPermissionWrapper wib;
  public static final JsapiPermissionWrapper wic;
  public static final JsapiPermissionWrapper wid;
  public static final JsapiPermissionWrapper wie;
  public byte[] wif;
  public int wig;
  private Set<Integer> wih;
  private Set<Integer> wii;
  
  static
  {
    AppMethodBeat.i(79994);
    wib = new JsapiPermissionWrapper(1);
    wic = new JsapiPermissionWrapper(2);
    wid = new JsapiPermissionWrapper(3);
    wie = new JsapiPermissionWrapper(4);
    CREATOR = new JsapiPermissionWrapper.1();
    AppMethodBeat.o(79994);
  }
  
  public JsapiPermissionWrapper()
  {
    this.wif = null;
    this.wig = 0;
    this.wif = null;
  }
  
  public JsapiPermissionWrapper(int paramInt)
  {
    AppMethodBeat.i(79979);
    this.wif = null;
    this.wig = 0;
    this.wig = paramInt;
    this.wif = new byte[0];
    AppMethodBeat.o(79979);
  }
  
  private JsapiPermissionWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(79985);
    this.wif = null;
    this.wig = 0;
    this.wif = paramParcel.createByteArray();
    this.wig = paramParcel.readInt();
    D(paramParcel.createIntArray());
    E(paramParcel.createIntArray());
    AppMethodBeat.o(79985);
  }
  
  public JsapiPermissionWrapper(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(79978);
    this.wif = null;
    this.wig = 0;
    if (paramArrayOfByte == null)
    {
      this.wif = null;
      AppMethodBeat.o(79978);
      return;
    }
    this.wif = paramArrayOfByte;
    AppMethodBeat.o(79978);
  }
  
  private void D(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79989);
    if (this.wih == null) {
      this.wih = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.wih.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.wih.clear();
    }
    AppMethodBeat.o(79989);
  }
  
  private void E(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(79992);
    if (this.wii == null) {
      this.wii = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.wii.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.wii.clear();
    }
    AppMethodBeat.o(79992);
  }
  
  private boolean MC(int paramInt)
  {
    AppMethodBeat.i(79990);
    if ((this.wih != null) && (this.wih.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(79990);
      return true;
    }
    AppMethodBeat.o(79990);
    return false;
  }
  
  private boolean MD(int paramInt)
  {
    AppMethodBeat.i(79993);
    if ((this.wii != null) && (this.wii.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(79993);
      return true;
    }
    AppMethodBeat.o(79993);
    return false;
  }
  
  public final int MB(int paramInt)
  {
    AppMethodBeat.i(79980);
    if (MD(paramInt))
    {
      AppMethodBeat.o(79980);
      return 1;
    }
    if (MC(paramInt))
    {
      AppMethodBeat.o(79980);
      return 0;
    }
    if (this.wig == 1)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        ab.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(79980);
        return 0;
      }
      AppMethodBeat.o(79980);
      return 1;
    }
    if (this.wig == 2)
    {
      if (paramInt == -3)
      {
        AppMethodBeat.o(79980);
        return 1;
      }
      AppMethodBeat.o(79980);
      return 0;
    }
    if (this.wig == 3)
    {
      if ((paramInt == 34) || (paramInt == 75) || (paramInt == 23))
      {
        ab.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(79980);
        return 0;
      }
      AppMethodBeat.o(79980);
      return 1;
    }
    if (this.wig == 4)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        ab.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(79980);
        return 0;
      }
      AppMethodBeat.o(79980);
      return 1;
    }
    if ((paramInt == -2) || (paramInt == -3))
    {
      AppMethodBeat.o(79980);
      return 1;
    }
    if ((this.wif == null) || (paramInt < 0) || (paramInt >= this.wif.length))
    {
      AppMethodBeat.o(79980);
      return 0;
    }
    paramInt = this.wif[paramInt];
    AppMethodBeat.o(79980);
    return paramInt;
  }
  
  public final void a(int paramInt, byte paramByte)
  {
    int i = 0;
    AppMethodBeat.i(79981);
    if ((this.wif == null) || (paramInt < 0) || (paramInt >= this.wif.length))
    {
      if (this.wif == null) {}
      for (;;)
      {
        ab.e("MicroMsg.JsapiPermissionWrapper", "setPermission pos out of range, %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        AppMethodBeat.o(79981);
        return;
        i = this.wif.length;
      }
    }
    this.wif[paramInt] = paramByte;
    AppMethodBeat.o(79981);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int[] dqA()
  {
    AppMethodBeat.i(79988);
    if (this.wih != null)
    {
      int[] arrayOfInt = new int[this.wih.size()];
      Iterator localIterator = this.wih.iterator();
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
      AppMethodBeat.o(79988);
      return arrayOfInt;
    }
    AppMethodBeat.o(79988);
    return new int[0];
  }
  
  public final int[] dqB()
  {
    AppMethodBeat.i(79991);
    if (this.wii != null)
    {
      int[] arrayOfInt = new int[this.wii.size()];
      Iterator localIterator = this.wii.iterator();
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
      AppMethodBeat.o(79991);
      return arrayOfInt;
    }
    AppMethodBeat.o(79991);
    return new int[0];
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof JsapiPermissionWrapper)) {}
    do
    {
      return false;
      paramObject = (JsapiPermissionWrapper)paramObject;
      if (this.wif == paramObject.wif) {
        return true;
      }
    } while ((this.wif == null) || (paramObject.wif == null) || (this.wif.length != paramObject.wif.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.wif.length) {
        break label87;
      }
      if (this.wif[i] != paramObject.wif[i]) {
        break;
      }
      i += 1;
    }
    label87:
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(79987);
    this.wif = paramBundle.getByteArray("jsapi_perm_wrapper_bytes");
    this.wig = paramBundle.getInt("jsapi_perm_wrapper_hardcodePermission");
    D(paramBundle.getIntArray("jsapi_perm_wrapper_blacklist"));
    E(paramBundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    AppMethodBeat.o(79987);
  }
  
  public final boolean jy(int paramInt)
  {
    AppMethodBeat.i(79982);
    if (MB(paramInt) == 1)
    {
      AppMethodBeat.o(79982);
      return true;
    }
    AppMethodBeat.o(79982);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(79983);
    if (this.wif == null)
    {
      AppMethodBeat.o(79983);
      return "null";
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder(180);
    byte[] arrayOfByte = this.wif;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfByte[i]);
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    ab.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(79983);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(79984);
    paramParcel.writeByteArray(this.wif);
    paramParcel.writeInt(this.wig);
    paramParcel.writeIntArray(dqA());
    paramParcel.writeIntArray(dqB());
    AppMethodBeat.o(79984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.JsapiPermissionWrapper
 * JD-Core Version:    0.7.0.1
 */