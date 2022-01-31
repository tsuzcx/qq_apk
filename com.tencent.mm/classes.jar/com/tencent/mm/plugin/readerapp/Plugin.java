package com.tencent.mm.plugin.readerapp;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements c
{
  private b hYb = new Plugin.1(this);
  
  public final n createApplication()
  {
    return new a();
  }
  
  public final ar createSubCore()
  {
    return null;
  }
  
  public final b getContactWidgetFactory()
  {
    return this.hYb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.Plugin
 * JD-Core Version:    0.7.0.1
 */