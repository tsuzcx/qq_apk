package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.o;
import java.util.Comparator;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  private static int FlY;
  private static String FlZ;
  private static final String Fma;
  public static final a Fmb;
  
  static
  {
    AppMethodBeat.i(118667);
    Fmb = new a((byte)0);
    FlY = 86400;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    FlZ = locale.getAccPath() + "story/";
    Fma = FlZ + "mix/";
    AppMethodBeat.o(118667);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/StoryConstants$Companion;", "", "()V", "STORY_DEPRECATED_TIME_SECOND", "", "getSTORY_DEPRECATED_TIME_SECOND", "()I", "setSTORY_DEPRECATED_TIME_SECOND", "(I)V", "STORY_FRIENDLY_TIME_SECOND", "StoryMixPath", "", "getStoryMixPath", "()Ljava/lang/String;", "StoryRootPath", "getStoryRootPath", "setStoryRootPath", "(Ljava/lang/String;)V", "StoryTypeImage", "StoryTypeNone", "StoryTypeVideo", "videoRequestMaxThreadCount", "cleanMixFile", "", "getRecordTempPath", "timeStamp", "", "getRecordThumbTempPath", "plugin-story_release"})
  public static final class a
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    public static final class a
      implements Runnable
    {
      public static final a Fmc;
      
      static
      {
        AppMethodBeat.i(118666);
        Fmc = new a();
        AppMethodBeat.o(118666);
      }
      
      public final void run()
      {
        AppMethodBeat.i(118665);
        Object localObject1 = i.Fmb;
        localObject1 = new o(i.fnV()).het();
        if (localObject1 != null)
        {
          if (localObject1.length > 1) {
            kotlin.a.e.a((Object[])localObject1, (Comparator)new a());
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
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
      public static final class a<T>
        implements Comparator<T>
      {
        public final int compare(T paramT1, T paramT2)
        {
          AppMethodBeat.i(118664);
          int i = a.a((Comparable)Long.valueOf(((o)paramT2).lastModified()), (Comparable)Long.valueOf(((o)paramT1).lastModified()));
          AppMethodBeat.o(118664);
          return i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.i
 * JD-Core Version:    0.7.0.1
 */