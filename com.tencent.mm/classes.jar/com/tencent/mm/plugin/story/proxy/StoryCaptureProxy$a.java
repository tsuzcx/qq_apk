package com.tencent.mm.plugin.story.proxy;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy$Companion;", "", "()V", "RESULT_KEY", "", "TAG", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/story/proxy/StoryCaptureProxy;)V", "createInstance", "", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "plugin-story_release"})
public final class StoryCaptureProxy$a
{
  private static void a(StoryCaptureProxy paramStoryCaptureProxy)
  {
    AppMethodBeat.i(109705);
    j.q(paramStoryCaptureProxy, "<set-?>");
    StoryCaptureProxy.access$setInstance$cp(paramStoryCaptureProxy);
    AppMethodBeat.o(109705);
  }
  
  public static void createInstance(d paramd)
  {
    AppMethodBeat.i(109706);
    a(new StoryCaptureProxy(paramd));
    AppMethodBeat.o(109706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a
 * JD-Core Version:    0.7.0.1
 */