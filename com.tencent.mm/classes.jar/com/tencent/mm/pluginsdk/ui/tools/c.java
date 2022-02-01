package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class c
  extends f
{
  public int hYn = 0;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152375);
    paramStringBuilder.append("<directshare>").append(this.hYn).append("</directshare>");
    AppMethodBeat.o(152375);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152376);
    paramMap = (String)paramMap.get(".msg.appmsg.directshare");
    if (!Util.isNullOrNil(paramMap)) {
      this.hYn = Util.safeParseInt(paramMap);
    }
    AppMethodBeat.o(152376);
  }
  
  public final f biW()
  {
    AppMethodBeat.i(152374);
    c localc = new c();
    localc.hYn = this.hYn;
    AppMethodBeat.o(152374);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */