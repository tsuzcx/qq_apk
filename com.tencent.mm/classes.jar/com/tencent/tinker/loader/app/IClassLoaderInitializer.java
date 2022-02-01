package com.tencent.tinker.loader.app;

import android.app.Application;
import androidx.annotation.Keep;

@Keep
public abstract interface IClassLoaderInitializer
{
  @Keep
  public abstract void initializeClassLoader(Application paramApplication, ClassLoader paramClassLoader);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.app.IClassLoaderInitializer
 * JD-Core Version:    0.7.0.1
 */