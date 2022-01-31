package com.tencent.mm.plugin.story.i;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.c;
import com.tencent.mm.loader.g.a.g;
import com.tencent.mm.loader.g.a.h;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/task/StoryCleanTask;", "", "()V", "CLEAN_LIMIT", "", "TAG", "", "cleanQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/task/StoryCleanTask$CleanTask;", "isStop", "", "stopLock", "Ljava/lang/Object;", "checkLoopClean", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "startClean", "stopClean", "CleanTask", "plugin-story_release"})
public final class a
{
  private static final Object eRH;
  private static com.tencent.mm.loader.g.d<Object> sHe;
  public static final a sHf;
  
  static
  {
    AppMethodBeat.i(109986);
    sHf = new a();
    sHe = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new g((c)new com.tencent.mm.loader.g.a.a(5), new h(1, (byte)0), 1, "storyCleanQueue"));
    eRH = new Object();
    AppMethodBeat.o(109986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */