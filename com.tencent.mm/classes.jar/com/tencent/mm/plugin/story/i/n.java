package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/autogen/table/BaseStoryVideoCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()I", "setCacheSize", "(I)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "downloadFinish", "", "downloadFinishAndCheckFile", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "resetVideo", "", "toString", "Companion", "plugin-story_release"})
public final class n
  extends fu
{
  private static final c.a info;
  public static final a ypu;
  
  static
  {
    AppMethodBeat.i(119603);
    ypu = new a((byte)0);
    info = fu.So();
    AppMethodBeat.o(119603);
  }
  
  public final boolean UE()
  {
    return (this.field_totalSize > 0) && (this.field_cacheSize == this.field_totalSize);
  }
  
  public final boolean dKR()
  {
    AppMethodBeat.i(119600);
    if ((UE()) && (i.eK(this.field_filePath)))
    {
      AppMethodBeat.o(119600);
      return true;
    }
    AppMethodBeat.o(119600);
    return false;
  }
  
  public final void dKS()
  {
    this.field_cacheSize = 0;
    this.field_totalSize = 0;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119601);
    c.a locala = info;
    k.g(locala, "info");
    AppMethodBeat.o(119601);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119602);
    String str = this.field_storyId + ", " + this.field_filePath + ", cacheSize:" + this.field_cacheSize + ", totalSize:" + this.field_totalSize;
    AppMethodBeat.o(119602);
    return str;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.n
 * JD-Core Version:    0.7.0.1
 */