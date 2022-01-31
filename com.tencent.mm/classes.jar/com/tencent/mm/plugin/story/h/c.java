package com.tencent.mm.plugin.story.h;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eu;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/storage/StoryCommentSync;", "Lcom/tencent/mm/autogen/table/BaseStoryCommentSync;", "()V", "fromUser", "", "getFromUser", "()Ljava/lang/String;", "setFromUser", "(Ljava/lang/String;)V", "storyOwner", "getStoryOwner", "setStoryOwner", "addUnreadFlag", "", "checkUnreadFlag", "", "getDBInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "isUnread", "removeUnreadFlag", "Companion", "plugin-story_release"})
public final class c
  extends eu
{
  private static final com.tencent.mm.sdk.e.c.a info;
  public static final c.a sGt;
  public String czp = "";
  public String sxC = "";
  
  static
  {
    AppMethodBeat.i(109860);
    sGt = new c.a((byte)0);
    info = eu.Hm();
    AppMethodBeat.o(109860);
  }
  
  public final void adk(String paramString)
  {
    AppMethodBeat.i(138841);
    j.q(paramString, "<set-?>");
    this.sxC = paramString;
    AppMethodBeat.o(138841);
  }
  
  public final void adx(String paramString)
  {
    AppMethodBeat.i(138840);
    j.q(paramString, "<set-?>");
    this.czp = paramString;
    AppMethodBeat.o(138840);
  }
  
  public final void cEL()
  {
    AppMethodBeat.i(138842);
    int i = this.field_commentFlag;
    a.b localb = a.b.sFX;
    this.field_commentFlag = (i & (a.b.cEw() ^ 0xFFFFFFFF));
    AppMethodBeat.o(138842);
  }
  
  public final com.tencent.mm.sdk.e.c.a getDBInfo()
  {
    AppMethodBeat.i(109859);
    com.tencent.mm.sdk.e.c.a locala = info;
    j.p(locala, "info");
    AppMethodBeat.o(109859);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.h.c
 * JD-Core Version:    0.7.0.1
 */