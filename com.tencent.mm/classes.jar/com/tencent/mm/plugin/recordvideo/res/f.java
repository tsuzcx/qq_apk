package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditTransitionResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "RES_FILE_PAG", "RES_FILE_SVG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class f
  extends a
{
  private static final g xXt;
  public static final f xXx;
  
  static
  {
    AppMethodBeat.i(206684);
    xXx = new f();
    xXt = new g(20);
    AppMethodBeat.o(206684);
  }
  
  public final int dKk()
  {
    return 76;
  }
  
  public final String[] dKl()
  {
    return new String[] { "pag" };
  }
  
  public final String dKm()
  {
    AppMethodBeat.i(206683);
    String str = b.asc() + "transition/";
    AppMethodBeat.o(206683);
    return str;
  }
  
  public final String dKn()
  {
    return "WeChatVideoTransitionResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditTransitionResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.f
 * JD-Core Version:    0.7.0.1
 */