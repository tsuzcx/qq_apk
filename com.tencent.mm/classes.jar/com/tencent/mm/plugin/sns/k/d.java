package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.a.vz.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import java.util.HashMap;

public final class d
{
  private static d DUK = null;
  public HashMap<Integer, a> DUL;
  private IListener<vz> gmC;
  
  private d()
  {
    AppMethodBeat.i(96205);
    this.DUL = null;
    this.gmC = new IListener() {};
    this.DUL = new HashMap();
    EventCenter.instance.add(this.gmC);
    AppMethodBeat.o(96205);
  }
  
  public static d fcs()
  {
    AppMethodBeat.i(96206);
    if (DUK == null) {
      DUK = new d();
    }
    d locald = DUK;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.k.d
 * JD-Core Version:    0.7.0.1
 */