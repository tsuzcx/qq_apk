package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditFontResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_PATH", "", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class e
  extends a
{
  private static final h BYk;
  public static final e BYn;
  
  static
  {
    AppMethodBeat.i(237492);
    BYn = new e();
    BYk = new h(0);
    AppMethodBeat.o(237492);
  }
  
  public final int eLi()
  {
    return 75;
  }
  
  public final String[] eLj()
  {
    return new String[] { "path" };
  }
  
  public final String eLk()
  {
    AppMethodBeat.i(237491);
    String str = b.aKC() + "fonts/";
    AppMethodBeat.o(237491);
    return str;
  }
  
  public final String eLl()
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