package com.tencent.shadow.core.b.a;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class e
  implements Serializable
{
  public String a;
  public String b;
  public a c;
  public a d;
  public Map<String, b> e = new HashMap();
  
  public a a(String paramString)
  {
    return (a)this.e.get(paramString);
  }
  
  public static class a
    implements Serializable
  {
    public final int a;
    public final File b;
    public File c;
    public File d;
    
    a(int paramInt, File paramFile1, File paramFile2, File paramFile3)
    {
      this.a = paramInt;
      this.c = paramFile2;
      this.d = paramFile3;
      this.b = paramFile1;
    }
  }
  
  public static class b
    extends e.a
  {
    public final String e;
    public final String[] f;
    public final String[] g;
    
    b(int paramInt, String paramString, File paramFile1, File paramFile2, File paramFile3, String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      super(paramFile1, paramFile2, paramFile3);
      this.e = paramString;
      this.f = paramArrayOfString1;
      this.g = paramArrayOfString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.e
 * JD-Core Version:    0.7.0.1
 */