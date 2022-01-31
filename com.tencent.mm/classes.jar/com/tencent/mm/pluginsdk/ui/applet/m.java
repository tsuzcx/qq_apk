package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.sdk.platformtools.bk;

public final class m
{
  public int backgroundColor;
  public Object data;
  public int end;
  public String fKV;
  public int linkColor;
  public int start;
  public int type;
  public String url;
  public String username;
  
  @Deprecated
  public m(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.url = null;
    this.type = 0;
    this.data = null;
  }
  
  public m(String paramString, int paramInt, Object paramObject)
  {
    this.url = paramString;
    this.data = paramObject;
    this.type = paramInt;
  }
  
  public final <T> T S(Class<T> paramClass)
  {
    if (paramClass.isInstance(this.data)) {
      return paramClass.cast(this.data);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof m)) {
      return hashCode() == ((m)paramObject).hashCode();
    }
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    int j = super.hashCode();
    int i = j;
    if (!bk.bl(this.url)) {
      i = j + this.url.hashCode();
    }
    j = i + this.type + this.end + this.start;
    i = j;
    if (this.data != null) {
      i = j + this.data.hashCode();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.m
 * JD-Core Version:    0.7.0.1
 */