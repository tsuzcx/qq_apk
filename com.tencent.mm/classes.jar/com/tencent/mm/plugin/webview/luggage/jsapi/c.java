package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(a<e>.a parama)
  {
    y.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = parama.bih.bhk.optJSONArray("scope");
    if (localObject == null)
    {
      y.e("MicroMsg.JsApiAuthorize", "scope is null!");
      parama.a("fail", null);
      return;
    }
    String str = ((e)parama.big).rbS.getAppId();
    if (bk.bl(str))
    {
      y.e("MicroMsg.JsApiAuthorize", "appId is null!");
      parama.a("fail", null);
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
    arn localarn = new arn();
    ((b.a)localObject).ecH = localarn;
    ((b.a)localObject).ecI = new aro();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).ecG = 1157;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    localarn.euK = str;
    localarn.tmX = localLinkedList;
    localarn.tmZ = 0;
    b.a(((b.a)localObject).Kt(), new c.1(this, parama, str));
  }
  
  public final String name()
  {
    return "authorize";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c
 * JD-Core Version:    0.7.0.1
 */