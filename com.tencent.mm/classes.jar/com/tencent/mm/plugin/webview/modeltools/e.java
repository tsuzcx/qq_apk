package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.tf.a;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.th.a;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private a JaA;
  private IListener JaB;
  private IListener JaC;
  String Jaz;
  private IListener scanBankCardConfirmResultListener;
  
  public e()
  {
    AppMethodBeat.i(79131);
    this.Jaz = null;
    this.JaB = new IListener() {};
    this.scanBankCardConfirmResultListener = new IListener()
    {
      private boolean callback(tf paramAnonymoustf)
      {
        AppMethodBeat.i(79127);
        if (((paramAnonymoustf instanceof tf)) && ("bank".equals(e.this.Jaz)))
        {
          if (paramAnonymoustf.dZF.action != 0) {
            break label65;
          }
          e.a(e.this, e.this.Jaz);
        }
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79127);
          return false;
          label65:
          if (paramAnonymoustf.dZF.action == 1) {
            if (Util.isNullOrNil(paramAnonymoustf.dZF.cardNum)) {
              e.b(e.this, e.this.Jaz);
            } else {
              try
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("bankcard_number", paramAnonymoustf.dZF.cardNum);
                e.a(e.this, e.this.Jaz, localJSONObject, null);
              }
              catch (JSONException paramAnonymoustf)
              {
                Log.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", new Object[] { paramAnonymoustf });
                e.b(e.this, e.this.Jaz);
              }
            }
          }
        }
      }
    };
    this.JaC = new IListener()
    {
      private boolean a(th paramAnonymousth)
      {
        AppMethodBeat.i(79129);
        if (((paramAnonymousth instanceof th)) && (e.this.Jaz.equalsIgnoreCase(paramAnonymousth.dZJ.cardType)))
        {
          if (paramAnonymousth.dZJ.dZK != 0) {
            break label70;
          }
          e.b(e.this, e.this.Jaz);
        }
        label187:
        for (;;)
        {
          e.a(e.this);
          AppMethodBeat.o(79129);
          return false;
          label70:
          if (paramAnonymousth.dZJ.dZK == 2)
          {
            e.a(e.this, e.this.Jaz);
          }
          else
          {
            try
            {
              if (Util.isNullOrNil(paramAnonymousth.dZJ.dZL)) {
                break label187;
              }
              JSONObject localJSONObject = new JSONObject(paramAnonymousth.dZJ.dZL);
              e.a(e.this, e.this.Jaz, localJSONObject, paramAnonymousth.dZJ.dZM);
            }
            catch (Exception paramAnonymousth)
            {
              Log.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramAnonymousth.getMessage() });
              e.b(e.this, e.this.Jaz);
            }
            continue;
            e.a(e.this, e.this.Jaz, null, paramAnonymousth.dZJ.dZM);
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
      this.JaA = parama;
      this.Jaz = "bank";
      EventCenter.instance.addListener(this.JaB);
      EventCenter.instance.addListener(this.scanBankCardConfirmResultListener);
      AppMethodBeat.o(79132);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      c.b(paramContext, "scanner", ".ui.ScanCardUI", paramString);
      this.JaA = parama;
      this.Jaz = "identity_pay_auth";
      EventCenter.instance.addListener(this.JaB);
      EventCenter.instance.addListener(this.JaC);
      AppMethodBeat.o(79132);
      return true;
    }
    AppMethodBeat.o(79132);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void aZq(String paramString);
    
    public abstract void aas(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */