package com.tencent.mm.plugin.record;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;

public final class Plugin
  implements c
{
  public final com.tencent.mm.pluginsdk.n createApplication()
  {
    return new a();
  }
  
  public final ar createSubCore()
  {
    return new com.tencent.mm.plugin.record.b.n();
  }
  
  public final b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.record.Plugin
 * JD-Core Version:    0.7.0.1
 */