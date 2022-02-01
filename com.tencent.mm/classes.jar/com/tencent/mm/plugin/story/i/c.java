package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ge;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "()V", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "setFromUser", "(Ljava/lang/String;)V", "storyOwner", "getStoryOwner", "setStoryOwner", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"})
public final class c
  extends ge
{
  public static final a ATL;
  private static final com.tencent.mm.sdk.e.c.a info;
  public String ALG = "";
  public String dyU = "";
  
  static
  {
    AppMethodBeat.i(119482);
    ATL = new a((byte)0);
    info = ge.Vv();
    AppMethodBeat.o(119482);
  }
  
  public final void aBP(String paramString)
  {
    AppMethodBeat.i(119480);
    p.h(paramString, "<set-?>");
    this.ALG = paramString;
    AppMethodBeat.o(119480);
  }
  
  public final void aCd(String paramString)
  {
    AppMethodBeat.i(119479);
    p.h(paramString, "<set-?>");
    this.dyU = paramString;
    AppMethodBeat.o(119479);
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(119481);
    com.tencent.mm.sdk.e.c.a locala = info;
    p.g(locala, "info");
    AppMethodBeat.o(119481);
    return locala;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.c
 * JD-Core Version:    0.7.0.1
 */