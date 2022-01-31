package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.e.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("card_list");
      localObject = ((JSONObject)localObject).optString("tempalate_id");
      Intent localIntent = new Intent();
      localIntent.putExtra("card_list", paramString);
      localIntent.putExtra("key_template_id", (String)localObject);
      localIntent.putExtra("key_from_scene", 7);
      ((MMActivity)paramContext).gJb = new d.1(this, parama);
      com.tencent.mm.br.d.a(paramContext, "card", ".ui.CardViewEntranceUI", localIntent, 0xFFFF & hashCode(), false);
      return;
    }
    catch (JSONException paramContext)
    {
      y.e("MicroMsg.JsApiBatchViewCard", "paras data error: " + paramContext.getMessage());
      parama.e("fail", null);
    }
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(a<e>.a parama) {}
  
  public final String name()
  {
    return "batchViewCard";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.d
 * JD-Core Version:    0.7.0.1
 */