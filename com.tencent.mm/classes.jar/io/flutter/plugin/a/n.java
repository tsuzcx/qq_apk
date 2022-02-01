package io.flutter.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class n
  implements i<Object>
{
  private static final Charset Zcl;
  public static final n aauQ;
  private static final boolean aauR;
  
  static
  {
    AppMethodBeat.i(9865);
    aauQ = new n();
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {}
    for (boolean bool = true;; bool = false)
    {
      aauR = bool;
      Zcl = Charset.forName("UTF8");
      AppMethodBeat.o(9865);
      return;
    }
  }
  
  private static int I(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9860);
    if (!paramByteBuffer.hasRemaining())
    {
      paramByteBuffer = new IllegalArgumentException("Message corrupted");
      AppMethodBeat.o(9860);
      throw paramByteBuffer;
    }
    int i = paramByteBuffer.get() & 0xFF;
    if (i < 254)
    {
      AppMethodBeat.o(9860);
      return i;
    }
    if (i == 254)
    {
      i = paramByteBuffer.getChar();
      AppMethodBeat.o(9860);
      return i;
    }
    i = paramByteBuffer.getInt();
    AppMethodBeat.o(9860);
    return i;
  }
  
  private static byte[] J(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9861);
    byte[] arrayOfByte = new byte[I(paramByteBuffer)];
    paramByteBuffer.get(arrayOfByte);
    AppMethodBeat.o(9861);
    return arrayOfByte;
  }
  
  private Object a(byte paramByte, ByteBuffer paramByteBuffer)
  {
    byte b2 = 0;
    byte b1 = 0;
    AppMethodBeat.i(9864);
    Object localObject1;
    switch (paramByte)
    {
    default: 
      paramByteBuffer = new IllegalArgumentException("Message corrupted");
      AppMethodBeat.o(9864);
      throw paramByteBuffer;
    case 0: 
      localObject1 = null;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      for (;;)
      {
        AppMethodBeat.o(9864);
        return localObject1;
        localObject1 = Boolean.TRUE;
        continue;
        localObject1 = Boolean.FALSE;
        continue;
        localObject1 = Integer.valueOf(paramByteBuffer.getInt());
        continue;
        localObject1 = Long.valueOf(paramByteBuffer.getLong());
        continue;
        localObject1 = new BigInteger(new String(J(paramByteBuffer), Zcl), 16);
        continue;
        f(paramByteBuffer, 8);
        localObject1 = Double.valueOf(paramByteBuffer.getDouble());
        continue;
        localObject1 = new String(J(paramByteBuffer), Zcl);
        continue;
        localObject1 = J(paramByteBuffer);
        continue;
        paramByte = I(paramByteBuffer);
        localObject1 = new int[paramByte];
        f(paramByteBuffer, 4);
        paramByteBuffer.asIntBuffer().get((int[])localObject1);
        paramByteBuffer.position(paramByte * 4 + paramByteBuffer.position());
        continue;
        paramByte = I(paramByteBuffer);
        localObject1 = new long[paramByte];
        f(paramByteBuffer, 8);
        paramByteBuffer.asLongBuffer().get((long[])localObject1);
        paramByteBuffer.position(paramByte * 8 + paramByteBuffer.position());
        continue;
        paramByte = I(paramByteBuffer);
        localObject1 = new double[paramByte];
        f(paramByteBuffer, 8);
        paramByteBuffer.asDoubleBuffer().get((double[])localObject1);
        paramByteBuffer.position(paramByte * 8 + paramByteBuffer.position());
      }
    case 12: 
      b2 = I(paramByteBuffer);
      localObject2 = new ArrayList(b2);
      paramByte = b1;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramByte >= b2) {
          break;
        }
        ((List)localObject2).add(K(paramByteBuffer));
        paramByte += 1;
      }
    }
    b1 = I(paramByteBuffer);
    Object localObject2 = new HashMap();
    paramByte = b2;
    for (;;)
    {
      localObject1 = localObject2;
      if (paramByte >= b1) {
        break;
      }
      ((Map)localObject2).put(K(paramByteBuffer), K(paramByteBuffer));
      paramByte += 1;
    }
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, double paramDouble)
  {
    AppMethodBeat.i(9856);
    a(paramByteArrayOutputStream, Double.doubleToLongBits(paramDouble));
    AppMethodBeat.o(9856);
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    AppMethodBeat.i(9853);
    if (paramInt < 254)
    {
      paramByteArrayOutputStream.write(paramInt);
      AppMethodBeat.o(9853);
      return;
    }
    if (paramInt <= 65535)
    {
      paramByteArrayOutputStream.write(254);
      if (aauR)
      {
        paramByteArrayOutputStream.write(paramInt);
        paramByteArrayOutputStream.write(paramInt >>> 8);
        AppMethodBeat.o(9853);
        return;
      }
      paramByteArrayOutputStream.write(paramInt >>> 8);
      paramByteArrayOutputStream.write(paramInt);
      AppMethodBeat.o(9853);
      return;
    }
    paramByteArrayOutputStream.write(255);
    b(paramByteArrayOutputStream, paramInt);
    AppMethodBeat.o(9853);
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    AppMethodBeat.i(9855);
    if (aauR)
    {
      paramByteArrayOutputStream.write((byte)(int)paramLong);
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 8));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 16));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 24));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 32));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 40));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 48));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 56));
      AppMethodBeat.o(9855);
      return;
    }
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 56));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 48));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 40));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 32));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 24));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 16));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 8));
    paramByteArrayOutputStream.write((byte)(int)paramLong);
    AppMethodBeat.o(9855);
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9857);
    a(paramByteArrayOutputStream, paramArrayOfByte.length);
    paramByteArrayOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(9857);
  }
  
  private static void b(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    AppMethodBeat.i(9854);
    if (aauR)
    {
      paramByteArrayOutputStream.write(paramInt);
      paramByteArrayOutputStream.write(paramInt >>> 8);
      paramByteArrayOutputStream.write(paramInt >>> 16);
      paramByteArrayOutputStream.write(paramInt >>> 24);
      AppMethodBeat.o(9854);
      return;
    }
    paramByteArrayOutputStream.write(paramInt >>> 24);
    paramByteArrayOutputStream.write(paramInt >>> 16);
    paramByteArrayOutputStream.write(paramInt >>> 8);
    paramByteArrayOutputStream.write(paramInt);
    AppMethodBeat.o(9854);
  }
  
  private static void c(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    AppMethodBeat.i(9858);
    int j = paramByteArrayOutputStream.size() % paramInt;
    if (j != 0)
    {
      int i = 0;
      while (i < paramInt - j)
      {
        paramByteArrayOutputStream.write(0);
        i += 1;
      }
    }
    AppMethodBeat.o(9858);
  }
  
  private static void f(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(9862);
    int i = paramByteBuffer.position() % paramInt;
    if (i != 0) {
      paramByteBuffer.position(paramByteBuffer.position() + paramInt - i);
    }
    AppMethodBeat.o(9862);
  }
  
  public final Object F(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9852);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(9852);
      return null;
    }
    paramByteBuffer.order(ByteOrder.nativeOrder());
    Object localObject = K(paramByteBuffer);
    if (paramByteBuffer.hasRemaining())
    {
      paramByteBuffer = new IllegalArgumentException("Message corrupted");
      AppMethodBeat.o(9852);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(9852);
    return localObject;
  }
  
  protected final Object K(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9863);
    if (!paramByteBuffer.hasRemaining())
    {
      paramByteBuffer = new IllegalArgumentException("Message corrupted");
      AppMethodBeat.o(9863);
      throw paramByteBuffer;
    }
    paramByteBuffer = a(paramByteBuffer.get(), paramByteBuffer);
    AppMethodBeat.o(9863);
    return paramByteBuffer;
  }
  
  protected final void a(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    AppMethodBeat.i(9859);
    if ((paramObject == null) || (paramObject.equals(null)))
    {
      paramByteArrayOutputStream.write(0);
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {}
      for (i = 1;; i = 2)
      {
        paramByteArrayOutputStream.write(i);
        AppMethodBeat.o(9859);
        return;
      }
    }
    if ((paramObject instanceof Number))
    {
      if (((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)))
      {
        paramByteArrayOutputStream.write(3);
        b(paramByteArrayOutputStream, ((Number)paramObject).intValue());
        AppMethodBeat.o(9859);
        return;
      }
      if ((paramObject instanceof Long))
      {
        paramByteArrayOutputStream.write(4);
        a(paramByteArrayOutputStream, ((Long)paramObject).longValue());
        AppMethodBeat.o(9859);
        return;
      }
      if (((paramObject instanceof Float)) || ((paramObject instanceof Double)))
      {
        paramByteArrayOutputStream.write(6);
        c(paramByteArrayOutputStream, 8);
        a(paramByteArrayOutputStream, ((Number)paramObject).doubleValue());
        AppMethodBeat.o(9859);
        return;
      }
      if ((paramObject instanceof BigInteger))
      {
        paramByteArrayOutputStream.write(5);
        a(paramByteArrayOutputStream, ((BigInteger)paramObject).toString(16).getBytes(Zcl));
        AppMethodBeat.o(9859);
        return;
      }
      paramByteArrayOutputStream = new IllegalArgumentException("Unsupported Number type: " + paramObject.getClass());
      AppMethodBeat.o(9859);
      throw paramByteArrayOutputStream;
    }
    if ((paramObject instanceof String))
    {
      paramByteArrayOutputStream.write(7);
      a(paramByteArrayOutputStream, ((String)paramObject).getBytes(Zcl));
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramByteArrayOutputStream.write(8);
      a(paramByteArrayOutputStream, (byte[])paramObject);
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      paramByteArrayOutputStream.write(9);
      paramObject = (int[])paramObject;
      a(paramByteArrayOutputStream, paramObject.length);
      c(paramByteArrayOutputStream, 4);
      j = paramObject.length;
      while (i < j)
      {
        b(paramByteArrayOutputStream, paramObject[i]);
        i += 1;
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      paramByteArrayOutputStream.write(10);
      paramObject = (long[])paramObject;
      a(paramByteArrayOutputStream, paramObject.length);
      c(paramByteArrayOutputStream, 8);
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        a(paramByteArrayOutputStream, paramObject[i]);
        i += 1;
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      paramByteArrayOutputStream.write(11);
      paramObject = (double[])paramObject;
      a(paramByteArrayOutputStream, paramObject.length);
      c(paramByteArrayOutputStream, 8);
      j = paramObject.length;
      i = k;
      while (i < j)
      {
        a(paramByteArrayOutputStream, paramObject[i]);
        i += 1;
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof List))
    {
      paramByteArrayOutputStream.write(12);
      paramObject = (List)paramObject;
      a(paramByteArrayOutputStream, paramObject.size());
      paramObject = paramObject.iterator();
      while (paramObject.hasNext()) {
        a(paramByteArrayOutputStream, paramObject.next());
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramByteArrayOutputStream.write(13);
      paramObject = (Map)paramObject;
      a(paramByteArrayOutputStream, paramObject.size());
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramObject.next();
        a(paramByteArrayOutputStream, localEntry.getKey());
        a(paramByteArrayOutputStream, localEntry.getValue());
      }
      AppMethodBeat.o(9859);
      return;
    }
    paramByteArrayOutputStream = new IllegalArgumentException("Unsupported value: ".concat(String.valueOf(paramObject)));
    AppMethodBeat.o(9859);
    throw paramByteArrayOutputStream;
  }
  
  public final ByteBuffer eU(Object paramObject)
  {
    AppMethodBeat.i(9851);
    if (paramObject == null)
    {
      AppMethodBeat.o(9851);
      return null;
    }
    a locala = new a();
    a(locala, paramObject);
    paramObject = ByteBuffer.allocateDirect(locala.size());
    paramObject.put(locala.iBo(), 0, locala.size());
    AppMethodBeat.o(9851);
    return paramObject;
  }
  
  static final class a
    extends ByteArrayOutputStream
  {
    final byte[] iBo()
    {
      return this.buf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.plugin.a.n
 * JD-Core Version:    0.7.0.1
 */