package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.sk;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bh
  extends bo<com.tencent.mm.plugin.webview.luggage.f>
{
  private void b(final Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78632);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene_from", 4);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    localIntent.putExtra("Retr_Msg_thumb_path", paramString);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).mmSetOnActivityResultCallback(new MMActivity.a()
      {
        public final void c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78630);
          ac.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt1 == (bh.this.hashCode() & 0xFFFF)) {
            ac.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          }
          String str;
          Object localObject2;
          Object localObject1;
          Object localObject3;
          switch (paramAnonymousInt2)
          {
          default: 
            parama.f(null, null);
            AppMethodBeat.o(78630);
            return;
          case -1: 
            str = bs.bG(paramAnonymousIntent.getStringExtra("Select_Conv_User"), "");
            localObject2 = bs.bG(paramAnonymousIntent.getStringExtra("emoji_thumb_path"), "");
            localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.aOT((String)localObject2);
            if (localObject1 == null)
            {
              localObject3 = com.tencent.mm.emoji.d.a.fWM;
              localObject3 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", (String)localObject2);
              if (i.eA((String)localObject3)) {
                if (s.aKD((String)localObject3))
                {
                  paramAnonymousInt1 = EmojiInfo.KfZ;
                  localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.b((String)localObject2, "", EmojiInfo.Jss, paramAnonymousInt1, (int)i.aSp((String)localObject3), null, "");
                }
              }
            }
            break;
          }
          for (;;)
          {
            localObject2 = bs.S(bs.bG(str, "").split(",")).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (localObject1 != null)
                {
                  com.tencent.mm.plugin.emoji.model.k.ccm().a((String)localObject3, (EmojiInfo)localObject1, null);
                  continue;
                  paramAnonymousInt1 = EmojiInfo.KfY;
                  break;
                }
              }
            }
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
            if (!bs.isNullOrNil(paramAnonymousIntent))
            {
              localObject1 = new sk();
              ((sk)localObject1).dvv.dvw = str;
              ((sk)localObject1).dvv.content = paramAnonymousIntent;
              ((sk)localObject1).dvv.type = w.xt(str);
              ((sk)localObject1).dvv.flags = 0;
              com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
            }
            h.cg(paramContext, paramContext.getResources().getString(2131755894));
            break;
            parama.f(null, null);
            AppMethodBeat.o(78630);
            return;
          }
        }
      });
      d.c(paramContext, ".ui.transmit.SelectConversationUI", localIntent, hashCode() & 0xFFFF);
    }
    AppMethodBeat.o(78632);
  }
  
  public final void a(final Context paramContext, String paramString, final bn.a parama)
  {
    AppMethodBeat.i(78631);
    ac.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.LK(paramString);
    if (paramString == null)
    {
      ac.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.f("null_data", null);
      AppMethodBeat.o(78631);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    Object localObject2 = paramString.optString("url");
    if (!bs.isNullOrNil((String)localObject1))
    {
      ac.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
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
          AppMethodBeat.o(78631);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ac.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + paramContext.getMessage());
        parama.f("base64_decode_fail", null);
        AppMethodBeat.o(78631);
        return;
      }
      localObject1 = g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.d.a.fWM;
      localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", (String)localObject1);
      if ((!i.eA((String)localObject2)) || (!i.aKe((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        i.f((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    ac.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { localObject2 });
    paramString = new e(paramContext.getCacheDir(), g.getMessageDigest(((String)localObject2).getBytes()));
    if (paramString.exists())
    {
      localObject1 = i.aKe(q.B(paramString.mUri));
      localObject2 = com.tencent.mm.emoji.d.a.fWM;
      localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", (String)localObject1);
      if (!i.eA((String)localObject2)) {
        i.lZ(q.B(paramString.fxV()), (String)localObject2);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
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
        AppMethodBeat.i(78629);
        ac.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.Cnm)))
        {
          paramAnonymousString = new e(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            paramAnonymousView = i.aKe(q.B(paramAnonymousString.mUri));
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.fWM;
            paramAnonymousBitmap = EmojiLogic.P(com.tencent.mm.emoji.d.a.adJ(), "", paramAnonymousView);
            i.lZ(q.B(paramAnonymousString.fxV()), paramAnonymousBitmap);
            bh.a(bh.this, paramContext, paramAnonymousView, parama);
            AppMethodBeat.o(78629);
            return;
          }
        }
        parama.f("fail", null);
        AppMethodBeat.o(78629);
      }
    });
    AppMethodBeat.o(78631);
  }
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.webview.luggage.f>.a parama) {}
  
  public final int bYk()
  {
    return 2;
  }
  
  public final String name()
  {
    return "shareEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bh
 * JD-Core Version:    0.7.0.1
 */