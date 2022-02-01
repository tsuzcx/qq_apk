package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.gx;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "()V", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "setFromUser", "(Ljava/lang/String;)V", "storyOwner", "getStoryOwner", "setStoryOwner", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"})
public final class c
  extends gx
{
  public static final a LQc;
  private static final IAutoDBItem.MAutoDBInfo info;
  public String LIb = "";
  public String fLi = "";
  
  static
  {
    AppMethodBeat.i(119482);
    LQc = new a((byte)0);
    info = gx.aoY();
    AppMethodBeat.o(119482);
  }
  
  public final void bdh(String paramString)
  {
    AppMethodBeat.i(119480);
    p.k(paramString, "<set-?>");
    this.LIb = paramString;
    AppMethodBeat.o(119480);
  }
  
  public final void bdv(String paramString)
  {
    AppMethodBeat.i(119479);
    p.k(paramString, "<set-?>");
    this.fLi = paramString;
    AppMethodBeat.o(119479);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119481);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    p.j(localMAutoDBInfo, "info");
    AppMethodBeat.o(119481);
    return localMAutoDBInfo;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.c
 * JD-Core Version:    0.7.0.1
 */