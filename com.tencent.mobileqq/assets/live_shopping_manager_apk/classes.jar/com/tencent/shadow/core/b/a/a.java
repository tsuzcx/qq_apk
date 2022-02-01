package com.tencent.shadow.core.b.a;

import java.io.File;

public class a
{
  private static File a(File paramFile)
  {
    return new File(paramFile, "oDex");
  }
  
  public static File a(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }
  
  public static File a(File paramFile, String paramString1, String paramString2)
  {
    return new File(a(paramFile, paramString1), paramString2);
  }
  
  private static File b(File paramFile)
  {
    return new File(paramFile, "lib");
  }
  
  public static File b(File paramFile, String paramString)
  {
    paramFile = a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_odex");
    return new File(paramFile, localStringBuilder.toString());
  }
  
  public static File c(File paramFile, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_oDexed");
    return new File(paramFile, localStringBuilder.toString());
  }
  
  public static File d(File paramFile, String paramString)
  {
    paramFile = b(paramFile);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_lib");
    return new File(paramFile, localStringBuilder.toString());
  }
  
  public static File e(File paramFile, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_copied");
    return new File(paramFile, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.a
 * JD-Core Version:    0.7.0.1
 */