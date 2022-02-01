package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.az;
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
    Object localObject = com.tencent.mm.emoji.d.a.fWM;
    String str = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", paramString1);
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT(paramString1);
    localObject = localEmojiInfo;
    if (localEmojiInfo == null)
    {
      localObject = localEmojiInfo;
      if (i.eA(str)) {
        if (!s.aKD(str)) {
          break label189;
        }
      }
    }
    label189:
    for (int i = EmojiInfo.KfZ;; i = EmojiInfo.KfY)
    {
      localObject = new EmojiInfo();
      ((EmojiInfo)localObject).field_md5 = paramString1;
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.Jss;
      ((EmojiInfo)localObject).field_type = i;
      ((EmojiInfo)localObject).field_size = ((int)i.aSp(str));
      ((EmojiInfo)localObject).field_temp = 1;
      ((EmojiInfo)localObject).field_thumbUrl = paramString2;
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.J((EmojiInfo)localObject);
      if (localObject == null) {
        break label210;
      }
      boolean bool = com.tencent.mm.plugin.emoji.model.k.ccm().a(paramContext, (EmojiInfo)localObject, 18, u.axw());
      ac.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", new Object[] { Boolean.valueOf(bool) });
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
    ac.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.LK(paramString);
    if (paramString == null)
    {
      ac.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.f("null_data", null);
      AppMethodBeat.o(78514);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    final String str = paramString.optString("thumbUrl");
    Object localObject2 = paramString.optString("url");
    if (!bs.isNullOrNil((String)localObject1))
    {
      ac.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bs.cv(paramString))
        {
          parama.f("fail", null);
          AppMethodBeat.o(78514);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ac.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + paramContext.getMessage());
        parama.f("fail", null);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.d.a.fWM;
      localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", (String)localObject1);
      if ((!i.eA((String)localObject2)) || (!i.aKe((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        i.f((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      AppMethodBeat.o(78514);
      return;
    }
    if (!bs.isNullOrNil((String)localObject2))
    {
      ac.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { localObject2 });
      paramString = new e(paramContext.getCacheDir(), g.getMessageDigest(((String)localObject2).getBytes()));
      if (paramString.exists())
      {
        localObject1 = i.aKe(q.B(paramString.mUri));
        localObject2 = com.tencent.mm.emoji.d.a.fWM;
        localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", (String)localObject1);
        if (!i.eA((String)localObject2)) {
          i.lZ(q.B(paramString.fxV()), (String)localObject2);
        }
        a(paramContext, (String)localObject1, str, parama);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = new c.a();
      ((c.a)localObject1).hKx = true;
      ((c.a)localObject1).gKe = q.B(paramString.fxV());
      ((c.a)localObject1).hKW = new Object[] { q.B(paramString.fxV()) };
      paramString = ((c.a)localObject1).aFT();
      com.tencent.mm.plugin.emoji.model.k.cck().a((String)localObject2, null, paramString, new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(78513);
          ac.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
          if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.Cnm)))
          {
            paramAnonymousString = new e(paramAnonymousVarArgs[0].toString());
            if (paramAnonymousString.exists())
            {
              paramAnonymousView = i.aKe(q.B(paramAnonymousString.mUri));
              paramAnonymousBitmap = com.tencent.mm.emoji.d.a.fWM;
              paramAnonymousBitmap = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", paramAnonymousView);
              i.lZ(q.B(paramAnonymousString.fxV()), paramAnonymousBitmap);
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
    ac.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
    parama.f("base64DataString_and_url_is_null", null);
    AppMethodBeat.o(78514);
  }
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.webview.luggage.f>.a parama) {}
  
  public final int bYk()
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