package org.apache.commons.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.c.e;
import org.apache.commons.c.j;

public abstract class b
  implements Serializable
{
  public static final b ajXb = new a();
  public static final b ajXc = new b();
  public static final b ajXd = new c();
  public static final b ajXe = new d();
  public static final b ajXf = new e();
  private static final ThreadLocal ajXg = new ThreadLocal();
  String NmA = "[";
  String NmB = "]";
  private boolean ajXh = true;
  boolean ajXi = true;
  boolean ajXj = false;
  boolean ajXk = true;
  private String ajXl = "=";
  boolean ajXm = false;
  boolean ajXn = false;
  String ajXo = ",";
  private String ajXp = "{";
  private String ajXq = ",";
  private boolean ajXr = true;
  private String ajXs = "}";
  private boolean ajXt = true;
  String ajXu = "<null>";
  private String ajXv = "<size=";
  private String ajXw = ">";
  private String ajXx = "<";
  private String ajXy = ">";
  
  private void a(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(this.ajXv);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.ajXw);
  }
  
  private void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((jL(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      e.a(paramStringBuffer, paramObject);
      return;
    }
    jM(paramObject);
    for (;;)
    {
      try
      {
        if ((paramObject instanceof Collection))
        {
          if (paramBoolean)
          {
            paramStringBuffer.append((Collection)paramObject);
            return;
          }
          a(paramStringBuffer, ((Collection)paramObject).size());
          continue;
        }
        if (!(paramObject instanceof Map)) {
          break label129;
        }
      }
      finally
      {
        jN(paramObject);
      }
      if (paramBoolean)
      {
        paramStringBuffer.append((Map)paramObject);
      }
      else
      {
        a(paramStringBuffer, ((Map)paramObject).size());
        continue;
        label129:
        if ((paramObject instanceof long[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (long[])paramObject);
          } else {
            a(paramStringBuffer, ((long[])paramObject).length);
          }
        }
        else if ((paramObject instanceof int[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (int[])paramObject);
          } else {
            a(paramStringBuffer, ((int[])paramObject).length);
          }
        }
        else if ((paramObject instanceof short[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (short[])paramObject);
          } else {
            a(paramStringBuffer, ((short[])paramObject).length);
          }
        }
        else if ((paramObject instanceof byte[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (byte[])paramObject);
          } else {
            a(paramStringBuffer, ((byte[])paramObject).length);
          }
        }
        else if ((paramObject instanceof char[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (char[])paramObject);
          } else {
            a(paramStringBuffer, ((char[])paramObject).length);
          }
        }
        else if ((paramObject instanceof double[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (double[])paramObject);
          } else {
            a(paramStringBuffer, ((double[])paramObject).length);
          }
        }
        else if ((paramObject instanceof float[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (float[])paramObject);
          } else {
            a(paramStringBuffer, ((float[])paramObject).length);
          }
        }
        else if ((paramObject instanceof boolean[]))
        {
          if (paramBoolean) {
            a(paramStringBuffer, (boolean[])paramObject);
          } else {
            a(paramStringBuffer, ((boolean[])paramObject).length);
          }
        }
        else if (paramObject.getClass().isArray())
        {
          if (paramBoolean) {
            a(paramStringBuffer, paramString, (Object[])paramObject);
          } else {
            a(paramStringBuffer, ((Object[])paramObject).length);
          }
        }
        else if (paramBoolean) {
          paramStringBuffer.append(paramObject);
        } else {
          c(paramStringBuffer, paramObject);
        }
      }
    }
  }
  
  private void a(StringBuffer paramStringBuffer, String paramString, Object[] paramArrayOfObject)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      if (localObject == null) {
        b(paramStringBuffer);
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramStringBuffer, paramString, localObject, this.ajXr);
      }
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfChar[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfDouble[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfFloat[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfInt[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfLong[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfShort[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void a(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.ajXp);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.ajXq);
      }
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      i += 1;
    }
    paramStringBuffer.append(this.ajXs);
  }
  
  private void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.ajXu);
  }
  
  private void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    paramStringBuffer.append(this.ajXx);
    paramStringBuffer.append(org.apache.commons.c.b.cP(paramObject.getClass()));
    paramStringBuffer.append(this.ajXy);
  }
  
  private static boolean jL(Object paramObject)
  {
    Map localMap = kJt();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }
  
  static void jM(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = kJt();
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new WeakHashMap();
        ajXg.set(localObject);
      }
      ((Map)localObject).put(paramObject, null);
    }
  }
  
  static void jN(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = kJt();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty()) {
          ajXg.set(null);
        }
      }
    }
  }
  
  private static Map kJt()
  {
    return (Map)ajXg.get();
  }
  
  public final void b(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject == null) {
      b(paramStringBuffer);
    }
    for (;;)
    {
      c(paramStringBuffer);
      return;
      a(paramStringBuffer, null, paramObject, this.ajXt);
    }
  }
  
  protected final void bLm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.NmB = str;
  }
  
  final void c(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.ajXo);
  }
  
  protected final void kJu()
  {
    this.ajXh = false;
  }
  
  static final class a
    extends b
  {}
  
  static final class b
    extends b
  {
    b()
    {
      AppMethodBeat.i(40698);
      this.NmA = "[";
      String str2 = j.ajUO + "  ";
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      this.ajXo = str1;
      this.ajXm = true;
      bLm(j.ajUO + "]");
      AppMethodBeat.o(40698);
    }
  }
  
  static final class c
    extends b
  {
    c()
    {
      AppMethodBeat.i(187221);
      kJu();
      AppMethodBeat.o(187221);
    }
  }
  
  static final class d
    extends b
  {
    d()
    {
      AppMethodBeat.i(187219);
      this.ajXj = true;
      this.ajXk = false;
      AppMethodBeat.o(187219);
    }
  }
  
  static final class e
    extends b
  {
    e()
    {
      AppMethodBeat.i(40699);
      this.ajXi = false;
      this.ajXk = false;
      kJu();
      this.NmA = "";
      bLm("");
      AppMethodBeat.o(40699);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.apache.commons.c.a.b
 * JD-Core Version:    0.7.0.1
 */