package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gu;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/autogen/table/BaseStoryVideoCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()I", "setCacheSize", "(I)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "downloadFinish", "", "downloadFinishAndCheckFile", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "resetVideo", "", "toString", "Companion", "plugin-story_release"})
public final class n
  extends gu
{
  public static final a FwG;
  private static final IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(119603);
    FwG = new a((byte)0);
    info = gu.ajs();
    AppMethodBeat.o(119603);
  }
  
  public final boolean alN()
  {
    return (this.field_totalSize > 0) && (this.field_cacheSize == this.field_totalSize);
  }
  
  public final boolean frQ()
  {
    AppMethodBeat.i(119600);
    if ((alN()) && (s.YS(this.field_filePath)))
    {
      AppMethodBeat.o(119600);
      return true;
    }
    AppMethodBeat.o(119600);
    return false;
  }
  
  public final void frR()
  {
    this.field_cacheSize = 0;
    this.field_totalSize = 0;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119601);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.g(localMAutoDBInfo, "info");
    AppMethodBeat.o(119601);
    return localMAutoDBInfo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119602);
    String str = this.field_storyId + ", " + this.field_filePath + ", cacheSize:" + this.field_cacheSize + ", totalSize:" + this.field_totalSize;
    AppMethodBeat.o(119602);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.n
 * JD-Core Version:    0.7.0.1
 */