package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import org.json.JSONObject;

public class bb
  extends bi<com.tencent.mm.plugin.webview.luggage.e>
{
  private void b(Context paramContext, String paramString, bh.a parama)
  {
    AppMethodBeat.i(6380);
    Intent localIntent = new Intent();
    localIntent.putExtra("scene_from", 4);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    localIntent.putExtra("Retr_Msg_thumb_path", paramString);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2131034181);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).mmSetOnActivityResultCallback(new bb.2(this, paramContext, parama));
      d.b(paramContext, ".ui.transmit.SelectConversationUI", localIntent, hashCode() & 0xFFFF);
    }
    AppMethodBeat.o(6380);
  }
  
  public final void a(final Context paramContext, final String paramString, final bh.a parama)
  {
    AppMethodBeat.i(6379);
    ab.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.c.b.BJ(paramString);
    if (paramString == null)
    {
      ab.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.c("null_data", null);
      AppMethodBeat.o(6379);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    paramString = paramString.optString("url");
    if (!bo.isNullOrNil((String)localObject1))
    {
      ab.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bo.ce(paramString))
        {
          parama.c("fail", null);
          AppMethodBeat.o(6379);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ab.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + paramContext.getMessage());
        parama.c("base64_decode_fail", null);
        AppMethodBeat.o(6379);
        return;
      }
      localObject1 = g.w(paramString);
      localObject2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", (String)localObject1);
      if ((!com.tencent.mm.a.e.cN((String)localObject2)) || (!g.getMD5((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        com.tencent.mm.a.e.b((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      AppMethodBeat.o(6379);
      return;
    }
    ab.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { paramString });
    localObject1 = new File(paramContext.getCacheDir(), g.w(paramString.getBytes()));
    if (((File)localObject1).exists())
    {
      paramString = g.r((File)localObject1);
      localObject2 = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", paramString);
      if (!FileOp.cN((String)localObject2)) {
        FileOp.C(((File)localObject1).getAbsolutePath(), (String)localObject2);
      }
      b(paramContext, paramString, parama);
      AppMethodBeat.o(6379);
      return;
    }
    Object localObject2 = new c.a();
    ((c.a)localObject2).eNM = true;
    ((c.a)localObject2).eNO = ((File)localObject1).getAbsolutePath();
    ((c.a)localObject2).eOi = new Object[] { ((File)localObject1).getAbsolutePath() };
    localObject1 = ((c.a)localObject2).ahY();
    com.tencent.mm.plugin.emoji.model.i.bld().a(paramString, null, (c)localObject1, new com.tencent.mm.at.a.c.i()
    {
      public final void a(String paramAnonymousString, View paramAnonymousView, Bitmap paramAnonymousBitmap, Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(6377);
        ab.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramAnonymousString });
        if ((paramAnonymousBitmap != null) && (paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0) && (paramAnonymousVarArgs[0] != null) && ((paramAnonymousVarArgs[0] instanceof String)) && (paramAnonymousString.equals(paramString)))
        {
          paramAnonymousString = new File(paramAnonymousVarArgs[0].toString());
          if (paramAnonymousString.exists())
          {
            paramAnonymousView = g.r(paramAnonymousString);
            paramAnonymousBitmap = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", paramAnonymousView);
            FileOp.C(paramAnonymousString.getAbsolutePath(), paramAnonymousBitmap);
            bb.a(bb.this, paramContext, paramAnonymousView, parama);
            AppMethodBeat.o(6377);
            return;
          }
        }
        parama.c("fail", null);
        AppMethodBeat.o(6377);
      }
    });
    AppMethodBeat.o(6379);
  }
  
  public final void b(com.tencent.luggage.d.a<com.tencent.mm.plugin.webview.luggage.e>.a parama) {}
  
  public final int bjL()
  {
    return 2;
  }
  
  public final String name()
  {
    return "shareEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.bb
 * JD-Core Version:    0.7.0.1
 */