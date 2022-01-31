package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l
{
  protected String a;
  private ByteBuffer b;
  private o c;
  
  public l()
  {
    this(128);
  }
  
  public l(int paramInt)
  {
    AppMethodBeat.i(100297);
    this.a = "GBK";
    this.b = ByteBuffer.allocate(paramInt);
    AppMethodBeat.o(100297);
  }
  
  private void a(Object[] paramArrayOfObject, int paramInt)
  {
    AppMethodBeat.i(100317);
    a(8);
    a((byte)9, paramInt);
    a(paramArrayOfObject.length, 0);
    int i = paramArrayOfObject.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfObject[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(100317);
  }
  
  public int a(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public ByteBuffer a()
  {
    return this.b;
  }
  
  public void a(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(100300);
    byte b1;
    if (paramInt < 15)
    {
      b1 = (byte)(paramInt << 4 | paramByte);
      this.b.put(b1);
      AppMethodBeat.o(100300);
      return;
    }
    if (paramInt < 256)
    {
      b1 = (byte)(paramByte | 0xF0);
      this.b.put(b1);
      this.b.put((byte)paramInt);
      AppMethodBeat.o(100300);
      return;
    }
    j localj = new j("tag is too large: ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(100300);
    throw localj;
  }
  
  public void a(double paramDouble, int paramInt)
  {
    AppMethodBeat.i(100307);
    a(10);
    a((byte)5, paramInt);
    this.b.putDouble(paramDouble);
    AppMethodBeat.o(100307);
  }
  
  public void a(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(100306);
    a(6);
    a((byte)4, paramInt);
    this.b.putFloat(paramFloat);
    AppMethodBeat.o(100306);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(100299);
    int i;
    if (this.b.remaining() < paramInt) {
      i = (this.b.capacity() + paramInt) * 2;
    }
    try
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i);
      localByteBuffer.put(this.b.array(), 0, this.b.position());
      this.b = localByteBuffer;
      AppMethodBeat.o(100299);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (this.c != null) {
        this.c.a(localIllegalArgumentException, this.b, paramInt, i);
      }
      AppMethodBeat.o(100299);
      throw localIllegalArgumentException;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(100304);
    a(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      AppMethodBeat.o(100304);
      return;
    }
    a((byte)2, paramInt2);
    this.b.putInt(paramInt1);
    AppMethodBeat.o(100304);
  }
  
  public void a(long paramLong, int paramInt)
  {
    AppMethodBeat.i(100305);
    a(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      a((int)paramLong, paramInt);
      AppMethodBeat.o(100305);
      return;
    }
    a((byte)3, paramInt);
    this.b.putLong(paramLong);
    AppMethodBeat.o(100305);
  }
  
  public void a(m paramm, int paramInt)
  {
    AppMethodBeat.i(100319);
    a(2);
    a((byte)10, paramInt);
    paramm.writeTo(this);
    a(2);
    a((byte)11, 0);
    AppMethodBeat.o(100319);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(100320);
    if ((paramObject instanceof Byte))
    {
      b(((Byte)paramObject).byteValue(), paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      a(((Boolean)paramObject).booleanValue(), paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Short))
    {
      a(((Short)paramObject).shortValue(), paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      a(((Integer)paramObject).intValue(), paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Long))
    {
      a(((Long)paramObject).longValue(), paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Float))
    {
      a(((Float)paramObject).floatValue(), paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Double))
    {
      a(((Double)paramObject).doubleValue(), paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof String))
    {
      a((String)paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Map))
    {
      a((Map)paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof List))
    {
      a((List)paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof m))
    {
      a((m)paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      a((byte[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      a((boolean[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof short[]))
    {
      a((short[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof int[]))
    {
      a((int[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof long[]))
    {
      a((long[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof float[]))
    {
      a((float[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof double[]))
    {
      a((double[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if (paramObject.getClass().isArray())
    {
      a((Object[])paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      AppMethodBeat.o(100320);
      return;
    }
    paramObject = new j("write object error: unsupport type. " + paramObject.getClass());
    AppMethodBeat.o(100320);
    throw paramObject;
  }
  
  public void a(String paramString, int paramInt)
  {
    AppMethodBeat.i(100308);
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.a);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      a((byte)6, paramInt);
      this.b.put((byte)paramString.length);
      this.b.put(paramString);
      AppMethodBeat.o(100308);
    }
    a(paramString.length + 10);
    if (paramString.length > 255)
    {
      a((byte)7, paramInt);
      this.b.putInt(paramString.length);
      this.b.put(paramString);
      AppMethodBeat.o(100308);
      return;
    }
  }
  
  public <T> void a(Collection<T> paramCollection, int paramInt)
  {
    AppMethodBeat.i(100318);
    a(8);
    a((byte)9, paramInt);
    if (paramCollection == null) {}
    for (paramInt = 0;; paramInt = paramCollection.size())
    {
      a(paramInt, 0);
      if (paramCollection == null) {
        break;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next(), 0);
      }
    }
    AppMethodBeat.o(100318);
  }
  
  public <K, V> void a(Map<K, V> paramMap, int paramInt)
  {
    AppMethodBeat.i(100309);
    a(8);
    a((byte)8, paramInt);
    if (paramMap == null) {}
    for (paramInt = 0;; paramInt = paramMap.size())
    {
      a(paramInt, 0);
      if (paramMap == null) {
        break;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a(localEntry.getKey(), 0);
        a(localEntry.getValue(), 1);
      }
    }
    AppMethodBeat.o(100309);
  }
  
  public void a(short paramShort, int paramInt)
  {
    AppMethodBeat.i(100303);
    a(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      b((byte)paramShort, paramInt);
      AppMethodBeat.o(100303);
      return;
    }
    a((byte)1, paramInt);
    this.b.putShort(paramShort);
    AppMethodBeat.o(100303);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(100301);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      b((byte)i, paramInt);
      AppMethodBeat.o(100301);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(100311);
    a(paramArrayOfByte.length + 8);
    a((byte)13, paramInt);
    a((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.b.put(paramArrayOfByte);
    AppMethodBeat.o(100311);
  }
  
  public void a(double[] paramArrayOfDouble, int paramInt)
  {
    AppMethodBeat.i(100316);
    a(8);
    a((byte)9, paramInt);
    a(paramArrayOfDouble.length, 0);
    int i = paramArrayOfDouble.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfDouble[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(100316);
  }
  
  public void a(float[] paramArrayOfFloat, int paramInt)
  {
    AppMethodBeat.i(100315);
    a(8);
    a((byte)9, paramInt);
    a(paramArrayOfFloat.length, 0);
    int i = paramArrayOfFloat.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfFloat[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(100315);
  }
  
  public void a(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(100313);
    a(8);
    a((byte)9, paramInt);
    a(paramArrayOfInt.length, 0);
    int i = paramArrayOfInt.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfInt[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(100313);
  }
  
  public void a(long[] paramArrayOfLong, int paramInt)
  {
    AppMethodBeat.i(100314);
    a(8);
    a((byte)9, paramInt);
    a(paramArrayOfLong.length, 0);
    int i = paramArrayOfLong.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfLong[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(100314);
  }
  
  public void a(short[] paramArrayOfShort, int paramInt)
  {
    AppMethodBeat.i(100312);
    a(8);
    a((byte)9, paramInt);
    a(paramArrayOfShort.length, 0);
    int i = paramArrayOfShort.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfShort[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(100312);
  }
  
  public void a(boolean[] paramArrayOfBoolean, int paramInt)
  {
    AppMethodBeat.i(100310);
    a(8);
    a((byte)9, paramInt);
    a(paramArrayOfBoolean.length, 0);
    int i = paramArrayOfBoolean.length;
    paramInt = 0;
    while (paramInt < i)
    {
      a(paramArrayOfBoolean[paramInt], 0);
      paramInt += 1;
    }
    AppMethodBeat.o(100310);
  }
  
  public void b(byte paramByte, int paramInt)
  {
    AppMethodBeat.i(100302);
    a(3);
    if (paramByte == 0)
    {
      a((byte)12, paramInt);
      AppMethodBeat.o(100302);
      return;
    }
    a((byte)0, paramInt);
    this.b.put(paramByte);
    AppMethodBeat.o(100302);
  }
  
  public byte[] b()
  {
    AppMethodBeat.i(100298);
    byte[] arrayOfByte = new byte[this.b.position()];
    System.arraycopy(this.b.array(), 0, arrayOfByte, 0, this.b.position());
    AppMethodBeat.o(100298);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.l
 * JD-Core Version:    0.7.0.1
 */