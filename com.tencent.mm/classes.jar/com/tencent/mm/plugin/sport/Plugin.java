package com.tencent.mm.plugin.sport;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.sport.c.o;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return new d();
  }
  
  public ar createSubCore()
  {
    return new o();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return new com.tencent.mm.plugin.sport.ui.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.Plugin
 * JD-Core Version:    0.7.0.1
 */