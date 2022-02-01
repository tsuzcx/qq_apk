package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class u
{
  public String EWS;
  public int backgroundColor;
  public String chatroomName;
  public Object data;
  public int end;
  public int linkColor;
  public String mSessionId;
  public Object scd;
  public int start;
  public int type;
  public String url;
  public String username;
  
  @Deprecated
  public u(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
    this.url = null;
    this.type = 0;
    this.data = null;
  }
  
  public u(String paramString, int paramInt, Object paramObject)
  {
    this.url = paramString;
    this.data = paramObject;
    this.type = paramInt;
  }
  
  public final <T> T aY(Class<T> paramClass)
  {
    AppMethodBeat.i(152234);
    if (paramClass.isInstance(this.data))
    {
      paramClass = paramClass.cast(this.data);
      AppMethodBeat.o(152234);
      return paramClass;
    }
    AppMethodBeat.o(152234);
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(152236);
    if ((paramObject instanceof u))
    {
      if (hashCode() == ((u)paramObject).hashCode())
      {
        AppMethodBeat.o(152236);
        return true;
      }
      AppMethodBeat.o(152236);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(152236);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(152235);
    int j = super.hashCode();
    int i = j;
    if (!bt.isNullOrNil(this.url)) {
      i = j + this.url.hashCode();
    }
    j = i + this.type + this.end + this.start;
    i = j;
    if (this.data != null) {
      i = j + this.data.hashCode();
    }
    AppMethodBeat.o(152235);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.u
 * JD-Core Version:    0.7.0.1
 */