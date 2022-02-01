package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;

public class u
{
  public String AWk;
  public int YcU = 1;
  public String YcV = null;
  public int backgroundColor;
  public String chatroomName;
  public Object cpt;
  public int end;
  public Object extraData;
  public int fromScene = 0;
  public cc hTm = null;
  public int kLv;
  public int linkColor;
  public String mSessionId;
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
    this.cpt = null;
  }
  
  public u(String paramString, int paramInt, Object paramObject)
  {
    this.url = paramString;
    this.cpt = paramObject;
    this.type = paramInt;
  }
  
  public final <T> T cf(Class<T> paramClass)
  {
    AppMethodBeat.i(152234);
    if (paramClass.isInstance(this.cpt))
    {
      paramClass = paramClass.cast(this.cpt);
      AppMethodBeat.o(152234);
      return paramClass;
    }
    AppMethodBeat.o(152234);
    return null;
  }
  
  public boolean equals(Object paramObject)
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
  
  public int hashCode()
  {
    AppMethodBeat.i(152235);
    int j = super.hashCode();
    int i = j;
    if (!Util.isNullOrNil(this.url)) {
      i = j + this.url.hashCode();
    }
    j = i + this.type + this.end + this.start;
    i = j;
    if (this.cpt != null) {
      i = j + this.cpt.hashCode();
    }
    AppMethodBeat.o(152235);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.u
 * JD-Core Version:    0.7.0.1
 */