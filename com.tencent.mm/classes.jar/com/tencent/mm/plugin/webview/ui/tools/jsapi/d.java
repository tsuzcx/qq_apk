package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "GetRedPacketDoneTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final d Xin;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(164017);
    Xin = new d();
    TAG = "MicroMsg.JsApiGetRedPacketDone";
    OOk = 365;
    idA = "getRedPacketDone";
    AppMethodBeat.o(164017);
  }
  
  private static final void a(h paramh, p paramp, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(297374);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    Log.i(TAG, s.X("on select envelope result: ", Integer.valueOf(paramInt2)));
    if (paramInt1 == 207)
    {
      if (paramInt2 == -1)
      {
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok confirm"), null);
        AppMethodBeat.o(297374);
        return;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok cancel"), null);
    }
    AppMethodBeat.o(297374);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297403);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Log.i(TAG, s.X("do get red packet done: ", paramp.params));
    if (s.p(paramp.params.get("shouldShowRedDot"), "1")) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (s.p(paramp.params.get("isNeedRefresh"), "1")) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        if (s.p(paramp.params.get("shouldOpenSelectSkinPage"), "1")) {}
        for (boolean bool3 = true;; bool3 = false)
        {
          Log.i(TAG, "isNeedRefresh: " + paramp.params.get("isNeedRefresh") + ", shouldShowRedDot: " + paramp.params.get("shouldShowRedDot") + ", shouldOpenSelectSkinPage: " + bool3 + ", packageId: " + paramp.params.get("packetId"));
          Object localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("shouldShowRedDot", bool1);
          ((Bundle)localObject1).putBoolean("isNeedRefresh", bool2);
          j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject1, a.class);
          if (bool3)
          {
            localObject1 = new Intent();
            Object localObject2 = paramp.params.get("packetId");
            if (localObject2 == null)
            {
              paramh = new NullPointerException("null cannot be cast to non-null type kotlin.String");
              AppMethodBeat.o(297403);
              throw paramh;
            }
            ((Intent)localObject1).putExtra("packetId", (String)localObject2);
            if ((paramh.context instanceof MMActivity)) {
              ((MMActivity)paramh.context).mmSetOnActivityResultCallback(new d..ExternalSyntheticLambda0(paramh, paramp));
            }
            c.b(paramh.context, "luckymoney", ".ui.LuckyMoneyPickEnvelopeUI", (Intent)localObject1, 207);
          }
          for (;;)
          {
            AppMethodBeat.o(297403);
            return true;
            paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
          }
        }
      }
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiGetRedPacketDone$GetRedPacketDoneTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "data", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m<Bundle, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.d
 * JD-Core Version:    0.7.0.1
 */