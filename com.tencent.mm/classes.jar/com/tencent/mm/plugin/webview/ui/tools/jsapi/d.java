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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import d.g.b.p;
import d.v;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "GetRedPacketDoneTask", "plugin-webview_release"})
public final class d
  extends a
{
  private static final int ECX = 365;
  public static final d EDb;
  private static final String TAG = "MicroMsg.JsApiGetRedPacketDone";
  private static final String dLB = "getRedPacketDone";
  
  static
  {
    AppMethodBeat.i(164017);
    EDb = new d();
    TAG = "MicroMsg.JsApiGetRedPacketDone";
    ECX = 365;
    dLB = "getRedPacketDone";
    AppMethodBeat.o(164017);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, final com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199360);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    ae.i(TAG, "do get red packet done: " + paraml.xqN);
    if (p.i(paraml.xqN.get("shouldShowRedDot"), "1")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (p.i(paraml.xqN.get("isNeedRefresh"), "1")) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (p.i(paraml.xqN.get("shouldOpenSelectSkinPage"), "1")) {}
        for (boolean bool3 = true;; bool3 = false)
        {
          ae.i(TAG, "isNeedRefresh: " + paraml.xqN.get("isNeedRefresh") + ", shouldShowRedDot: " + paraml.xqN.get("shouldShowRedDot") + ", shouldOpenSelectSkinPage: " + bool3 + ", packageId: " + paraml.xqN.get("packetId"));
          Object localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("shouldShowRedDot", bool1);
          ((Bundle)localObject1).putBoolean("isNeedRefresh", bool2);
          h.a("com.tencent.mm", (Parcelable)localObject1, a.class);
          if (bool3)
          {
            localObject1 = new Intent();
            Object localObject2 = paraml.xqN.get("packetId");
            if (localObject2 == null)
            {
              paramd = new v("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(199360);
              throw paramd;
            }
            ((Intent)localObject1).putExtra("packetId", (String)localObject2);
            if ((paramd.context instanceof MMActivity))
            {
              localObject2 = paramd.context;
              if (localObject2 == null)
              {
                paramd = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(199360);
                throw paramd;
              }
              ((MMActivity)localObject2).mmSetOnActivityResultCallback((MMActivity.a)new b(paramd, paraml));
            }
            com.tencent.mm.br.d.b(paramd.context, "luckymoney", ".ui.LuckyMoneyPickEnvelopeUI", (Intent)localObject1, 789);
          }
          for (;;)
          {
            AppMethodBeat.o(199360);
            return true;
            paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
          }
        }
      }
    }
  }
  
  public final int eSw()
  {
    return ECX;
  }
  
  public final String eSx()
  {
    return dLB;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone$GetRedPacketDoneTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-webview_release"})
  public static final class a
    implements k<Bundle, IPCVoid>
  {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class b
    implements MMActivity.a
  {
    b(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(199359);
      paramIntent = d.EDb;
      ae.i(d.getTAG(), "on select envelope result: ".concat(String.valueOf(paramInt2)));
      if (paramInt1 == 789)
      {
        if (paramInt2 == -1)
        {
          this.EDa.DQe.i(paraml.Efy, paraml.lcx + ":ok confirm", null);
          AppMethodBeat.o(199359);
          return;
        }
        this.EDa.DQe.i(paraml.Efy, paraml.lcx + ":ok cancel", null);
      }
      AppMethodBeat.o(199359);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d
 * JD-Core Version:    0.7.0.1
 */