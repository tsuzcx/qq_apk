package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.util.Base64;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.io.File;
import org.json.JSONObject;

public class b
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  private static void a(Context paramContext, String paramString1, String paramString2, aw.a parama)
  {
    au.Hx();
    String str = EmojiLogic.J(com.tencent.mm.model.c.FL(), "", paramString1);
    EmojiInfo localEmojiInfo2 = i.getEmojiStorageMgr().uBb.acC(paramString1);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null)
    {
      localEmojiInfo1 = localEmojiInfo2;
      if (com.tencent.mm.a.e.bK(str)) {
        if (!o.Za(str)) {
          break label177;
        }
      }
    }
    label177:
    for (int i = EmojiInfo.uDb;; i = EmojiInfo.uDa)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString1;
      localEmojiInfo1.field_catalog = EmojiInfo.uCT;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = com.tencent.mm.a.e.bJ(str);
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_thumbUrl = paramString2;
      i.getEmojiStorageMgr().uBb.o(localEmojiInfo1);
      if (localEmojiInfo1 == null) {
        break label193;
      }
      boolean bool = i.aHP().a(paramContext, localEmojiInfo1, 18, q.Gj());
      y.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      parama.e(null, null);
      return;
    }
    parama.e("fail", null);
    return;
    label193:
    parama.e("fail", null);
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.d.c.tJ(paramString);
    if (paramString == null)
    {
      y.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.e("null_data", null);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    String str = paramString.optString("thumbUrl");
    paramString = paramString.optString("url");
    Object localObject2;
    if (!bk.bl((String)localObject1))
    {
      y.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bk.bE(paramString))
        {
          parama.e("fail", null);
          return;
        }
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + paramContext.getMessage());
        parama.e("fail", null);
        return;
      }
      localObject1 = g.o(paramString);
      au.Hx();
      localObject2 = EmojiLogic.J(com.tencent.mm.model.c.FL(), "", (String)localObject1);
      if ((!com.tencent.mm.a.e.bK((String)localObject2)) || (!g.bQ((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        com.tencent.mm.a.e.b((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      return;
    }
    if (!bk.bl(paramString))
    {
      y.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { paramString });
      localObject1 = new File(paramContext.getCacheDir(), g.o(paramString.getBytes()));
      if (((File)localObject1).exists())
      {
        paramString = g.m((File)localObject1);
        au.Hx();
        localObject2 = EmojiLogic.J(com.tencent.mm.model.c.FL(), "", paramString);
        if (!FileOp.bK((String)localObject2)) {
          FileOp.r(((File)localObject1).getAbsolutePath(), (String)localObject2);
        }
        a(paramContext, paramString, str, parama);
        return;
      }
      localObject2 = new c.a();
      ((c.a)localObject2).erf = true;
      ((c.a)localObject2).erh = ((File)localObject1).getAbsolutePath();
      ((c.a)localObject2).erJ = new Object[] { ((File)localObject1).getAbsolutePath() };
      localObject1 = ((c.a)localObject2).OV();
      i.aHr().a(paramString, null, (com.tencent.mm.as.a.a.c)localObject1, new b.1(this, paramString, paramContext, str, parama));
      return;
    }
    y.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
    parama.e("base64DataString_and_url_is_null", null);
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<com.tencent.mm.plugin.webview.luggage.e>.a parama) {}
  
  public final String name()
  {
    return "addToEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.b
 * JD-Core Version:    0.7.0.1
 */