package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditTransitionResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "RES_FILE_PAG", "RES_FILE_SVG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class f
  extends a
{
  private static final h BYk;
  public static final f BYo;
  
  static
  {
    AppMethodBeat.i(237494);
    BYo = new f();
    BYk = new h(20);
    AppMethodBeat.o(237494);
  }
  
  public final int eLi()
  {
    return 76;
  }
  
  public final String[] eLj()
  {
    return new String[] { "pag" };
  }
  
  public final String eLk()
  {
    AppMethodBeat.i(237493);
    String str = b.aKC() + "transition/";
    AppMethodBeat.o(237493);
    return str;
  }
  
  public final String eLl()
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