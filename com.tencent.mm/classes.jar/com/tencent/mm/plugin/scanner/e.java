package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.cuk;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import java.util.LinkedList;

public final class e
{
  public final com.tencent.mm.vending.g.e<cuk> a(int paramInt, a parama)
  {
    AppMethodBeat.i(313344);
    parama = g.V(Integer.valueOf(paramInt), parama).b(new a() {});
    AppMethodBeat.o(313344);
    return parama;
  }
  
  public final com.tencent.mm.vending.g.e<cuk> cJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(151552);
    paramString = a(paramInt, new a(paramString));
    AppMethodBeat.o(151552);
    return paramString;
  }
  
  public static final class a
  {
    String OGM;
    String OGN;
    public int sessionType;
    public String uWs;
    
    public a(String paramString)
    {
      this.OGM = paramString;
      this.sessionType = 0;
    }
    
    public static a aP(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(313215);
      paramString1 = new a(paramString1);
      paramString1.sessionType = 3;
      paramString1.uWs = paramString2;
      paramString1.OGN = paramString3;
      AppMethodBeat.o(313215);
      return paramString1;
    }
    
    public static a lE(String paramString1, String paramString2)
    {
      AppMethodBeat.i(313219);
      paramString1 = new a(paramString1);
      paramString1.sessionType = 4;
      paramString1.uWs = paramString2;
      AppMethodBeat.o(313219);
      return paramString1;
    }
    
    public static a lF(String paramString1, String paramString2)
    {
      AppMethodBeat.i(313222);
      paramString1 = new a(paramString1);
      paramString1.sessionType = 5;
      paramString1.uWs = paramString2;
      AppMethodBeat.o(313222);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e
 * JD-Core Version:    0.7.0.1
 */