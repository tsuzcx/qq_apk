package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xe;
import com.tencent.mm.f.a.xe.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;

public final class f
{
  private static f KhU = null;
  public HashMap<Integer, a> KhV;
  private IListener<xe> iQL;
  
  private f()
  {
    AppMethodBeat.i(96205);
    this.KhV = null;
    this.iQL = new IListener() {};
    this.KhV = new HashMap();
    EventCenter.instance.add(this.iQL);
    AppMethodBeat.o(96205);
  }
  
  public static f fQl()
  {
    AppMethodBeat.i(96206);
    if (KhU == null) {
      KhU = new f();
    }
    f localf = KhU;
    AppMethodBeat.o(96206);
    return localf;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.k.f
 * JD-Core Version:    0.7.0.1
 */