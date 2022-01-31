package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.appbrand.i.f;

final class s$2
  implements Runnable
{
  s$2(f paramf) {}
  
  public final void run()
  {
    this.snH.evaluateJavascript("javascript:var edw_iframe = document.getElementById('_edw_iframe_');if (edw_iframe === null) {edw_iframe = document.createElement('iframe');edw_iframe.id = '_edw_iframe_';edw_iframe.style.display = 'none';document.documentElement.appendChild(edw_iframe);}", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.s.2
 * JD-Core Version:    0.7.0.1
 */