package com.tencent.tinker.loader;

import dalvik.system.PathClassLoader;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;

public final class TinkerClassLoader
  extends PathClassLoader
{
  private final ClassLoader mOriginAppClassLoader;
  
  TinkerClassLoader(String paramString1, File paramFile, String paramString2, ClassLoader paramClassLoader)
  {
    super("", paramString2, ClassLoader.getSystemClassLoader());
    this.mOriginAppClassLoader = paramClassLoader;
    injectDexPath(this, paramString1, paramFile);
  }
  
  private static void injectDexPath(ClassLoader paramClassLoader, String paramString, File paramFile)
  {
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList = new ArrayList(16);
        paramString = paramString.split(":");
        int j = paramString.length;
        i = 0;
        if (i < j)
        {
          String str = paramString[i];
          if (!str.isEmpty()) {
            localArrayList.add(new File(str));
          }
        }
        else
        {
          if (!localArrayList.isEmpty()) {
            SystemClassLoaderAdder.injectDexesInternal(paramClassLoader, localArrayList, paramFile);
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  protected final Class<?> findClass(String paramString)
  {
    try
    {
      Class localClass = super.findClass(paramString);
      if (localClass != null) {
        return localClass;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
    return this.mOriginAppClassLoader.loadClass(paramString);
  }
  
  public final URL getResource(String paramString)
  {
    Object localObject = Object.class.getClassLoader().getResource(paramString);
    if (localObject != null) {}
    URL localURL;
    do
    {
      return localObject;
      localURL = findResource(paramString);
      localObject = localURL;
    } while (localURL != null);
    return this.mOriginAppClassLoader.getResource(paramString);
  }
  
  public final Enumeration<URL> getResources(String paramString)
  {
    return new CompoundEnumeration((Enumeration[])new Enumeration[] { Object.class.getClassLoader().getResources(paramString), findResources(paramString), this.mOriginAppClassLoader.getResources(paramString) });
  }
  
  class CompoundEnumeration<E>
    implements Enumeration<E>
  {
    private Enumeration<E>[] enums;
    private int index = 0;
    
    public CompoundEnumeration()
    {
      Object localObject;
      this.enums = localObject;
    }
    
    public boolean hasMoreElements()
    {
      while (this.index < this.enums.length)
      {
        if ((this.enums[this.index] != null) && (this.enums[this.index].hasMoreElements())) {
          return true;
        }
        this.index += 1;
      }
      return false;
    }
    
    public E nextElement()
    {
      if (!hasMoreElements()) {
        throw new NoSuchElementException();
      }
      return this.enums[this.index].nextElement();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.TinkerClassLoader
 * JD-Core Version:    0.7.0.1
 */