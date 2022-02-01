package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ud;
import com.tencent.mm.g.a.ud.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public final class e
{
  private static e ydy = null;
  private c<ud> fnf;
  public HashMap<Integer, a> ydz;
  
  private e()
  {
    AppMethodBeat.i(96205);
    this.ydz = null;
    this.fnf = new c() {};
    this.ydz = new HashMap();
    a.GpY.b(this.fnf);
    AppMethodBeat.o(96205);
  }
  
  public static e dJq()
  {
    AppMethodBeat.i(96206);
    if (ydy == null) {
      ydy = new e();
    }
    e locale = ydy;
    AppMethodBeat.o(96206);
    return locale;
  }
  
  public final class a
  {
    String content = "";
    int mediaType = 0;
    
    public a(int paramInt, String paramString)
    {
      this.content = paramString;
      this.mediaType = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.e
 * JD-Core Version:    0.7.0.1
 */