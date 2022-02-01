package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.rv.a;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.rx.a;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  String CrR;
  private a CrS;
  private c CrT;
  private c CrU;
  private c scanBankCardConfirmResultListener;
  
  public e()
  {
    AppMethodBeat.i(79131);
    this.CrR = null;
    this.CrT = new c() {};
    this.scanBankCardConfirmResultListener = new c()
    {
      private boolean callback(rv paramAnonymousrv)
      {
        AppMethodBeat.i(79127);
        if (((paramAnonymousrv instanceof rv)) && ("bank".equals(e.this.CrR)))
        {
          if (paramAnonymousrv.duM.action != 0) {
            break label65;
          }
          e.a(e.this, e.this.CrR);
        }
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79127);
          return false;
          label65:
          if (paramAnonymousrv.duM.action == 1) {
            if (bs.isNullOrNil(paramAnonymousrv.duM.cardNum)) {
              e.b(e.this, e.this.CrR);
            } else {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("bankcard_number", paramAnonymousrv.duM.cardNum);
                e.a(e.this, e.this.CrR, localJSONObject, null);
              }
              catch (JSONException paramAnonymousrv)
              {
                ac.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramAnonymousrv });
                e.b(e.this, e.this.CrR);
              }
            }
          }
        }
      }
    };
    this.CrU = new c()
    {
      private boolean a(rx paramAnonymousrx)
      {
        AppMethodBeat.i(79129);
        if (((paramAnonymousrx instanceof rx)) && (e.this.CrR.equalsIgnoreCase(paramAnonymousrx.duQ.cardType)))
        {
          if (paramAnonymousrx.duQ.duR != 0) {
            break label70;
          }
          e.b(e.this, e.this.CrR);
        }
        label187:
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79129);
          return false;
          label70:
          if (paramAnonymousrx.duQ.duR == 2)
          {
            e.a(e.this, e.this.CrR);
          }
          else
          {
            try
            {
              if (bs.isNullOrNil(paramAnonymousrx.duQ.duS)) {
                break label187;
              }
              JSONObject localJSONObject = new JSONObject(paramAnonymousrx.duQ.duS);
              e.a(e.this, e.this.CrR, localJSONObject, paramAnonymousrx.duQ.duT);
            }
            catch (Exception paramAnonymousrx)
            {
              ac.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramAnonymousrx.getMessage() });
              e.b(e.this, e.this.CrR);
            }
            continue;
            e.a(e.this, e.this.CrR, null, paramAnonymousrx.duQ.duT);
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
      this.CrS = parama;
      this.CrR = "bank";
      a.GpY.c(this.CrT);
      a.GpY.c(this.scanBankCardConfirmResultListener);
      AppMethodBeat.o(79132);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      d.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.CrS = parama;
      this.CrR = "identity_pay_auth";
      a.GpY.c(this.CrT);
      a.GpY.c(this.CrU);
      AppMethodBeat.o(79132);
      return true;
    }
    AppMethodBeat.o(79132);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void ML(String paramString);
    
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void aCs(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */