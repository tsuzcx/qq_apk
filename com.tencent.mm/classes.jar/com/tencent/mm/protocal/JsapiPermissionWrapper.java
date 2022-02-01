package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JsapiPermissionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<JsapiPermissionWrapper> CREATOR;
  public static final JsapiPermissionWrapper Cqe;
  public static final JsapiPermissionWrapper Cqf;
  public static final JsapiPermissionWrapper Cqg;
  public static final JsapiPermissionWrapper Cqh;
  public byte[] Cqi;
  public int Cqj;
  private Set<Integer> Cqk;
  private Set<Integer> Cql;
  
  static
  {
    AppMethodBeat.i(152466);
    Cqe = new JsapiPermissionWrapper(1);
    Cqf = new JsapiPermissionWrapper(2);
    Cqg = new JsapiPermissionWrapper(3);
    Cqh = new JsapiPermissionWrapper(4);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152466);
  }
  
  public JsapiPermissionWrapper()
  {
    this.Cqi = null;
    this.Cqj = 0;
    this.Cqi = null;
  }
  
  public JsapiPermissionWrapper(int paramInt)
  {
    AppMethodBeat.i(152452);
    this.Cqi = null;
    this.Cqj = 0;
    this.Cqj = paramInt;
    this.Cqi = new byte[0];
    AppMethodBeat.o(152452);
  }
  
  private JsapiPermissionWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152458);
    this.Cqi = null;
    this.Cqj = 0;
    this.Cqi = paramParcel.createByteArray();
    this.Cqj = paramParcel.readInt();
    G(paramParcel.createIntArray());
    H(paramParcel.createIntArray());
    AppMethodBeat.o(152458);
  }
  
  public JsapiPermissionWrapper(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152451);
    this.Cqi = null;
    this.Cqj = 0;
    if (paramArrayOfByte == null)
    {
      this.Cqi = null;
      AppMethodBeat.o(152451);
      return;
    }
    this.Cqi = paramArrayOfByte;
    AppMethodBeat.o(152451);
  }
  
  private void G(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152461);
    if (this.Cqk == null) {
      this.Cqk = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.Cqk.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.Cqk.clear();
    }
    AppMethodBeat.o(152461);
  }
  
  private void H(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152464);
    if (this.Cql == null) {
      this.Cql = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.Cql.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.Cql.clear();
    }
    AppMethodBeat.o(152464);
  }
  
  private boolean Vx(int paramInt)
  {
    AppMethodBeat.i(152462);
    if ((this.Cqk != null) && (this.Cqk.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152462);
      return true;
    }
    AppMethodBeat.o(152462);
    return false;
  }
  
  private boolean Vy(int paramInt)
  {
    AppMethodBeat.i(152465);
    if ((this.Cql != null) && (this.Cql.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152465);
      return true;
    }
    AppMethodBeat.o(152465);
    return false;
  }
  
  public final int Vw(int paramInt)
  {
    AppMethodBeat.i(190798);
    if (Vy(paramInt))
    {
      AppMethodBeat.o(190798);
      return 1;
    }
    if (Vx(paramInt))
    {
      AppMethodBeat.o(190798);
      return 0;
    }
    if (this.Cqj == 1)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        ad.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(190798);
        return 0;
      }
      AppMethodBeat.o(190798);
      return 1;
    }
    if (this.Cqj == 2)
    {
      if (paramInt == -3)
      {
        AppMethodBeat.o(190798);
        return 1;
      }
      AppMethodBeat.o(190798);
      return 0;
    }
    if (this.Cqj == 3)
    {
      if ((paramInt == 34) || (paramInt == 75) || (paramInt == 23))
      {
        ad.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(190798);
        return 0;
      }
      AppMethodBeat.o(190798);
      return 1;
    }
    if (this.Cqj == 4)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        ad.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(190798);
        return 0;
      }
      AppMethodBeat.o(190798);
      return 1;
    }
    if ((paramInt == -2) || (paramInt == -3))
    {
      AppMethodBeat.o(190798);
      return 1;
    }
    if ((this.Cqi == null) || (paramInt < 0) || (paramInt >= this.Cqi.length))
    {
      AppMethodBeat.o(190798);
      return 0;
    }
    paramInt = this.Cqi[paramInt];
    AppMethodBeat.o(190798);
    return paramInt;
  }
  
  /* Error */
  public final void a(int paramInt, byte paramByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 139
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Cqi	[B
    //   11: ifnull +7 -> 18
    //   14: iload_1
    //   15: ifge +29 -> 44
    //   18: ldc 127
    //   20: ldc 141
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: iload_1
    //   29: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 144	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc 139
    //   38: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: iload_1
    //   45: aload_0
    //   46: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Cqi	[B
    //   49: arraylength
    //   50: if_icmplt +63 -> 113
    //   53: ldc 127
    //   55: ldc 146
    //   57: iconst_2
    //   58: anewarray 4	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: iload_1
    //   64: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_0
    //   71: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Cqi	[B
    //   74: arraylength
    //   75: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: invokestatic 149	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: newarray byte
    //   87: astore_3
    //   88: aload_3
    //   89: iconst_2
    //   90: invokestatic 155	java/util/Arrays:fill	([BB)V
    //   93: aload_0
    //   94: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Cqi	[B
    //   97: iconst_0
    //   98: aload_3
    //   99: iconst_0
    //   100: aload_0
    //   101: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Cqi	[B
    //   104: arraylength
    //   105: invokestatic 161	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   108: aload_0
    //   109: aload_3
    //   110: putfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Cqi	[B
    //   113: aload_0
    //   114: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Cqi	[B
    //   117: iload_1
    //   118: iload_2
    //   119: bastore
    //   120: ldc 139
    //   122: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: goto -84 -> 41
    //   128: astore_3
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_3
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	JsapiPermissionWrapper
    //   0	133	1	paramInt	int
    //   0	133	2	paramByte	byte
    //   87	23	3	arrayOfByte	byte[]
    //   128	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	128	finally
    //   18	41	128	finally
    //   44	113	128	finally
    //   113	125	128	finally
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int[] eBT()
  {
    AppMethodBeat.i(152460);
    if (this.Cqk != null)
    {
      int[] arrayOfInt = new int[this.Cqk.size()];
      Iterator localIterator = this.Cqk.iterator();
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
      AppMethodBeat.o(152460);
      return arrayOfInt;
    }
    AppMethodBeat.o(152460);
    return new int[0];
  }
  
  public final int[] eBU()
  {
    AppMethodBeat.i(152463);
    if (this.Cql != null)
    {
      int[] arrayOfInt = new int[this.Cql.size()];
      Iterator localIterator = this.Cql.iterator();
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
      AppMethodBeat.o(152463);
      return arrayOfInt;
    }
    AppMethodBeat.o(152463);
    return new int[0];
  }
  
  public final JsapiPermissionWrapper eBV()
  {
    AppMethodBeat.i(190799);
    Object localObject1 = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localParcel;
      localParcel.writeParcelable(this, 0);
      localObject1 = localParcel;
      localParcel.setDataPosition(0);
      localObject1 = localParcel;
      JsapiPermissionWrapper localJsapiPermissionWrapper = (JsapiPermissionWrapper)localParcel.readParcelable(JsapiPermissionWrapper.class.getClassLoader());
      return localJsapiPermissionWrapper;
    }
    finally
    {
      localObject1.recycle();
      AppMethodBeat.o(190799);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof JsapiPermissionWrapper)) {}
    do
    {
      return false;
      paramObject = (JsapiPermissionWrapper)paramObject;
      if (this.Cqi == paramObject.Cqi) {
        return true;
      }
    } while ((this.Cqi == null) || (paramObject.Cqi == null) || (this.Cqi.length != paramObject.Cqi.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.Cqi.length) {
        break label87;
      }
      if (this.Cqi[i] != paramObject.Cqi[i]) {
        break;
      }
      i += 1;
    }
    label87:
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(152459);
    this.Cqi = paramBundle.getByteArray("jsapi_perm_wrapper_bytes");
    this.Cqj = paramBundle.getInt("jsapi_perm_wrapper_hardcodePermission");
    G(paramBundle.getIntArray("jsapi_perm_wrapper_blacklist"));
    H(paramBundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    AppMethodBeat.o(152459);
  }
  
  public final boolean mb(int paramInt)
  {
    AppMethodBeat.i(152455);
    if (Vw(paramInt) == 1)
    {
      AppMethodBeat.o(152455);
      return true;
    }
    AppMethodBeat.o(152455);
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(152456);
    if (this.Cqi == null)
    {
      AppMethodBeat.o(152456);
      return "null";
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder(180);
    byte[] arrayOfByte = this.Cqi;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfByte[i]);
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    ad.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(152456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152457);
    paramParcel.writeByteArray(this.Cqi);
    paramParcel.writeInt(this.Cqj);
    paramParcel.writeIntArray(eBT());
    paramParcel.writeIntArray(eBU());
    AppMethodBeat.o(152457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.JsapiPermissionWrapper
 * JD-Core Version:    0.7.0.1
 */