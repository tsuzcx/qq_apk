package com.tencent.mm.plugin.webview.jsapi;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.ddo;
import com.tencent.mm.protocal.protobuf.ddp;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.aa;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/BizJsApiAuthUtil;", "", "()V", "Companion", "GetAllUseUserInfoCgi", "SetModUseUserInfoCgi", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
{
  public static final a WDs = new a((byte)0);
  private static boolean WDt = true;
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/BizJsApiAuthUtil$Companion;", "", "()V", "AuthScopeItem_Refused", "", "AuthScopeItem_Unused", "AuthScopeItem_Used", "ModSceneType_JsapiUseUserInfo", "ModSceneType_UserCancelInfo", "ModSceneType_UserModAuth", "PrivacyScopeItem_Notified", "PrivacyScopeItem_Refused", "PrivacyScopeItem_Unused", "PrivacyScopeItem_Used", "canShowTestToast", "", "getCanShowTestToast", "()Z", "setCanShowTestToast", "(Z)V", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/jsapi/BizJsApiAuthUtil$SetModUseUserInfoCgi;", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/JSAPIModUseUserInfoResponse;", "sceneType", "", "appId", "", "jsapiName", "scope", "state", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "onCgiBack", "", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends b<ddp>
  {
    public c(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
    {
      AppMethodBeat.i(295265);
      ddo localddo = new ddo();
      localddo.scene_type = paramInt1;
      localddo.appid = paramString1;
      localddo.aaIK = paramString2;
      localddo.scope = paramString3;
      localddo.state = paramInt2;
      paramString1 = new c.a();
      paramString1.otE = ((com.tencent.mm.bx.a)localddo);
      paramString1.otF = ((com.tencent.mm.bx.a)new ddp());
      paramString1.uri = "/cgi-bin/mmbiz-bin/jsapi-moduseuserinfo";
      paramString1.funcId = 4810;
      c(paramString1.bEF());
      AppMethodBeat.o(295265);
    }
    
    private static final void bjH(String paramString)
    {
      AppMethodBeat.i(295273);
      s.u(paramString, "$showWords");
      aa.makeText(MMApplicationContext.getContext(), (CharSequence)paramString, 1).show();
      AppMethodBeat.o(295273);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.jsapi.a
 * JD-Core Version:    0.7.0.1
 */