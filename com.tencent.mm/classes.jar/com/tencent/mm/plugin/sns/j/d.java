package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.va;
import com.tencent.mm.g.a.va.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public final class d
{
  private static d zKI = null;
  private c<va> fHr;
  public HashMap<Integer, a> zKJ;
  
  private d()
  {
    AppMethodBeat.i(96205);
    this.zKJ = null;
    this.fHr = new c() {};
    this.zKJ = new HashMap();
    a.IvT.b(this.fHr);
    AppMethodBeat.o(96205);
  }
  
  public static d dZe()
  {
    AppMethodBeat.i(96206);
    if (zKI == null) {
      zKI = new d();
    }
    d locald = zKI;
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