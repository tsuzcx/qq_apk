package io.flutter.plugin.common;

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

public class StandardMessageCodec
  implements MessageCodec<Object>
{
  private static final byte BIGINT = 5;
  private static final byte BYTE_ARRAY = 8;
  private static final byte DOUBLE = 6;
  private static final byte DOUBLE_ARRAY = 11;
  private static final byte FALSE = 2;
  public static final StandardMessageCodec INSTANCE;
  private static final byte INT = 3;
  private static final byte INT_ARRAY = 9;
  private static final byte LIST = 12;
  private static final boolean LITTLE_ENDIAN;
  private static final byte LONG = 4;
  private static final byte LONG_ARRAY = 10;
  private static final byte MAP = 13;
  private static final byte NULL = 0;
  private static final byte STRING = 7;
  private static final String TAG = "StandardMessageCodec#";
  private static final byte TRUE = 1;
  private static final Charset UTF8;
  
  static
  {
    AppMethodBeat.i(9865);
    INSTANCE = new StandardMessageCodec();
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {}
    for (boolean bool = true;; bool = false)
    {
      LITTLE_ENDIAN = bool;
      UTF8 = Charset.forName("UTF8");
      AppMethodBeat.o(9865);
      return;
    }
  }
  
  protected static final void readAlignment(ByteBuffer paramByteBuffer, int paramInt)
  {
    AppMethodBeat.i(9862);
    int i = paramByteBuffer.position() % paramInt;
    if (i != 0) {
      paramByteBuffer.position(paramByteBuffer.position() + paramInt - i);
    }
    AppMethodBeat.o(9862);
  }
  
  protected static final byte[] readBytes(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9861);
    byte[] arrayOfByte = new byte[readSize(paramByteBuffer)];
    paramByteBuffer.get(arrayOfByte);
    AppMethodBeat.o(9861);
    return arrayOfByte;
  }
  
  protected static final int readSize(ByteBuffer paramByteBuffer)
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
  
  protected static final void writeAlignment(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
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
  
  protected static final void writeBytes(ByteArrayOutputStream paramByteArrayOutputStream, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9857);
    writeSize(paramByteArrayOutputStream, paramArrayOfByte.length);
    paramByteArrayOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
    AppMethodBeat.o(9857);
  }
  
  protected static final void writeChar(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    AppMethodBeat.i(189861);
    if (LITTLE_ENDIAN)
    {
      paramByteArrayOutputStream.write(paramInt);
      paramByteArrayOutputStream.write(paramInt >>> 8);
      AppMethodBeat.o(189861);
      return;
    }
    paramByteArrayOutputStream.write(paramInt >>> 8);
    paramByteArrayOutputStream.write(paramInt);
    AppMethodBeat.o(189861);
  }
  
  protected static final void writeDouble(ByteArrayOutputStream paramByteArrayOutputStream, double paramDouble)
  {
    AppMethodBeat.i(9856);
    writeLong(paramByteArrayOutputStream, Double.doubleToLongBits(paramDouble));
    AppMethodBeat.o(9856);
  }
  
  protected static final void writeInt(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    AppMethodBeat.i(9854);
    if (LITTLE_ENDIAN)
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
  
  protected static final void writeLong(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    AppMethodBeat.i(9855);
    if (LITTLE_ENDIAN)
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
  
  protected static final void writeSize(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
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
      writeChar(paramByteArrayOutputStream, paramInt);
      AppMethodBeat.o(9853);
      return;
    }
    paramByteArrayOutputStream.write(255);
    writeInt(paramByteArrayOutputStream, paramInt);
    AppMethodBeat.o(9853);
  }
  
  public Object decodeMessage(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9852);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(9852);
      return null;
    }
    paramByteBuffer.order(ByteOrder.nativeOrder());
    Object localObject = readValue(paramByteBuffer);
    if (paramByteBuffer.hasRemaining())
    {
      paramByteBuffer = new IllegalArgumentException("Message corrupted");
      AppMethodBeat.o(9852);
      throw paramByteBuffer;
    }
    AppMethodBeat.o(9852);
    return localObject;
  }
  
  public ByteBuffer encodeMessage(Object paramObject)
  {
    AppMethodBeat.i(9851);
    if (paramObject == null)
    {
      AppMethodBeat.o(9851);
      return null;
    }
    ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new ExposedByteArrayOutputStream();
    writeValue(localExposedByteArrayOutputStream, paramObject);
    paramObject = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
    paramObject.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
    AppMethodBeat.o(9851);
    return paramObject;
  }
  
  protected final Object readValue(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(9863);
    if (!paramByteBuffer.hasRemaining())
    {
      paramByteBuffer = new IllegalArgumentException("Message corrupted");
      AppMethodBeat.o(9863);
      throw paramByteBuffer;
    }
    paramByteBuffer = readValueOfType(paramByteBuffer.get(), paramByteBuffer);
    AppMethodBeat.o(9863);
    return paramByteBuffer;
  }
  
  protected Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
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
        localObject1 = new BigInteger(new String(readBytes(paramByteBuffer), UTF8), 16);
        continue;
        readAlignment(paramByteBuffer, 8);
        localObject1 = Double.valueOf(paramByteBuffer.getDouble());
        continue;
        localObject1 = new String(readBytes(paramByteBuffer), UTF8);
        continue;
        localObject1 = readBytes(paramByteBuffer);
        continue;
        paramByte = readSize(paramByteBuffer);
        localObject1 = new int[paramByte];
        readAlignment(paramByteBuffer, 4);
        paramByteBuffer.asIntBuffer().get((int[])localObject1);
        paramByteBuffer.position(paramByte * 4 + paramByteBuffer.position());
        continue;
        paramByte = readSize(paramByteBuffer);
        localObject1 = new long[paramByte];
        readAlignment(paramByteBuffer, 8);
        paramByteBuffer.asLongBuffer().get((long[])localObject1);
        paramByteBuffer.position(paramByte * 8 + paramByteBuffer.position());
        continue;
        paramByte = readSize(paramByteBuffer);
        localObject1 = new double[paramByte];
        readAlignment(paramByteBuffer, 8);
        paramByteBuffer.asDoubleBuffer().get((double[])localObject1);
        paramByteBuffer.position(paramByte * 8 + paramByteBuffer.position());
      }
    case 12: 
      b2 = readSize(paramByteBuffer);
      localObject2 = new ArrayList(b2);
      paramByte = b1;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramByte >= b2) {
          break;
        }
        ((List)localObject2).add(readValue(paramByteBuffer));
        paramByte += 1;
      }
    }
    b1 = readSize(paramByteBuffer);
    Object localObject2 = new HashMap();
    paramByte = b2;
    for (;;)
    {
      localObject1 = localObject2;
      if (paramByte >= b1) {
        break;
      }
      ((Map)localObject2).put(readValue(paramByteBuffer), readValue(paramByteBuffer));
      paramByte += 1;
    }
  }
  
  protected void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
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
        writeInt(paramByteArrayOutputStream, ((Number)paramObject).intValue());
        AppMethodBeat.o(9859);
        return;
      }
      if ((paramObject instanceof Long))
      {
        paramByteArrayOutputStream.write(4);
        writeLong(paramByteArrayOutputStream, ((Long)paramObject).longValue());
        AppMethodBeat.o(9859);
        return;
      }
      if (((paramObject instanceof Float)) || ((paramObject instanceof Double)))
      {
        paramByteArrayOutputStream.write(6);
        writeAlignment(paramByteArrayOutputStream, 8);
        writeDouble(paramByteArrayOutputStream, ((Number)paramObject).doubleValue());
        AppMethodBeat.o(9859);
        return;
      }
      if ((paramObject instanceof BigInteger))
      {
        paramByteArrayOutputStream.write(5);
        writeBytes(paramByteArrayOutputStream, ((BigInteger)paramObject).toString(16).getBytes(UTF8));
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
      writeBytes(paramByteArrayOutputStream, ((String)paramObject).getBytes(UTF8));
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramByteArrayOutputStream.write(8);
      writeBytes(paramByteArrayOutputStream, (byte[])paramObject);
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      paramByteArrayOutputStream.write(9);
      paramObject = (int[])paramObject;
      writeSize(paramByteArrayOutputStream, paramObject.length);
      writeAlignment(paramByteArrayOutputStream, 4);
      j = paramObject.length;
      while (i < j)
      {
        writeInt(paramByteArrayOutputStream, paramObject[i]);
        i += 1;
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      paramByteArrayOutputStream.write(10);
      paramObject = (long[])paramObject;
      writeSize(paramByteArrayOutputStream, paramObject.length);
      writeAlignment(paramByteArrayOutputStream, 8);
      k = paramObject.length;
      i = j;
      while (i < k)
      {
        writeLong(paramByteArrayOutputStream, paramObject[i]);
        i += 1;
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      paramByteArrayOutputStream.write(11);
      paramObject = (double[])paramObject;
      writeSize(paramByteArrayOutputStream, paramObject.length);
      writeAlignment(paramByteArrayOutputStream, 8);
      j = paramObject.length;
      i = k;
      while (i < j)
      {
        writeDouble(paramByteArrayOutputStream, paramObject[i]);
        i += 1;
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof List))
    {
      paramByteArrayOutputStream.write(12);
      paramObject = (List)paramObject;
      writeSize(paramByteArrayOutputStream, paramObject.size());
      paramObject = paramObject.iterator();
      while (paramObject.hasNext()) {
        writeValue(paramByteArrayOutputStream, paramObject.next());
      }
      AppMethodBeat.o(9859);
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramByteArrayOutputStream.write(13);
      paramObject = (Map)paramObject;
      writeSize(paramByteArrayOutputStream, paramObject.size());
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramObject.next();
        writeValue(paramByteArrayOutputStream, localEntry.getKey());
        writeValue(paramByteArrayOutputStream, localEntry.getValue());
      }
      AppMethodBeat.o(9859);
      return;
    }
    paramByteArrayOutputStream = new IllegalArgumentException("Unsupported value: ".concat(String.valueOf(paramObject)));
    AppMethodBeat.o(9859);
    throw paramByteArrayOutputStream;
  }
  
  static final class ExposedByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    final byte[] buffer()
    {
      return this.buf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     io.flutter.plugin.common.StandardMessageCodec
 * JD-Core Version:    0.7.0.1
 */