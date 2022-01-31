package com.tencent.tencentmap.mapsdk.a;

import java.util.List;

public final class py
{
  private String a;
  private String b;
  private int c;
  private List<qa> d;
  
  public py(String paramString1, String paramString2, List<qa> paramList, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramList;
    this.c = paramInt;
  }
  
  public final String a()
  {
    return this.a;
  }
  
  public final String b()
  {
    return this.b;
  }
  
  public final List<qa> c()
  {
    return this.d;
  }
  
  public final int d()
  {
    return this.c;
  }
  
  public final String toString()
  {
    if ((this.a == null) || (this.d == null) || (this.d.size() <= this.c)) {
      return null;
    }
    return this.a + "_" + ((qa)this.d.get(this.c)).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.py
 * JD-Core Version:    0.7.0.1
 */