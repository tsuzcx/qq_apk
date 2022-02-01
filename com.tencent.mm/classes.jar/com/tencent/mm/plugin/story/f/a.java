package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.c;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Comparator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/CleanVideoTask;", "", "()V", "MAX_COUNT", "", "MAX_STORY_SIZE", "TAG", "", "getTAG", "()Ljava/lang/String;", "isRun", "", "cancel", "", "cleanCacheFiles", "subDir", "maxStoryCache", "maxStoryCount", "plugin-story_release"})
public final class a
{
  final int BaH = 314572800;
  final int MAX_COUNT = 100;
  final String TAG = "MicroMsg.GalleryMgr";
  boolean zwA = true;
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
  public static final class a<T>
    implements Comparator<T>
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(118628);
      int i = d.b.a.a((Comparable)Long.valueOf(((c)paramT1).LGc), (Comparable)Long.valueOf(((c)paramT2).LGc));
      AppMethodBeat.o(118628);
      return i;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.a
 * JD-Core Version:    0.7.0.1
 */