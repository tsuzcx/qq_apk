package com.tencent.smtt.export.external;

import dalvik.system.DexClassLoader;

class DexLoader$TbsCorePrivateClassLoader
  extends DexClassLoader
{
  public DexLoader$TbsCorePrivateClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    Object localObject2;
    if ((paramString != null) && (paramString.startsWith("org.chromium")))
    {
      localObject2 = findLoadedClass(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    try
    {
      localObject1 = findClass(paramString);
      localObject2 = localObject1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label37:
      ClassLoader localClassLoader;
      break label37;
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localClassLoader = getParent();
      localObject1 = localObject2;
      if (localClassLoader != null) {
        localObject1 = localClassLoader.loadClass(paramString);
      }
    }
    return localObject1;
    return super.loadClass(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexLoader.TbsCorePrivateClassLoader
 * JD-Core Version:    0.7.0.1
 */