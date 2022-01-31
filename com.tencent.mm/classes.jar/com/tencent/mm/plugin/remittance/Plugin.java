package com.tencent.mm.plugin.remittance;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements c
{
  public final n createApplication()
  {
    return null;
  }
  
  public final ar createSubCore()
  {
    return new com.tencent.mm.plugin.remittance.a.b();
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.Plugin
 * JD-Core Version:    0.7.0.1
 */