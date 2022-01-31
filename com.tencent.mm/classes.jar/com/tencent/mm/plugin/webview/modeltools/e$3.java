package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.px;
import com.tencent.mm.g.a.px.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

final class e$3
  extends c<px>
{
  e$3(e parame)
  {
    AppMethodBeat.i(6937);
    this.__eventId = px.class.getName().hashCode();
    AppMethodBeat.o(6937);
  }
  
  private boolean a(px parampx)
  {
    AppMethodBeat.i(6938);
    if (((parampx instanceof px)) && (this.uXB.uXx.equalsIgnoreCase(parampx.cGs.cardType)))
    {
      if (parampx.cGs.cGt != 0) {
        break label72;
      }
      e.b(this.uXB, this.uXB.uXx);
    }
    label189:
    for (;;)
    {
      e.a(this.uXB);
      AppMethodBeat.o(6938);
      return false;
      label72:
      if (parampx.cGs.cGt == 2)
      {
        e.a(this.uXB, this.uXB.uXx);
      }
      else
      {
        try
        {
          if (bo.isNullOrNil(parampx.cGs.cGu)) {
            break label189;
          }
          JSONObject localJSONObject = new JSONObject(parampx.cGs.cGu);
          e.a(this.uXB, this.uXB.uXx, localJSONObject, parampx.cGs.cGv);
        }
        catch (Exception parampx)
        {
          ab.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { parampx.getMessage() });
          e.b(this.uXB, this.uXB.uXx);
        }
        continue;
        e.a(this.uXB, this.uXB.uXx, null, parampx.cGs.cGv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e.3
 * JD-Core Version:    0.7.0.1
 */