package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "GetRedPacketDoneTask", "plugin-webview_release"})
public final class d
  extends a
{
  private static final int CDJ = 365;
  public static final d JsC;
  private static final String TAG = "MicroMsg.JsApiGetRedPacketDone";
  private static final String edq = "getRedPacketDone";
  
  static
  {
    AppMethodBeat.i(164017);
    JsC = new d();
    TAG = "MicroMsg.JsApiGetRedPacketDone";
    CDJ = 365;
    edq = "getRedPacketDone";
    AppMethodBeat.o(164017);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final boolean a(f paramf, final n paramn)
  {
    AppMethodBeat.i(210552);
    p.h(paramf, "env");
    p.h(paramn, "msg");
    Log.i(TAG, "do get red packet done: " + paramn.params);
    if (p.j(paramn.params.get("shouldShowRedDot"), "1")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (p.j(paramn.params.get("isNeedRefresh"), "1")) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (p.j(paramn.params.get("shouldOpenSelectSkinPage"), "1")) {}
        for (boolean bool3 = true;; bool3 = false)
        {
          Log.i(TAG, "isNeedRefresh: " + paramn.params.get("isNeedRefresh") + ", shouldShowRedDot: " + paramn.params.get("shouldShowRedDot") + ", shouldOpenSelectSkinPage: " + bool3 + ", packageId: " + paramn.params.get("packetId"));
          Object localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("shouldShowRedDot", bool1);
          ((Bundle)localObject1).putBoolean("isNeedRefresh", bool2);
          com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localObject1, a.class);
          if (bool3)
          {
            localObject1 = new Intent();
            Object localObject2 = paramn.params.get("packetId");
            if (localObject2 == null)
            {
              paramf = new t("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(210552);
              throw paramf;
            }
            ((Intent)localObject1).putExtra("packetId", (String)localObject2);
            if ((paramf.context instanceof MMActivity))
            {
              localObject2 = paramf.context;
              if (localObject2 == null)
              {
                paramf = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(210552);
                throw paramf;
              }
              ((MMActivity)localObject2).mmSetOnActivityResultCallback((MMActivity.a)new b(paramf, paramn));
            }
            c.b(paramf.context, "luckymoney", ".ui.LuckyMoneyPickEnvelopeUI", (Intent)localObject1, 789);
          }
          for (;;)
          {
            AppMethodBeat.o(210552);
            return true;
            paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
          }
        }
      }
    }
  }
  
  public final int ePA()
  {
    return CDJ;
  }
  
  public final String ePz()
  {
    return edq;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone$GetRedPacketDoneTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-webview_release"})
  public static final class a
    implements k<Bundle, IPCVoid>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
  static final class b
    implements MMActivity.a
  {
    b(f paramf, n paramn) {}
    
    public final void d(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(210551);
      paramIntent = d.JsC;
      Log.i(d.getTAG(), "on select envelope result: ".concat(String.valueOf(paramInt2)));
      if (paramInt1 == 789)
      {
        if (paramInt2 == -1)
        {
          this.CDE.IQZ.h(paramn.ISe, paramn.mhO + ":ok confirm", null);
          AppMethodBeat.o(210551);
          return;
        }
        this.CDE.IQZ.h(paramn.ISe, paramn.mhO + ":ok cancel", null);
      }
      AppMethodBeat.o(210551);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d
 * JD-Core Version:    0.7.0.1
 */