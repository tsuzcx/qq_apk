package com.tencent.mm.plugin.story.model;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.b;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryConstants;", "", "()V", "Companion", "plugin-story_release"})
public final class i
{
  private static int suE;
  private static String suF;
  private static final String suG;
  private static final String suH;
  private static final String suI;
  public static final a suJ;
  
  static
  {
    AppMethodBeat.i(109041);
    suJ = new a((byte)0);
    suE = 86400;
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.kernel.e locale = g.RL();
    j.p(locale, "MMKernel.storage()");
    suF = locale.getAccPath() + "story/";
    suG = suF + "temp/";
    suH = suF + "mix/";
    suI = suF + "audio/";
    AppMethodBeat.o(109041);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/model/StoryConstants$Companion;", "", "()V", "STORY_DEPRECATED_TIME_SECOND", "", "getSTORY_DEPRECATED_TIME_SECOND", "()I", "setSTORY_DEPRECATED_TIME_SECOND", "(I)V", "StoryAudioPath", "", "getStoryAudioPath", "()Ljava/lang/String;", "StoryMixPath", "getStoryMixPath", "StoryRootPath", "getStoryRootPath", "setStoryRootPath", "(Ljava/lang/String;)V", "StoryTempPath", "getStoryTempPath", "StoryTypeImage", "StoryTypeNone", "StoryTypeVideo", "videoRequestMaxThreadCount", "cleanAudioFile", "", "cleanMixFile", "cleanTempData", "getRecordTempPath", "timeStamp", "", "getRecordThumbTempPath", "setup", "accPath", "plugin-story_release"})
  public static final class a
  {
    public static String mu(long paramLong)
    {
      AppMethodBeat.i(109040);
      com.tencent.mm.vfs.e.um(i.cAs());
      String str = i.cAs() + "thumb" + paramLong + ".jpg";
      AppMethodBeat.o(109040);
      return str;
    }
    
    @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
    public static final class b
      implements Runnable
    {
      public static final b suL;
      
      static
      {
        AppMethodBeat.i(109039);
        suL = new b();
        AppMethodBeat.o(109039);
      }
      
      public final void run()
      {
        AppMethodBeat.i(109038);
        Object localObject1 = i.suJ;
        localObject1 = new b(i.cAt()).dQL();
        if (localObject1 != null)
        {
          if (localObject1.length > 1) {
            a.a.e.a((Object[])localObject1, (Comparator)new i.a.b.a());
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
        AppMethodBeat.o(109038);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.i
 * JD-Core Version:    0.7.0.1
 */