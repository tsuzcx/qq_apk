package com.tencent.tencentmap.mapsdk.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ni
{
  private StringBuilder a;
  private int b = 0;
  
  public ni(StringBuilder paramStringBuilder, int paramInt)
  {
    this.a = paramStringBuilder;
    this.b = paramInt;
  }
  
  private void a(String paramString)
  {
    int i = 0;
    while (i < this.b)
    {
      this.a.append('\t');
      i += 1;
    }
    if (paramString != null) {
      this.a.append(paramString).append(": ");
    }
  }
  
  public final ni a(byte paramByte, String paramString)
  {
    a(paramString);
    this.a.append(paramByte).append('\n');
    return this;
  }
  
  public final ni a(byte paramByte, boolean paramBoolean)
  {
    this.a.append(paramByte);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final ni a(char paramChar, String paramString)
  {
    a(paramString);
    this.a.append(paramChar).append('\n');
    return this;
  }
  
  public final ni a(double paramDouble, String paramString)
  {
    a(paramString);
    this.a.append(paramDouble).append('\n');
    return this;
  }
  
  public final ni a(double paramDouble, boolean paramBoolean)
  {
    this.a.append(paramDouble);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final ni a(float paramFloat, String paramString)
  {
    a(paramString);
    this.a.append(paramFloat).append('\n');
    return this;
  }
  
  public final ni a(float paramFloat, boolean paramBoolean)
  {
    this.a.append(paramFloat);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final ni a(int paramInt, String paramString)
  {
    a(paramString);
    this.a.append(paramInt).append('\n');
    return this;
  }
  
  public final ni a(int paramInt, boolean paramBoolean)
  {
    this.a.append(paramInt);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final ni a(long paramLong, String paramString)
  {
    a(paramString);
    this.a.append(paramLong).append('\n');
    return this;
  }
  
  public final ni a(long paramLong, boolean paramBoolean)
  {
    this.a.append(paramLong);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final ni a(nm paramnm, String paramString)
  {
    a('{', paramString);
    if (paramnm == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      a('}', null);
      return this;
      paramnm.display(this.a, this.b + 1);
    }
  }
  
  public final ni a(nm paramnm, boolean paramBoolean)
  {
    this.a.append("{");
    if (paramnm == null) {
      this.a.append('\t').append("null");
    }
    for (;;)
    {
      this.a.append("}");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
      paramnm.displaySimple(this.a, this.b + 1);
    }
  }
  
  public final <T> ni a(T paramT, String paramString)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramString);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramString);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramString);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramString);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramString);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramString);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramString);
      return this;
    }
    if ((paramT instanceof String))
    {
      a((String)paramT, paramString);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramString);
      return this;
    }
    if ((paramT instanceof List))
    {
      a((List)paramT, paramString);
      return this;
    }
    if ((paramT instanceof nm))
    {
      a((nm)paramT, paramString);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      a((short[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramString);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramString);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramString);
      return this;
    }
    throw new nj("write object error: unsupport type.");
  }
  
  public final <T> ni a(T paramT, boolean paramBoolean)
  {
    if (paramT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if ((paramT instanceof Byte))
    {
      a(((Byte)paramT).byteValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Boolean))
    {
      a(((Boolean)paramT).booleanValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Short))
    {
      a(((Short)paramT).shortValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Integer))
    {
      a(((Integer)paramT).intValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Long))
    {
      a(((Long)paramT).longValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Float))
    {
      a(((Float)paramT).floatValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof Double))
    {
      a(((Double)paramT).doubleValue(), paramBoolean);
      return this;
    }
    if ((paramT instanceof String))
    {
      a((String)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof Map))
    {
      a((Map)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof List))
    {
      a((List)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof nm))
    {
      a((nm)paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof byte[]))
    {
      a((byte[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof boolean[]))
    {
      a((boolean[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof short[]))
    {
      a((short[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof int[]))
    {
      a((int[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof long[]))
    {
      a((long[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof float[]))
    {
      a((float[])paramT, paramBoolean);
      return this;
    }
    if ((paramT instanceof double[]))
    {
      a((double[])paramT, paramBoolean);
      return this;
    }
    if (paramT.getClass().isArray())
    {
      a((Object[])paramT, paramBoolean);
      return this;
    }
    throw new nj("write object error: unsupport type.");
  }
  
  public final ni a(String paramString1, String paramString2)
  {
    a(paramString2);
    if (paramString1 == null)
    {
      this.a.append("null\n");
      return this;
    }
    this.a.append(paramString1).append('\n');
    return this;
  }
  
  public final ni a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      this.a.append("null");
    }
    for (;;)
    {
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
      this.a.append(paramString);
    }
  }
  
  public final <T> ni a(Collection<T> paramCollection, String paramString)
  {
    if (paramCollection == null)
    {
      a(paramString);
      this.a.append("null\t");
      return this;
    }
    return a(paramCollection.toArray(), paramString);
  }
  
  public final <T> ni a(Collection<T> paramCollection, boolean paramBoolean)
  {
    if (paramCollection == null)
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
      return this;
    }
    return a(paramCollection.toArray(), paramBoolean);
  }
  
  public final <K, V> ni a(Map<K, V> paramMap, String paramString)
  {
    a(paramString);
    if (paramMap == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramMap.isEmpty())
    {
      this.a.append(paramMap.size()).append(", {}\n");
      return this;
    }
    this.a.append(paramMap.size()).append(", {\n");
    paramString = new ni(this.a, this.b + 1);
    ni localni = new ni(this.a, this.b + 2);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramString.a('(', null);
      localni.a(localEntry.getKey(), null);
      localni.a(localEntry.getValue(), null);
      paramString.a(')', null);
    }
    a('}', null);
    return this;
  }
  
  public final <K, V> ni a(Map<K, V> paramMap, boolean paramBoolean)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      this.a.append("{}");
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append("{");
      ni localni = new ni(this.a, this.b + 2);
      paramMap = paramMap.entrySet().iterator();
      for (int i = 1; paramMap.hasNext(); i = 0)
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (i == 0) {
          this.a.append(",");
        }
        localni.a(localEntry.getKey(), true);
        localni.a(localEntry.getValue(), false);
      }
      this.a.append("}");
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
  
  public final ni a(short paramShort, String paramString)
  {
    a(paramString);
    this.a.append(paramShort).append('\n');
    return this;
  }
  
  public final ni a(short paramShort, boolean paramBoolean)
  {
    this.a.append(paramShort);
    if (paramBoolean) {
      this.a.append("|");
    }
    return this;
  }
  
  public final ni a(boolean paramBoolean, String paramString)
  {
    a(paramString);
    paramString = this.a;
    if (paramBoolean) {}
    for (char c = 'T';; c = 'F')
    {
      paramString.append(c).append('\n');
      return this;
    }
  }
  
  public final ni a(boolean paramBoolean1, boolean paramBoolean2)
  {
    StringBuilder localStringBuilder = this.a;
    if (paramBoolean1) {}
    for (char c = 'T';; c = 'F')
    {
      localStringBuilder.append(c);
      if (paramBoolean2) {
        this.a.append("|");
      }
      return this;
    }
  }
  
  public final ni a(byte[] paramArrayOfByte, String paramString)
  {
    a(paramString);
    if (paramArrayOfByte == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfByte.length == 0)
    {
      this.a.append(paramArrayOfByte.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfByte.length).append(", [\n");
    paramString = new ni(this.a, this.b + 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfByte[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final ni a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append(ng.a(paramArrayOfByte));
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
  
  public final ni a(double[] paramArrayOfDouble, String paramString)
  {
    a(paramString);
    if (paramArrayOfDouble == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfDouble.length == 0)
    {
      this.a.append(paramArrayOfDouble.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfDouble.length).append(", [\n");
    paramString = new ni(this.a, this.b + 1);
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfDouble[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final ni a(double[] paramArrayOfDouble, boolean paramBoolean)
  {
    if ((paramArrayOfDouble == null) || (paramArrayOfDouble.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append("[");
      ni localni = new ni(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfDouble.length)
      {
        double d = paramArrayOfDouble[i];
        if (i != 0) {
          this.a.append("|");
        }
        localni.a(d, false);
        i += 1;
      }
      this.a.append("[");
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
  
  public final ni a(float[] paramArrayOfFloat, String paramString)
  {
    a(paramString);
    if (paramArrayOfFloat == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfFloat.length == 0)
    {
      this.a.append(paramArrayOfFloat.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfFloat.length).append(", [\n");
    paramString = new ni(this.a, this.b + 1);
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfFloat[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final ni a(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append("[");
      ni localni = new ni(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfFloat.length)
      {
        float f = paramArrayOfFloat[i];
        if (i != 0) {
          this.a.append("|");
        }
        localni.a(f, false);
        i += 1;
      }
      this.a.append("]");
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
  
  public final ni a(int[] paramArrayOfInt, String paramString)
  {
    a(paramString);
    if (paramArrayOfInt == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfInt.length == 0)
    {
      this.a.append(paramArrayOfInt.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfInt.length).append(", [\n");
    paramString = new ni(this.a, this.b + 1);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfInt[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final ni a(int[] paramArrayOfInt, boolean paramBoolean)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append("[");
      ni localni = new ni(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        int j = paramArrayOfInt[i];
        if (i != 0) {
          this.a.append("|");
        }
        localni.a(j, false);
        i += 1;
      }
      this.a.append("]");
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
  
  public final ni a(long[] paramArrayOfLong, String paramString)
  {
    a(paramString);
    if (paramArrayOfLong == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfLong.length == 0)
    {
      this.a.append(paramArrayOfLong.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfLong.length).append(", [\n");
    paramString = new ni(this.a, this.b + 1);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfLong[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final ni a(long[] paramArrayOfLong, boolean paramBoolean)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append("[");
      ni localni = new ni(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        long l = paramArrayOfLong[i];
        if (i != 0) {
          this.a.append("|");
        }
        localni.a(l, false);
        i += 1;
      }
      this.a.append("]");
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
  
  public final <T> ni a(T[] paramArrayOfT, String paramString)
  {
    a(paramString);
    if (paramArrayOfT == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfT.length == 0)
    {
      this.a.append(paramArrayOfT.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfT.length).append(", [\n");
    paramString = new ni(this.a, this.b + 1);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfT[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final <T> ni a(T[] paramArrayOfT, boolean paramBoolean)
  {
    if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append("[");
      ni localni = new ni(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfT.length)
      {
        T ? = paramArrayOfT[i];
        if (i != 0) {
          this.a.append("|");
        }
        localni.a(?, false);
        i += 1;
      }
      this.a.append("]");
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
  
  public final ni a(short[] paramArrayOfShort, String paramString)
  {
    a(paramString);
    if (paramArrayOfShort == null)
    {
      this.a.append("null\n");
      return this;
    }
    if (paramArrayOfShort.length == 0)
    {
      this.a.append(paramArrayOfShort.length).append(", []\n");
      return this;
    }
    this.a.append(paramArrayOfShort.length).append(", [\n");
    paramString = new ni(this.a, this.b + 1);
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramString.a(paramArrayOfShort[i], null);
      i += 1;
    }
    a(']', null);
    return this;
  }
  
  public final ni a(short[] paramArrayOfShort, boolean paramBoolean)
  {
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0))
    {
      this.a.append("[]");
      if (paramBoolean) {
        this.a.append("|");
      }
    }
    do
    {
      return this;
      this.a.append("[");
      ni localni = new ni(this.a, this.b + 1);
      int i = 0;
      while (i < paramArrayOfShort.length)
      {
        short s = paramArrayOfShort[i];
        if (i != 0) {
          this.a.append("|");
        }
        localni.a(s, false);
        i += 1;
      }
      this.a.append("]");
    } while (!paramBoolean);
    this.a.append("|");
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ni
 * JD-Core Version:    0.7.0.1
 */