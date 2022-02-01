package com.tencent.skyline.jni;

public abstract interface ISkylineLibraryLoader
{
  public abstract boolean afterLoad();
  
  public abstract boolean beforeLoad();
  
  public abstract boolean load(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.skyline.jni.ISkylineLibraryLoader
 * JD-Core Version:    0.7.0.1
 */