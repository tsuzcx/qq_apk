package com.tencent.mm.plugin.story;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.story.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/Plugin;", "Lcom/tencent/mm/pluginsdk/deprecated/IPlugin;", "()V", "createApplication", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "createSubCore", "Lcom/tencent/mm/model/ISubCore;", "getContactWidgetFactory", "Lcom/tencent/mm/pluginsdk/deprecated/IContactWidgetFactory;", "plugin-story_release"})
public final class Plugin
  implements d
{
  public final n createApplication()
  {
    AppMethodBeat.i(118534);
    n localn = (n)new a();
    AppMethodBeat.o(118534);
    return localn;
  }
  
  public final bd createSubCore()
  {
    return null;
  }
  
  public final c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.Plugin
 * JD-Core Version:    0.7.0.1
 */