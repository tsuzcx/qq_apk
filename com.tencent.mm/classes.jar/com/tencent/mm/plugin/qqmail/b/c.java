package com.tencent.mm.plugin.qqmail.b;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

public final class c
{
  public static final String Hlb;
  
  static
  {
    AppMethodBeat.i(249647);
    Hlb = "weixin/" + d.kQZ + "/0x" + Integer.toHexString(d.RAD);
    AppMethodBeat.o(249647);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, a.a parama)
  {
    AppMethodBeat.i(249646);
    paramString1 = new b(paramString1, paramString2, parama);
    paramString2 = new Bundle();
    paramString2.putString("param_cookie", paramString3);
    paramString1.y(new Bundle[] { paramString2 });
    AppMethodBeat.o(249646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.c
 * JD-Core Version:    0.7.0.1
 */