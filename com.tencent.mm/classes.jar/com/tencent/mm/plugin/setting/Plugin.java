package com.tencent.mm.plugin.setting;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.y;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.c
{
  public Plugin()
  {
    y.i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
  }
  
  public final n createApplication()
  {
    y.i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
    return new b();
  }
  
  public final ar createSubCore()
  {
    y.i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
    return new c();
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    y.i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.Plugin
 * JD-Core Version:    0.7.0.1
 */