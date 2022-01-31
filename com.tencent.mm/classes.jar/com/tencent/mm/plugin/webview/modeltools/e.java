package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ov;
import com.tencent.mm.h.a.ov.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

public final class e
{
  String rhX = null;
  private a rhY;
  private c rhZ = new e.1(this);
  private c ria = new e.2(this);
  private c rib = new c()
  {
    private boolean a(ov paramAnonymousov)
    {
      if (((paramAnonymousov instanceof ov)) && (e.this.rhX.equalsIgnoreCase(paramAnonymousov.bYr.cardType)))
      {
        if (paramAnonymousov.bYr.bYs != 0) {
          break label60;
        }
        e.b(e.this, e.this.rhX);
      }
      label177:
      for (;;)
      {
        e.a(e.this);
        return false;
        label60:
        if (paramAnonymousov.bYr.bYs == 2)
        {
          e.a(e.this, e.this.rhX);
        }
        else
        {
          try
          {
            if (bk.bl(paramAnonymousov.bYr.bYt)) {
              break label177;
            }
            JSONObject localJSONObject = new JSONObject(paramAnonymousov.bYr.bYt);
            e.a(e.this, e.this.rhX, localJSONObject, paramAnonymousov.bYr.bYu);
          }
          catch (Exception paramAnonymousov)
          {
            y.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", new Object[] { paramAnonymousov.getMessage() });
            e.b(e.this, e.this.rhX);
          }
          continue;
          e.a(e.this, e.this.rhX, null, paramAnonymousov.bYr.bYu);
        }
      }
    }
  };
  
  public final boolean a(String paramString, Context paramContext, a parama)
  {
    if ("bank".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 7);
      paramString.putExtra("scan_bankcard_with_confirm_ui", true);
      paramString.addFlags(268435456);
      d.b(paramContext, "scanner", ".ui.BaseScanUI", paramString);
      this.rhY = parama;
      this.rhX = "bank";
      a.udP.c(this.rhZ);
      a.udP.c(this.ria);
      return true;
    }
    if ("identity_pay_auth".equalsIgnoreCase(paramString))
    {
      paramString = new Intent();
      paramString.putExtra("BaseScanUI_select_scan_mode", 11);
      d.b(paramContext, "scanner", ".ui.BaseScanUI", paramString);
      this.rhY = parama;
      this.rhX = "identity";
      a.udP.c(this.rhZ);
      a.udP.c(this.rib);
      return true;
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void SF(String paramString);
    
    public abstract void a(String paramString, JSONObject paramJSONObject, Bitmap paramBitmap);
    
    public abstract void uv(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.e
 * JD-Core Version:    0.7.0.1
 */