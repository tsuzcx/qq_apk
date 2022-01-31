package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.as.a.c.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;

final class aq$1
  implements i
{
  aq$1(aq paramaq, String paramString, Context paramContext, aw.a parama) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.i("MicroMsg.JsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramString });
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof String)) && (paramString.equals(this.rdp)))
    {
      paramString = new File(paramVarArgs[0].toString());
      if (paramString.exists())
      {
        paramView = g.m(paramString);
        au.Hx();
        paramBitmap = EmojiLogic.J(c.FL(), "", paramView);
        FileOp.r(paramString.getAbsolutePath(), paramBitmap);
        aq.a(this.rdS, this.val$context, paramView, this.iRN);
        return;
      }
    }
    this.iRN.e("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq.1
 * JD-Core Version:    0.7.0.1
 */