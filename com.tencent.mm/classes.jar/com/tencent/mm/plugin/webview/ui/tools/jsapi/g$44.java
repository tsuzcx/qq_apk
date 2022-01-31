package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.e.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class g$44
  implements e.a
{
  g$44(g paramg, String paramString, i parami) {}
  
  public final void CF(String paramString)
  {
    AppMethodBeat.i(154968);
    if (!bo.nullAsNil(paramString).equals(this.vqP))
    {
      AppMethodBeat.o(154968);
      return;
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("cardType", paramString);
    this.vqm.a(this.vqQ, "scanLicence:fail", localHashMap);
    AppMethodBeat.o(154968);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap)
  {
    AppMethodBeat.i(154966);
    if (!bo.nullAsNil(paramString).equalsIgnoreCase(this.vqP))
    {
      ab.i("MicroMsg.MsgHandler", "msg.params.cardType = %s, callback type = %s, mismatch!!!", new Object[] { this.vqP, paramString });
      AppMethodBeat.o(154966);
      return;
    }
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.MsgHandler", "doScanLicence, type = %s, callback onSuccess but result is null", new Object[] { paramString });
      CF(paramString);
      AppMethodBeat.o(154966);
      return;
    }
    paramBitmap = new HashMap(2);
    paramBitmap.put("cardType", paramString);
    paramBitmap.put("cardInfo", paramJSONObject);
    this.vqm.a(this.vqQ, "scanLicence:ok", paramBitmap);
    AppMethodBeat.o(154966);
  }
  
  public final void ahA(String paramString)
  {
    AppMethodBeat.i(154967);
    if (!bo.nullAsNil(paramString).equals(this.vqP))
    {
      AppMethodBeat.o(154967);
      return;
    }
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("cardType", paramString);
    this.vqm.a(this.vqQ, "scanLicence:cancel", localHashMap);
    AppMethodBeat.o(154967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.44
 * JD-Core Version:    0.7.0.1
 */