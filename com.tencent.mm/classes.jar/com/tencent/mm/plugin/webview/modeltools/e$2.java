package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.g.a.pw.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

final class e$2
  extends c<pw>
{
  e$2(e parame)
  {
    AppMethodBeat.i(6934);
    this.__eventId = pw.class.getName().hashCode();
    AppMethodBeat.o(6934);
  }
  
  private boolean callback(pw parampw)
  {
    AppMethodBeat.i(6935);
    if (((parampw instanceof pw)) && ("bank".equals(this.uXB.uXx)))
    {
      if (parampw.cGr.action != 0) {
        break label67;
      }
      e.a(this.uXB, this.uXB.uXx);
    }
    for (;;)
    {
      e.a(this.uXB);
      AppMethodBeat.o(6935);
      return false;
      label67:
      if (parampw.cGr.action == 1) {
        if (bo.isNullOrNil(parampw.cGr.cardNum)) {
          e.b(this.uXB, this.uXB.uXx);
        } else {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("bankcard_number", parampw.cGr.cardNum);
            e.a(this.uXB, this.uXB.uXx, localJSONObject, null);
          }
          catch (JSONException parampw)
          {
            ab.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { parampw });
            e.b(this.uXB, this.uXB.uXx);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e.2
 * JD-Core Version:    0.7.0.1
 */