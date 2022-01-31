package com.tencent.mm.plugin.webview;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return new a();
  }
  
  public ar createSubCore()
  {
    return new g();
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.Plugin
 * JD-Core Version:    0.7.0.1
 */