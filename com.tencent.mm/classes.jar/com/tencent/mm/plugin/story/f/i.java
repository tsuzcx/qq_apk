package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import d.b.a;
import d.g.b.k;
import d.l;
import java.util.Comparator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  private static int zrH;
  private static String zrI;
  private static final String zrJ;
  public static final a zrK;
  
  static
  {
    AppMethodBeat.i(118667);
    zrK = new a((byte)0);
    zrH = 86400;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.e locale = g.agR();
    k.g(locale, "MMKernel.storage()");
    zrI = locale.getAccPath() + "story/";
    zrJ = zrI + "mix/";
    AppMethodBeat.o(118667);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/StoryConstants$Companion;", "", "()V", "STORY_DEPRECATED_TIME_SECOND", "", "getSTORY_DEPRECATED_TIME_SECOND", "()I", "setSTORY_DEPRECATED_TIME_SECOND", "(I)V", "STORY_FRIENDLY_TIME_SECOND", "StoryMixPath", "", "getStoryMixPath", "()Ljava/lang/String;", "StoryRootPath", "getStoryRootPath", "setStoryRootPath", "(Ljava/lang/String;)V", "StoryTypeImage", "StoryTypeNone", "StoryTypeVideo", "videoRequestMaxThreadCount", "cleanMixFile", "", "getRecordTempPath", "timeStamp", "", "getRecordThumbTempPath", "plugin-story_release"})
  public static final class a
  {
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    public static final class a
      implements Runnable
    {
      public static final a zrL;
      
      static
      {
        AppMethodBeat.i(118666);
        zrL = new a();
        AppMethodBeat.o(118666);
      }
      
      public final void run()
      {
        AppMethodBeat.i(118665);
        Object localObject1 = i.zrK;
        localObject1 = new com.tencent.mm.vfs.e(i.dVx()).fxX();
        if (localObject1 != null)
        {
          if (localObject1.length > 1) {
            d.a.e.a((Object[])localObject1, (Comparator)new a());
          }
          int k = localObject1.length;
          int j = 0;
          int i = 0;
          while (j < k)
          {
            Object localObject2 = localObject1[j];
            if (i >= 4) {
              localObject2.delete();
            }
            j += 1;
            i += 1;
          }
        }
        AppMethodBeat.o(118665);
      }
      
      @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
      public static final class a<T>
        implements Comparator<T>
      {
        public final int compare(T paramT1, T paramT2)
        {
          AppMethodBeat.i(118664);
          int i = a.a((Comparable)Long.valueOf(((com.tencent.mm.vfs.e)paramT2).lastModified()), (Comparable)Long.valueOf(((com.tencent.mm.vfs.e)paramT1).lastModified()));
          AppMethodBeat.o(118664);
          return i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.i
 * JD-Core Version:    0.7.0.1
 */