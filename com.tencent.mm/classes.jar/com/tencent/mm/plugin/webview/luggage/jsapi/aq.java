package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.mm.R.a;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.br.d;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import org.json.JSONObject;

public class aq
  extends ax<com.tencent.mm.plugin.webview.luggage.e>
{
  private void b(Context paramContext, String paramString, aw.a parama)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("scene_from", 4);
    localIntent.putExtra("Select_Conv_Type", 3);
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("Retr_Msg_Type", 5);
    localIntent.putExtra("Retr_Msg_thumb_path", paramString);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
    if ((paramContext instanceof MMActivity))
    {
      ((MMActivity)paramContext).gJb = new aq.2(this, parama);
      d.c(paramContext, ".ui.transmit.SelectConversationUI", localIntent, hashCode() & 0xFFFF);
    }
  }
  
  public final void a(Context paramContext, String paramString, aw.a parama)
  {
    y.i("MicroMsg.JsApiShareEmotion", "invoke");
    paramString = com.tencent.mm.plugin.webview.luggage.d.c.tJ(paramString);
    if (paramString == null)
    {
      y.e("MicroMsg.JsApiShareEmotion", "data is null");
      parama.e("null_data", null);
      return;
    }
    Object localObject1 = paramString.optString("base64DataString");
    paramString = paramString.optString("url");
    if (!bk.bl((String)localObject1))
    {
      y.i("MicroMsg.JsApiShareEmotion", "use base64DataString");
      int i = ((String)localObject1).indexOf(";base64,");
      paramString = "";
      if (i != -1) {
        paramString = ((String)localObject1).substring(i + 8, ((String)localObject1).length());
      }
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (bk.bE(paramString))
        {
          parama.e("fail", null);
          return;
        }
      }
      catch (Exception paramContext)
      {
        y.e("MicroMsg.JsApiShareEmotion", "doShareEmoticon error:" + paramContext.getMessage());
        parama.e("base64_decode_fail", null);
        return;
      }
      localObject1 = g.o(paramString);
      au.Hx();
      localObject2 = EmojiLogic.J(com.tencent.mm.model.c.FL(), "", (String)localObject1);
      if ((!com.tencent.mm.a.e.bK((String)localObject2)) || (!g.bQ((String)localObject2).equalsIgnoreCase((String)localObject1))) {
        com.tencent.mm.a.e.b((String)localObject2, paramString, paramString.length);
      }
      b(paramContext, (String)localObject1, parama);
      return;
    }
    y.i("MicroMsg.JsApiShareEmotion", "doShareEmoticon use url:%s", new Object[] { paramString });
    localObject1 = new File(paramContext.getCacheDir(), g.o(paramString.getBytes()));
    if (((File)localObject1).exists())
    {
      paramString = g.m((File)localObject1);
      au.Hx();
      localObject2 = EmojiLogic.J(com.tencent.mm.model.c.FL(), "", paramString);
      if (!FileOp.bK((String)localObject2)) {
        FileOp.r(((File)localObject1).getAbsolutePath(), (String)localObject2);
      }
      b(paramContext, paramString, parama);
      return;
    }
    Object localObject2 = new c.a();
    ((c.a)localObject2).erf = true;
    ((c.a)localObject2).erh = ((File)localObject1).getAbsolutePath();
    ((c.a)localObject2).erJ = new Object[] { ((File)localObject1).getAbsolutePath() };
    localObject1 = ((c.a)localObject2).OV();
    i.aHr().a(paramString, null, (com.tencent.mm.as.a.a.c)localObject1, new aq.1(this, paramString, paramContext, parama));
  }
  
  public final int aGj()
  {
    return 2;
  }
  
  public final void b(com.tencent.luggage.e.a<com.tencent.mm.plugin.webview.luggage.e>.a parama) {}
  
  public final String name()
  {
    return "shareEmoticon";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */