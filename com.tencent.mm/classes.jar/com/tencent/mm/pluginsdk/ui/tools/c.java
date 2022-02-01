package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class c
  extends f
{
  public int dvY = 0;
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152376);
    paramMap = (String)paramMap.get(".msg.appmsg.directshare");
    if (!bt.isNullOrNil(paramMap)) {
      this.dvY = bt.aGh(paramMap);
    }
    AppMethodBeat.o(152376);
  }
  
  public final f apu()
  {
    AppMethodBeat.i(152374);
    c localc = new c();
    localc.dvY = this.dvY;
    AppMethodBeat.o(152374);
    return localc;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152375);
    paramStringBuilder.append("<directshare>").append(this.dvY).append("</directshare>");
    AppMethodBeat.o(152375);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */