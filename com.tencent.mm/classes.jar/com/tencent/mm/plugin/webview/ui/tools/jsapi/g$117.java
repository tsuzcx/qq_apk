package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class g$117
  implements com.tencent.mm.as.a.c.i
{
  g$117(g paramg, String paramString1, String paramString2, i parami) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    y.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramString });
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      if ((paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof String)))
      {
        if (paramString.equals(this.rdp))
        {
          paramString = new b(paramVarArgs[0].toString());
          if (paramString.exists())
          {
            paramView = e.aeY(j.n(paramString.mUri));
            au.Hx();
            paramBitmap = EmojiLogic.J(c.FL(), "", paramView);
            e.r(j.n(paramString.cLr()), paramBitmap);
            g.a(this.rzi, paramView, this.rAA);
            return;
          }
          g.a(this.rzi, this.rzk, "shareEmoticon:fail", null);
          return;
        }
        g.a(this.rzi, this.rzk, "shareEmoticon:fail", null);
        return;
      }
      g.a(this.rzi, this.rzk, "shareEmoticon:fail", null);
      return;
    }
    g.a(this.rzi, this.rzk, "shareEmoticon:fail", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.117
 * JD-Core Version:    0.7.0.1
 */