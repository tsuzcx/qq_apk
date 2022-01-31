package com.tencent.mm.plugin.traceroute;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements c
{
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
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.traceroute.Plugin
 * JD-Core Version:    0.7.0.1
 */