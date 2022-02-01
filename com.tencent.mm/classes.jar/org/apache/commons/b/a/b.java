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
  public static final b UgR = new a();
  public static final b UgS = new b();
  public static final b UgT = new c();
  public static final b UgU = new d();
  public static final b UgV = new e();
  private static final ThreadLocal UgW = new ThreadLocal();
  String But = "[";
  String Buu = "]";
  boolean UgX = true;
  boolean UgY = true;
  boolean UgZ = false;
  boolean Uha = true;
  private String Uhb = "=";
  boolean Uhc = false;
  boolean Uhd = false;
  String Uhe = ",";
  private String Uhf = "{";
  private String Uhg = ",";
  private boolean Uhh = true;
  private String Uhi = "}";
  private boolean Uhj = true;
  String Uhk = "<null>";
  private String Uhl = "<size=";
  private String Uhm = ">";
  private String Uhn = "<";
  private String Uho = ">";
  
  private void a(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(this.Uhl);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.Uhm);
  }
  
  private void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((gC(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      e.a(paramStringBuffer, paramObject);
      return;
    }
    gD(paramObject);
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
        gE(paramObject);
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
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      if (localObject == null) {
        b(paramStringBuffer);
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramStringBuffer, paramString, localObject, this.Uhh);
      }
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfChar[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfDouble[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfFloat[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfInt[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfLong[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfShort[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void a(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.Uhf);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Uhg);
      }
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Uhi);
  }
  
  private void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.Uhk);
  }
  
  private void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    paramStringBuffer.append(this.Uhn);
    paramStringBuffer.append(org.apache.commons.b.b.bE(paramObject.getClass()));
    paramStringBuffer.append(this.Uho);
  }
  
  private static boolean gC(Object paramObject)
  {
    Map localMap = hPN();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }
  
  static void gD(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = hPN();
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new WeakHashMap();
        UgW.set(localObject);
      }
      ((Map)localObject).put(paramObject, null);
    }
  }
  
  static void gE(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = hPN();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty()) {
          UgW.set(null);
        }
      }
    }
  }
  
  private static Map hPN()
  {
    return (Map)UgW.get();
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
      a(paramStringBuffer, null, paramObject, this.Uhj);
    }
  }
  
  protected final void bvm(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.Buu = str;
  }
  
  final void c(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.Uhe);
  }
  
  static final class a
    extends b
  {
    private Object readResolve()
    {
      return b.UgR;
    }
  }
  
  static final class b
    extends b
  {
    b()
    {
      AppMethodBeat.i(40698);
      this.But = "[";
      String str2 = h.TTr + "  ";
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      this.Uhe = str1;
      this.Uhc = true;
      bvm(h.TTr + "]");
      AppMethodBeat.o(40698);
    }
    
    private Object readResolve()
    {
      return b.UgS;
    }
  }
  
  static final class c
    extends b
  {
    c()
    {
      this.UgX = false;
    }
    
    private Object readResolve()
    {
      return b.UgT;
    }
  }
  
  static final class d
    extends b
  {
    d()
    {
      this.UgZ = true;
      this.Uha = false;
    }
    
    private Object readResolve()
    {
      return b.UgU;
    }
  }
  
  static final class e
    extends b
  {
    e()
    {
      AppMethodBeat.i(40699);
      this.UgY = false;
      this.Uha = false;
      this.UgX = false;
      this.But = "";
      bvm("");
      AppMethodBeat.o(40699);
    }
    
    private Object readResolve()
    {
      return b.UgV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.apache.commons.b.a.b
 * JD-Core Version:    0.7.0.1
 */