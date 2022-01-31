package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebView;

final class d$16
  implements View.OnClickListener
{
  d$16(d paramd) {}
  
  public final void onClick(View paramView)
  {
    d.b(this.xiF).evaluateJavascript("xwebVideoBridge.xwebToJS_Video_Play();", new ValueCallback() {});
    this.xiF.cSA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.16
 * JD-Core Version:    0.7.0.1
 */