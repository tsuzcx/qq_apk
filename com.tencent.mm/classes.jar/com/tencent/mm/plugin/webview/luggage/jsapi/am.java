package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public class am
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiSetCloseWindowConfirmDialogInfo", "invoke");
    boolean bool = parama.bih.bhk.optBoolean("switch");
    String str1 = parama.bih.bhk.optString("title_cn");
    String str2 = parama.bih.bhk.optString("title_eng");
    String str3 = parama.bih.bhk.optString("ok_cn");
    String str4 = parama.bih.bhk.optString("ok_eng");
    String str5 = parama.bih.bhk.optString("cancel_cn");
    String str6 = parama.bih.bhk.optString("cancel_eng");
    m localm = ((e)parama.big).rbE;
    if (localm == null) {
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
    localm.setCloseWindowConfirmInfo(localBundle);
    parama.a("", null);
  }
  
  public final String name()
  {
    return "setCloseWindowConfirmDialogInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.am
 * JD-Core Version:    0.7.0.1
 */