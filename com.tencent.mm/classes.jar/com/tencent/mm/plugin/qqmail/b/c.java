package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

public final class c
{
  public static final String USER_AGENT;
  
  static
  {
    AppMethodBeat.i(215177);
    USER_AGENT = "weixin/" + d.hgH + "/0x" + Integer.toHexString(d.Fnj);
    AppMethodBeat.o(215177);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a.a parama)
  {
    AppMethodBeat.i(215176);
    paramString1 = new b(paramString1, paramString2, parama);
    paramString2 = new Bundle();
    paramString2.putString("param_cookie", paramString3);
    paramString1.x(new Bundle[] { paramString2 });
    AppMethodBeat.o(215176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.c
 * JD-Core Version:    0.7.0.1
 */