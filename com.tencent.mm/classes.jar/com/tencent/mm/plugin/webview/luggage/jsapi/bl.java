package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.c.k;
import com.tencent.mm.f.a.uz;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.webview.c.i;
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
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", com.tencent.mm.plugin.webview.c.a.fast_faded_in);
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
          String str1;
          Object localObject2;
          Object localObject1;
          String str2;
          switch (paramAnonymousInt2)
          {
          default: 
            parama.i(null, null);
            AppMethodBeat.o(78630);
            return;
          case -1: 
            str1 = Util.nullAs(paramAnonymousIntent.getStringExtra("Select_Conv_User"), "");
            localObject2 = Util.nullAs(paramAnonymousIntent.getStringExtra("emoji_thumb_path"), "");
            localObject1 = p.getEmojiStorageMgr().VFH.bxK((String)localObject2);
            if (localObject1 == null)
            {
              str2 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", (String)localObject2);
              if (u.agG(str2)) {
                if (ImgUtil.isGif(str2))
                {
                  paramAnonymousInt1 = EmojiInfo.YCF;
                  localObject1 = p.getEmojiStorageMgr().VFH.a((String)localObject2, "", EmojiInfo.YCx, paramAnonymousInt1, (int)u.bBQ(str2), null, null, null, "");
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
                  p.cUO().a(str2, (EmojiInfo)localObject1, null);
                  continue;
                  paramAnonymousInt1 = EmojiInfo.YCE;
                  break;
                }
              }
            }
            paramAnonymousIntent = paramAnonymousIntent.getStringExtra("custom_send_text");
            if (!Util.isNullOrNil(paramAnonymousIntent))
            {
              localObject1 = new uz();
              ((uz)localObject1).fUn.fcD = str1;
              ((uz)localObject1).fUn.content = paramAnonymousIntent;
              ((uz)localObject1).fUn.type = ab.QZ(str1);
              ((uz)localObject1).fUn.flags = 0;
              EventCenter.instance.publish((IEvent)localObject1);
            }
            h.cO(paramContext, paramContext.getResources().getString(c.i.app_shared));
            break;
            parama.i(null, null);
            AppMethodBeat.o(78630);
            return;
          }
        }
      });
      com.tencent.mm.by.c.d(paramContext, ".ui.transmit.SelectConversationUI", localIntent, hashCode() & 0xFFFF);
    }
    AppMethodBeat.o(78632);
  }
  
  public final void a(final Context paramContext, final String paramString, final br.a parama)
  {
    AppMethodBeat.i(78631);
    Log.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.c.agO(paramString);
    if (paramString == null)
    {
      Log.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.i("null_data", null);
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
      localObject2 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", (String)localObject1);
      if ((!u.agG((String)localObject2)) || (!u.buc((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        u.f((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(78631);
      return;
    }
    Log.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { paramString });
    localObject1 = new q(paramContext.getCacheDir(), com.tencent.mm.b.g.getMessageDigest(paramString.getBytes()));
    if (((q)localObject1).ifE())
    {
      paramString = u.buc(((q)localObject1).getPath());
      localObject2 = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", paramString);
      if (!u.agG((String)localObject2)) {
        u.on(((q)localObject1).bOF(), (String)localObject2);
      }
      b(paramContext, paramString, parama);
      AppMethodBeat.o(78631);
      return;
    }
    Object localObject2 = new com.tencent.mm.ay.a.a.c.a();
    ((com.tencent.mm.ay.a.a.c.a)localObject2).lRD = true;
    ((com.tencent.mm.ay.a.a.c.a)localObject2).fullPath = ((q)localObject1).bOF();
    ((com.tencent.mm.ay.a.a.c.a)localObject2).lSd = new Object[] { ((q)localObject1).bOF() };
    localObject1 = ((com.tencent.mm.ay.a.a.c.a)localObject2).bmL();
    p.cUL().a(paramString, null, (com.tencent.mm.ay.a.a.c)localObject1, new k()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(78629);
        Log.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(paramString)))
        {
          paramAnonymousString = new q(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.ifE())
          {
            paramAnonymousView = u.buc(paramAnonymousString.getPath());
            paramAnonymousBitmap = EmojiLogic.T(com.tencent.mm.plugin.emoji.i.b.bcb(), "", paramAnonymousView);
            u.on(paramAnonymousString.bOF(), paramAnonymousBitmap);
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
  
  public final int cDj()
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