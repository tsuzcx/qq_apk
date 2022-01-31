package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.protocal.protobuf.axs;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6281);
    ab.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = parama.byF.bxK.optJSONArray("scope");
    if (localObject == null)
    {
      ab.e("MicroMsg.JsApiAuthorize", "scope is null!");
      parama.a("fail", null);
      AppMethodBeat.o(6281);
      return;
    }
    String str = ((e)parama.byE).uRD.getAppId();
    if (bo.isNullOrNil(str))
    {
      ab.e("MicroMsg.JsApiAuthorize", "appId is null!");
      parama.a("fail", null);
      AppMethodBeat.o(6281);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < ((JSONArray)localObject).length())
    {
      localLinkedList.add(((JSONArray)localObject).optString(i));
      i += 1;
    }
    localObject = new b.a();
    axs localaxs = new axs();
    ((b.a)localObject).fsX = localaxs;
    ((b.a)localObject).fsY = new axt();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).funcId = 1157;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localaxs.fKw = str;
    localaxs.xmO = localLinkedList;
    localaxs.xmQ = 0;
    b.a(((b.a)localObject).ado(), new c.1(this, parama, str));
    AppMethodBeat.o(6281);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "authorize";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c
 * JD-Core Version:    0.7.0.1
 */