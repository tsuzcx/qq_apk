package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.xweb.WebView;

final class d$15
  implements View.OnClickListener
{
  d$15(d paramd) {}
  
  public final void onClick(View paramView)
  {
    d.b(this.xiF).evaluateJavascript("xwebVideoBridge.xwebToJS_Video_ExitFullscreen();", new d.15.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.15
 * JD-Core Version:    0.7.0.1
 */