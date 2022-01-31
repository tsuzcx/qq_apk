package com.tencent.mm.plugin.story.proxy;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryAudioManagerProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
public final class StoryAudioManagerProxy$a
{
  private static void a(StoryAudioManagerProxy paramStoryAudioManagerProxy)
  {
    AppMethodBeat.i(109688);
    j.q(paramStoryAudioManagerProxy, "<set-?>");
    StoryAudioManagerProxy.access$setInstance$cp(paramStoryAudioManagerProxy);
    AppMethodBeat.o(109688);
  }
  
  public static void createInstance(d paramd)
  {
    AppMethodBeat.i(109689);
    a(new StoryAudioManagerProxy(paramd));
    AppMethodBeat.o(109689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a
 * JD-Core Version:    0.7.0.1
 */