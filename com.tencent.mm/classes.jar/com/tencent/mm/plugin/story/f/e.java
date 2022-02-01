package com.tencent.mm.plugin.story.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/GalleryUserState;", "", "username", "", "(Ljava/lang/String;)V", "dataState", "", "getDataState", "()I", "setDataState", "(I)V", "getUsername", "()Ljava/lang/String;", "setUsername", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a SoS;
  int SoT;
  private String username;
  
  static
  {
    AppMethodBeat.i(119196);
    SoS = new a((byte)0);
    AppMethodBeat.o(119196);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(119195);
    this.username = paramString;
    AppMethodBeat.o(119195);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/presenter/GalleryUserState$Companion;", "", "()V", "DataStateFailed", "", "DataStateLoaded", "DataStateNone", "DataStatePreload", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e
 * JD-Core Version:    0.7.0.1
 */