package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditFontResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_PATH", "", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class e
  extends a
{
  public static final e xHB;
  private static final g xHy;
  
  static
  {
    AppMethodBeat.i(200421);
    xHB = new e();
    xHy = new g(0);
    AppMethodBeat.o(200421);
  }
  
  public final int dGT()
  {
    return 75;
  }
  
  public final String[] dGU()
  {
    return new String[] { "path" };
  }
  
  public final String dGV()
  {
    AppMethodBeat.i(200420);
    String str = b.arN() + "fonts/";
    AppMethodBeat.o(200420);
    return str;
  }
  
  public final String dGW()
  {
    return "WeChatFontResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditFontResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.e
 * JD-Core Version:    0.7.0.1
 */