package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.appbrand.i.f;

final class s$3
  implements Runnable
{
  s$3(boolean paramBoolean, f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    if (this.snI)
    {
      this.snH.evaluateJavascript("javascript:document.getElementById('_edw_iframe_').src = '" + this.snJ + "' + " + this.rqn, null);
      return;
    }
    this.snH.evaluateJavascript("javascript:console.log('" + this.snJ + "' + " + this.rqn + ")", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.s.3
 * JD-Core Version:    0.7.0.1
 */