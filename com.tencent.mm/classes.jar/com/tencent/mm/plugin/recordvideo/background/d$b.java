package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData$STATUS;", "", "()V", "FAIL", "", "getFAIL", "()I", "INIT", "getINIT", "OK", "getOK", "plugin-recordvideo_release"})
public final class d$b
{
  private static final int OK = 2;
  private static final int vdB = 1;
  private static final int vdC = 3;
  public static final b vdD;
  
  static
  {
    AppMethodBeat.i(75175);
    vdD = new b();
    vdB = 1;
    OK = 2;
    vdC = 3;
    AppMethodBeat.o(75175);
  }
  
  public static int blq()
  {
    return OK;
  }
  
  public static int dgG()
  {
    return vdB;
  }
  
  public static int dgH()
  {
    return vdC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.d.b
 * JD-Core Version:    0.7.0.1
 */