package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class bl
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  private void b(final Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(78632);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene_from", 4);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    localIntent.putExtra("Retr_Msg_thumb_path", paramString);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772059);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).mmSetOnActivityResultCallback(new MMActivity.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(78630);
          Log.i("MicroMsg.JsApiShareEmotion", "mmOnActivityResult, %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
          if (paramAnonymousInt1 == (bl.this.hashCode() & 0xFFFF)) {
            Log.i("MicroMsg.JsApiShareEmotion", "share emmotion resultCode: %d", new Object[] { Integer.valueOf(paramAnonymousInt2) });
          }
          String str;
          Object localObject2;
          Object localObject1;
          Object localObject3;
          switch (paramAnonymousInt2)
          {
          default: 
            parama.i(null, null);
            AppMethodBeat.o(78630);
            return;
          case -1: 
            str = Util.nullAs(paramAnonymousIntent.getStringExtra("Select_Conv_User"), "");
            localObject2 = Util.nullAs(paramAnonymousIntent.getStringExtra("emoji_thumb_path"), "");
            localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk((String)localObject2);
            if (localObject1 == null)
            {
              localObject3 = com.tencent.mm.emoji.e.a.hdT;
              localObject3 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", (String)localObject2);
              if (s.YS((String)localObject3)) {
                if (ImgUtil.isGif((String)localObject3))
                {
                  paramAnonymousInt1 = EmojiInfo.Uux;
                  localObject1 = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.a((String)localObject2, "", EmojiInfo.Uup, paramAnonymousInt1, (int)s.boW((String)localObject3), null, null, null, "");
                }
              }
            }
            break;
          }
          for (;;)
          {
            localObject2 = Util.stringsToList(Util.nullAs(str, "").split(",")).iterator();
            for (;;)
            {
              if (((Iterator)localObject2).hasNext())
              {
                localObject3 = (String)((Iterator)localObject2).next();
                if (localObject1 != null)
                {
                  com.tencent.mm.plugin.emoji.model.k.cGf().a((String)localObject3, (EmojiInfo)localObject1, null);
                  continue;
                  paramAnonymousInt1 = EmojiInfo.Uuw;
                  break;
                }
              }
            }
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
            if (!Util.isNullOrNil(paramAnonymousIntent))
            {
              localObject1 = new tw();
              ((tw)localObject1).eaq.dkV = str;
              ((tw)localObject1).eaq.content = paramAnonymousIntent;
              ((tw)localObject1).eaq.type = ab.JG(str);
              ((tw)localObject1).eaq.flags = 0;
              EventCenter.instance.publish((IEvent)localObject1);
            }
            h.cD(paramContext, paramContext.getResources().getString(2131755986));
            break;
            parama.i(null, null);
            AppMethodBeat.o(78630);
            return;
          }
        }
      });
      c.c(paramContext, ".ui.transmit.SelectConversationUI", localIntent, hashCode() & 0xFFFF);
    }
    AppMethodBeat.o(78632);
  }
  
  public final void a(final Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(78631);
    Log.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.i("null_data", null);
      AppMethodBeat.o(78631);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    Object localObject2 = paramString.optString("url");
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
          parama.i("fail", null);
          AppMethodBeat.o(78631);
          return;
        }
      }
      catch (Exception paramContext)
      {
        Log.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + paramContext.getMessage());
        parama.i("base64_decode_fail", null);
        AppMethodBeat.o(78631);
        return;
      }
      localObject1 = com.tencent.mm.b.g.getMessageDigest(paramString);
      localObject2 = com.tencent.mm.emoji.e.a.hdT;
      localObject2 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", (String)localObject1);
      if ((!s.YS((String)localObject2)) || (!s.bhK((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        s.f((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    Log.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { localObject2 });
    paramString = new o(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(((String)localObject2).getBytes()));
    if (paramString.exists())
    {
      localObject1 = s.bhK(aa.z(paramString.mUri));
      localObject2 = com.tencent.mm.emoji.e.a.hdT;
      localObject2 = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", (String)localObject1);
      if (!s.YS((String)localObject2)) {
        s.nw(aa.z(paramString.her()), (String)localObject2);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
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
        AppMethodBeat.i(78629);
        Log.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(this.IVB)))
        {
          paramAnonymousString = new o(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            paramAnonymousView = s.bhK(aa.z(paramAnonymousString.mUri));
            paramAnonymousBitmap = com.tencent.mm.emoji.e.a.hdT;
            paramAnonymousBitmap = EmojiLogic.W(com.tencent.mm.emoji.e.a.awt(), "", paramAnonymousView);
            s.nw(aa.z(paramAnonymousString.her()), paramAnonymousBitmap);
            bl.a(bl.this, paramContext, paramAnonymousView, parama);
            AppMethodBeat.o(78629);
            return;
          }
        }
        parama.i("fail", null);
        AppMethodBeat.o(78629);
      }
    });
    AppMethodBeat.o(78631);
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb) {}
  
  public final int dTs()
  {
    return 2;
  }
  
  public final String name()
  {
    return "shareEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bl
 * JD-Core Version:    0.7.0.1
 */