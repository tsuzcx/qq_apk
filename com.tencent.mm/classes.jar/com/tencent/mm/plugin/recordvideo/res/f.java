package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditTransitionResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "RES_FILE_PAG", "RES_FILE_SVG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class f
  extends a
{
  public static final f xHC;
  private static final g xHy;
  
  static
  {
    AppMethodBeat.i(200423);
    xHC = new f();
    xHy = new g(20);
    AppMethodBeat.o(200423);
  }
  
  public final int dGT()
  {
    return 76;
  }
  
  public final String[] dGU()
  {
    return new String[] { "pag" };
  }
  
  public final String dGV()
  {
    AppMethodBeat.i(200422);
    String str = b.arN() + "transition/";
    AppMethodBeat.o(200422);
    return str;
  }
  
  public final String dGW()
  {
    return "WeChatVideoTransitionResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditTransitionResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.f
 * JD-Core Version:    0.7.0.1
 */