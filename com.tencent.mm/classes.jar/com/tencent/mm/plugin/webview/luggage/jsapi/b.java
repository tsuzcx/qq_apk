package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.loader.b.k;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import org.json.JSONObject;

public class b
  extends bw<com.tencent.mm.plugin.webview.luggage.g>
{
  private static void a(Context paramContext, String paramString1, String paramString2, bv.a parama)
  {
    AppMethodBeat.i(78515);
    String str = EmojiLogic.W(d.bzQ(), "", paramString1);
    EmojiInfo localEmojiInfo2 = s.getEmojiStorageMgr().adju.bza(paramString1);
    EmojiInfo localEmojiInfo1 = localEmojiInfo2;
    if (localEmojiInfo2 == null)
    {
      localEmojiInfo1 = localEmojiInfo2;
      if (y.ZC(str)) {
        if (!ImgUtil.isGif(str)) {
          break label184;
        }
      }
    }
    label184:
    for (int i = EmojiInfo.aklO;; i = EmojiInfo.aklN)
    {
      localEmojiInfo1 = new EmojiInfo();
      localEmojiInfo1.field_md5 = paramString1;
      localEmojiInfo1.field_catalog = EmojiInfo.aklG;
      localEmojiInfo1.field_type = i;
      localEmojiInfo1.field_size = ((int)y.bEl(str));
      localEmojiInfo1.field_temp = 1;
      localEmojiInfo1.field_thumbUrl = paramString2;
      s.getEmojiStorageMgr().adju.K(localEmojiInfo1);
      if (localEmojiInfo1 == null) {
        break label205;
      }
      boolean bool = s.dAl().a(paramContext, localEmojiInfo1, 18, z.bAM());
      Log.i("MicroMsg.JsApiAddToEmotion", "doAddAction %b", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {
        break;
      }
      parama.j(null, null);
      AppMethodBeat.o(78515);
      return;
    }
    parama.j("fail", null);
    AppMethodBeat.o(78515);
    return;
    label205:
    parama.j("fail", null);
    AppMethodBeat.o(78515);
  }
  
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78514);
    Log.i("MicroMsg.JsApiAddToEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.JsApiAddToEmotion", "bundle is null");
      parama.j("null_data", null);
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
          parama.j("fail", null);
          AppMethodBeat.o(78514);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon error:" + paramContext.getMessage());
        parama.j("fail", null);
        AppMethodBeat.o(78514);
        return;
      }
      localObject1 = com.tencent.mm.b.g.getMessageDigest(paramString);
      localObject2 = EmojiLogic.W(d.bzQ(), "", (String)localObject1);
      if ((!y.ZC((String)localObject2)) || (!y.bub((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        y.f((String)localObject2, paramString, paramString.length);
      }
      a(paramContext, (String)localObject1, str, parama);
      AppMethodBeat.o(78514);
      return;
    }
    if (!Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[] { paramString });
      localObject1 = new u(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
      if (((u)localObject1).jKS())
      {
        paramString = y.bub(ah.v(((u)localObject1).mUri));
        localObject2 = EmojiLogic.W(d.bzQ(), "", paramString);
        if (!y.ZC((String)localObject2)) {
          y.O(ah.v(((u)localObject1).jKT()), (String)localObject2, false);
        }
        a(paramContext, paramString, str, parama);
        AppMethodBeat.o(78514);
        return;
      }
      localObject2 = new c.a();
      ((c.a)localObject2).oKp = true;
      ((c.a)localObject2).fullPath = ah.v(((u)localObject1).jKT());
      ((c.a)localObject2).oKP = new Object[] { ah.v(((u)localObject1).jKT()) };
      localObject1 = ((c.a)localObject2).bKx();
      s.dAi().a(paramString, null, (com.tencent.mm.modelimage.loader.a.c)localObject1, new k()
      {
        public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
        {
          AppMethodBeat.i(78513);
          Log.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
          if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(paramString)))
          {
            paramAnonymousString = new u(paramAnonymousVarArgs[0].toString());
            if (paramAnonymousString.jKS())
            {
              paramAnonymousView = y.bub(ah.v(paramAnonymousString.mUri));
              paramAnonymousBitmap = EmojiLogic.W(d.bzQ(), "", paramAnonymousView);
              y.O(ah.v(paramAnonymousString.jKT()), paramAnonymousBitmap, false);
              b.b(paramContext, paramAnonymousView, str, parama);
              AppMethodBeat.o(78513);
              return;
            }
          }
          parama.j("fail", null);
          AppMethodBeat.o(78513);
        }
      });
      AppMethodBeat.o(78514);
      return;
    }
    Log.e("MicroMsg.JsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
    parama.j("base64DataString_and_url_is_null", null);
    AppMethodBeat.o(78514);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dgI()
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