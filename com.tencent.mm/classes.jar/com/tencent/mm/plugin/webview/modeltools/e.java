package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.g.a.sh.a;
import com.tencent.mm.g.a.sj;
import com.tencent.mm.g.a.sj.a;
import com.tencent.mm.g.a.sn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  String DVw;
  private a DVx;
  private c DVy;
  private c DVz;
  private c scanBankCardConfirmResultListener;
  
  public e()
  {
    AppMethodBeat.i(79131);
    this.DVw = null;
    this.DVy = new c() {};
    this.scanBankCardConfirmResultListener = new c()
    {
      private boolean callback(sh paramAnonymoussh)
      {
        AppMethodBeat.i(79127);
        if (((paramAnonymoussh instanceof sh)) && ("bank".equals(e.this.DVw)))
        {
          if (paramAnonymoussh.dGN.action != 0) {
            break label65;
          }
          e.a(e.this, e.this.DVw);
        }
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79127);
          return false;
          label65:
          if (paramAnonymoussh.dGN.action == 1) {
            if (bt.isNullOrNil(paramAnonymoussh.dGN.cardNum)) {
              e.b(e.this, e.this.DVw);
            } else {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("bankcard_number", paramAnonymoussh.dGN.cardNum);
                e.a(e.this, e.this.DVw, localJSONObject, null);
              }
              catch (JSONException paramAnonymoussh)
              {
                ad.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramAnonymoussh });
                e.b(e.this, e.this.DVw);
              }
            }
          }
        }
      }
    };
    this.DVz = new c()
    {
      private boolean a(sj paramAnonymoussj)
      {
        AppMethodBeat.i(79129);
        if (((paramAnonymoussj instanceof sj)) && (e.this.DVw.equalsIgnoreCase(paramAnonymoussj.dGR.cardType)))
        {
          if (paramAnonymoussj.dGR.dGS != 0) {
            break label70;
          }
          e.b(e.this, e.this.DVw);
        }
        label187:
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79129);
          return false;
          label70:
          if (paramAnonymoussj.dGR.dGS == 2)
          {
            e.a(e.this, e.this.DVw);
          }
          else
          {
            try
            {
              if (bt.isNullOrNil(paramAnonymoussj.dGR.dGT)) {
                break label187;
              }
              JSONObject localJSONObject = new JSONObject(paramAnonymoussj.dGR.dGT);
              e.a(e.this, e.this.DVw, localJSONObject, paramAnonymoussj.dGR.dGU);
            }
            catch (Exception paramAnonymoussj)
            {
              ad.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramAnonymoussj.getMessage() });
              e.b(e.this, e.this.DVw);
            }
            continue;
            e.a(e.this, e.this.DVw, null, paramAnonymoussj.dGR.dGU);
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
      this.DVx = parama;
      this.DVw = "bank";
      a.IbL.c(this.DVy);
      a.IbL.c(this.scanBankCardConfirmResultListener);
      AppMethodBeat.o(79132);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      d.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.DVx = parama;
      this.DVw = "identity_pay_auth";
      a.IbL.c(this.DVy);
      a.IbL.c(this.DVz);
      AppMethodBeat.o(79132);
      return true;
    }
    AppMethodBeat.o(79132);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void Qi(String paramString);
    
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void aHS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */