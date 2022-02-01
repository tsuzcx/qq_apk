package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JsapiPermissionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<JsapiPermissionWrapper> CREATOR;
  public static final JsapiPermissionWrapper Kzm;
  public static final JsapiPermissionWrapper Kzn;
  public static final JsapiPermissionWrapper Kzo;
  public static final JsapiPermissionWrapper Kzp;
  public byte[] Kzq;
  public int Kzr;
  private Set<Integer> Kzs;
  private Set<Integer> Kzt;
  
  static
  {
    AppMethodBeat.i(152466);
    Kzm = new JsapiPermissionWrapper(1);
    Kzn = new JsapiPermissionWrapper(2);
    Kzo = new JsapiPermissionWrapper(3);
    Kzp = new JsapiPermissionWrapper(4);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152466);
  }
  
  public JsapiPermissionWrapper()
  {
    this.Kzq = null;
    this.Kzr = 0;
    this.Kzq = null;
  }
  
  public JsapiPermissionWrapper(int paramInt)
  {
    AppMethodBeat.i(152452);
    this.Kzq = null;
    this.Kzr = 0;
    this.Kzr = paramInt;
    this.Kzq = new byte[0];
    AppMethodBeat.o(152452);
  }
  
  private JsapiPermissionWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152458);
    this.Kzq = null;
    this.Kzr = 0;
    this.Kzq = paramParcel.createByteArray();
    this.Kzr = paramParcel.readInt();
    O(paramParcel.createIntArray());
    P(paramParcel.createIntArray());
    AppMethodBeat.o(152458);
  }
  
  public JsapiPermissionWrapper(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152451);
    this.Kzq = null;
    this.Kzr = 0;
    if (paramArrayOfByte == null)
    {
      this.Kzq = null;
      AppMethodBeat.o(152451);
      return;
    }
    this.Kzq = paramArrayOfByte;
    AppMethodBeat.o(152451);
  }
  
  private void O(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152461);
    if (this.Kzs == null) {
      this.Kzs = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.Kzs.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.Kzs.clear();
    }
    AppMethodBeat.o(152461);
  }
  
  private void P(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152464);
    if (this.Kzt == null) {
      this.Kzt = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.Kzt.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.Kzt.clear();
    }
    AppMethodBeat.o(152464);
  }
  
  private boolean aiX(int paramInt)
  {
    AppMethodBeat.i(152462);
    if ((this.Kzs != null) && (this.Kzs.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152462);
      return true;
    }
    AppMethodBeat.o(152462);
    return false;
  }
  
  private boolean aiY(int paramInt)
  {
    AppMethodBeat.i(152465);
    if ((this.Kzt != null) && (this.Kzt.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152465);
      return true;
    }
    AppMethodBeat.o(152465);
    return false;
  }
  
  /* Error */
  public final void a(int paramInt, byte paramByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 121
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzq	[B
    //   11: ifnull +7 -> 18
    //   14: iload_1
    //   15: ifge +29 -> 44
    //   18: ldc 123
    //   20: ldc 125
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: iload_1
    //   29: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc 121
    //   38: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: iload_1
    //   45: aload_0
    //   46: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzq	[B
    //   49: arraylength
    //   50: if_icmplt +63 -> 113
    //   53: ldc 123
    //   55: ldc 133
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
    //   71: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzq	[B
    //   74: arraylength
    //   75: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: newarray byte
    //   87: astore_3
    //   88: aload_3
    //   89: iconst_2
    //   90: invokestatic 142	java/util/Arrays:fill	([BB)V
    //   93: aload_0
    //   94: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzq	[B
    //   97: iconst_0
    //   98: aload_3
    //   99: iconst_0
    //   100: aload_0
    //   101: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzq	[B
    //   104: arraylength
    //   105: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   108: aload_0
    //   109: aload_3
    //   110: putfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzq	[B
    //   113: aload_0
    //   114: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:Kzq	[B
    //   117: iload_1
    //   118: iload_2
    //   119: bastore
    //   120: ldc 121
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
  
  public final int aiW(int paramInt)
  {
    AppMethodBeat.i(223877);
    if (aiY(paramInt))
    {
      AppMethodBeat.o(223877);
      return 1;
    }
    if (aiX(paramInt))
    {
      AppMethodBeat.o(223877);
      return 0;
    }
    if (this.Kzr == 1)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        Log.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(223877);
        return 0;
      }
      AppMethodBeat.o(223877);
      return 1;
    }
    if (this.Kzr == 2)
    {
      if (paramInt == -3)
      {
        AppMethodBeat.o(223877);
        return 1;
      }
      AppMethodBeat.o(223877);
      return 0;
    }
    if (this.Kzr == 3)
    {
      if ((paramInt == 34) || (paramInt == 75) || (paramInt == 23))
      {
        Log.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(223877);
        return 0;
      }
      AppMethodBeat.o(223877);
      return 1;
    }
    if (this.Kzr == 4)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        Log.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(223877);
        return 0;
      }
      AppMethodBeat.o(223877);
      return 1;
    }
    if ((paramInt == -2) || (paramInt == -3))
    {
      AppMethodBeat.o(223877);
      return 1;
    }
    if ((this.Kzq == null) || (paramInt < 0) || (paramInt >= this.Kzq.length))
    {
      AppMethodBeat.o(223877);
      return 0;
    }
    paramInt = this.Kzq[paramInt];
    AppMethodBeat.o(223877);
    return paramInt;
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
      if (this.Kzq == paramObject.Kzq) {
        return true;
      }
    } while ((this.Kzq == null) || (paramObject.Kzq == null) || (this.Kzq.length != paramObject.Kzq.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.Kzq.length) {
        break label87;
      }
      if (this.Kzq[i] != paramObject.Kzq[i]) {
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
    this.Kzq = paramBundle.getByteArray("jsapi_perm_wrapper_bytes");
    this.Kzr = paramBundle.getInt("jsapi_perm_wrapper_hardcodePermission");
    O(paramBundle.getIntArray("jsapi_perm_wrapper_blacklist"));
    P(paramBundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    AppMethodBeat.o(152459);
  }
  
  public final int[] gtL()
  {
    AppMethodBeat.i(152460);
    if (this.Kzs != null)
    {
      int[] arrayOfInt = new int[this.Kzs.size()];
      Iterator localIterator = this.Kzs.iterator();
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
  
  public final int[] gtM()
  {
    AppMethodBeat.i(152463);
    if (this.Kzt != null)
    {
      int[] arrayOfInt = new int[this.Kzt.size()];
      Iterator localIterator = this.Kzt.iterator();
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
  
  public final JsapiPermissionWrapper gtN()
  {
    AppMethodBeat.i(223878);
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
      AppMethodBeat.o(223878);
    }
  }
  
  public final boolean pP(int paramInt)
  {
    AppMethodBeat.i(152455);
    if (aiW(paramInt) == 1)
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
    if (this.Kzq == null)
    {
      AppMethodBeat.o(152456);
      return "null";
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder(180);
    byte[] arrayOfByte = this.Kzq;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfByte[i]);
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    Log.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(152456);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(152457);
    paramParcel.writeByteArray(this.Kzq);
    paramParcel.writeInt(this.Kzr);
    paramParcel.writeIntArray(gtL());
    paramParcel.writeIntArray(gtM());
    AppMethodBeat.o(152457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.JsapiPermissionWrapper
 * JD-Core Version:    0.7.0.1
 */