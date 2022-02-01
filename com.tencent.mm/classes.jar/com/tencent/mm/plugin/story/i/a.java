package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.a.c;
import com.tencent.mm.loader.f.a.f;
import com.tencent.mm.loader.f.a.g;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/task/StoryCleanTask;", "", "()V", "CLEAN_LIMIT", "", "TAG", "", "cleanQueue", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/plugin/story/task/StoryCleanTask$CleanTask;", "isStop", "", "stopLock", "Ljava/lang/Object;", "checkLoopClean", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "startClean", "stopClean", "CleanTask", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Stw;
  private static com.tencent.mm.loader.f.d<Object> Stx;
  private static final Object cBq;
  
  static
  {
    AppMethodBeat.i(119611);
    Stw = new a();
    Stx = new com.tencent.mm.loader.f.d((com.tencent.mm.loader.f.a.d)new f((c)new com.tencent.mm.loader.f.a.a(5), new g(1, (byte)0), 1, "storyCleanQueue"));
    cBq = new Object();
    AppMethodBeat.o(119611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.a
 * JD-Core Version:    0.7.0.1
 */