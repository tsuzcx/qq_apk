package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
          ae.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt1 == (bk.this.hashCode() & 0xFFFF)) {
            ae.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
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
            str = bu.bI(paramAnonymousIntent.getStringExtra("Select_Conv_User"), "");
            localObject2 = bu.bI(paramAnonymousIntent.getStringExtra("emoji_thumb_path"), "");
            localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.aWl((String)localObject2);
            if (localObject1 == null)
            {
              localObject3 = com.tencent.mm.emoji.d.a.gsI;
              localObject3 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", (String)localObject2);
              if (o.fB((String)localObject3)) {
                if (u.aRG((String)localObject3))
                {
                  paramAnonymousInt1 = EmojiInfo.OAc;
                  localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.b((String)localObject2, "", EmojiInfo.OzU, paramAnonymousInt1, (int)o.aZR((String)localObject3), null, "");
                }
              }
            }
            break;
          }
          for (;;)
          {
            localObject2 = bu.U(bu.bI(str, "").split(",")).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (localObject1 != null)
                {
                  com.tencent.mm.plugin.emoji.model.k.cig().a((String)localObject3, (EmojiInfo)localObject1, null);
                  continue;
                  paramAnonymousInt1 = EmojiInfo.OAb;
                  break;
                }
              }
            }
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
            if (!bu.isNullOrNil(paramAnonymousIntent))
            {
              localObject1 = new sy();
              ((sy)localObject1).dID.cUB = str;
              ((sy)localObject1).dID.content = paramAnonymousIntent;
              ((sy)localObject1).dID.type = x.Bb(str);
              ((sy)localObject1).dID.flags = 0;
              com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
            }
            h.cm(paramContext, paramContext.getResources().getString(2131755894));
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
    ae.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (paramString == null)
    {
      ae.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.f("null_data", null);
      AppMethodBeat.o(78631);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    Object localObject2 = paramString.optString("url");
    if (!bu.isNullOrNil((String)localObject1))
    {
      ae.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
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
          AppMethodBeat.o(78631);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ae.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + paramContext.getMessage());
        parama.f("base64_decode_fail", null);
        AppMethodBeat.o(78631);
        return;
      }
      localObject1 = com.tencent.mm.b.g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.d.a.gsI;
      localObject2 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", (String)localObject1);
      if ((!o.fB((String)localObject2)) || (!o.aRh((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        o.f((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    ae.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { localObject2 });
    paramString = new com.tencent.mm.vfs.k(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
    if (paramString.exists())
    {
      localObject1 = o.aRh(w.B(paramString.mUri));
      localObject2 = com.tencent.mm.emoji.d.a.gsI;
      localObject2 = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", (String)localObject1);
      if (!o.fB((String)localObject2)) {
        o.mF(w.B(paramString.fTh()), (String)localObject2);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
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
        AppMethodBeat.i(78629);
        ae.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.EiG)))
        {
          paramAnonymousString = new com.tencent.mm.vfs.k(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            paramAnonymousView = o.aRh(w.B(paramAnonymousString.mUri));
            paramAnonymousBitmap = com.tencent.mm.emoji.d.a.gsI;
            paramAnonymousBitmap = EmojiLogic.R(com.tencent.mm.emoji.d.a.agD(), "", paramAnonymousView);
            o.mF(w.B(paramAnonymousString.fTh()), paramAnonymousBitmap);
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
  
  public final int ced()
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