package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.n;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class bh
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78623);
    Log.i("MicroMsg.JsApiSetCloseWindowConfirmDialogInfo", "invoke");
    boolean bool = paramb.eiZ.eif.optBoolean("switch");
    String str1 = paramb.eiZ.eif.optString("title_cn");
    String str2 = paramb.eiZ.eif.optString("title_eng");
    String str3 = paramb.eiZ.eif.optString("ok_cn");
    String str4 = paramb.eiZ.eif.optString("ok_eng");
    String str5 = paramb.eiZ.eif.optString("cancel_cn");
    String str6 = paramb.eiZ.eif.optString("cancel_eng");
    n localn = ((g)paramb.eiY).iuf();
    if (localn == null)
    {
      AppMethodBeat.o(78623);
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
    localn.setCloseWindowConfirmInfo(localBundle);
    paramb.a("", null);
    AppMethodBeat.o(78623);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setCloseWindowConfirmDialogInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bh
 * JD-Core Version:    0.7.0.1
 */