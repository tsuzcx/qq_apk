package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import d.b.a;
import d.g.b.p;
import d.l;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  private static int AJB;
  private static String AJC;
  private static final String AJD;
  public static final i.a AJE;
  
  static
  {
    AppMethodBeat.i(118667);
    AJE = new i.a((byte)0);
    AJB = 86400;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    AJC = locale.getAccPath() + "story/";
    AJD = AJC + "mix/";
    AppMethodBeat.o(118667);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  public static final class a$a
    implements Runnable
  {
    public static final a AJF;
    
    static
    {
      AppMethodBeat.i(118666);
      AJF = new a();
      AppMethodBeat.o(118666);
    }
    
    public final void run()
    {
      AppMethodBeat.i(118665);
      Object localObject1 = i.AJE;
      localObject1 = new com.tencent.mm.vfs.e(i.ehM()).fOM();
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
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
  public static final class a$a$a<T>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.i
 * JD-Core Version:    0.7.0.1
 */