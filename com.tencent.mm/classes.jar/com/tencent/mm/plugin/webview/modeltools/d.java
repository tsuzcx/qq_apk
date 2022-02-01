package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.ug;
import com.tencent.mm.f.a.ug.a;
import com.tencent.mm.f.a.ui;
import com.tencent.mm.f.a.ui.a;
import com.tencent.mm.f.a.um;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  String PWR;
  private a PWS;
  private IListener PWT;
  private IListener PWU;
  private IListener scanBankCardConfirmResultListener;
  
  public d()
  {
    AppMethodBeat.i(79131);
    this.PWR = null;
    this.PWT = new IListener() {};
    this.scanBankCardConfirmResultListener = new IListener()
    {
      private boolean callback(ug paramAnonymousug)
      {
        AppMethodBeat.i(79127);
        if (((paramAnonymousug instanceof ug)) && ("bank".equals(d.this.PWR)))
        {
          if (paramAnonymousug.fTz.action != 0) {
            break label65;
          }
          d.a(d.this, d.this.PWR);
        }
        for (;;)
        {
          d.a(d.this);
          AppMethodBeat.o(79127);
          return false;
          label65:
          if (paramAnonymousug.fTz.action == 1) {
            if (Util.isNullOrNil(paramAnonymousug.fTz.cardNum)) {
              d.b(d.this, d.this.PWR);
            } else {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("bankcard_number", paramAnonymousug.fTz.cardNum);
                d.a(d.this, d.this.PWR, localJSONObject, null);
              }
              catch (JSONException paramAnonymousug)
              {
                Log.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramAnonymousug });
                d.b(d.this, d.this.PWR);
              }
            }
          }
        }
      }
    };
    this.PWU = new IListener()
    {
      private boolean a(ui paramAnonymousui)
      {
        AppMethodBeat.i(79129);
        if (((paramAnonymousui instanceof ui)) && (d.this.PWR.equalsIgnoreCase(paramAnonymousui.fTD.cardType)))
        {
          if (paramAnonymousui.fTD.fTE != 0) {
            break label70;
          }
          d.b(d.this, d.this.PWR);
        }
        label187:
        for (;;)
        {
          d.a(d.this);
          AppMethodBeat.o(79129);
          return false;
          label70:
          if (paramAnonymousui.fTD.fTE == 2)
          {
            d.a(d.this, d.this.PWR);
          }
          else
          {
            try
            {
              if (Util.isNullOrNil(paramAnonymousui.fTD.fTF)) {
                break label187;
              }
              JSONObject localJSONObject = new JSONObject(paramAnonymousui.fTD.fTF);
              d.a(d.this, d.this.PWR, localJSONObject, paramAnonymousui.fTD.fTG);
            }
            catch (Exception paramAnonymousui)
            {
              Log.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramAnonymousui.getMessage() });
              d.b(d.this, d.this.PWR);
            }
            continue;
            d.a(d.this, d.this.PWR, null, paramAnonymousui.fTD.fTG);
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
      c.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.PWS = parama;
      this.PWR = "bank";
      EventCenter.instance.addListener(this.PWT);
      EventCenter.instance.addListener(this.scanBankCardConfirmResultListener);
      AppMethodBeat.o(79132);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      c.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.PWS = parama;
      this.PWR = "identity_pay_auth";
      EventCenter.instance.addListener(this.PWT);
      EventCenter.instance.addListener(this.PWU);
      AppMethodBeat.o(79132);
      return true;
    }
    AppMethodBeat.o(79132);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void aij(String paramString);
    
    public abstract void blj(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.d
 * JD-Core Version:    0.7.0.1
 */