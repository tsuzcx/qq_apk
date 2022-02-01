package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wp;
import com.tencent.mm.model.ab;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bp
  extends bw<com.tencent.mm.plugin.webview.luggage.g>
{
  private void b(final Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78632);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene_from", 4);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    localIntent.putExtra("Retr_Msg_thumb_path", paramString);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", com.tencent.mm.plugin.webview.c.a.fast_faded_in);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).mmSetOnActivityResultCallback(new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78630);
          Log.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt1 == (bp.this.hashCode() & 0xFFFF)) {
            Log.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          }
          String str1;
          Object localObject2;
          Object localObject1;
          String str2;
          switch (paramAnonymousInt2)
          {
          default: 
            parama.j(null, null);
            AppMethodBeat.o(78630);
            return;
          case -1: 
            str1 = Util.nullAs(paramAnonymousIntent.getStringExtra("Select_Conv_User"), "");
            localObject2 = Util.nullAs(paramAnonymousIntent.getStringExtra("emoji_thumb_path"), "");
            localObject1 = s.getEmojiStorageMgr().adju.bza((String)localObject2);
            if (localObject1 == null)
            {
              str2 = EmojiLogic.W(d.bzQ(), "", (String)localObject2);
              if (y.ZC(str2)) {
                if (ImgUtil.isGif(str2))
                {
                  paramAnonymousInt1 = EmojiInfo.aklO;
                  localObject1 = s.getEmojiStorageMgr().adju.a((String)localObject2, "", EmojiInfo.aklG, paramAnonymousInt1, (int)y.bEl(str2), null, null, null, "");
                }
              }
            }
            break;
          }
          for (;;)
          {
            localObject2 = Util.stringsToList(Util.nullAs(str1, "").split(",")).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                str2 = (String)((Iterator)localObject2).next();
                if (localObject1 != null)
                {
                  s.dAl().a(str2, (EmojiInfo)localObject1, null);
                  continue;
                  paramAnonymousInt1 = EmojiInfo.aklN;
                  break;
                }
              }
            }
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
            if (!Util.isNullOrNil(paramAnonymousIntent))
            {
              localObject1 = new wp();
              ((wp)localObject1).iak.hgl = str1;
              ((wp)localObject1).iak.content = paramAnonymousIntent;
              ((wp)localObject1).iak.type = ab.IX(str1);
              ((wp)localObject1).iak.flags = 0;
              ((wp)localObject1).publish();
            }
            com.tencent.mm.ui.base.k.cZ(paramContext, paramContext.getResources().getString(c.i.app_shared));
            break;
            parama.j(null, null);
            AppMethodBeat.o(78630);
            return;
          }
        }
      });
      com.tencent.mm.br.c.d(paramContext, ".ui.transmit.SelectConversationUI", localIntent, hashCode() & 0xFFFF);
    }
    AppMethodBeat.o(78632);
  }
  
  public final void a(final Context paramContext, final String paramString, final bv.a parama)
  {
    AppMethodBeat.i(78631);
    Log.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.j("null_data", null);
      AppMethodBeat.o(78631);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    paramString = paramString.optString("url");
    if (!Util.isNullOrNil((String)localObject1))
    {
      Log.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
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
          AppMethodBeat.o(78631);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + paramContext.getMessage());
        parama.j("base64_decode_fail", null);
        AppMethodBeat.o(78631);
        return;
      }
      localObject1 = com.tencent.mm.b.g.getMessageDigest(paramString);
      localObject2 = EmojiLogic.W(d.bzQ(), "", (String)localObject1);
      if ((!y.ZC((String)localObject2)) || (!y.bub((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        y.f((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    Log.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { paramString });
    localObject1 = new u(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (((u)localObject1).jKS())
    {
      paramString = y.bub(ah.v(((u)localObject1).mUri));
      localObject2 = EmojiLogic.W(d.bzQ(), "", paramString);
      if (!y.ZC((String)localObject2)) {
        y.O(ah.v(((u)localObject1).jKT()), (String)localObject2, false);
      }
      b(paramContext, paramString, parama);
      AppMethodBeat.o(78631);
      return;
    }
    Object localObject2 = new com.tencent.mm.modelimage.loader.a.c.a();
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKp = true;
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).fullPath = ah.v(((u)localObject1).jKT());
    ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).oKP = new Object[] { ah.v(((u)localObject1).jKT()) };
    localObject1 = ((com.tencent.mm.modelimage.loader.a.c.a)localObject2).bKx();
    s.dAi().a(paramString, null, (com.tencent.mm.modelimage.loader.a.c)localObject1, new com.tencent.mm.modelimage.loader.b.k()
    {
      public final void onImageLoadComplete(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(78629);
        Log.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(paramString)))
        {
          paramAnonymousString = new u(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.jKS())
          {
            paramAnonymousView = y.bub(ah.v(paramAnonymousString.mUri));
            paramAnonymousBitmap = EmojiLogic.W(d.bzQ(), "", paramAnonymousView);
            y.O(ah.v(paramAnonymousString.jKT()), paramAnonymousBitmap, false);
            bp.a(bp.this, paramContext, paramAnonymousView, parama);
            AppMethodBeat.o(78629);
            return;
          }
        }
        parama.j("fail", null);
        AppMethodBeat.o(78629);
      }
    });
    AppMethodBeat.o(78631);
  }
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "shareEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bp
 * JD-Core Version:    0.7.0.1
 */