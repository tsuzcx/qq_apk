package com.tencent.shadow.a.a.a;

import java.util.HashMap;

public class b
{
  private static b a;
  private HashMap<Integer, a> b = null;
  
  public static b a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new b();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(int paramInt)
  {
    a locala2 = (a)this.b.get(Integer.valueOf(paramInt));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramInt);
      this.b.put(Integer.valueOf(paramInt), locala1);
    }
    locala1.a();
  }
  
  public a b(int paramInt)
  {
    a locala2 = (a)this.b.get(Integer.valueOf(paramInt));
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramInt);
      locala1.a();
      this.b.put(Integer.valueOf(paramInt), locala1);
    }
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */