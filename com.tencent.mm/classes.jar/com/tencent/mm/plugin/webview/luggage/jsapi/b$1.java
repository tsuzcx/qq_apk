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

final class b$1
  implements i
{
  b$1(b paramb, String paramString1, Context paramContext, String paramString2, aw.a parama) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramString });
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof String)) && (paramString.equals(this.rdp)))
    {
      paramString = new File(paramVarArgs[0].toString());
      if (paramString.exists())
      {
        paramView = g.m(paramString);
        au.Hx();
        paramBitmap = EmojiLogic.J(c.FL(), "", paramView);
        FileOp.r(paramString.getAbsolutePath(), paramBitmap);
        b.b(this.val$context, paramView, this.eoz, this.iRN);
        return;
      }
    }
    this.iRN.e("fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.b.1
 * JD-Core Version:    0.7.0.1
 */