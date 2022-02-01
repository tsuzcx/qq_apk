package com.tencent.mm.plugin.story.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "", "username", "", "(Ljava/lang/String;)V", "dataState", "", "getDataState", "()I", "setDataState", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "Companion", "plugin-story_release"})
public final class e
{
  public static final a BgR;
  int BgQ;
  private String username;
  
  static
  {
    AppMethodBeat.i(119196);
    BgR = new a((byte)0);
    AppMethodBeat.o(119196);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(119195);
    this.username = paramString;
    AppMethodBeat.o(119195);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/presenter/GalleryUserState$Companion;", "", "()V", "DataStateFailed", "", "DataStateLoaded", "DataStateNone", "DataStatePreload", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.g.e
 * JD-Core Version:    0.7.0.1
 */