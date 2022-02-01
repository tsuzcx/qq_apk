package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class c
  extends f
{
  public int dtL = 0;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(152375);
    paramStringBuilder.append("<directshare>").append(this.dtL).append("</directshare>");
    AppMethodBeat.o(152375);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(152376);
    paramMap = (String)paramMap.get(".msg.appmsg.directshare");
    if (!bs.isNullOrNil(paramMap)) {
      this.dtL = bs.aLy(paramMap);
    }
    AppMethodBeat.o(152376);
  }
  
  public final f alG()
  {
    AppMethodBeat.i(152374);
    c localc = new c();
    localc.dtL = this.dtL;
    AppMethodBeat.o(152374);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.c
 * JD-Core Version:    0.7.0.1
 */