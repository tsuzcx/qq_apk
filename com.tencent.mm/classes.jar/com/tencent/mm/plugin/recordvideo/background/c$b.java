package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS_;", "", "()V", "FAIL", "", "getFAIL", "()I", "INIT", "getINIT", "OK", "getOK", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
{
  public static final b NDQ;
  private static final int NDR;
  private static final int NDS;
  private static final int OK;
  
  static
  {
    AppMethodBeat.i(279444);
    NDQ = new b();
    NDR = 1;
    OK = 2;
    NDS = 3;
    AppMethodBeat.o(279444);
  }
  
  public static int cHj()
  {
    return OK;
  }
  
  public static int gGI()
  {
    return NDR;
  }
  
  public static int gGJ()
  {
    return NDS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.b
 * JD-Core Version:    0.7.0.1
 */