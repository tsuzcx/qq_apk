package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class ej
{
  private final Map<Type, dm<?>> a;
  
  public ej(Map<Type, dm<?>> paramMap)
  {
    this.a = paramMap;
  }
  
  private <T> eo<T> a(Class<? super T> paramClass)
  {
    AppMethodBeat.i(147578);
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      if (!paramClass.isAccessible()) {
        paramClass.setAccessible(true);
      }
      paramClass = new ej.5(this, paramClass);
      AppMethodBeat.o(147578);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      AppMethodBeat.o(147578);
    }
    return null;
  }
  
  private <T> eo<T> a(Type paramType, Class<? super T> paramClass)
  {
    AppMethodBeat.i(147579);
    if (Collection.class.isAssignableFrom(paramClass))
    {
      if (SortedSet.class.isAssignableFrom(paramClass))
      {
        paramType = new ej.6(this);
        AppMethodBeat.o(147579);
        return paramType;
      }
      if (Set.class.isAssignableFrom(paramClass))
      {
        paramType = new ej.7(this);
        AppMethodBeat.o(147579);
        return paramType;
      }
      if (Queue.class.isAssignableFrom(paramClass))
      {
        paramType = new ej.8(this);
        AppMethodBeat.o(147579);
        return paramType;
      }
      paramType = new eo()
      {
        public T a()
        {
          AppMethodBeat.i(147576);
          ArrayList localArrayList = new ArrayList();
          AppMethodBeat.o(147576);
          return localArrayList;
        }
      };
      AppMethodBeat.o(147579);
      return paramType;
    }
    if (Map.class.isAssignableFrom(paramClass))
    {
      if (SortedMap.class.isAssignableFrom(paramClass))
      {
        paramType = new ej.10(this);
        AppMethodBeat.o(147579);
        return paramType;
      }
      if (((paramType instanceof ParameterizedType)) && (!String.class.isAssignableFrom(fe.a(((ParameterizedType)paramType).getActualTypeArguments()[0]).a())))
      {
        paramType = new ej.11(this);
        AppMethodBeat.o(147579);
        return paramType;
      }
      paramType = new ej.2(this);
      AppMethodBeat.o(147579);
      return paramType;
    }
    AppMethodBeat.o(147579);
    return null;
  }
  
  private <T> eo<T> b(Type paramType, Class<? super T> paramClass)
  {
    AppMethodBeat.i(147580);
    paramType = new ej.3(this, paramClass, paramType);
    AppMethodBeat.o(147580);
    return paramType;
  }
  
  public final <T> eo<T> a(fe<T> paramfe)
  {
    AppMethodBeat.i(147577);
    Type localType = paramfe.b();
    paramfe = paramfe.a();
    Object localObject = (dm)this.a.get(localType);
    if (localObject != null)
    {
      paramfe = new ej.1(this, (dm)localObject, localType);
      AppMethodBeat.o(147577);
      return paramfe;
    }
    localObject = (dm)this.a.get(paramfe);
    if (localObject != null)
    {
      paramfe = new ej.4(this, (dm)localObject, localType);
      AppMethodBeat.o(147577);
      return paramfe;
    }
    localObject = a(paramfe);
    if (localObject != null)
    {
      AppMethodBeat.o(147577);
      return localObject;
    }
    localObject = a(localType, paramfe);
    if (localObject != null)
    {
      AppMethodBeat.o(147577);
      return localObject;
    }
    paramfe = b(localType, paramfe);
    AppMethodBeat.o(147577);
    return paramfe;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(147581);
    String str = this.a.toString();
    AppMethodBeat.o(147581);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ej
 * JD-Core Version:    0.7.0.1
 */