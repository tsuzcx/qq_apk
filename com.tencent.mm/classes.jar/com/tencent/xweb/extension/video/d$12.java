package com.tencent.xweb.extension.video;

import com.tencent.xweb.WebView;

final class d$12
  implements c.a
{
  d$12(d paramd) {}
  
  public final void aT(float paramFloat)
  {
    double d = d.a(this.xiF) * paramFloat / 100.0D;
    this.xiF.e(d, false);
    d.b(this.xiF).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[] { Double.valueOf(d) }), new d.12.1(this));
    this.xiF.cSA();
  }
  
  public final void akz()
  {
    this.xiF.cSB();
    this.xiF.cSC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.12
 * JD-Core Version:    0.7.0.1
 */