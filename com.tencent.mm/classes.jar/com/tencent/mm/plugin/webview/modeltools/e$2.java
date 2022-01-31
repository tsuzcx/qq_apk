package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.h.a.ou;
import com.tencent.mm.h.a.ou.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class e$2
  extends c<ou>
{
  e$2(e parame)
  {
    this.udX = ou.class.getName().hashCode();
  }
  
  private boolean a(ou paramou)
  {
    if (((paramou instanceof ou)) && ("bank".equals(this.ric.rhX)))
    {
      if (paramou.bYq.action != 0) {
        break label55;
      }
      e.a(this.ric, this.ric.rhX);
    }
    for (;;)
    {
      e.a(this.ric);
      return false;
      label55:
      if (paramou.bYq.action == 1) {
        if (bk.bl(paramou.bYq.cardNum)) {
          e.b(this.ric, this.ric.rhX);
        } else {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("bankcard_number", paramou.bYq.cardNum);
            e.a(this.ric, this.ric.rhX, localJSONObject, null);
          }
          catch (JSONException paramou)
          {
            y.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramou });
            e.b(this.ric, this.ric.rhX);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e.2
 * JD-Core Version:    0.7.0.1
 */