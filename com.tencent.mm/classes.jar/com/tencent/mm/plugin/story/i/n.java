package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gj;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/autogen/table/BaseStoryVideoCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()I", "setCacheSize", "(I)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "downloadFinish", "", "downloadFinishAndCheckFile", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "resetVideo", "", "toString", "Companion", "plugin-story_release"})
public final class n
  extends gj
{
  public static final a BlQ;
  private static final c.a info;
  
  static
  {
    AppMethodBeat.i(119603);
    BlQ = new a((byte)0);
    info = gj.VD();
    AppMethodBeat.o(119603);
  }
  
  public final boolean Ya()
  {
    return (this.field_totalSize > 0) && (this.field_cacheSize == this.field_totalSize);
  }
  
  public final boolean epq()
  {
    AppMethodBeat.i(119600);
    if ((Ya()) && (o.fB(this.field_filePath)))
    {
      AppMethodBeat.o(119600);
      return true;
    }
    AppMethodBeat.o(119600);
    return false;
  }
  
  public final void epr()
  {
    this.field_cacheSize = 0;
    this.field_totalSize = 0;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(119601);
    c.a locala = info;
    p.g(locala, "info");
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.n
 * JD-Core Version:    0.7.0.1
 */