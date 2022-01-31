package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class m
{
  public int backgroundColor;
  public Object data;
  public int end;
  public int linkColor;
  public String mSessionId;
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
  
  public final <T> T ap(Class<T> paramClass)
  {
    AppMethodBeat.i(79785);
    if (paramClass.isInstance(this.data))
    {
      paramClass = paramClass.cast(this.data);
      AppMethodBeat.o(79785);
      return paramClass;
    }
    AppMethodBeat.o(79785);
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(79787);
    if ((paramObject instanceof m))
    {
      if (hashCode() == ((m)paramObject).hashCode())
      {
        AppMethodBeat.o(79787);
        return true;
      }
      AppMethodBeat.o(79787);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(79787);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(79786);
    int j = super.hashCode();
    int i = j;
    if (!bo.isNullOrNil(this.url)) {
      i = j + this.url.hashCode();
    }
    j = i + this.type + this.end + this.start;
    i = j;
    if (this.data != null) {
      i = j + this.data.hashCode();
    }
    AppMethodBeat.o(79786);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.m
 * JD-Core Version:    0.7.0.1
 */