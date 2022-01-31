package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.a.uk;
import com.tencent.mm.h.a.uo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class i
{
  boolean bGq = false;
  public String bQZ;
  public String lRE;
  public String lRF;
  c<uo> mas = new i.1(this);
  public int qho;
  public String title;
  public boolean tol;
  public i.a wAl;
  d wAm;
  c<uk> wAn = new i.2(this);
  
  public static i aB(JSONObject paramJSONObject)
  {
    label250:
    label253:
    for (;;)
    {
      try
      {
        y.i("MicroMsg.JumpRemind", "feed %s", new Object[] { paramJSONObject });
        Object localObject = paramJSONObject.optJSONObject("bindquerynew_resp");
        if (localObject == null) {
          break label253;
        }
        paramJSONObject = (JSONObject)localObject;
        JSONObject localJSONObject = paramJSONObject.optJSONObject("bindqueryresp");
        localObject = paramJSONObject;
        if (localJSONObject != null) {
          localObject = localJSONObject;
        }
        localJSONObject = ((JSONObject)localObject).optJSONObject("jumpRemind");
        paramJSONObject = localJSONObject;
        if (localJSONObject == null) {
          paramJSONObject = ((JSONObject)localObject).optJSONObject("jump_remind");
        }
        if (paramJSONObject != null) {
          break label250;
        }
        paramJSONObject = ((JSONObject)localObject).optJSONObject("jump_remind_info");
        if (paramJSONObject != null)
        {
          localObject = new i();
          ((i)localObject).qho = paramJSONObject.optInt("jump_type");
          ((i)localObject).tol = paramJSONObject.optBoolean("is_pop_up_windows");
          ((i)localObject).bQZ = paramJSONObject.optString("wording");
          ((i)localObject).lRE = paramJSONObject.optString("left_button_wording");
          ((i)localObject).lRF = paramJSONObject.optString("right_button_wording");
          ((i)localObject).title = paramJSONObject.optString("title");
          paramJSONObject = paramJSONObject.optJSONObject("url");
          ((i)localObject).wAl = new i.a();
          if (paramJSONObject != null)
          {
            ((i)localObject).wAl.type = paramJSONObject.optInt("type");
            ((i)localObject).wAl.bOL = paramJSONObject.optString("appid");
            ((i)localObject).wAl.tDL = paramJSONObject.optString("app_version");
            ((i)localObject).wAl.path = paramJSONObject.optString("path");
            ((i)localObject).wAl.tDM = paramJSONObject.optString("button_name");
          }
          return localObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        y.printErrStackTrace("MicroMsg.JumpRemind", paramJSONObject, "error create", new Object[0]);
      }
      return null;
    }
  }
  
  public final boolean a(Activity paramActivity, d paramd)
  {
    this.wAm = paramd;
    if (this.tol)
    {
      h.a(paramActivity, this.bQZ, this.title, this.lRF, this.lRE, new i.3(this, paramActivity), new i.4(this, paramActivity));
      return true;
    }
    hl(paramActivity);
    return true;
  }
  
  public final boolean a(Activity paramActivity, e parame)
  {
    return a(paramActivity, new i.5(this, parame, paramActivity));
  }
  
  public final boolean cMu()
  {
    return this.qho == 1;
  }
  
  final void hl(Context paramContext)
  {
    if ((paramContext instanceof f))
    {
      ((f)paramContext).a(new i.6(this));
      this.mas.cqo();
      this.wAn.cqo();
      this.bGq = false;
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.wAl.path);
      localIntent.putExtra("showShare", false);
      com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.i
 * JD-Core Version:    0.7.0.1
 */