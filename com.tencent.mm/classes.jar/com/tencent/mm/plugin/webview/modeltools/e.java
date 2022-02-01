package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.rm;
import com.tencent.mm.g.a.rm.a;
import com.tencent.mm.g.a.ro;
import com.tencent.mm.g.a.ro.a;
import com.tencent.mm.g.a.rs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  String AZE;
  private a AZF;
  private c AZG;
  private c AZH;
  private c scanBankCardConfirmResultListener;
  
  public e()
  {
    AppMethodBeat.i(79131);
    this.AZE = null;
    this.AZG = new c() {};
    this.scanBankCardConfirmResultListener = new c()
    {
      private boolean callback(rm paramAnonymousrm)
      {
        AppMethodBeat.i(79127);
        if (((paramAnonymousrm instanceof rm)) && ("bank".equals(e.this.AZE)))
        {
          if (paramAnonymousrm.dwZ.action != 0) {
            break label65;
          }
          e.a(e.this, e.this.AZE);
        }
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79127);
          return false;
          label65:
          if (paramAnonymousrm.dwZ.action == 1) {
            if (bt.isNullOrNil(paramAnonymousrm.dwZ.cardNum)) {
              e.b(e.this, e.this.AZE);
            } else {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("bankcard_number", paramAnonymousrm.dwZ.cardNum);
                e.a(e.this, e.this.AZE, localJSONObject, null);
              }
              catch (JSONException paramAnonymousrm)
              {
                ad.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramAnonymousrm });
                e.b(e.this, e.this.AZE);
              }
            }
          }
        }
      }
    };
    this.AZH = new c()
    {
      private boolean a(ro paramAnonymousro)
      {
        AppMethodBeat.i(79129);
        if (((paramAnonymousro instanceof ro)) && (e.this.AZE.equalsIgnoreCase(paramAnonymousro.dxd.cardType)))
        {
          if (paramAnonymousro.dxd.dxe != 0) {
            break label70;
          }
          e.b(e.this, e.this.AZE);
        }
        label187:
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79129);
          return false;
          label70:
          if (paramAnonymousro.dxd.dxe == 2)
          {
            e.a(e.this, e.this.AZE);
          }
          else
          {
            try
            {
              if (bt.isNullOrNil(paramAnonymousro.dxd.dxf)) {
                break label187;
              }
              JSONObject localJSONObject = new JSONObject(paramAnonymousro.dxd.dxf);
              e.a(e.this, e.this.AZE, localJSONObject, paramAnonymousro.dxd.dxg);
            }
            catch (Exception paramAnonymousro)
            {
              ad.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramAnonymousro.getMessage() });
              e.b(e.this, e.this.AZE);
            }
            continue;
            e.a(e.this, e.this.AZE, null, paramAnonymousro.dxd.dxg);
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
      this.AZF = parama;
      this.AZE = "bank";
      a.ESL.c(this.AZG);
      a.ESL.c(this.scanBankCardConfirmResultListener);
      AppMethodBeat.o(79132);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      d.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.AZF = parama;
      this.AZE = "identity_pay_auth";
      a.ESL.c(this.AZG);
      a.ESL.c(this.AZH);
      AppMethodBeat.o(79132);
      return true;
    }
    AppMethodBeat.o(79132);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void IK(String paramString);
    
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void axa(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */