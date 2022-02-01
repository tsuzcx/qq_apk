package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import org.json.JSONObject;

public class b
  extends bo<com.tencent.mm.plugin.webview.luggage.f>
{
  private static void a(Context paramContext, String paramString1, String paramString2, bn.a parama)
  {
    AppMethodBeat.i(78515);
    Object localObject = com.tencent.mm.emoji.d.a.fSR;
    String str = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", paramString1);
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx(paramString1);
    localObject = localEmojiInfo;
    if (localEmojiInfo == null)
    {
      localObject = localEmojiInfo;
      if (i.eK(str)) {
        if (!t.aFm(str)) {
          break label189;
        }
      }
    }
    label189:
    for (int i = EmojiInfo.LBY;; i = EmojiInfo.LBX)
    {
      localObject = new EmojiInfo();
      ((EmojiInfo)localObject).field_md5 = paramString1;
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.LBQ;
      ((EmojiInfo)localObject).field_type = i;
      ((EmojiInfo)localObject).field_size = ((int)i.aMN(str));
      ((EmojiInfo)localObject).field_temp = 1;
      ((EmojiInfo)localObject).field_thumbUrl = paramString2;
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.J((EmojiInfo)localObject);
      if (localObject == null) {
        break label210;
      }
      boolean bool = com.tencent.mm.plugin.emoji.model.k.bUZ().a(paramContext, (EmojiInfo)localObject, 18, u.aqG());
      ad.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      parama.f(null, null);
      AppMethodBeat.o(78515);
      return;
    }
    parama.f("fail", null);
    AppMethodBeat.o(78515);
    return;
    label210:
    parama.f("fail", null);
    AppMethodBeat.o(78515);
  }
  
  public final void a(final Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78514);
    ad.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.HG(paramString);
    if (paramString == null)
    {
      ad.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.f("null_data", null);
      AppMethodBeat.o(78514);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    final String str = paramString.optString("thumbUrl");
    Object localObject2 = paramString.optString("url");
    if (!bt.isNullOrNil((String)localObject1))
    {
      ad.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bt.cw(paramString))
        {
          parama.f("fail", null);
          AppMethodBeat.o(78514);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + paramContext.getMessage());
        parama.f("fail", null);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.d.a.fSR;
      localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", (String)localObject1);
      if ((!i.eK((String)localObject2)) || (!i.aEN((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        i.f((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      AppMethodBeat.o(78514);
      return;
    }
    if (!bt.isNullOrNil((String)localObject2))
    {
      ad.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { localObject2 });
      paramString = new e(paramContext.getCacheDir(), g.getMessageDigest(((String)localObject2).getBytes()));
      if (paramString.exists())
      {
        localObject1 = i.aEN(q.B(paramString.mUri));
        localObject2 = com.tencent.mm.emoji.d.a.fSR;
        localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", (String)localObject1);
        if (!i.eK((String)localObject2)) {
          i.lC(q.B(paramString.fhU()), (String)localObject2);
        }
        a(paramContext, (String)localObject1, str, parama);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = new c.a();
      ((c.a)localObject1).hjU = true;
      ((c.a)localObject1).gjt = q.B(paramString.fhU());
      ((c.a)localObject1).hkt = new Object[] { q.B(paramString.fhU()) };
      paramString = ((c.a)localObject1).azc();
      com.tencent.mm.plugin.emoji.model.k.bUX().a((String)localObject2, null, paramString, new com.tencent.mm.aw.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(78513);
          ad.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
          if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.AUZ)))
          {
            paramAnonymousString = new e(paramAnonymousVarArgs[0].toString());
            if (paramAnonymousString.exists())
            {
              paramAnonymousView = i.aEN(q.B(paramAnonymousString.mUri));
              paramAnonymousBitmap = com.tencent.mm.emoji.d.a.fSR;
              paramAnonymousBitmap = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", paramAnonymousView);
              i.lC(q.B(paramAnonymousString.fhU()), paramAnonymousBitmap);
              b.b(paramContext, paramAnonymousView, str, parama);
              AppMethodBeat.o(78513);
              return;
            }
          }
          parama.f("fail", null);
          AppMethodBeat.o(78513);
        }
      });
      AppMethodBeat.o(78514);
      return;
    }
    ad.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
    parama.f("base64DataString_and_url_is_null", null);
    AppMethodBeat.o(78514);
  }
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.webview.luggage.f>.a parama) {}
  
  public final int bQV()
  {
    return 2;
  }
  
  public final String name()
  {
    return "addToEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.b
 * JD-Core Version:    0.7.0.1
 */