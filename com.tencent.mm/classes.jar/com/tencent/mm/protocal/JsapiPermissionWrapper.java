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
  public static final JsapiPermissionWrapper YxF;
  public static final JsapiPermissionWrapper YxG;
  public static final JsapiPermissionWrapper YxH;
  public static final JsapiPermissionWrapper YxI;
  public byte[] YxJ;
  public int YxK;
  private Set<Integer> YxL;
  private Set<Integer> YxM;
  
  static
  {
    AppMethodBeat.i(152466);
    YxF = new JsapiPermissionWrapper(1);
    YxG = new JsapiPermissionWrapper(2);
    YxH = new JsapiPermissionWrapper(3);
    YxI = new JsapiPermissionWrapper(4);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(152466);
  }
  
  public JsapiPermissionWrapper()
  {
    this.YxJ = null;
    this.YxK = 0;
    this.YxJ = null;
  }
  
  public JsapiPermissionWrapper(int paramInt)
  {
    AppMethodBeat.i(152452);
    this.YxJ = null;
    this.YxK = 0;
    this.YxK = paramInt;
    this.YxJ = new byte[0];
    AppMethodBeat.o(152452);
  }
  
  private JsapiPermissionWrapper(Parcel paramParcel)
  {
    AppMethodBeat.i(152458);
    this.YxJ = null;
    this.YxK = 0;
    this.YxJ = paramParcel.createByteArray();
    this.YxK = paramParcel.readInt();
    P(paramParcel.createIntArray());
    Q(paramParcel.createIntArray());
    AppMethodBeat.o(152458);
  }
  
  public JsapiPermissionWrapper(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(152451);
    this.YxJ = null;
    this.YxK = 0;
    if (paramArrayOfByte == null)
    {
      this.YxJ = null;
      AppMethodBeat.o(152451);
      return;
    }
    this.YxJ = paramArrayOfByte;
    AppMethodBeat.o(152451);
  }
  
  private void P(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152461);
    if (this.YxL == null) {
      this.YxL = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.YxL.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.YxL.clear();
    }
    AppMethodBeat.o(152461);
  }
  
  private void Q(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(152464);
    if (this.YxM == null) {
      this.YxM = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.YxM.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.YxM.clear();
    }
    AppMethodBeat.o(152464);
  }
  
  private boolean axs(int paramInt)
  {
    AppMethodBeat.i(152462);
    if ((this.YxL != null) && (this.YxL.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152462);
      return true;
    }
    AppMethodBeat.o(152462);
    return false;
  }
  
  private boolean axt(int paramInt)
  {
    AppMethodBeat.i(152465);
    if ((this.YxM != null) && (this.YxM.contains(Integer.valueOf(paramInt))))
    {
      AppMethodBeat.o(152465);
      return true;
    }
    AppMethodBeat.o(152465);
    return false;
  }
  
  public static boolean iPV()
  {
    return true;
  }
  
  /* Error */
  public final void a(int paramInt, byte paramByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 123
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:YxJ	[B
    //   11: ifnull +7 -> 18
    //   14: iload_1
    //   15: ifge +29 -> 44
    //   18: ldc 125
    //   20: ldc 127
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: iload_1
    //   29: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: ldc 123
    //   38: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: iload_1
    //   45: aload_0
    //   46: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:YxJ	[B
    //   49: arraylength
    //   50: if_icmplt +63 -> 113
    //   53: ldc 125
    //   55: ldc 135
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
    //   71: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:YxJ	[B
    //   74: arraylength
    //   75: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: iload_1
    //   83: iconst_1
    //   84: iadd
    //   85: newarray byte
    //   87: astore_3
    //   88: aload_3
    //   89: iconst_2
    //   90: invokestatic 144	java/util/Arrays:fill	([BB)V
    //   93: aload_0
    //   94: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:YxJ	[B
    //   97: iconst_0
    //   98: aload_3
    //   99: iconst_0
    //   100: aload_0
    //   101: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:YxJ	[B
    //   104: arraylength
    //   105: invokestatic 150	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   108: aload_0
    //   109: aload_3
    //   110: putfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:YxJ	[B
    //   113: aload_0
    //   114: getfield 55	com/tencent/mm/protocal/JsapiPermissionWrapper:YxJ	[B
    //   117: iload_1
    //   118: iload_2
    //   119: bastore
    //   120: ldc 123
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
  
  public final int axr(int paramInt)
  {
    AppMethodBeat.i(257300);
    if (axt(paramInt))
    {
      AppMethodBeat.o(257300);
      return 1;
    }
    if (axs(paramInt))
    {
      AppMethodBeat.o(257300);
      return 0;
    }
    if (this.YxK == 1)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        Log.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(257300);
        return 0;
      }
      AppMethodBeat.o(257300);
      return 1;
    }
    if (this.YxK == 2)
    {
      if (paramInt == -3)
      {
        AppMethodBeat.o(257300);
        return 1;
      }
      AppMethodBeat.o(257300);
      return 0;
    }
    if (this.YxK == 3)
    {
      if ((paramInt == 34) || (paramInt == 75) || (paramInt == 23))
      {
        Log.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(257300);
        return 0;
      }
      AppMethodBeat.o(257300);
      return 1;
    }
    if (this.YxK == 4)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        Log.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        AppMethodBeat.o(257300);
        return 0;
      }
      AppMethodBeat.o(257300);
      return 1;
    }
    if ((paramInt == -2) || (paramInt == -3))
    {
      AppMethodBeat.o(257300);
      return 1;
    }
    if ((this.YxJ == null) || (paramInt < 0) || (paramInt >= this.YxJ.length))
    {
      AppMethodBeat.o(257300);
      return 0;
    }
    paramInt = this.YxJ[paramInt];
    AppMethodBeat.o(257300);
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
      if (this.YxJ == paramObject.YxJ) {
        return true;
      }
    } while ((this.YxJ == null) || (paramObject.YxJ == null) || (this.YxJ.length != paramObject.YxJ.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.YxJ.length) {
        break label87;
      }
      if (this.YxJ[i] != paramObject.YxJ[i]) {
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
    this.YxJ = paramBundle.getByteArray("jsapi_perm_wrapper_bytes");
    this.YxK = paramBundle.getInt("jsapi_perm_wrapper_hardcodePermission");
    P(paramBundle.getIntArray("jsapi_perm_wrapper_blacklist"));
    Q(paramBundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    AppMethodBeat.o(152459);
  }
  
  public final int[] iPW()
  {
    AppMethodBeat.i(152460);
    if (this.YxL != null)
    {
      int[] arrayOfInt = new int[this.YxL.size()];
      Iterator localIterator = this.YxL.iterator();
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
  
  public final int[] iPX()
  {
    AppMethodBeat.i(152463);
    if (this.YxM != null)
    {
      int[] arrayOfInt = new int[this.YxM.size()];
      Iterator localIterator = this.YxM.iterator();
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
  
  public final JsapiPermissionWrapper iPY()
  {
    AppMethodBeat.i(257301);
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
      AppMethodBeat.o(257301);
    }
  }
  
  public final boolean sk(int paramInt)
  {
    AppMethodBeat.i(152455);
    if (axr(paramInt) == 1)
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
    if (this.YxJ == null)
    {
      AppMethodBeat.o(152456);
      return "null";
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder(180);
    byte[] arrayOfByte = this.YxJ;
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
    paramParcel.writeByteArray(this.YxJ);
    paramParcel.writeInt(this.YxK);
    paramParcel.writeIntArray(iPW());
    paramParcel.writeIntArray(iPX());
    AppMethodBeat.o(152457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.JsapiPermissionWrapper
 * JD-Core Version:    0.7.0.1
 */