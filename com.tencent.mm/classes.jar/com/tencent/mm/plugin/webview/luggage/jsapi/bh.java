package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.b.g;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.sb;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.aw;
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
          ad.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt1 == (bh.this.hashCode() & 0xFFFF)) {
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
            str = bt.by(paramAnonymousIntent.getStringExtra("Select_Conv_User"), "");
            localObject2 = bt.by(paramAnonymousIntent.getStringExtra("emoji_thumb_path"), "");
            localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.aJx((String)localObject2);
            if (localObject1 == null)
            {
              localObject3 = com.tencent.mm.emoji.d.a.fSR;
              localObject3 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", (String)localObject2);
              if (i.eK((String)localObject3)) {
                if (t.aFm((String)localObject3))
                {
                  paramAnonymousInt1 = EmojiInfo.LBY;
                  localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.b((String)localObject2, "", EmojiInfo.LBQ, paramAnonymousInt1, (int)i.aMN((String)localObject3), null, "");
                }
              }
            }
            break;
          }
          for (;;)
          {
            localObject2 = bt.S(bt.by(str, "").split(",")).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (localObject1 != null)
                {
                  com.tencent.mm.plugin.emoji.model.k.bUZ().a((String)localObject3, (EmojiInfo)localObject1, null);
                  continue;
                  paramAnonymousInt1 = EmojiInfo.LBX;
                  break;
                }
              }
            }
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
            if (!bt.isNullOrNil(paramAnonymousIntent))
            {
              localObject1 = new sb();
              ((sb)localObject1).dxJ.dxK = str;
              ((sb)localObject1).dxJ.content = paramAnonymousIntent;
              ((sb)localObject1).dxJ.type = w.tq(str);
              ((sb)localObject1).dxJ.flags = 0;
              com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            }
            h.cf(paramContext, paramContext.getResources().getString(2131755894));
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
    ad.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.HG(paramString);
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
        if (bt.cw(paramString))
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
      localObject1 = g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.d.a.fSR;
      localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", (String)localObject1);
      if ((!i.eK((String)localObject2)) || (!i.aEN((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        i.f((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    ad.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { localObject2 });
    paramString = new e(paramContext.getCacheDir(), g.getMessageDigest(((String)localObject2).getBytes()));
    if (paramString.exists())
    {
      localObject1 = i.aEN(q.B(paramString.mUri));
      localObject2 = com.tencent.mm.emoji.d.a.fSR;
      localObject2 = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", (String)localObject1);
      if (!i.eK((String)localObject2)) {
        i.lC(q.B(paramString.fhU()), (String)localObject2);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
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
        AppMethodBeat.i(78629);
        ad.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.AUZ)))
        {
          paramAnonymousString = new e(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            paramAnonymousView = i.aEN(q.B(paramAnonymousString.mUri));
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.fSR;
            paramAnonymousBitmap = EmojiLogic.P(com.tencent.mm.emoji.d.a.acD(), "", paramAnonymousView);
            i.lC(q.B(paramAnonymousString.fhU()), paramAnonymousBitmap);
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
  
  public final int bQV()
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