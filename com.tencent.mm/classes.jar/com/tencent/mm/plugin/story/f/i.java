package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.vfs.q;
import java.util.Comparator;
import kotlin.a.e;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  private static int LGa;
  private static String LGb;
  private static final String LGc;
  public static final a LGd;
  
  static
  {
    AppMethodBeat.i(118667);
    LGd = new a((byte)0);
    LGa = 86400;
    StringBuilder localStringBuilder = new StringBuilder();
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    LGb = localf.getAccPath() + "story/";
    LGc = LGb + "mix/";
    AppMethodBeat.o(118667);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/StoryConstants$Companion;", "", "()V", "STORY_DEPRECATED_TIME_SECOND", "", "getSTORY_DEPRECATED_TIME_SECOND", "()I", "setSTORY_DEPRECATED_TIME_SECOND", "(I)V", "STORY_FRIENDLY_TIME_SECOND", "StoryMixPath", "", "getStoryMixPath", "()Ljava/lang/String;", "StoryRootPath", "getStoryRootPath", "setStoryRootPath", "(Ljava/lang/String;)V", "StoryTypeImage", "StoryTypeNone", "StoryTypeVideo", "videoRequestMaxThreadCount", "cleanMixFile", "", "getRecordTempPath", "timeStamp", "", "getRecordThumbTempPath", "plugin-story_release"})
  public static final class a
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    public static final class a
      implements Runnable
    {
      public static final a LGe;
      
      static
      {
        AppMethodBeat.i(118666);
        LGe = new a();
        AppMethodBeat.o(118666);
      }
      
      public final void run()
      {
        AppMethodBeat.i(118665);
        Object localObject1 = i.LGd;
        localObject1 = new q(i.gcp()).ifJ();
        if (localObject1 != null)
        {
          if (localObject1.length > 1) {
            e.a((Object[])localObject1, (Comparator)new a());
          }
          int k = localObject1.length;
          int j = 0;
          int i = 0;
          while (j < k)
          {
            Object localObject2 = localObject1[j];
            if (i >= 4) {
              localObject2.cFq();
            }
            j += 1;
            i += 1;
          }
        }
        AppMethodBeat.o(118665);
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
      public static final class a<T>
        implements Comparator<T>
      {
        public final int compare(T paramT1, T paramT2)
        {
          AppMethodBeat.i(118664);
          int i = a.a((Comparable)Long.valueOf(((q)paramT2).lastModified()), (Comparable)Long.valueOf(((q)paramT1).lastModified()));
          AppMethodBeat.o(118664);
          return i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.i
 * JD-Core Version:    0.7.0.1
 */