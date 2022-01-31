package com.tencent.mm.z.b;

import org.json.JSONObject;

public abstract class c
  implements e
{
  private int index;
  public String name;
  
  public c(String paramString)
  {
    this.name = paramString;
  }
  
  public c(String paramString, int paramInt)
  {
    this.name = paramString;
    this.index = paramInt;
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public abstract JSONObject toJSONObject();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.z.b.c
 * JD-Core Version:    0.7.0.1
 */