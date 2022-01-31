package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ez
  implements ec
{
  private final ej a;
  private final dj b;
  private final ek c;
  
  public ez(ej paramej, dj paramdj, ek paramek)
  {
    this.a = paramej;
    this.b = paramdj;
    this.c = paramek;
  }
  
  private b a(dk paramdk, Field paramField, String paramString, fe<?> paramfe, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(147724);
    paramdk = new ez.1(this, paramString, paramBoolean1, paramBoolean2, paramdk, paramfe, paramField, ep.a(paramfe.a()));
    AppMethodBeat.o(147724);
    return paramdk;
  }
  
  private String a(Field paramField)
  {
    AppMethodBeat.i(147722);
    ee localee = (ee)paramField.getAnnotation(ee.class);
    if (localee == null)
    {
      paramField = this.b.a(paramField);
      AppMethodBeat.o(147722);
      return paramField;
    }
    paramField = localee.a();
    AppMethodBeat.o(147722);
    return paramField;
  }
  
  private Map<String, b> a(dk paramdk, fe<?> paramfe, Class<?> paramClass)
  {
    AppMethodBeat.i(147725);
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface())
    {
      AppMethodBeat.o(147725);
      return localLinkedHashMap;
    }
    Type localType1 = paramfe.b();
    while (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfField[i];
        boolean bool1 = a((Field)localObject, true);
        boolean bool2 = a((Field)localObject, false);
        if ((bool1) || (bool2))
        {
          ((Field)localObject).setAccessible(true);
          Type localType2 = ei.a(paramfe.b(), paramClass, ((Field)localObject).getGenericType());
          localObject = a(paramdk, (Field)localObject, a((Field)localObject), fe.a(localType2), bool1, bool2);
          localObject = (b)localLinkedHashMap.put(((b)localObject).g, localObject);
          if (localObject != null)
          {
            paramdk = new IllegalArgumentException(localType1 + " declares multiple JSON fields named " + ((b)localObject).g);
            AppMethodBeat.o(147725);
            throw paramdk;
          }
        }
        i += 1;
      }
      paramfe = fe.a(ei.a(paramfe.b(), paramClass, paramClass.getGenericSuperclass()));
      paramClass = paramfe.a();
    }
    AppMethodBeat.o(147725);
    return localLinkedHashMap;
  }
  
  public final <T> eb<T> a(dk paramdk, fe<T> paramfe)
  {
    AppMethodBeat.i(147723);
    Class localClass = paramfe.a();
    if (!Object.class.isAssignableFrom(localClass))
    {
      AppMethodBeat.o(147723);
      return null;
    }
    paramdk = new ez.a(this, this.a.a(paramfe), a(paramdk, paramfe, localClass), null);
    AppMethodBeat.o(147723);
    return paramdk;
  }
  
  public final boolean a(Field paramField, boolean paramBoolean)
  {
    AppMethodBeat.i(147721);
    if ((!this.c.a(paramField.getType(), paramBoolean)) && (!this.c.a(paramField, paramBoolean)))
    {
      AppMethodBeat.o(147721);
      return true;
    }
    AppMethodBeat.o(147721);
    return false;
  }
  
  static abstract class b
  {
    final String g;
    final boolean h;
    final boolean i;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.g = paramString;
      this.h = paramBoolean1;
      this.i = paramBoolean2;
    }
    
    abstract void a(ff paramff, Object paramObject);
    
    abstract void a(fh paramfh, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ez
 * JD-Core Version:    0.7.0.1
 */