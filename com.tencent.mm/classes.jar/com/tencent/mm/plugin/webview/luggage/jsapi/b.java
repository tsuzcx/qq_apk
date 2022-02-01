package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import org.json.JSONObject;

public class b
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  private static void a(Context paramContext, String paramString1, String paramString2, br.a parama)
  {
    AppMethodBeat.i(78515);
    Object localObject = com.tencent.mm.emoji.e.a.hdT;
    String str = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", paramString1);
    EmojiInfo localEmojiInfo = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(paramString1);
    localObject = localEmojiInfo;
    if (localEmojiInfo == null)
    {
      localObject = localEmojiInfo;
      if (s.YS(str)) {
        if (!ImgUtil.isGif(str)) {
          break label189;
        }
      }
    }
    label189:
    for (int i = EmojiInfo.Uux;; i = EmojiInfo.Uuw)
    {
      localObject = new EmojiInfo();
      ((EmojiInfo)localObject).field_md5 = paramString1;
      ((EmojiInfo)localObject).field_catalog = EmojiInfo.Uup;
      ((EmojiInfo)localObject).field_type = i;
      ((EmojiInfo)localObject).field_size = ((int)s.boW(str));
      ((EmojiInfo)localObject).field_temp = 1;
      ((EmojiInfo)localObject).field_thumbUrl = paramString2;
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.J((EmojiInfo)localObject);
      if (localObject == null) {
        break label210;
      }
      boolean bool = com.tencent.mm.plugin.emoji.model.k.cGf().a(paramContext, (EmojiInfo)localObject, 18, z.aTY());
      Log.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      parama.i(null, null);
      AppMethodBeat.o(78515);
      return;
    }
    parama.i("fail", null);
    AppMethodBeat.o(78515);
    return;
    label210:
    parama.i("fail", null);
    AppMethodBeat.o(78515);
  }
  
  public final void a(final Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(78514);
    Log.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.i("null_data", null);
      AppMethodBeat.o(78514);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    final String str = paramString.optString("thumbUrl");
    Object localObject2 = paramString.optString("url");
    if (!Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (Util.isNullOrNil(paramString))
        {
          parama.i("fail", null);
          AppMethodBeat.o(78514);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + paramContext.getMessage());
        parama.i("fail", null);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = com.tencent.mm.b.g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.e.a.hdT;
      localObject2 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", (String)localObject1);
      if ((!s.YS((String)localObject2)) || (!s.bhK((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        s.f((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      AppMethodBeat.o(78514);
      return;
    }
    if (!Util.isNullOrNil((String)localObject2))
    {
      Log.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { localObject2 });
      paramString = new o(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
      if (paramString.exists())
      {
        localObject1 = s.bhK(aa.z(paramString.mUri));
        localObject2 = com.tencent.mm.emoji.e.a.hdT;
        localObject2 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", (String)localObject1);
        if (!s.YS((String)localObject2)) {
          s.nw(aa.z(paramString.her()), (String)localObject2);
        }
        a(paramContext, (String)localObject1, str, parama);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = new c.a();
      ((c.a)localObject1).jbf = true;
      ((c.a)localObject1).fullPath = aa.z(paramString.her());
      ((c.a)localObject1).jbE = new Object[] { aa.z(paramString.her()) };
      paramString = ((c.a)localObject1).bdv();
      com.tencent.mm.plugin.emoji.model.k.cGc().a((String)localObject2, null, paramString, new com.tencent.mm.av.a.c.k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(78513);
          Log.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
          if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.IVB)))
          {
            paramAnonymousString = new o(paramAnonymousVarArgs[0].toString());
            if (paramAnonymousString.exists())
            {
              paramAnonymousView = s.bhK(aa.z(paramAnonymousString.mUri));
              paramAnonymousBitmap = com.tencent.mm.emoji.e.a.hdT;
              paramAnonymousBitmap = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", paramAnonymousView);
              s.nw(aa.z(paramAnonymousString.her()), paramAnonymousBitmap);
              b.b(paramContext, paramAnonymousView, str, parama);
              AppMethodBeat.o(78513);
              return;
            }
          }
          parama.i("fail", null);
          AppMethodBeat.o(78513);
        }
      });
      AppMethodBeat.o(78514);
      return;
    }
    Log.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
    parama.i("base64DataString_and_url_is_null", null);
    AppMethodBeat.o(78514);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dTs()
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