package com.tencent.mm.plugin.qqmail;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements c
{
  private a ncW = new a();
  
  public final n createApplication()
  {
    return new com.tencent.mm.plugin.qqmail.a.a();
  }
  
  public final ar createSubCore()
  {
    return new ac();
  }
  
  public final b getContactWidgetFactory()
  {
    return this.ncW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.Plugin
 * JD-Core Version:    0.7.0.1
 */