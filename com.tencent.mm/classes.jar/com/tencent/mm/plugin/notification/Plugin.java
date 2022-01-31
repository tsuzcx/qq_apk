package com.tencent.mm.plugin.notification;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements c
{
  a mIs = new a();
  
  public n createApplication()
  {
    return this.mIs;
  }
  
  public ar createSubCore()
  {
    return f.bpH();
  }
  
  public b getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.notification.Plugin
 * JD-Core Version:    0.7.0.1
 */