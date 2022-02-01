package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystem.a;
import d.y;
import java.util.Comparator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "", "()V", "MAX_COUNT", "", "MAX_STORY_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "isRun", "", "cancel", "", "cleanCacheFiles", "subDir", "maxStoryCache", "maxStoryCount", "plugin-story_release"})
public final class a
{
  final int MAX_COUNT = 100;
  final String TAG = "MicroMsg.GalleryMgr";
  boolean xPQ = true;
  final int zrk = 314572800;
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118628);
      int i = d.b.a.a((Comparable)Long.valueOf(((FileSystem.a)paramT1).Jsf), (Comparable)Long.valueOf(((FileSystem.a)paramT2).Jsf));
      AppMethodBeat.o(118628);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a
 * JD-Core Version:    0.7.0.1
 */