package com.tencent.mm.plugin.profile;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.y;

public final class Plugin
  implements c
{
  public Plugin()
  {
    y.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
  }
  
  public final n createApplication()
  {
    y.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
    return new a();
  }
  
  public final ar createSubCore()
  {
    y.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
    return new b();
  }
  
  public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory()
  {
    y.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.Plugin
 * JD-Core Version:    0.7.0.1
 */