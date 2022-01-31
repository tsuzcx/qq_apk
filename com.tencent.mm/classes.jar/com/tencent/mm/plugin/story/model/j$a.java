package com.tencent.mm.plugin.story.model;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sy;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryCore$AppForegroundListener;", "Lcom/tencent/mm/app/IAppForegroundListener$Impl;", "(Lcom/tencent/mm/plugin/story/model/StoryCore;)V", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-story_release"})
public final class j$a
  extends com.tencent.mm.app.j.a
{
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(151057);
    paramString = new sy();
    paramString.cJB.state = 0;
    a.ymk.l((b)paramString);
    AppMethodBeat.o(151057);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(151056);
    paramString = new sy();
    paramString.cJB.state = 1;
    a.ymk.l((b)paramString);
    AppMethodBeat.o(151056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.j.a
 * JD-Core Version:    0.7.0.1
 */