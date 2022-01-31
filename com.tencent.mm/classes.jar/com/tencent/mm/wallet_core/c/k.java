package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.we;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class k
{
  k.a AWN;
  e AWO;
  c<we> AWP;
  public boolean AWQ;
  boolean cnz;
  String cyA;
  c<wj> oAp;
  String opC;
  String opD;
  int pdt;
  String title;
  boolean xog;
  
  public k()
  {
    AppMethodBeat.i(49052);
    this.cnz = false;
    this.oAp = new k.1(this);
    this.AWP = new c() {};
    this.AWQ = false;
    AppMethodBeat.o(49052);
  }
  
  public static k a(aym paramaym)
  {
    AppMethodBeat.i(142653);
    if (paramaym == null)
    {
      AppMethodBeat.o(142653);
      return null;
    }
    k localk = new k();
    localk.xog = paramaym.xog;
    localk.pdt = paramaym.pdt;
    localk.cyA = paramaym.cyA;
    localk.opC = paramaym.opC;
    localk.opD = paramaym.opD;
    localk.title = paramaym.title;
    localk.AWN = new k.a();
    if (paramaym.xoh != null)
    {
      localk.AWN.type = paramaym.xoh.type;
      localk.AWN.cwc = paramaym.xoh.cwc;
      localk.AWN.xGz = paramaym.xoh.xGz;
      localk.AWN.path = paramaym.xoh.path;
      localk.AWN.tMg = paramaym.xoh.tMg;
    }
    AppMethodBeat.o(142653);
    return localk;
  }
  
  public static k aX(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(49053);
    label268:
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.JumpRemind", "feed %s", new Object[] { paramJSONObject });
        Object localObject = paramJSONObject.optJSONObject("bindquerynew_resp");
        if (localObject == null) {
          break label268;
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
        if (paramJSONObject == null)
        {
          paramJSONObject = ((JSONObject)localObject).optJSONObject("jump_remind_info");
          if (paramJSONObject != null)
          {
            localObject = new k();
            ((k)localObject).pdt = paramJSONObject.optInt("jump_type");
            ((k)localObject).xog = paramJSONObject.optBoolean("is_pop_up_windows");
            ((k)localObject).cyA = paramJSONObject.optString("wording");
            ((k)localObject).opC = paramJSONObject.optString("left_button_wording");
            ((k)localObject).opD = paramJSONObject.optString("right_button_wording");
            ((k)localObject).title = paramJSONObject.optString("title");
            paramJSONObject = paramJSONObject.optJSONObject("url");
            ((k)localObject).AWN = new k.a();
            if (paramJSONObject != null)
            {
              ((k)localObject).AWN.type = paramJSONObject.optInt("type");
              ((k)localObject).AWN.cwc = paramJSONObject.optString("appid");
              ((k)localObject).AWN.xGz = paramJSONObject.optString("app_version");
              ((k)localObject).AWN.path = paramJSONObject.optString("path");
              ((k)localObject).AWN.tMg = paramJSONObject.optString("button_name");
            }
            AppMethodBeat.o(49053);
            return localObject;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ab.printErrStackTrace("MicroMsg.JumpRemind", paramJSONObject, "error create", new Object[0]);
        AppMethodBeat.o(49053);
        return null;
      }
    }
  }
  
  public final boolean a(Activity paramActivity, e parame)
  {
    AppMethodBeat.i(49054);
    this.AWO = parame;
    if (this.xog)
    {
      com.tencent.mm.ui.base.h.d(paramActivity, this.cyA, this.title, this.opD, this.opC, new k.3(this, paramActivity), new k.4(this, paramActivity));
      AppMethodBeat.o(49054);
      return true;
    }
    iK(paramActivity);
    AppMethodBeat.o(49054);
    return true;
  }
  
  public final boolean a(Activity paramActivity, f paramf)
  {
    AppMethodBeat.i(49055);
    boolean bool = a(paramActivity, new k.5(this, paramf, paramActivity));
    AppMethodBeat.o(49055);
    return bool;
  }
  
  public final boolean a(Activity paramActivity, g paramg)
  {
    AppMethodBeat.i(49056);
    com.tencent.mm.ui.base.h.d(paramActivity, this.cyA, this.title, this.opD, this.opC, new k.6(this, paramg), new k.7(this, paramg));
    AppMethodBeat.o(49056);
    return true;
  }
  
  public final boolean dSl()
  {
    return this.pdt == 1;
  }
  
  public final void dSm()
  {
    AppMethodBeat.i(142654);
    this.oAp.dead();
    this.AWP.dead();
    AppMethodBeat.o(142654);
  }
  
  final void iK(Context paramContext)
  {
    AppMethodBeat.i(49057);
    Intent localIntent;
    if ((paramContext instanceof h))
    {
      ((h)paramContext).register(new k.8(this));
      this.oAp.alive();
      this.AWP.alive();
      this.cnz = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.AWN.path);
      localIntent.putExtra("showShare", false);
      this.AWO.onEnter();
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(49057);
      return;
    }
    if (this.AWQ)
    {
      this.oAp.alive();
      this.AWP.alive();
      this.cnz = false;
      localIntent = new Intent();
      localIntent.putExtra("rawUrl", this.AWN.path);
      localIntent.putExtra("showShare", false);
      this.AWO.onEnter();
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(49057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.c.k
 * JD-Core Version:    0.7.0.1
 */