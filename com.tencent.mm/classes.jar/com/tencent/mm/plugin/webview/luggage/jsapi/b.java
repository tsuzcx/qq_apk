package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import org.json.JSONObject;

public class b
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  private static void a(Context paramContext, String paramString1, String paramString2, br.a parama)
  {
    AppMethodBeat.i(78515);
    String str = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", paramString1);
    EmojiInfo localEmojiInfo2 = p.getEmojiStorageMgr().VFH.bxK(paramString1);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null)
    {
      localEmojiInfo1 = localEmojiInfo2;
      if (u.agG(str)) {
        if (!ImgUtil.isGif(str)) {
          break label184;
        }
      }
    }
    label184:
    for (int i = EmojiInfo.YCF;; i = EmojiInfo.YCE)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString1;
      localEmojiInfo1.field_catalog = EmojiInfo.YCx;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = ((int)u.bBQ(str));
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_thumbUrl = paramString2;
      p.getEmojiStorageMgr().VFH.K(localEmojiInfo1);
      if (localEmojiInfo1 == null) {
        break label205;
      }
      boolean bool = p.cUO().a(paramContext, localEmojiInfo1, 18, z.bcZ());
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
    label205:
    parama.i("fail", null);
    AppMethodBeat.o(78515);
  }
  
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(78514);
    Log.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.c.agO(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.i("null_data", null);
      AppMethodBeat.o(78514);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    final String str = paramString.optString("thumbUrl");
    paramString = paramString.optString("url");
    Object localObject2;
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
      localObject2 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", (String)localObject1);
      if ((!u.agG((String)localObject2)) || (!u.buc((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        u.f((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      AppMethodBeat.o(78514);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { paramString });
      localObject1 = new q(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
      if (((q)localObject1).ifE())
      {
        paramString = u.buc(((q)localObject1).getPath());
        localObject2 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", paramString);
        if (!u.agG((String)localObject2)) {
          u.on(((q)localObject1).bOF(), (String)localObject2);
        }
        a(paramContext, paramString, str, parama);
        AppMethodBeat.o(78514);
        return;
      }
      localObject2 = new c.a();
      ((c.a)localObject2).lRD = true;
      ((c.a)localObject2).fullPath = ((q)localObject1).bOF();
      ((c.a)localObject2).lSd = new Object[] { ((q)localObject1).bOF() };
      localObject1 = ((c.a)localObject2).bmL();
      p.cUL().a(paramString, null, (com.tencent.mm.ay.a.a.c)localObject1, new k()
      {
        public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(78513);
          Log.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
          if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(paramString)))
          {
            paramAnonymousString = new q(paramAnonymousVarArgs[0].toString());
            if (paramAnonymousString.ifE())
            {
              paramAnonymousView = u.buc(paramAnonymousString.getPath());
              paramAnonymousBitmap = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", paramAnonymousView);
              u.on(paramAnonymousString.bOF(), paramAnonymousBitmap);
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
  
  public final int cDj()
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