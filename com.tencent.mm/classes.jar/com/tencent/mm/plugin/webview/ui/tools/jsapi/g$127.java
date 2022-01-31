package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;

final class g$127
  implements com.tencent.mm.at.a.c.i
{
  g$127(g paramg, String paramString1, String paramString2, i parami) {}
  
  public final void a(String paramString, View paramView, Bitmap paramBitmap, Object... paramVarArgs)
  {
    AppMethodBeat.i(155040);
    ab.i("MicroMsg.MsgHandler", "imageLoaderListener onImageLoadComplete %s", new Object[] { paramString });
    if ((paramBitmap != null) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      if ((paramVarArgs[0] != null) && ((paramVarArgs[0] instanceof String)))
      {
        if (paramString.equals(this.uTk))
        {
          paramString = new com.tencent.mm.vfs.b(paramVarArgs[0].toString());
          if (paramString.exists())
          {
            paramView = e.avP(j.p(paramString.mUri));
            paramBitmap = EmojiLogic.M(com.tencent.mm.plugin.emoji.h.b.YP(), "", paramView);
            e.C(j.p(paramString.dQJ()), paramBitmap);
            g.a(this.vqm, paramView, this.vrD);
            AppMethodBeat.o(155040);
            return;
          }
          this.vqm.a(this.uZa, "shareEmoticon:fail", null);
          AppMethodBeat.o(155040);
          return;
        }
        this.vqm.a(this.uZa, "shareEmoticon:fail", null);
        AppMethodBeat.o(155040);
        return;
      }
      this.vqm.a(this.uZa, "shareEmoticon:fail", null);
      AppMethodBeat.o(155040);
      return;
    }
    this.vqm.a(this.uZa, "shareEmoticon:fail", null);
    AppMethodBeat.o(155040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.127
 * JD-Core Version:    0.7.0.1
 */