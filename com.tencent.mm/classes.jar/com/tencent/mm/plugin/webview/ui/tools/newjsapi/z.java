package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.w;
import com.tencent.mm.plugin.textstatus.a.w.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.ax;
import com.tencent.mm.plugin.textstatus.proto.az;
import com.tencent.mm.plugin.textstatus.proto.m;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPublishTextState;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "KEY_REQUEST_DATA", "", "KEY_RESULT_CODE", "KEY_RESULT_DATA", "TAG", "TYPE_H5", "TYPE_WEBSEARCH", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "type2JumpTypeMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getType2JumpTypeMap", "()Ljava/util/HashMap;", "getJumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "jumpJson", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "isArgumentValid", "sourceId", "sourceName", "sourceIconUrl", "jumpInfos", "JsSetStatusTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends a
{
  private static final int OOk;
  public static final z XnM;
  private static final HashMap<String, String> XnN;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297746);
    XnM = new z();
    OOk = 424;
    idA = "publishTextState";
    HashMap localHashMap = new HashMap();
    localHashMap.put("websearch", "9");
    localHashMap.put("h5", "10");
    XnN = localHashMap;
    AppMethodBeat.o(297746);
  }
  
  private static final void b(h paramh, p paramp, Bundle paramBundle)
  {
    AppMethodBeat.i(297740);
    s.u(paramh, "$env");
    s.u(paramp, "$msg");
    int i = paramBundle.getInt("KEY_RESULT_CODE");
    paramBundle = (Bundle)paramBundle.getParcelable("KEY_RESULT_DATA");
    if (i == -1)
    {
      Object localObject = new m();
      if (paramBundle == null)
      {
        paramBundle = null;
        if (paramBundle != null) {
          ((m)localObject).parseFrom(paramBundle);
        }
        paramBundle = ((m)localObject).Okz;
        if (paramBundle != null) {
          break label141;
        }
        paramBundle = "";
      }
      label141:
      for (;;)
      {
        localObject = (Map)new LinkedHashMap();
        ((Map)localObject).put("icon_id", paramBundle);
        paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), (Map)localObject);
        AppMethodBeat.o(297740);
        return;
        paramBundle = paramBundle.getByteArray("select_status_info");
        break;
      }
    }
    paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail_cancel"), null);
    AppMethodBeat.o(297740);
  }
  
  private static List<TextStatusJumpInfo> bmL(String paramString)
  {
    AppMethodBeat.i(297732);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1)))
    {
      i = 1;
      if (i != 0) {}
    }
    try
    {
      localObject1 = new JSONObject(paramString).optJSONArray("infos");
      if (localObject1 == null) {
        break label293;
      }
      k = ((JSONArray)localObject1).length();
      if (k < 0) {
        break label293;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        int k;
        String str;
        label132:
        label293:
        label353:
        Log.printErrStackTrace("MicroMsg.JsApiPublishTextState", paramString, "parse jumpJSON", new Object[0]);
        continue;
        i += 1;
        continue;
        int j = 1;
        continue;
        j = 1;
        continue;
        j = 1;
      }
    }
    paramString = ((JSONArray)localObject1).optJSONObject(i);
    if (paramString != null)
    {
      str = paramString.optString("type");
      paramString = paramString.optString("buf");
      str = (String)XnN.get(str);
    }
    try
    {
      localObject2 = (CharSequence)paramString;
      if (localObject2 == null) {
        break label487;
      }
      if (!n.bp((CharSequence)localObject2)) {
        break label353;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        Log.printErrStackTrace("MicroMsg.JsApiPublishTextState", paramString, "parse keyBusiBuf err", new Object[0]);
        paramString = null;
        continue;
        j = 0;
        continue;
        j = 0;
      }
    }
    if (j == 0) {
      if (s.p(str, "9"))
      {
        s.s(paramString, "buf");
        paramString = URLDecoder.decode(Uri.parse(aa.bmM(paramString)).getQueryParameter("keyword"), "UTF-8");
        localObject2 = new az();
        ((az)localObject2).query = paramString;
        paramString = ((az)localObject2).toByteArray();
        paramString = Base64.encodeToString(paramString, 0, paramString.length, 0);
      }
    }
    for (;;)
    {
      localObject2 = (CharSequence)str;
      if (localObject2 == null) {
        break label492;
      }
      if (!n.bp((CharSequence)localObject2)) {
        break label452;
      }
      break label492;
      if (j == 0)
      {
        localObject2 = (CharSequence)paramString;
        if (localObject2 == null) {
          break label497;
        }
        if (!n.bp((CharSequence)localObject2)) {
          break label457;
        }
        break label497;
        if (j == 0)
        {
          localObject2 = new TextStatusJumpInfo();
          ((TextStatusJumpInfo)localObject2).jumpType = str;
          ((TextStatusJumpInfo)localObject2).keyBusiBuf = paramString;
          paramString = ah.aiuX;
          localArrayList.add(localObject2);
        }
      }
      if (i != k) {
        break label480;
      }
      if (localArrayList.size() > 0)
      {
        paramString = new TextStatusJumpInfo();
        paramString.jumpType = "3";
        paramString.busiBuf = "https://support.weixin.qq.com/security/readtemplate?t=w_security_center_website/upgrade&scene=1#wechat_redirect";
        localObject1 = ah.aiuX;
        localArrayList.add(paramString);
      }
      paramString = (List)localArrayList;
      AppMethodBeat.o(297732);
      return paramString;
      i = 0;
      break;
      j = 0;
      break label132;
      if (s.p(str, "10"))
      {
        s.s(paramString, "buf");
        paramString = URLDecoder.decode(Uri.parse(aa.bmM(paramString)).getQueryParameter("url"), "UTF-8");
        localObject2 = new ax();
        ((ax)localObject2).url = paramString;
        paramString = ((ax)localObject2).toByteArray();
        paramString = Base64.encodeToString(paramString, 0, paramString.length, 0);
      }
      else
      {
        paramString = null;
      }
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297776);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    if (!ac.hFS())
    {
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail_not_support"), null);
      AppMethodBeat.o(297776);
      return true;
    }
    Object localObject1 = paramp.params.get("sourceId");
    label116:
    Object localObject3;
    label145:
    Object localObject4;
    label174:
    Object localObject5;
    label203:
    Object localObject6;
    label232:
    Object localObject7;
    label261:
    Object localObject8;
    label290:
    Object localObject9;
    label319:
    label348:
    boolean bool;
    label365:
    int i;
    if ((localObject1 instanceof String))
    {
      localObject1 = (String)localObject1;
      localObject2 = paramp.params.get("sourceActivityId");
      if (!(localObject2 instanceof String)) {
        break label466;
      }
      localObject2 = (String)localObject2;
      localObject3 = paramp.params.get("sourceVerifyInfo");
      if (!(localObject3 instanceof String)) {
        break label472;
      }
      localObject3 = (String)localObject3;
      localObject4 = paramp.params.get("sourceName");
      if (!(localObject4 instanceof String)) {
        break label478;
      }
      localObject4 = (String)localObject4;
      localObject5 = paramp.params.get("sourceIconURL");
      if (!(localObject5 instanceof String)) {
        break label484;
      }
      localObject5 = (String)localObject5;
      localObject6 = paramp.params.get("iconId");
      if (!(localObject6 instanceof String)) {
        break label490;
      }
      localObject6 = (String)localObject6;
      localObject7 = paramp.params.get("image");
      if (!(localObject7 instanceof String)) {
        break label496;
      }
      localObject7 = (String)localObject7;
      localObject8 = paramp.params.get("desc");
      if (!(localObject8 instanceof String)) {
        break label502;
      }
      localObject8 = (String)localObject8;
      localObject9 = paramp.params.get("jumpJSON");
      if (!(localObject9 instanceof String)) {
        break label508;
      }
      localObject9 = (String)localObject9;
      localObject10 = paramp.params.get("hideToast");
      if (!(localObject10 instanceof String)) {
        break label514;
      }
      localObject10 = (String)localObject10;
      if ((localObject10 == null) || (Integer.parseInt((String)localObject10) != 1)) {
        break label520;
      }
      bool = true;
      Log.i("MicroMsg.JsApiPublishTextState", s.X("publishTextState params:", paramp.params));
      localObject9 = bmL((String)localObject9);
      s.u(localObject9, "jumpInfos");
      localObject10 = (CharSequence)localObject1;
      if ((localObject10 != null) && (!n.bp((CharSequence)localObject10))) {
        break label526;
      }
      i = 1;
      label418:
      if (i == 0) {
        break label531;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label623;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail_invalid_arguments"), null);
      AppMethodBeat.o(297776);
      return true;
      localObject1 = null;
      break;
      label466:
      localObject2 = null;
      break label116;
      label472:
      localObject3 = null;
      break label145;
      label478:
      localObject4 = null;
      break label174;
      label484:
      localObject5 = null;
      break label203;
      label490:
      localObject6 = null;
      break label232;
      label496:
      localObject7 = null;
      break label261;
      label502:
      localObject8 = null;
      break label290;
      label508:
      localObject9 = null;
      break label319;
      label514:
      localObject10 = null;
      break label348;
      label520:
      bool = false;
      break label365;
      label526:
      i = 0;
      break label418;
      label531:
      localObject10 = (CharSequence)localObject4;
      if ((localObject10 == null) || (n.bp((CharSequence)localObject10))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label567;
        }
        i = 0;
        break;
      }
      label567:
      localObject10 = (CharSequence)localObject5;
      if ((localObject10 == null) || (n.bp((CharSequence)localObject10))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label603;
        }
        i = 0;
        break;
      }
      label603:
      if (((List)localObject9).isEmpty()) {
        i = 0;
      } else {
        i = 1;
      }
    }
    label623:
    Object localObject10 = new w.a();
    ((w.a)localObject10).bdr((String)localObject6);
    ((w.a)localObject10).bdx((String)localObject4);
    ((w.a)localObject10).bdu((String)localObject1);
    ((w.a)localObject10).bdv((String)localObject2);
    ((w.a)localObject10).bdw((String)localObject3);
    ((w.a)localObject10).bdy((String)localObject5);
    ((w.a)localObject10).bdt((String)localObject7);
    ((w.a)localObject10).bds((String)localObject8);
    ((w.a)localObject10).ls((List)localObject9);
    ((w.a)localObject10).ThS.Tor = bool;
    localObject1 = ((w.a)localObject10).ThS;
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putByteArray("KEY_REQUEST_DATA", ((w)localObject1).toByteArray());
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, localObject2, a.class, new z..ExternalSyntheticLambda0(paramh, paramp));
    AppMethodBeat.o(297776);
    return true;
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiPublishTextState$JsSetStatusTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.z
 * JD-Core Version:    0.7.0.1
 */