package com.tencent.mm.plugin.webview.modeltools;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.vy;
import com.tencent.mm.autogen.a.vy.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

class LicenceScanner$3
  extends IListener<vy>
{
  LicenceScanner$3(e parame, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(295771);
    this.__eventId = vy.class.getName().hashCode();
    AppMethodBeat.o(295771);
  }
  
  private boolean a(vy paramvy)
  {
    AppMethodBeat.i(79129);
    if (((paramvy instanceof vy)) && (this.WNz.WNv.equalsIgnoreCase(paramvy.hZB.cardType)))
    {
      if (paramvy.hZB.hZC != 0) {
        break label70;
      }
      e.b(this.WNz, this.WNz.WNv);
    }
    label187:
    for (;;)
    {
      e.a(this.WNz);
      AppMethodBeat.o(79129);
      return false;
      label70:
      if (paramvy.hZB.hZC == 2)
      {
        e.a(this.WNz, this.WNz.WNv);
      }
      else
      {
        try
        {
          if (Util.isNullOrNil(paramvy.hZB.hZD)) {
            break label187;
          }
          JSONObject localJSONObject = new JSONObject(paramvy.hZB.hZD);
          e.a(this.WNz, this.WNz.WNv, localJSONObject, paramvy.hZB.hZE);
        }
        catch (Exception paramvy)
        {
          Log.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramvy.getMessage() });
          e.b(this.WNz, this.WNz.WNv);
        }
        continue;
        e.a(this.WNz, this.WNz.WNv, null, paramvy.hZB.hZE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.LicenceScanner.3
 * JD-Core Version:    0.7.0.1
 */