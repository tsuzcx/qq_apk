package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.l;
import org.xwalk.core.Log;

final class d$34
  implements View.OnClickListener
{
  d$34(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153587);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/xweb/extension/video/XWebNativeInterface$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    l.kie();
    paramView = this.aihL;
    if (!d.i(this.aihL)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("XWebNativeInterface", "xwebToJS, videoMute muted:".concat(String.valueOf(bool)));
      paramView.WvQ.evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_MuteChange(%b);", new Object[] { Boolean.valueOf(bool) }), new d.13(paramView));
      a.a(this, "com/tencent/xweb/extension/video/XWebNativeInterface$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(153587);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.34
 * JD-Core Version:    0.7.0.1
 */