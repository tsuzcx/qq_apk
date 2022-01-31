package com.tencent.mm.plugin.shake;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  private b nYq = new Plugin.1(this);
  
  public n createApplication()
  {
    return new a();
  }
  
  public ar createSubCore()
  {
    return new m();
  }
  
  public b getContactWidgetFactory()
  {
    return this.nYq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.Plugin
 * JD-Core Version:    0.7.0.1
 */