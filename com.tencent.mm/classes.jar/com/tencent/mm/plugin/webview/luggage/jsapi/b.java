package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.io.File;
import org.json.JSONObject;

public class b
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  private static void a(Context paramContext, String paramString1, String paramString2, bh.a parama)
  {
    AppMethodBeat.i(6275);
    String str = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", paramString1);
    EmojiInfo localEmojiInfo2 = i.getEmojiStorageMgr().yNn.asP(paramString1);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null)
    {
      localEmojiInfo1 = localEmojiInfo2;
      if (com.tencent.mm.a.e.cN(str)) {
        if (!com.tencent.mm.sdk.platformtools.r.aoY(str)) {
          break label185;
        }
      }
    }
    label185:
    for (int i = EmojiInfo.yPo;; i = EmojiInfo.yPn)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString1;
      localEmojiInfo1.field_catalog = EmojiInfo.yPg;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = com.tencent.mm.a.e.cM(str);
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_thumbUrl = paramString2;
      i.getEmojiStorageMgr().yNn.H(localEmojiInfo1);
      if (localEmojiInfo1 == null) {
        break label207;
      }
      boolean bool = i.blp().a(paramContext, localEmojiInfo1, 18, com.tencent.mm.model.r.Zn());
      ab.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      parama.c(null, null);
      AppMethodBeat.o(6275);
      return;
    }
    parama.c("fail", null);
    AppMethodBeat.o(6275);
    return;
    label207:
    parama.c("fail", null);
    AppMethodBeat.o(6275);
  }
  
  public final void a(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6274);
    ab.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.BJ(paramString);
    if (paramString == null)
    {
      ab.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.c("null_data", null);
      AppMethodBeat.o(6274);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    String str = paramString.optString("thumbUrl");
    paramString = paramString.optString("url");
    Object localObject2;
    if (!bo.isNullOrNil((String)localObject1))
    {
      ab.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bo.ce(paramString))
        {
          parama.c("fail", null);
          AppMethodBeat.o(6274);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ab.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + paramContext.getMessage());
        parama.c("fail", null);
        AppMethodBeat.o(6274);
        return;
      }
      localObject1 = g.w(paramString);
      localObject2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", (String)localObject1);
      if ((!com.tencent.mm.a.e.cN((String)localObject2)) || (!g.getMD5((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        com.tencent.mm.a.e.b((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      AppMethodBeat.o(6274);
      return;
    }
    if (!bo.isNullOrNil(paramString))
    {
      ab.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { paramString });
      localObject1 = new File(paramContext.getCacheDir(), g.w(paramString.getBytes()));
      if (((File)localObject1).exists())
      {
        paramString = g.r((File)localObject1);
        localObject2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", paramString);
        if (!FileOp.cN((String)localObject2)) {
          FileOp.C(((File)localObject1).getAbsolutePath(), (String)localObject2);
        }
        a(paramContext, paramString, str, parama);
        AppMethodBeat.o(6274);
        return;
      }
      localObject2 = new c.a();
      ((c.a)localObject2).eNM = true;
      ((c.a)localObject2).eNO = ((File)localObject1).getAbsolutePath();
      ((c.a)localObject2).eOi = new Object[] { ((File)localObject1).getAbsolutePath() };
      localObject1 = ((c.a)localObject2).ahY();
      i.bld().a(paramString, null, (c)localObject1, new b.1(this, paramString, paramContext, str, parama));
      AppMethodBeat.o(6274);
      return;
    }
    ab.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
    parama.c("base64DataString_and_url_is_null", null);
    AppMethodBeat.o(6274);
  }
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.webview.luggage.e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "addToEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.b
 * JD-Core Version:    0.7.0.1
 */