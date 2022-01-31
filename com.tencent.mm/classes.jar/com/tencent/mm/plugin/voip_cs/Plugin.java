package com.tencent.mm.plugin.voip_cs;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public n createApplication()
  {
    return null;
  }
  
  public ar createSubCore()
  {
    return new com.tencent.mm.plugin.voip_cs.b.c();
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.Plugin
 * JD-Core Version:    0.7.0.1
 */