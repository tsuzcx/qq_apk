package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.si;
import com.tencent.mm.g.a.si.a;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.sk.a;
import com.tencent.mm.g.a.so;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  String Env;
  private a Enw;
  private c Enx;
  private c Eny;
  private c scanBankCardConfirmResultListener;
  
  public e()
  {
    AppMethodBeat.i(79131);
    this.Env = null;
    this.Enx = new c() {};
    this.scanBankCardConfirmResultListener = new c()
    {
      private boolean callback(si paramAnonymoussi)
      {
        AppMethodBeat.i(79127);
        if (((paramAnonymoussi instanceof si)) && ("bank".equals(e.this.Env)))
        {
          if (paramAnonymoussi.dHT.action != 0) {
            break label65;
          }
          e.a(e.this, e.this.Env);
        }
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79127);
          return false;
          label65:
          if (paramAnonymoussi.dHT.action == 1) {
            if (bu.isNullOrNil(paramAnonymoussi.dHT.cardNum)) {
              e.b(e.this, e.this.Env);
            } else {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("bankcard_number", paramAnonymoussi.dHT.cardNum);
                e.a(e.this, e.this.Env, localJSONObject, null);
              }
              catch (JSONException paramAnonymoussi)
              {
                ae.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramAnonymoussi });
                e.b(e.this, e.this.Env);
              }
            }
          }
        }
      }
    };
    this.Eny = new c()
    {
      private boolean a(sk paramAnonymoussk)
      {
        AppMethodBeat.i(79129);
        if (((paramAnonymoussk instanceof sk)) && (e.this.Env.equalsIgnoreCase(paramAnonymoussk.dHX.cardType)))
        {
          if (paramAnonymoussk.dHX.dHY != 0) {
            break label70;
          }
          e.b(e.this, e.this.Env);
        }
        label187:
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79129);
          return false;
          label70:
          if (paramAnonymoussk.dHX.dHY == 2)
          {
            e.a(e.this, e.this.Env);
          }
          else
          {
            try
            {
              if (bu.isNullOrNil(paramAnonymoussk.dHX.dHZ)) {
                break label187;
              }
              JSONObject localJSONObject = new JSONObject(paramAnonymoussk.dHX.dHZ);
              e.a(e.this, e.this.Env, localJSONObject, paramAnonymoussk.dHX.dIa);
            }
            catch (Exception paramAnonymoussk)
            {
              ae.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramAnonymoussk.getMessage() });
              e.b(e.this, e.this.Env);
            }
            continue;
            e.a(e.this, e.this.Env, null, paramAnonymoussk.dHX.dIa);
          }
        }
      }
    };
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
      d.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.Enw = parama;
      this.Env = "bank";
      a.IvT.c(this.Enx);
      a.IvT.c(this.scanBankCardConfirmResultListener);
      AppMethodBeat.o(79132);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      d.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.Enw = parama;
      this.Env = "identity_pay_auth";
      a.IvT.c(this.Enx);
      a.IvT.c(this.Eny);
      AppMethodBeat.o(79132);
      return true;
    }
    AppMethodBeat.o(79132);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void QR(String paramString);
    
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void aJl(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */