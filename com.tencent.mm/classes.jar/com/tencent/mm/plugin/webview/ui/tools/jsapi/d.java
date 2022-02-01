package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.b.p;
import d.v;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "GetRedPacketDoneTask", "plugin-webview_release"})
public final class d
  extends a
{
  private static final int EkT = 365;
  public static final d EkX;
  private static final String TAG = "MicroMsg.JsApiGetRedPacketDone";
  private static final String dKm = "getRedPacketDone";
  
  static
  {
    AppMethodBeat.i(164017);
    EkX = new d();
    TAG = "MicroMsg.JsApiGetRedPacketDone";
    EkT = 365;
    dKm = "getRedPacketDone";
    AppMethodBeat.o(164017);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207604);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    ad.i(TAG, "do get red packet done: " + paraml.xaW);
    if (p.i(paraml.xaW.get("shouldShowRedDot"), "1")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (p.i(paraml.xaW.get("isNeedRefresh"), "1")) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (p.i(paraml.xaW.get("shouldOpenSelectSkinPage"), "1")) {}
        for (boolean bool3 = true;; bool3 = false)
        {
          ad.i(TAG, "isNeedRefresh: " + paraml.xaW.get("isNeedRefresh") + ", shouldShowRedDot: " + paraml.xaW.get("shouldShowRedDot") + ", shouldOpenSelectSkinPage: " + bool3 + ", packageId: " + paraml.xaW.get("packetId"));
          Object localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("shouldShowRedDot", bool1);
          ((Bundle)localObject1).putBoolean("isNeedRefresh", bool2);
          h.a("com.tencent.mm", (Parcelable)localObject1, a.class);
          if (bool3)
          {
            localObject1 = new Intent();
            Object localObject2 = paraml.xaW.get("packetId");
            if (localObject2 == null)
            {
              paramd = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(207604);
              throw paramd;
            }
            ((Intent)localObject1).putExtra("packetId", (String)localObject2);
            if ((paramd.context instanceof MMActivity))
            {
              localObject2 = paramd.context;
              if (localObject2 == null)
              {
                paramd = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(207604);
                throw paramd;
              }
              ((MMActivity)localObject2).mmSetOnActivityResultCallback((MMActivity.a)new b(paramd, paraml));
            }
            com.tencent.mm.bs.d.b(paramd.context, "luckymoney", ".ui.LuckyMoneyPickEnvelopeUI", (Intent)localObject1, 789);
          }
          for (;;)
          {
            AppMethodBeat.o(207604);
            return true;
            paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", null);
          }
        }
      }
    }
  }
  
  public final int eOL()
  {
    return EkT;
  }
  
  public final String eOM()
  {
    return dKm;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone$GetRedPacketDoneTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-webview_release"})
  public static final class a
    implements k<Bundle, IPCVoid>
  {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class b
    implements MMActivity.a
  {
    b(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(207603);
      paramIntent = d.EkX;
      ad.i(d.getTAG(), "on select envelope result: ".concat(String.valueOf(paramInt2)));
      if (paramInt1 == 789)
      {
        if (paramInt2 == -1)
        {
          this.EkW.Dyx.i(paraml.DNz, paraml.kYO + ":ok confirm", null);
          AppMethodBeat.o(207603);
          return;
        }
        this.EkW.Dyx.i(paraml.DNz, paraml.kYO + ":ok cancel", null);
      }
      AppMethodBeat.o(207603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d
 * JD-Core Version:    0.7.0.1
 */