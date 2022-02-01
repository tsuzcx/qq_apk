package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.event.IListener;
import org.json.JSONObject;

public final class e
{
  String WNv;
  private a WNw;
  private IListener WNx;
  private IListener WNy;
  private IListener scanBankCardConfirmResultListener;
  
  public e()
  {
    AppMethodBeat.i(79131);
    this.WNv = null;
    this.WNx = new LicenceScanner.1(this, f.hfK);
    this.scanBankCardConfirmResultListener = new LicenceScanner.2(this, f.hfK);
    this.WNy = new LicenceScanner.3(this, f.hfK);
    AppMethodBeat.o(79131);
  }
  
  public final boolean a(String paramString, Context paramContext, a parama)
  {
    AppMethodBeat.i(79132);
    if ("bank".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 7);
      paramString.putExtra("scan_bankcard_with_confirm_ui", true);
      paramString.addFlags(268435456);
      c.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.WNw = parama;
      this.WNv = "bank";
      this.WNx.alive();
      this.scanBankCardConfirmResultListener.alive();
      AppMethodBeat.o(79132);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      c.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.WNw = parama;
      this.WNv = "identity_pay_auth";
      this.WNx.alive();
      this.WNy.alive();
      AppMethodBeat.o(79132);
      return true;
    }
    AppMethodBeat.o(79132);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void abh(String paramString);
    
    public abstract void bkM(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */