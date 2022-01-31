package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class af
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(com.tencent.luggage.e.a<e>.a parama)
  {
    y.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    com.tencent.mm.plugin.webview.luggage.c.a.RY(((e)parama.big).caV());
    Object localObject1 = parama.bih.bhk;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    y.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((e)parama.big).getUrl();
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      int i;
      Object localObject3;
      try
      {
        y.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
        if (((JSONArray)localObject2).length() != 0) {
          break label438;
        }
        parama.a("checkJsApi:param is empty", null);
        return;
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.JsApiPreVerify", "exception occur " + localException.getMessage());
        parama.a("", null);
        return;
      }
      if (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getString(i);
        if (!bk.bl((String)localObject3)) {
          localLinkedList.add(localObject3);
        }
        i += 1;
      }
      else
      {
        if ((bk.bl(localException)) || (localLinkedList.size() <= 0) || (bk.bl((String)localObject1)))
        {
          y.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
          parama.a("pre_verify_jsapi:fail_invalid_args", null);
          return;
        }
        localObject2 = new b.a();
        ((b.a)localObject2).ecH = new arf();
        ((b.a)localObject2).ecI = new arg();
        ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        ((b.a)localObject2).ecG = 1093;
        ((b.a)localObject2).ecJ = 0;
        ((b.a)localObject2).ecK = 0;
        localObject2 = ((b.a)localObject2).Kt();
        localObject3 = (arf)((com.tencent.mm.ah.b)localObject2).ecE.ecN;
        ((arf)localObject3).url = ((String)localObject1);
        ((arf)localObject3).bOL = localException;
        ((arf)localObject3).tmR = localLinkedList;
        ((arf)localObject3).bIK = str4;
        ((arf)localObject3).tmB = str3;
        ((arf)localObject3).signature = str2;
        ((arf)localObject3).tmC = str5;
        com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ah.b)localObject2, new af.a(parama, localException));
        return;
        label438:
        i = 0;
      }
    }
  }
  
  public final String name()
  {
    return "preVerifyJSAPI";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af
 * JD-Core Version:    0.7.0.1
 */