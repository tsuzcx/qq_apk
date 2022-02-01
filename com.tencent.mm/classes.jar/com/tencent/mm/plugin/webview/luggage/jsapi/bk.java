package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.bd;
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

public class bk
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  private void b(final Context paramContext, String paramString, final bq.a parama)
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
          ad.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt1 == (bk.this.hashCode() & 0xFFFF)) {
            ad.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
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
            str = bt.bI(paramAnonymousIntent.getStringExtra("Select_Conv_User"), "");
            localObject2 = bt.bI(paramAnonymousIntent.getStringExtra("emoji_thumb_path"), "");
            localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.aUK((String)localObject2);
            if (localObject1 == null)
            {
              localObject3 = com.tencent.mm.emoji.d.a.gqn;
              localObject3 = EmojiLogic.Q(com.tencent.mm.emoji.d.a.agp(), "", (String)localObject2);
              if (i.fv((String)localObject3)) {
                if (t.aQj((String)localObject3))
                {
                  paramAnonymousInt1 = EmojiInfo.OeV;
                  localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().ILn.b((String)localObject2, "", EmojiInfo.OeN, paramAnonymousInt1, (int)i.aYo((String)localObject3), null, "");
                }
              }
            }
            break;
          }
          for (;;)
          {
            localObject2 = bt.U(bt.bI(str, "").split(",")).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (localObject1 != null)
                {
                  com.tencent.mm.plugin.emoji.model.k.cgQ().a((String)localObject3, (EmojiInfo)localObject1, null);
                  continue;
                  paramAnonymousInt1 = EmojiInfo.OeU;
                  break;
                }
              }
            }
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
            if (!bt.isNullOrNil(paramAnonymousIntent))
            {
              localObject1 = new sx();
              ((sx)localObject1).dHy.dHz = str;
              ((sx)localObject1).dHy.content = paramAnonymousIntent;
              ((sx)localObject1).dHy.type = w.Ar(str);
              ((sx)localObject1).dHy.flags = 0;
              com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
            }
            h.cl(paramContext, paramContext.getResources().getString(2131755894));
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
  
  public final void a(final Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(78631);
    ad.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Pe(paramString);
    if (paramString == null)
    {
      ad.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.f("null_data", null);
      AppMethodBeat.o(78631);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    Object localObject2 = paramString.optString("url");
    if (!bt.isNullOrNil((String)localObject1))
    {
      ad.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bt.cC(paramString))
        {
          parama.f("fail", null);
          AppMethodBeat.o(78631);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + paramContext.getMessage());
        parama.f("base64_decode_fail", null);
        AppMethodBeat.o(78631);
        return;
      }
      localObject1 = com.tencent.mm.b.g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.d.a.gqn;
      localObject2 = EmojiLogic.Q(com.tencent.mm.emoji.d.a.agp(), "", (String)localObject1);
      if ((!i.fv((String)localObject2)) || (!i.aPK((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        i.f((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    ad.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { localObject2 });
    paramString = new e(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
    if (paramString.exists())
    {
      localObject1 = i.aPK(q.B(paramString.mUri));
      localObject2 = com.tencent.mm.emoji.d.a.gqn;
      localObject2 = EmojiLogic.Q(com.tencent.mm.emoji.d.a.agp(), "", (String)localObject1);
      if (!i.fv((String)localObject2)) {
        i.mz(q.B(paramString.fOK()), (String)localObject2);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    localObject1 = new c.a();
    ((c.a)localObject1).idr = true;
    ((c.a)localObject1).hdP = q.B(paramString.fOK());
    ((c.a)localObject1).idR = new Object[] { q.B(paramString.fOK()) };
    paramString = ((c.a)localObject1).aJc();
    com.tencent.mm.plugin.emoji.model.k.cgO().a((String)localObject2, null, paramString, new com.tencent.mm.aw.a.c.k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(78629);
        ad.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.DQG)))
        {
          paramAnonymousString = new e(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            paramAnonymousView = i.aPK(q.B(paramAnonymousString.mUri));
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.gqn;
            paramAnonymousBitmap = EmojiLogic.Q(com.tencent.mm.emoji.d.a.agp(), "", paramAnonymousView);
            i.mz(q.B(paramAnonymousString.fOK()), paramAnonymousBitmap);
            bk.a(bk.this, paramContext, paramAnonymousView, parama);
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
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int ccO()
  {
    return 2;
  }
  
  public final String name()
  {
    return "shareEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bk
 * JD-Core Version:    0.7.0.1
 */