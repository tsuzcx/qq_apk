package com.tencent.mm.plugin.scanner;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public n createApplication()
  {
    return new b();
  }
  
  public ar createSubCore()
  {
    return new c();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.Plugin
 * JD-Core Version:    0.7.0.1
 */