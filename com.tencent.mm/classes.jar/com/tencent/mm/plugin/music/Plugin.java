package com.tencent.mm.plugin.music;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  public n createApplication()
  {
    return new com.tencent.mm.plugin.music.model.b();
  }
  
  public ar createSubCore()
  {
    return new e();
  }
  
  public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.Plugin
 * JD-Core Version:    0.7.0.1
 */