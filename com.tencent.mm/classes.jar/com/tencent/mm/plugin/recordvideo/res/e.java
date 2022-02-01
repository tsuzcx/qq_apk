package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditFontResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_PATH", "", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class e
  extends a
{
  private static final g xXt;
  public static final e xXw;
  
  static
  {
    AppMethodBeat.i(206682);
    xXw = new e();
    xXt = new g(0);
    AppMethodBeat.o(206682);
  }
  
  public final int dKk()
  {
    return 75;
  }
  
  public final String[] dKl()
  {
    return new String[] { "path" };
  }
  
  public final String dKm()
  {
    AppMethodBeat.i(206681);
    String str = b.asc() + "fonts/";
    AppMethodBeat.o(206681);
    return str;
  }
  
  public final String dKn()
  {
    return "WeChatFontResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditFontResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.e
 * JD-Core Version:    0.7.0.1
 */