package com.tencent.mm.plugin.story.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.u;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.b.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a SjL;
  private static int SjM;
  private static String SjN;
  private static final String SjO;
  
  static
  {
    AppMethodBeat.i(118667);
    SjL = new a((byte)0);
    SjM = 86400;
    String str = s.X(h.baE().mCJ, "story/");
    SjN = str;
    SjO = s.X(str, "mix/");
    AppMethodBeat.o(118667);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/StoryConstants$Companion;", "", "()V", "STORY_DEPRECATED_TIME_SECOND", "", "getSTORY_DEPRECATED_TIME_SECOND", "()I", "setSTORY_DEPRECATED_TIME_SECOND", "(I)V", "STORY_FRIENDLY_TIME_SECOND", "StoryMixPath", "", "getStoryMixPath", "()Ljava/lang/String;", "StoryRootPath", "getStoryRootPath", "setStoryRootPath", "(Ljava/lang/String;)V", "StoryTypeImage", "StoryTypeNone", "StoryTypeVideo", "videoRequestMaxThreadCount", "cleanMixFile", "", "getRecordTempPath", "timeStamp", "", "getRecordThumbTempPath", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void hvC()
    {
      AppMethodBeat.i(367131);
      ThreadPool.post(i.a..ExternalSyntheticLambda0.INSTANCE, "Story_cleanAudioFile");
      AppMethodBeat.o(367131);
    }
    
    private static final void hvD()
    {
      AppMethodBeat.i(367133);
      Object localObject1 = i.SjL;
      localObject1 = new u(i.hvB()).jKX();
      if (localObject1 != null)
      {
        if (localObject1.length > 1) {
          k.a((Object[])localObject1, (Comparator)new a());
        }
        int k = localObject1.length;
        int j = 0;
        int i = 0;
        while (j < k)
        {
          Object localObject2 = localObject1[j];
          if (i >= 4) {
            localObject2.diJ();
          }
          j += 1;
          i += 1;
        }
      }
      AppMethodBeat.o(367133);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
    public static final class a<T>
      implements Comparator
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(367138);
        int i = a.b((Comparable)Long.valueOf(((u)paramT2).lastModified()), (Comparable)Long.valueOf(((u)paramT1).lastModified()));
        AppMethodBeat.o(367138);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.i
 * JD-Core Version:    0.7.0.1
 */