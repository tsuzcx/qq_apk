package com.tencent.mm.plugin.wenote;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public final n createApplication()
  {
    return new a();
  }
  
  public final ar createSubCore()
  {
    return new com.tencent.mm.plugin.wenote.model.c();
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.Plugin
 * JD-Core Version:    0.7.0.1
 */