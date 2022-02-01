package com.tencent.mm.plugin.story.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fq;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "()V", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "setFromUser", "(Ljava/lang/String;)V", "storyOwner", "getStoryOwner", "setStoryOwner", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"})
public final class c
  extends fq
{
  private static final com.tencent.mm.sdk.e.c.a info;
  public static final a yoN;
  public String dpv = "";
  public String ygM = "";
  
  static
  {
    AppMethodBeat.i(119482);
    yoN = new a((byte)0);
    info = fq.So();
    AppMethodBeat.o(119482);
  }
  
  public final void arC(String paramString)
  {
    AppMethodBeat.i(119480);
    k.h(paramString, "<set-?>");
    this.ygM = paramString;
    AppMethodBeat.o(119480);
  }
  
  public final void arQ(String paramString)
  {
    AppMethodBeat.i(119479);
    k.h(paramString, "<set-?>");
    this.dpv = paramString;
    AppMethodBeat.o(119479);
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(119481);
    com.tencent.mm.sdk.e.c.a locala = info;
    k.g(locala, "info");
    AppMethodBeat.o(119481);
    return locala;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync$Companion;", "", "()V", "info", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "kotlin.jvm.PlatformType", "getInfo", "()Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.i.c
 * JD-Core Version:    0.7.0.1
 */