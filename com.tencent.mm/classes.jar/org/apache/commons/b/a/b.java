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
  public static final b OrT = new a();
  public static final b OrU = new b();
  public static final b OrV = new c();
  public static final b OrW = new d();
  public static final b OrX = new e();
  private static final ThreadLocal OrY = new ThreadLocal();
  boolean OrZ = true;
  boolean Osa = true;
  boolean Osb = false;
  boolean Osc = true;
  private String Osd = "=";
  boolean Ose = false;
  boolean Osf = false;
  String Osg = ",";
  private String Osh = "{";
  private String Osi = ",";
  private boolean Osj = true;
  private String Osk = "}";
  private boolean Osl = true;
  String Osm = "<null>";
  private String Osn = "<size=";
  private String Oso = ">";
  private String Osp = "<";
  private String Osq = ">";
  String xuq = "[";
  String xur = "]";
  
  private void a(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append(this.Osn);
    paramStringBuffer.append(paramInt);
    paramStringBuffer.append(this.Oso);
  }
  
  private void a(StringBuffer paramStringBuffer, String paramString, Object paramObject, boolean paramBoolean)
  {
    if ((gx(paramObject)) && (!(paramObject instanceof Number)) && (!(paramObject instanceof Boolean)) && (!(paramObject instanceof Character)))
    {
      e.a(paramStringBuffer, paramObject);
      return;
    }
    gy(paramObject);
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
        gz(paramObject);
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
    paramStringBuffer.append(this.Osh);
    int i = 0;
    if (i < paramArrayOfObject.length)
    {
      Object localObject = paramArrayOfObject[i];
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      if (localObject == null) {
        b(paramStringBuffer);
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramStringBuffer, paramString, localObject, this.Osj);
      }
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, char[] paramArrayOfChar)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfChar[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, double[] paramArrayOfDouble)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfDouble[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, float[] paramArrayOfFloat)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfFloat[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, int[] paramArrayOfInt)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfInt[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, long[] paramArrayOfLong)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfLong[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, short[] paramArrayOfShort)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfShort[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void a(StringBuffer paramStringBuffer, boolean[] paramArrayOfBoolean)
  {
    paramStringBuffer.append(this.Osh);
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      if (i > 0) {
        paramStringBuffer.append(this.Osi);
      }
      paramStringBuffer.append(paramArrayOfBoolean[i]);
      i += 1;
    }
    paramStringBuffer.append(this.Osk);
  }
  
  private void b(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.Osm);
  }
  
  private void c(StringBuffer paramStringBuffer, Object paramObject)
  {
    paramStringBuffer.append(this.Osp);
    paramStringBuffer.append(org.apache.commons.b.b.bE(paramObject.getClass()));
    paramStringBuffer.append(this.Osq);
  }
  
  private static Map gCJ()
  {
    return (Map)OrY.get();
  }
  
  private static boolean gx(Object paramObject)
  {
    Map localMap = gCJ();
    return (localMap != null) && (localMap.containsKey(paramObject));
  }
  
  static void gy(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = gCJ();
      Object localObject = localMap;
      if (localMap == null)
      {
        localObject = new WeakHashMap();
        OrY.set(localObject);
      }
      ((Map)localObject).put(paramObject, null);
    }
  }
  
  static void gz(Object paramObject)
  {
    if (paramObject != null)
    {
      Map localMap = gCJ();
      if (localMap != null)
      {
        localMap.remove(paramObject);
        if (localMap.isEmpty()) {
          OrY.set(null);
        }
      }
    }
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
      a(paramStringBuffer, null, paramObject, this.Osl);
    }
  }
  
  protected final void bfw(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.xur = str;
  }
  
  final void c(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.Osg);
  }
  
  static final class a
    extends b
  {
    private Object readResolve()
    {
      return b.OrT;
    }
  }
  
  static final class b
    extends b
  {
    b()
    {
      AppMethodBeat.i(40698);
      this.xuq = "[";
      String str2 = h.Oex + "  ";
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      this.Osg = str1;
      this.Ose = true;
      bfw(h.Oex + "]");
      AppMethodBeat.o(40698);
    }
    
    private Object readResolve()
    {
      return b.OrU;
    }
  }
  
  static final class c
    extends b
  {
    c()
    {
      this.OrZ = false;
    }
    
    private Object readResolve()
    {
      return b.OrV;
    }
  }
  
  static final class d
    extends b
  {
    d()
    {
      this.Osb = true;
      this.Osc = false;
    }
    
    private Object readResolve()
    {
      return b.OrW;
    }
  }
  
  static final class e
    extends b
  {
    e()
    {
      AppMethodBeat.i(40699);
      this.Osa = false;
      this.Osc = false;
      this.OrZ = false;
      this.xuq = "";
      bfw("");
      AppMethodBeat.o(40699);
    }
    
    private Object readResolve()
    {
      return b.OrX;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     org.apache.commons.b.a.b
 * JD-Core Version:    0.7.0.1
 */