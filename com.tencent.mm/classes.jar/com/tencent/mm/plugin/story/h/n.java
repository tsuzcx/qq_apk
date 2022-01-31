package com.tencent.mm.plugin.story.h;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ey;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryVideoCache;", "Lcom/tencent/mm/autogen/table/BaseStoryVideoCacheInfo;", "()V", "value", "", "cacheSize", "getCacheSize", "()I", "setCacheSize", "(I)V", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "", "storyId", "getStoryId", "()J", "setStoryId", "(J)V", "totalSize", "getTotalSize", "setTotalSize", "url", "getUrl", "setUrl", "downloadFinish", "", "downloadFinishAndCheckFile", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "resetVideo", "", "toString", "Companion", "plugin-story_release"})
public final class n
  extends ey
{
  private static final c.a info;
  public static final n.a sHc;
  
  static
  {
    AppMethodBeat.i(109978);
    sHc = new n.a((byte)0);
    info = ey.Hm();
    AppMethodBeat.o(109978);
  }
  
  public final boolean Jo()
  {
    return (this.field_totalSize > 0) && (this.field_cacheSize == this.field_totalSize);
  }
  
  public final boolean cFk()
  {
    AppMethodBeat.i(109975);
    if ((Jo()) && (e.cN(this.field_filePath)))
    {
      AppMethodBeat.o(109975);
      return true;
    }
    AppMethodBeat.o(109975);
    return false;
  }
  
  public final void cFl()
  {
    this.field_cacheSize = 0;
    this.field_totalSize = 0;
  }
  
  public final c.a getDBInfo()
  {
    AppMethodBeat.i(109976);
    c.a locala = info;
    j.p(locala, "info");
    AppMethodBeat.o(109976);
    return locala;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(109977);
    String str = this.field_storyId + ", " + this.field_filePath + ", cacheSize:" + this.field_cacheSize + ", totalSize:" + this.field_totalSize;
    AppMethodBeat.o(109977);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.n
 * JD-Core Version:    0.7.0.1
 */