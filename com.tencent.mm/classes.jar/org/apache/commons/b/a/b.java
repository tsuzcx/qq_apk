package org.apache.commons.b.a;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.b.e;

public abstract class b
  implements Serializable
{
  public static final b CQN = new b.a();
  public static final b CQO = new b.b();
  public static final b CQP = new b.c();
  public static final b CQQ = new d();
  public static final b CQR = new b.e();
  private static final ThreadLocal CQS = new ThreadLocal();
  boolean CQT = true;
  boolean CQU = true;
  boolean CQV = false;
  boolean CQW = true;
  private String CQX = "=";
  boolean CQY = false;
  boolean CQZ = false;
  String CRa = ",";
  private String CRb = "{";
  private String CRc = ",";
  private boolean CRd = true;
  private String CRe = "}";
  private boolean CRf = true;
  String CRg = "<null>";
  private String CRh = "<size=";
  private String CRi = ">";
  private String CRj = "<";
  private String CRk = ">";
  String pLF = "[";
  String pLG = "]";
  
  private void a(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.CRg);
  }
  
  private void a(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(this.CRh);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.CRi);
  }
  
  private void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((el(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      e.a(paramStringBuffer, paramObject);
      return;
    }
    em(paramObject);
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
        en(paramObject);
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
    paramStringBuffer.append(this.CRb);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      if (localObject == null) {
        a(paramStringBuffer);
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramStringBuffer, paramString, localObject, this.CRd);
      }
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfChar[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfDouble[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfFloat[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfInt[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfLong[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfShort[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void a(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.CRb);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.CRc);
      }
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      i += 1;
    }
    paramStringBuffer.append(this.CRe);
  }
  
  private void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    paramStringBuffer.append(this.CRj);
    paramStringBuffer.append(org.apache.commons.b.b.aX(paramObject.getClass()));
    paramStringBuffer.append(this.CRk);
  }
  
  private static boolean el(Object paramObject)
  {
    Map localMap = err();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }
  
  static void em(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = err();
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new WeakHashMap();
        CQS.set(localObject);
      }
      ((Map)localObject).put(paramObject, null);
    }
  }
  
  static void en(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = err();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty()) {
          CQS.set(null);
        }
      }
    }
  }
  
  private static Map err()
  {
    return (Map)CQS.get();
  }
  
  protected final void azN(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.pLG = str;
  }
  
  final void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.CRa);
  }
  
  public final void b(StringBuffer paramStringBuffer, Object paramObject)
  {
    if (paramObject == null) {
      a(paramStringBuffer);
    }
    for (;;)
    {
      b(paramStringBuffer);
      return;
      a(paramStringBuffer, null, paramObject, this.CRf);
    }
  }
  
  static final class d
    extends b
  {
    d()
    {
      this.CQV = true;
      this.CQW = false;
    }
    
    private Object readResolve()
    {
      return b.CQQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.a.b
 * JD-Core Version:    0.7.0.1
 */