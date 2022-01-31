package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class aw
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6372);
    ab.i("MicroMsg.JsApiSetCloseWindowConfirmDialogInfo", "invoke");
    boolean bool = parama.byF.bxK.optBoolean("switch");
    String str1 = parama.byF.bxK.optString("title_cn");
    String str2 = parama.byF.bxK.optString("title_eng");
    String str3 = parama.byF.bxK.optString("ok_cn");
    String str4 = parama.byF.bxK.optString("ok_eng");
    String str5 = parama.byF.bxK.optString("cancel_cn");
    String str6 = parama.byF.bxK.optString("cancel_eng");
    l locall = ((e)parama.byE).daV();
    if (locall == null)
    {
      AppMethodBeat.o(6372);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("close_window_confirm_dialog_switch", Boolean.valueOf(bool).booleanValue());
    localBundle.putString("close_window_confirm_dialog_title_cn", str1);
    localBundle.putString("close_window_confirm_dialog_title_eng", str2);
    localBundle.putString("close_window_confirm_dialog_ok_cn", str3);
    localBundle.putString("close_window_confirm_dialog_ok_eng", str4);
    localBundle.putString("close_window_confirm_dialog_cancel_cn", str5);
    localBundle.putString("close_window_confirm_dialog_cancel_eng", str6);
    locall.setCloseWindowConfirmInfo(localBundle);
    parama.a("", null);
    AppMethodBeat.o(6372);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setCloseWindowConfirmDialogInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aw
 * JD-Core Version:    0.7.0.1
 */