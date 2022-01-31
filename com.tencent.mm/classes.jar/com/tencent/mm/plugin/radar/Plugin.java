package com.tencent.mm.plugin.radar;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public final n createApplication()
  {
    return (n)new b();
  }
  
  public final ar createSubCore()
  {
    return (ar)new c();
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.Plugin
 * JD-Core Version:    0.7.0.1
 */