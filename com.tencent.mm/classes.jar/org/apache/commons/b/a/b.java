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
  public static final b Mao = new a();
  public static final b Map = new b();
  public static final b Maq = new c();
  public static final b Mar = new d();
  public static final b Mas = new e();
  private static final ThreadLocal Mat = new ThreadLocal();
  boolean MaA = false;
  String MaB = ",";
  private String MaC = "{";
  private String MaD = ",";
  private boolean MaE = true;
  private String MaF = "}";
  private boolean MaG = true;
  String MaH = "<null>";
  private String MaI = "<size=";
  private String MaJ = ">";
  private String MaK = "<";
  private String MaL = ">";
  boolean Mau = true;
  boolean Mav = true;
  boolean Maw = false;
  boolean Max = true;
  private String May = "=";
  boolean Maz = false;
  String vWI = "[";
  String vWJ = "]";
  
  private void a(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(this.MaI);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.MaJ);
  }
  
  private void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((fY(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      e.a(paramStringBuffer, paramObject);
      return;
    }
    fZ(paramObject);
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
        ga(paramObject);
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
    paramStringBuffer.append(this.MaC);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      if (localObject == null) {
        b(paramStringBuffer);
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramStringBuffer, paramString, localObject, this.MaE);
      }
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfChar[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfDouble[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfFloat[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfInt[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfLong[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfShort[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void a(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.MaC);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.MaD);
      }
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      i += 1;
    }
    paramStringBuffer.append(this.MaF);
  }
  
  private void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.MaH);
  }
  
  private void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    paramStringBuffer.append(this.MaK);
    paramStringBuffer.append(org.apache.commons.b.b.bC(paramObject.getClass()));
    paramStringBuffer.append(this.MaL);
  }
  
  private static boolean fY(Object paramObject)
  {
    Map localMap = gfJ();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }
  
  static void fZ(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = gfJ();
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new WeakHashMap();
        Mat.set(localObject);
      }
      ((Map)localObject).put(paramObject, null);
    }
  }
  
  static void ga(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = gfJ();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty()) {
          Mat.set(null);
        }
      }
    }
  }
  
  private static Map gfJ()
  {
    return (Map)Mat.get();
  }
  
  protected final void aXy(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.vWJ = str;
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
      a(paramStringBuffer, null, paramObject, this.MaG);
    }
  }
  
  final void c(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.MaB);
  }
  
  static final class a
    extends b
  {
    private Object readResolve()
    {
      return b.Mao;
    }
  }
  
  static final class b
    extends b
  {
    b()
    {
      AppMethodBeat.i(40698);
      this.vWI = "[";
      String str2 = h.LQw + "  ";
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      this.MaB = str1;
      this.Maz = true;
      aXy(h.LQw + "]");
      AppMethodBeat.o(40698);
    }
    
    private Object readResolve()
    {
      return b.Map;
    }
  }
  
  static final class c
    extends b
  {
    c()
    {
      this.Mau = false;
    }
    
    private Object readResolve()
    {
      return b.Maq;
    }
  }
  
  static final class d
    extends b
  {
    d()
    {
      this.Maw = true;
      this.Max = false;
    }
    
    private Object readResolve()
    {
      return b.Mar;
    }
  }
  
  static final class e
    extends b
  {
    e()
    {
      AppMethodBeat.i(40699);
      this.Mav = false;
      this.Max = false;
      this.Mau = false;
      this.vWI = "";
      aXy("");
      AppMethodBeat.o(40699);
    }
    
    private Object readResolve()
    {
      return b.Mas;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     org.apache.commons.b.a.b
 * JD-Core Version:    0.7.0.1
 */