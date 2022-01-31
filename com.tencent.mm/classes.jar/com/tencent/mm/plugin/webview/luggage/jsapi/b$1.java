package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.c.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;

final class b$1
  implements i
{
  b$1(b paramb, String paramString1, Context paramContext, String paramString2, bh.a parama) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(6273);
    ab.i("MicroMsg.JsApiAddToEmotion", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramString });
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0) && (paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof String)) && (paramString.equals(this.uTk)))
    {
      paramString = new File(paramVarArgs[0].toString());
      if (paramString.exists())
      {
        paramView = g.r(paramString);
        paramBitmap = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", paramView);
        FileOp.C(paramString.getAbsolutePath(), paramBitmap);
        b.b(this.val$context, paramView, this.fEW, this.lax);
        AppMethodBeat.o(6273);
        return;
      }
    }
    this.lax.c("fail", null);
    AppMethodBeat.o(6273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.b.1
 * JD-Core Version:    0.7.0.1
 */