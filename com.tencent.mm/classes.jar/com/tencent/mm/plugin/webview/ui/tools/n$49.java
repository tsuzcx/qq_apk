package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class n$49
  implements Runnable
{
  n$49(n paramn, boolean paramBoolean1, Bitmap paramBitmap, String paramString, boolean paramBoolean2, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(7766);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7766);
      return;
    }
    if (this.vdT)
    {
      ((WebViewUI)n.a(this.vdr).get()).ou(true);
      AppMethodBeat.o(7766);
      return;
    }
    Object localObject = ((WebViewUI)n.a(this.vdr).get()).dek();
    if (!bo.isNullOrNil((String)localObject)) {}
    for (localObject = (Boolean)((WebViewUI)n.a(this.vdr).get()).vfn.get(localObject);; localObject = null)
    {
      boolean bool;
      if (localObject == null)
      {
        bool = false;
        ((WebViewUI)n.a(this.vdr).get()).ou(Boolean.valueOf(bool).booleanValue());
        if ((this.uSC == null) || (this.uSC.isRecycled())) {
          break label285;
        }
        ((WebViewUI)n.a(this.vdr).get()).c(this.val$text, new BitmapDrawable(((WebViewUI)n.a(this.vdr).get()).getResources(), this.uSC));
        if (this.uSD) {
          ((WebViewUI)n.a(this.vdr).get()).updateOptionMenuListener(0, new n.49.1(this), null);
        }
      }
      for (;;)
      {
        ((WebViewUI)n.a(this.vdr).get()).KA(this.uSG);
        AppMethodBeat.o(7766);
        return;
        bool = ((Boolean)localObject).booleanValue();
        break;
        label285:
        if (!bo.isNullOrNil(this.val$text))
        {
          if (this.uSF == -1) {
            ((WebViewUI)n.a(this.vdr).get()).addTextOptionMenu(0, this.val$text, new n.49.2(this));
          } else {
            ((WebViewUI)n.a(this.vdr).get()).addTextOptionMenu(0, this.val$text, this.uSF, new n.49.3(this));
          }
        }
        else {
          ((WebViewUI)n.a(this.vdr).get()).addIconOptionMenu(0, ((WebViewUI)n.a(this.vdr).get()).dev(), new n.49.4(this), ((WebViewUI)n.a(this.vdr).get()).vgm);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.49
 * JD-Core Version:    0.7.0.1
 */