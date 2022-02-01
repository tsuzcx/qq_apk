package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS;", "", "()V", "FAIL", "", "getFAIL", "()I", "INIT", "getINIT", "OK", "getOK", "plugin-recordvideo_release"})
public final class c$b
{
  private static final int HGs = 1;
  private static final int HGt = 3;
  public static final b HGu;
  private static final int OK = 2;
  
  static
  {
    AppMethodBeat.i(75175);
    HGu = new b();
    HGs = 1;
    OK = 2;
    HGt = 3;
    AppMethodBeat.o(75175);
  }
  
  public static int cgp()
  {
    return OK;
  }
  
  public static int fuS()
  {
    return HGs;
  }
  
  public static int fuT()
  {
    return HGt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.b
 * JD-Core Version:    0.7.0.1
 */