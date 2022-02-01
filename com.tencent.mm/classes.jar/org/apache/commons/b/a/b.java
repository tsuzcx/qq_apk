package org.apache.commons.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.b.e;
import org.apache.commons.b.h;

public abstract class b
  implements Serializable
{
  public static final b NUO = new a();
  public static final b NUP = new b();
  public static final b NUQ = new c();
  public static final b NUR = new d();
  public static final b NUS = new e();
  private static final ThreadLocal NUT = new ThreadLocal();
  boolean NUU = true;
  boolean NUV = true;
  boolean NUW = false;
  boolean NUX = true;
  private String NUY = "=";
  boolean NUZ = false;
  boolean NVa = false;
  String NVb = ",";
  private String NVc = "{";
  private String NVd = ",";
  private boolean NVe = true;
  private String NVf = "}";
  private boolean NVg = true;
  String NVh = "<null>";
  private String NVi = "<size=";
  private String NVj = ">";
  private String NVk = "<";
  private String NVl = ">";
  String xeA = "]";
  String xez = "[";
  
  private void a(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(this.NVi);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.NVj);
  }
  
  private void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((gu(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      e.a(paramStringBuffer, paramObject);
      return;
    }
    gv(paramObject);
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
        gw(paramObject);
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
    paramStringBuffer.append(this.NVc);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      if (localObject == null) {
        b(paramStringBuffer);
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramStringBuffer, paramString, localObject, this.NVe);
      }
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfChar[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfDouble[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfFloat[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfInt[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfLong[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfShort[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void a(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.NVc);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.NVd);
      }
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      i += 1;
    }
    paramStringBuffer.append(this.NVf);
  }
  
  private void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.NVh);
  }
  
  private void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    paramStringBuffer.append(this.NVk);
    paramStringBuffer.append(org.apache.commons.b.b.bE(paramObject.getClass()));
    paramStringBuffer.append(this.NVl);
  }
  
  private static boolean gu(Object paramObject)
  {
    Map localMap = gyh();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }
  
  static void gv(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = gyh();
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new WeakHashMap();
        NUT.set(localObject);
      }
      ((Map)localObject).put(paramObject, null);
    }
  }
  
  static void gw(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = gyh();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty()) {
          NUT.set(null);
        }
      }
    }
  }
  
  private static Map gyh()
  {
    return (Map)NUT.get();
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
      a(paramStringBuffer, null, paramObject, this.NVg);
    }
  }
  
  protected final void bdS(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.xeA = str;
  }
  
  final void c(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.NVb);
  }
  
  static final class a
    extends b
  {
    private Object readResolve()
    {
      return b.NUO;
    }
  }
  
  static final class b
    extends b
  {
    b()
    {
      AppMethodBeat.i(40698);
      this.xez = "[";
      String str2 = h.NHr + "  ";
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      this.NVb = str1;
      this.NUZ = true;
      bdS(h.NHr + "]");
      AppMethodBeat.o(40698);
    }
    
    private Object readResolve()
    {
      return b.NUP;
    }
  }
  
  static final class c
    extends b
  {
    c()
    {
      this.NUU = false;
    }
    
    private Object readResolve()
    {
      return b.NUQ;
    }
  }
  
  static final class d
    extends b
  {
    d()
    {
      this.NUW = true;
      this.NUX = false;
    }
    
    private Object readResolve()
    {
      return b.NUR;
    }
  }
  
  static final class e
    extends b
  {
    e()
    {
      AppMethodBeat.i(40699);
      this.NUV = false;
      this.NUX = false;
      this.NUU = false;
      this.xez = "";
      bdS("");
      AppMethodBeat.o(40699);
    }
    
    private Object readResolve()
    {
      return b.NUS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.a.b
 * JD-Core Version:    0.7.0.1
 */