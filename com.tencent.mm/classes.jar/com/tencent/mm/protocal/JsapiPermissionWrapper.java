package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JsapiPermissionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<JsapiPermissionWrapper> CREATOR;
  public static final JsapiPermissionWrapper DIw;
  public static final JsapiPermissionWrapper DIx;
  public static final JsapiPermissionWrapper DIy;
  public static final JsapiPermissionWrapper DIz;
  public byte[] DIA;
  public int DIB;
  private Set<Integer> DIC;
  private Set<Integer> DID;
  
  static
  {
    AppMethodBeat.i(152466);
    DIw = new JsapiPermissionWrapper(1);
    DIx = new JsapiPermissionWrapper(2);
    DIy = new JsapiPermissionWrapper(3);
    DIz = new JsapiPermissionWrapper(4);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152466);
  }
  
  public JsapiPermissionWrapper()
  {
    this.DIA = null;
    this.DIB = 0;
    this.DIA = null;
  }
  
  public JsapiPermissionWrapper(int paramInt)
  {
    AppMethodBeat.i(152452);
    this.DIA = null;
    this.DIB = 0;
    this.DIB = paramInt;
    this.DIA = new byte[0];
    AppMethodBeat.o(152452);
  }
  
  private JsapiPermissionWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152458);
    this.DIA = null;
    this.DIB = 0;
    this.DIA = paramParcel.createByteArray();
    this.DIB = paramParcel.readInt();
    G(paramParcel.createIntArray());
    H(paramParcel.createIntArray());
    AppMethodBeat.o(152458);
  }
  
  public JsapiPermissionWrapper(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152451);
    this.DIA = null;
    this.DIB = 0;
    if (paramArrayOfByte == null)
    {
      this.DIA = null;
      AppMethodBeat.o(152451);
      return;
    }
    this.DIA = paramArrayOfByte;
    AppMethodBeat.o(152451);
  }
  
  private void G(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152461);
    if (this.DIC == null) {
      this.DIC = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.DIC.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.DIC.clear();
    }
    AppMethodBeat.o(152461);
  }
  
  private void H(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152464);
    if (this.DID == null) {
      this.DID = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.DID.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.DID.clear();
    }
    AppMethodBeat.o(152464);
  }
  
  private boolean XG(int paramInt)
  {
    AppMethodBeat.i(152462);
    if ((this.DIC != null) && (this.DIC.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152462);
      return true;
    }
    AppMethodBeat.o(152462);
    return false;
  }
  
  private boolean XH(int paramInt)
  {
    AppMethodBeat.i(152465);
    if ((this.DID != null) && (this.DID.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152465);
      return true;
    }
    AppMethodBeat.o(152465);
    return false;
  }
  
  public final int XF(int paramInt)
  {
    AppMethodBeat.i(192706);
    if (XH(paramInt))
    {
      AppMethodBeat.o(192706);
      return 1;
    }
    if (XG(paramInt))
    {
      AppMethodBeat.o(192706);
      return 0;
    }
    if (this.DIB == 1)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        ac.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(192706);
        return 0;
      }
      AppMethodBeat.o(192706);
      return 1;
    }
    if (this.DIB == 2)
    {
      if (paramInt == -3)
      {
        AppMethodBeat.o(192706);
        return 1;
      }
      AppMethodBeat.o(192706);
      return 0;
    }
    if (this.DIB == 3)
    {
      if ((paramInt == 34) || (paramInt == 75) || (paramInt == 23))
      {
        ac.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(192706);
        return 0;
      }
      AppMethodBeat.o(192706);
      return 1;
    }
    if (this.DIB == 4)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        ac.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(192706);
        return 0;
      }
      AppMethodBeat.o(192706);
      return 1;
    }
    if ((paramInt == -2) || (paramInt == -3))
    {
      AppMethodBeat.o(192706);
      return 1;
    }
    if ((this.DIA == null) || (paramInt < 0) || (paramInt >= this.DIA.length))
    {
      AppMethodBeat.o(192706);
      return 0;
    }
    paramInt = this.DIA[paramInt];
    AppMethodBeat.o(192706);
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
    //   8: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:DIA	[B
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
    //   33: invokestatic 144	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc 139
    //   38: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: iload_1
    //   45: aload_0
    //   46: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:DIA	[B
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
    //   71: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:DIA	[B
    //   74: arraylength
    //   75: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: invokestatic 149	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: newarray byte
    //   87: astore_3
    //   88: aload_3
    //   89: iconst_2
    //   90: invokestatic 155	java/util/Arrays:fill	([BB)V
    //   93: aload_0
    //   94: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:DIA	[B
    //   97: iconst_0
    //   98: aload_3
    //   99: iconst_0
    //   100: aload_0
    //   101: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:DIA	[B
    //   104: arraylength
    //   105: invokestatic 161	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   108: aload_0
    //   109: aload_3
    //   110: putfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:DIA	[B
    //   113: aload_0
    //   114: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:DIA	[B
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
  
  public final int[] eRo()
  {
    AppMethodBeat.i(152460);
    if (this.DIC != null)
    {
      int[] arrayOfInt = new int[this.DIC.size()];
      Iterator localIterator = this.DIC.iterator();
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
  
  public final int[] eRp()
  {
    AppMethodBeat.i(152463);
    if (this.DID != null)
    {
      int[] arrayOfInt = new int[this.DID.size()];
      Iterator localIterator = this.DID.iterator();
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
  
  public final JsapiPermissionWrapper eRq()
  {
    AppMethodBeat.i(192707);
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
      AppMethodBeat.o(192707);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof JsapiPermissionWrapper)) {}
    do
    {
      return false;
      paramObject = (JsapiPermissionWrapper)paramObject;
      if (this.DIA == paramObject.DIA) {
        return true;
      }
    } while ((this.DIA == null) || (paramObject.DIA == null) || (this.DIA.length != paramObject.DIA.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.DIA.length) {
        break label87;
      }
      if (this.DIA[i] != paramObject.DIA[i]) {
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
    this.DIA = paramBundle.getByteArray("jsapi_perm_wrapper_bytes");
    this.DIB = paramBundle.getInt("jsapi_perm_wrapper_hardcodePermission");
    G(paramBundle.getIntArray("jsapi_perm_wrapper_blacklist"));
    H(paramBundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    AppMethodBeat.o(152459);
  }
  
  public final boolean ma(int paramInt)
  {
    AppMethodBeat.i(152455);
    if (XF(paramInt) == 1)
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
    if (this.DIA == null)
    {
      AppMethodBeat.o(152456);
      return "null";
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder(180);
    byte[] arrayOfByte = this.DIA;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfByte[i]);
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    ac.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(152456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152457);
    paramParcel.writeByteArray(this.DIA);
    paramParcel.writeInt(this.DIB);
    paramParcel.writeIntArray(eRo());
    paramParcel.writeIntArray(eRp());
    AppMethodBeat.o(152457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.JsapiPermissionWrapper
 * JD-Core Version:    0.7.0.1
 */