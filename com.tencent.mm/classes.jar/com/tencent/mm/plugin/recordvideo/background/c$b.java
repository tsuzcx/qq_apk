package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS;", "", "()V", "FAIL", "", "getFAIL", "()I", "INIT", "getINIT", "OK", "getOK", "plugin-recordvideo_release"})
public final class c$b
{
  private static final int OK = 2;
  private static final int xKe = 1;
  private static final int xKf = 3;
  public static final b xKg;
  
  static
  {
    AppMethodBeat.i(75175);
    xKg = new b();
    xKe = 1;
    OK = 2;
    xKf = 3;
    AppMethodBeat.o(75175);
  }
  
  public static int bxa()
  {
    return OK;
  }
  
  public static int dIb()
  {
    return xKe;
  }
  
  public static int dIc()
  {
    return xKf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.c.b
 * JD-Core Version:    0.7.0.1
 */