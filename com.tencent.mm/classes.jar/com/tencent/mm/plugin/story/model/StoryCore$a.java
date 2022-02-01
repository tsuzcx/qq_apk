package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.q.a;
import com.tencent.mm.autogen.a.aac;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryCore$a
  extends q.a
{
  public StoryCore$a()
  {
    AppMethodBeat.i(367079);
    AppMethodBeat.o(367079);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(118683);
    paramString = new aac();
    paramString.idI.state = 0;
    paramString.publish();
    AppMethodBeat.o(118683);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(118682);
    paramString = new aac();
    paramString.idI.state = 1;
    paramString.publish();
    AppMethodBeat.o(118682);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.StoryCore.a
 * JD-Core Version:    0.7.0.1
 */