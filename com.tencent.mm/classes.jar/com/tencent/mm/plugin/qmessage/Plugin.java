package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  private b hYb = new Plugin.1(this);
  
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
    return this.hYb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.Plugin
 * JD-Core Version:    0.7.0.1
 */