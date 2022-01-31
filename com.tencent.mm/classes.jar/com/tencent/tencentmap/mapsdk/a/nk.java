package com.tencent.tencentmap.mapsdk.a;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class nk
{
  protected String a = "GBK";
  private ByteBuffer b;
  
  public nk() {}
  
  public nk(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public nk(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
    this.b.position(paramInt);
  }
  
  public static int a(nk.a parama, ByteBuffer paramByteBuffer)
  {
    int i = paramByteBuffer.get();
    parama.a = ((byte)(i & 0xF));
    parama.b = ((i & 0xF0) >> 4);
    if (parama.b == 15)
    {
      parama.b = (paramByteBuffer.get() & 0xFF);
      return 2;
    }
    return 1;
  }
  
  private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
  {
    if ((paramMap2 == null) || (paramMap2.isEmpty())) {
      paramMap2 = new HashMap();
    }
    do
    {
      return paramMap2;
      paramMap2 = (Map.Entry)paramMap2.entrySet().iterator().next();
      Object localObject1 = paramMap2.getKey();
      Object localObject2 = paramMap2.getValue();
      if (a(paramInt))
      {
        paramMap2 = new nk.a();
        a(paramMap2);
        switch (paramMap2.a)
        {
        default: 
          throw new nh("type mismatch.");
        }
        int i = a(0, 0, true);
        if (i < 0) {
          throw new nh("size invalid: " + i);
        }
        paramInt = 0;
        for (;;)
        {
          paramMap2 = paramMap1;
          if (paramInt >= i) {
            break;
          }
          paramMap1.put(a(localObject1, 0, true), a(localObject2, 1, true));
          paramInt += 1;
        }
      }
      paramMap2 = paramMap1;
    } while (!paramBoolean);
    throw new nh("require field not exist.");
  }
  
  private void a(byte paramByte)
  {
    byte b2 = 0;
    byte b1 = 0;
    switch (paramByte)
    {
    default: 
      throw new nh("invalid type.");
    case 0: 
      b(1);
    case 11: 
    case 12: 
      return;
    case 1: 
      b(2);
      return;
    case 2: 
      b(4);
      return;
    case 3: 
      b(8);
      return;
    case 4: 
      b(4);
      return;
    case 5: 
      b(8);
      return;
    case 6: 
      b1 = this.b.get();
      paramByte = b1;
      if (b1 < 0) {
        paramByte = b1 + 256;
      }
      b(paramByte);
      return;
    case 7: 
      b(this.b.getInt());
      return;
    case 8: 
      b2 = a(0, 0, true);
      paramByte = b1;
      while (paramByte < b2 * 2)
      {
        b();
        paramByte += 1;
      }
    case 9: 
      b1 = a(0, 0, true);
      paramByte = b2;
      while (paramByte < b1)
      {
        b();
        paramByte += 1;
      }
    case 13: 
      nk.a locala = new nk.a();
      a(locala);
      if (locala.a != 0) {
        throw new nh("skipField with invalid type, type value: " + paramByte + ", " + locala.a);
      }
      b(a(0, 0, true));
      return;
    }
    a();
  }
  
  private int b(nk.a parama)
  {
    return a(parama, this.b.duplicate());
  }
  
  private void b()
  {
    nk.a locala = new nk.a();
    a(locala);
    a(locala.a);
  }
  
  private void b(int paramInt)
  {
    this.b.position(this.b.position() + paramInt);
  }
  
  private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      localObject = new nk.a();
      a((nk.a)localObject);
      switch (((nk.a)localObject).a)
      {
      default: 
        throw new nh("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new nh("size invalid: " + i);
      }
      Object[] arrayOfObject = (Object[])Array.newInstance(paramT.getClass(), i);
      paramInt = 0;
      for (;;)
      {
        localObject = arrayOfObject;
        if (paramInt >= i) {
          break;
        }
        arrayOfObject[paramInt] = a(paramT, 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new nh("require field not exist.");
    }
    Object localObject = null;
    return localObject;
  }
  
  public final byte a(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new nk.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new nh("type mismatch.");
      case 12: 
        paramByte = 0;
      }
    }
    while (!paramBoolean)
    {
      nk.a locala;
      return paramByte;
      return this.b.get();
    }
    throw new nh("require field not exist.");
  }
  
  public final double a(double paramDouble, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new nk.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new nh("type mismatch.");
      case 12: 
        paramDouble = 0.0D;
      }
    }
    while (!paramBoolean)
    {
      nk.a locala;
      return paramDouble;
      return this.b.getFloat();
      return this.b.getDouble();
    }
    throw new nh("require field not exist.");
  }
  
  public final float a(float paramFloat, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new nk.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new nh("type mismatch.");
      case 12: 
        paramFloat = 0.0F;
      }
    }
    while (!paramBoolean)
    {
      nk.a locala;
      return paramFloat;
      return this.b.getFloat();
    }
    throw new nh("require field not exist.");
  }
  
  public final int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (a(paramInt2))
    {
      locala = new nk.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new nh("type mismatch.");
      case 12: 
        paramInt1 = 0;
      }
    }
    while (!paramBoolean)
    {
      nk.a locala;
      return paramInt1;
      return this.b.get();
      return this.b.getShort();
      return this.b.getInt();
    }
    throw new nh("require field not exist.");
  }
  
  public final int a(String paramString)
  {
    this.a = paramString;
    return 0;
  }
  
  public final long a(long paramLong, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new nk.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new nh("type mismatch.");
      case 12: 
        paramLong = 0L;
      }
    }
    while (!paramBoolean)
    {
      nk.a locala;
      return paramLong;
      return this.b.get();
      return this.b.getShort();
      return this.b.getInt();
      return this.b.getLong();
    }
    throw new nh("require field not exist.");
  }
  
  public final nm a(nm paramnm, int paramInt, boolean paramBoolean)
  {
    nk.a locala = null;
    if (a(paramInt))
    {
      try
      {
        paramnm = (nm)paramnm.getClass().newInstance();
        locala = new nk.a();
        a(locala);
        if (locala.a != 10) {
          throw new nh("type mismatch.");
        }
      }
      catch (Exception paramnm)
      {
        throw new nh(paramnm.getMessage());
      }
      paramnm.readFrom(this);
      a();
    }
    do
    {
      return paramnm;
      paramnm = locala;
    } while (!paramBoolean);
    throw new nh("require field not exist.");
  }
  
  public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
  {
    if ((paramT instanceof Byte)) {
      return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Boolean)) {
      return Boolean.valueOf(a(false, paramInt, paramBoolean));
    }
    if ((paramT instanceof Short)) {
      return Short.valueOf(a((short)0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Integer)) {
      return Integer.valueOf(a(0, paramInt, paramBoolean));
    }
    if ((paramT instanceof Long)) {
      return Long.valueOf(a(0L, paramInt, paramBoolean));
    }
    if ((paramT instanceof Float)) {
      return Float.valueOf(a(0.0F, paramInt, paramBoolean));
    }
    if ((paramT instanceof Double)) {
      return Double.valueOf(a(0.0D, paramInt, paramBoolean));
    }
    if ((paramT instanceof String)) {
      return a(paramInt, paramBoolean);
    }
    if ((paramT instanceof Map)) {
      return a((Map)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof List)) {
      return a((List)paramT, paramInt, paramBoolean);
    }
    if ((paramT instanceof nm)) {
      return a((nm)paramT, paramInt, paramBoolean);
    }
    if (paramT.getClass().isArray())
    {
      if (((paramT instanceof byte[])) || ((paramT instanceof Byte[]))) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof boolean[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof short[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof int[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof long[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof float[])) {
        return a(null, paramInt, paramBoolean);
      }
      if ((paramT instanceof double[])) {
        return a(null, paramInt, paramBoolean);
      }
      return a((Object[])paramT, paramInt, paramBoolean);
    }
    throw new nh("read object error: unsupport type.");
  }
  
  public final String a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    if (a(paramInt))
    {
      localObject1 = new nk.a();
      a((nk.a)localObject1);
      switch (((nk.a)localObject1).a)
      {
      default: 
        throw new nh("type mismatch.");
      case 6: 
        i = this.b.get();
        paramInt = i;
        if (i < 0) {
          paramInt = i + 256;
        }
        localObject2 = new byte[paramInt];
        this.b.get((byte[])localObject2);
      }
    }
    while (!paramBoolean)
    {
      Object localObject2;
      try
      {
        int i;
        localObject1 = new String((byte[])localObject2, this.a);
        return localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        return new String((byte[])localObject2);
      }
      paramInt = this.b.getInt();
      if ((paramInt > 104857600) || (paramInt < 0) || (paramInt > this.b.capacity())) {
        throw new nh("String too long: " + paramInt);
      }
      byte[] arrayOfByte = new byte[paramInt];
      this.b.get(arrayOfByte);
      try
      {
        localObject2 = new String(arrayOfByte, this.a);
        return localObject2;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        return new String(arrayOfByte);
      }
    }
    throw new nh("require field not exist.");
  }
  
  public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
  {
    return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
  }
  
  public final <T> List<T> a(List<T> paramList, int paramInt, boolean paramBoolean)
  {
    int i = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      return new ArrayList();
    }
    paramList = b(paramList.get(0), paramInt, paramBoolean);
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramInt = i;
    while (paramInt < paramList.length)
    {
      localArrayList.add(paramList[paramInt]);
      paramInt += 1;
    }
    return localArrayList;
  }
  
  public final short a(short paramShort, int paramInt, boolean paramBoolean)
  {
    if (a(paramInt))
    {
      locala = new nk.a();
      a(locala);
      switch (locala.a)
      {
      default: 
        throw new nh("type mismatch.");
      case 12: 
        paramShort = 0;
      }
    }
    while (!paramBoolean)
    {
      nk.a locala;
      return paramShort;
      return (short)this.b.get();
      return this.b.getShort();
    }
    throw new nh("require field not exist.");
  }
  
  public final void a()
  {
    nk.a locala = new nk.a();
    do
    {
      a(locala);
      a(locala.a);
    } while (locala.a != 11);
  }
  
  public final void a(nk.a parama)
  {
    a(parama, this.b);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.b = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  public final boolean a(int paramInt)
  {
    try
    {
      nk.a locala = new nk.a();
      for (;;)
      {
        int i = b(locala);
        if ((paramInt <= locala.b) || (locala.a == 11))
        {
          if (locala.a == 11) {
            return false;
          }
          if (paramInt != locala.b) {
            break;
          }
          return true;
        }
        b(i);
        a(locala.a);
      }
      return false;
    }
    catch (nh localnh)
    {
      return false;
    }
    catch (BufferUnderflowException localBufferUnderflowException) {}
  }
  
  public final boolean a(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    paramBoolean1 = false;
    if (a((byte)0, paramInt, paramBoolean2) != 0) {
      paramBoolean1 = true;
    }
    return paramBoolean1;
  }
  
  public final byte[] a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramArrayOfByte = null;
    if (a(paramInt))
    {
      paramArrayOfByte = new nk.a();
      a(paramArrayOfByte);
      switch (paramArrayOfByte.a)
      {
      default: 
        throw new nh("type mismatch.");
      case 13: 
        localObject = new nk.a();
        a((nk.a)localObject);
        if (((nk.a)localObject).a != 0) {
          throw new nh("type mismatch, tag: " + paramInt + ", type: " + paramArrayOfByte.a + ", " + ((nk.a)localObject).a);
        }
        i = a(0, 0, true);
        if ((i < 0) || (i > this.b.capacity())) {
          throw new nh("invalid size, tag: " + paramInt + ", type: " + paramArrayOfByte.a + ", " + ((nk.a)localObject).a + ", size: " + i);
        }
        paramArrayOfByte = new byte[i];
        this.b.get(paramArrayOfByte);
      }
    }
    while (!paramBoolean)
    {
      return paramArrayOfByte;
      int i = a(0, 0, true);
      if ((i < 0) || (i > this.b.capacity())) {
        throw new nh("size invalid: " + i);
      }
      Object localObject = new byte[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramInt >= i) {
          break;
        }
        localObject[paramInt] = a(localObject[0], 0, true);
        paramInt += 1;
      }
    }
    throw new nh("require field not exist.");
  }
  
  public final double[] a(double[] paramArrayOfDouble, int paramInt, boolean paramBoolean)
  {
    paramArrayOfDouble = null;
    if (a(paramInt))
    {
      paramArrayOfDouble = new nk.a();
      a(paramArrayOfDouble);
      switch (paramArrayOfDouble.a)
      {
      default: 
        throw new nh("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new nh("size invalid: " + i);
      }
      double[] arrayOfDouble = new double[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfDouble = arrayOfDouble;
        if (paramInt >= i) {
          break;
        }
        arrayOfDouble[paramInt] = a(arrayOfDouble[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new nh("require field not exist.");
    }
    return paramArrayOfDouble;
  }
  
  public final float[] a(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    paramArrayOfFloat = null;
    if (a(paramInt))
    {
      paramArrayOfFloat = new nk.a();
      a(paramArrayOfFloat);
      switch (paramArrayOfFloat.a)
      {
      default: 
        throw new nh("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new nh("size invalid: " + i);
      }
      float[] arrayOfFloat = new float[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfFloat = arrayOfFloat;
        if (paramInt >= i) {
          break;
        }
        arrayOfFloat[paramInt] = a(arrayOfFloat[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new nh("require field not exist.");
    }
    return paramArrayOfFloat;
  }
  
  public final int[] a(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    paramArrayOfInt = null;
    if (a(paramInt))
    {
      paramArrayOfInt = new nk.a();
      a(paramArrayOfInt);
      switch (paramArrayOfInt.a)
      {
      default: 
        throw new nh("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new nh("size invalid: " + i);
      }
      int[] arrayOfInt = new int[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfInt = arrayOfInt;
        if (paramInt >= i) {
          break;
        }
        arrayOfInt[paramInt] = a(arrayOfInt[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new nh("require field not exist.");
    }
    return paramArrayOfInt;
  }
  
  public final long[] a(long[] paramArrayOfLong, int paramInt, boolean paramBoolean)
  {
    paramArrayOfLong = null;
    if (a(paramInt))
    {
      paramArrayOfLong = new nk.a();
      a(paramArrayOfLong);
      switch (paramArrayOfLong.a)
      {
      default: 
        throw new nh("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new nh("size invalid: " + i);
      }
      long[] arrayOfLong = new long[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfLong = arrayOfLong;
        if (paramInt >= i) {
          break;
        }
        arrayOfLong[paramInt] = a(arrayOfLong[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new nh("require field not exist.");
    }
    return paramArrayOfLong;
  }
  
  public final <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
  {
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0)) {
      throw new nh("unable to get type of key and value.");
    }
    return b(paramArrayOfT[0], paramInt, paramBoolean);
  }
  
  public final short[] a(short[] paramArrayOfShort, int paramInt, boolean paramBoolean)
  {
    paramArrayOfShort = null;
    if (a(paramInt))
    {
      paramArrayOfShort = new nk.a();
      a(paramArrayOfShort);
      switch (paramArrayOfShort.a)
      {
      default: 
        throw new nh("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new nh("size invalid: " + i);
      }
      short[] arrayOfShort = new short[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfShort = arrayOfShort;
        if (paramInt >= i) {
          break;
        }
        arrayOfShort[paramInt] = a(arrayOfShort[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new nh("require field not exist.");
    }
    return paramArrayOfShort;
  }
  
  public final boolean[] a(boolean[] paramArrayOfBoolean, int paramInt, boolean paramBoolean)
  {
    paramArrayOfBoolean = null;
    if (a(paramInt))
    {
      paramArrayOfBoolean = new nk.a();
      a(paramArrayOfBoolean);
      switch (paramArrayOfBoolean.a)
      {
      default: 
        throw new nh("type mismatch.");
      }
      int i = a(0, 0, true);
      if (i < 0) {
        throw new nh("size invalid: " + i);
      }
      boolean[] arrayOfBoolean = new boolean[i];
      paramInt = 0;
      for (;;)
      {
        paramArrayOfBoolean = arrayOfBoolean;
        if (paramInt >= i) {
          break;
        }
        arrayOfBoolean[paramInt] = a(arrayOfBoolean[0], 0, true);
        paramInt += 1;
      }
    }
    if (paramBoolean) {
      throw new nh("require field not exist.");
    }
    return paramArrayOfBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nk
 * JD-Core Version:    0.7.0.1
 */