package com.tencent.mm.plugin.story.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.g.a.c;
import com.tencent.mm.loader.g.a.f;
import com.tencent.mm.loader.g.a.g;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/task/StoryCleanTask;", "", "()V", "CLEAN_LIMIT", "", "TAG", "", "cleanQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/task/StoryCleanTask$CleanTask;", "isStop", "", "stopLock", "Ljava/lang/Object;", "checkLoopClean", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "startClean", "stopClean", "CleanTask", "plugin-story_release"})
public final class a
{
  private static com.tencent.mm.loader.g.d<Object> AUu;
  public static final a AUv;
  private static final Object stopLock;
  
  static
  {
    AppMethodBeat.i(119611);
    AUv = new a();
    AUu = new com.tencent.mm.loader.g.d((com.tencent.mm.loader.g.a.d)new f((c)new com.tencent.mm.loader.g.a.a(5), new g(1, (byte)0), 1, "storyCleanQueue"));
    stopLock = new Object();
    AppMethodBeat.o(119611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.j.a
 * JD-Core Version:    0.7.0.1
 */