package com.tencent.mm.plugin.story.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hs;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "()V", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "setFromUser", "(Ljava/lang/String;)V", "storyOwner", "getStoryOwner", "setStoryOwner", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends hs
{
  public static final c.a SsO;
  private static final IAutoDBItem.MAutoDBInfo info;
  public String SlC = "";
  public String hQQ = "";
  
  static
  {
    AppMethodBeat.i(119482);
    SsO = new c.a((byte)0);
    info = hs.aJm();
    AppMethodBeat.o(119482);
  }
  
  public final void bbU(String paramString)
  {
    AppMethodBeat.i(119480);
    s.u(paramString, "<set-?>");
    this.SlC = paramString;
    AppMethodBeat.o(119480);
  }
  
  public final void bci(String paramString)
  {
    AppMethodBeat.i(119479);
    s.u(paramString, "<set-?>");
    this.hQQ = paramString;
    AppMethodBeat.o(119479);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    AppMethodBeat.i(119481);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = info;
    s.s(localMAutoDBInfo, "info");
    AppMethodBeat.o(119481);
    return localMAutoDBInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */