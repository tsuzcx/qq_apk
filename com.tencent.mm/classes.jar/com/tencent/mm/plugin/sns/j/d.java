package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.g.a.uw.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public final class d
{
  private static d ztt = null;
  private c<uw> fFn;
  public HashMap<Integer, a> ztu;
  
  private d()
  {
    AppMethodBeat.i(96205);
    this.ztu = null;
    this.fFn = new c() {};
    this.ztu = new HashMap();
    a.IbL.b(this.fFn);
    AppMethodBeat.o(96205);
  }
  
  public static d dVD()
  {
    AppMethodBeat.i(96206);
    if (ztt == null) {
      ztt = new d();
    }
    d locald = ztt;
    AppMethodBeat.o(96206);
    return locald;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.j.d
 * JD-Core Version:    0.7.0.1
 */