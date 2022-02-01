package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import org.json.JSONObject;

public class b
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  private static void a(Context paramContext, String paramString1, String paramString2, bq.a parama)
  {
    AppMethodBeat.i(78515);
    Object localObject = com.tencent.mm.emoji.d.a.gsI;
    String str = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", paramString1);
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl(paramString1);
    localObject = localEmojiInfo;
    if (localEmojiInfo == null)
    {
      localObject = localEmojiInfo;
      if (o.fB(str)) {
        if (!u.aRG(str)) {
          break label189;
        }
      }
    }
    label189:
    for (int i = EmojiInfo.OAc;; i = EmojiInfo.OAb)
    {
      localObject = new EmojiInfo();
      ((EmojiInfo)localObject).field_md5 = paramString1;
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.OzU;
      ((EmojiInfo)localObject).field_type = i;
      ((EmojiInfo)localObject).field_size = ((int)o.aZR(str));
      ((EmojiInfo)localObject).field_temp = 1;
      ((EmojiInfo)localObject).field_thumbUrl = paramString2;
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.I((EmojiInfo)localObject);
      if (localObject == null) {
        break label210;
      }
      boolean bool = com.tencent.mm.plugin.emoji.model.k.cig().a(paramContext, (EmojiInfo)localObject, 18, v.aAC());
      ae.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", new Object[] { Boolean.valueOf(bool) });
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
  
  public final void a(final Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78514);
    ae.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramString == null)
    {
      ae.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.f("null_data", null);
      AppMethodBeat.o(78514);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    final String str = paramString.optString("thumbUrl");
    Object localObject2 = paramString.optString("url");
    if (!bu.isNullOrNil((String)localObject1))
    {
      ae.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bu.cF(paramString))
        {
          parama.f("fail", null);
          AppMethodBeat.o(78514);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ae.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + paramContext.getMessage());
        parama.f("fail", null);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = com.tencent.mm.b.g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.d.a.gsI;
      localObject2 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", (String)localObject1);
      if ((!o.fB((String)localObject2)) || (!o.aRh((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        o.f((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      AppMethodBeat.o(78514);
      return;
    }
    if (!bu.isNullOrNil((String)localObject2))
    {
      ae.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { localObject2 });
      paramString = new com.tencent.mm.vfs.k(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
      if (paramString.exists())
      {
        localObject1 = o.aRh(w.B(paramString.mUri));
        localObject2 = com.tencent.mm.emoji.d.a.gsI;
        localObject2 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", (String)localObject1);
        if (!o.fB((String)localObject2)) {
          o.mF(w.B(paramString.fTh()), (String)localObject2);
        }
        a(paramContext, (String)localObject1, str, parama);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = new c.a();
      ((c.a)localObject1).igk = true;
      ((c.a)localObject1).hgD = w.B(paramString.fTh());
      ((c.a)localObject1).igJ = new Object[] { w.B(paramString.fTh()) };
      paramString = ((c.a)localObject1).aJu();
      com.tencent.mm.plugin.emoji.model.k.cie().a((String)localObject2, null, paramString, new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(78513);
          ae.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
          if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.EiG)))
          {
            paramAnonymousString = new com.tencent.mm.vfs.k(paramAnonymousVarArgs[0].toString());
            if (paramAnonymousString.exists())
            {
              paramAnonymousView = o.aRh(w.B(paramAnonymousString.mUri));
              paramAnonymousBitmap = com.tencent.mm.emoji.d.a.gsI;
              paramAnonymousBitmap = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", paramAnonymousView);
              o.mF(w.B(paramAnonymousString.fTh()), paramAnonymousBitmap);
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
    ae.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
    parama.f("base64DataString_and_url_is_null", null);
    AppMethodBeat.o(78514);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ced()
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