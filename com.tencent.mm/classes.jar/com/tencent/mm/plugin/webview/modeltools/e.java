package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import org.json.JSONObject;

public final class e
{
  private c scanBankCardConfirmResultListener;
  private c uXA;
  String uXx;
  private a uXy;
  private c uXz;
  
  public e()
  {
    AppMethodBeat.i(6940);
    this.uXx = null;
    this.uXz = new e.1(this);
    this.scanBankCardConfirmResultListener = new e.2(this);
    this.uXA = new e.3(this);
    AppMethodBeat.o(6940);
  }
  
  public final boolean a(String paramString, Context paramContext, a parama)
  {
    AppMethodBeat.i(6941);
    if ("bank".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 7);
      paramString.putExtra("scan_bankcard_with_confirm_ui", true);
      paramString.addFlags(268435456);
      d.b(paramContext, "scanner", ".ui.BaseScanUI", paramString);
      this.uXy = parama;
      this.uXx = "bank";
      a.ymk.c(this.uXz);
      a.ymk.c(this.scanBankCardConfirmResultListener);
      AppMethodBeat.o(6941);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      d.b(paramContext, "scanner", ".ui.BaseScanUI", paramString);
      this.uXy = parama;
      this.uXx = "identity";
      a.ymk.c(this.uXz);
      a.ymk.c(this.uXA);
      AppMethodBeat.o(6941);
      return true;
    }
    AppMethodBeat.o(6941);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void CF(String paramString);
    
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void ahA(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */