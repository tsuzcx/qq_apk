package com.tencent.mm.plugin.webview.modeltools;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.vw;
import com.tencent.mm.autogen.a.vw.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

class LicenceScanner$2
  extends IListener<vw>
{
  LicenceScanner$2(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(295767);
    this.__eventId = vw.class.getName().hashCode();
    AppMethodBeat.o(295767);
  }
  
  private boolean callback(vw paramvw)
  {
    AppMethodBeat.i(79127);
    if (((paramvw instanceof vw)) && ("bank".equals(this.WNz.WNv)))
    {
      if (paramvw.hZx.action != 0) {
        break label65;
      }
      e.a(this.WNz, this.WNz.WNv);
    }
    for (;;)
    {
      e.a(this.WNz);
      AppMethodBeat.o(79127);
      return false;
      label65:
      if (paramvw.hZx.action == 1) {
        if (Util.isNullOrNil(paramvw.hZx.cardNum)) {
          e.b(this.WNz, this.WNz.WNv);
        } else {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("bankcard_number", paramvw.hZx.cardNum);
            e.a(this.WNz, this.WNz.WNv, localJSONObject, null);
          }
          catch (JSONException paramvw)
          {
            Log.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramvw });
            e.b(this.WNz, this.WNz.WNv);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.LicenceScanner.2
 * JD-Core Version:    0.7.0.1
 */