package com.tencent.mm.plugin.webview.ui.tools;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

final class n$41
  implements Runnable
{
  n$41(n paramn) {}
  
  public final void run()
  {
    AppMethodBeat.i(7754);
    if ((n.a(this.vdr).get() == null) || (((WebViewUI)n.a(this.vdr).get()).isFinishing()))
    {
      AppMethodBeat.o(7754);
      return;
    }
    Object localObject = (WebViewUI)n.a(this.vdr).get();
    ((WebViewUI)localObject).vgh.vcU = new WebViewUI.4((WebViewUI)localObject);
    localObject = ((WebViewUI)localObject).vgh;
    ((l)localObject).hht = true;
    if (((l)localObject).vcW != null)
    {
      ((l)localObject).vcW.setVisibility(0);
      ((l)localObject).vcW.setMMOverScrollOffsetListener((LogoWebViewWrapper.b)localObject);
      ((l)localObject).vcW.setFastScrollBack(true);
      ((l)localObject).vcW.op(false);
      ((l)localObject).vcW.setReleaseTargetHeight(((l)localObject).vcX);
    }
    if (((l)localObject).vcV != null)
    {
      ((l)localObject).vcV.setWillNotDraw(true);
      ((l)localObject).vcV.setImageResource(l.vcY);
      ((l)localObject).vcV.setVisibility(0);
      ((l)localObject).vcV.setAlpha(0.0F);
      ((l)localObject).vcV.setWillNotDraw(false);
      ((l)localObject).vcV.invalidate();
    }
    ((l)localObject).dea();
    AppMethodBeat.o(7754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.41
 * JD-Core Version:    0.7.0.1
 */