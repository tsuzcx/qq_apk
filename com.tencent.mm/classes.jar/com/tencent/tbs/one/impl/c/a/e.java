package com.tencent.tbs.one.impl.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.BaseDexClassLoader;

public final class e
  extends BaseDexClassLoader
{
  private String a;
  
  public e(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, String paramString4) {}
  
  protected final Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(173828);
    if ((this.a == null) || (paramString == null) || (!paramString.startsWith(this.a)))
    {
      paramString = super.loadClass(paramString, paramBoolean);
      AppMethodBeat.o(173828);
      return paramString;
    }
    Object localObject2 = findLoadedClass(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      localObject1 = findClass(paramString);
      localObject2 = localObject1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label65:
      ClassLoader localClassLoader;
      break label65;
    }
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localClassLoader = getParent();
      localObject1 = localObject2;
      if (localClassLoader != null) {
        localObject1 = localClassLoader.loadClass(paramString);
      }
    }
    AppMethodBeat.o(173828);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.e
 * JD-Core Version:    0.7.0.1
 */