package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditTransitionResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "RES_FILE_PAG", "RES_FILE_SVG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class f
  extends a
{
  private static final h HUY;
  public static final f HVc;
  
  static
  {
    AppMethodBeat.i(223330);
    HVc = new f();
    HUY = new h(20);
    AppMethodBeat.o(223330);
  }
  
  public final int fxB()
  {
    return 76;
  }
  
  public final String[] fxC()
  {
    return new String[] { "pag" };
  }
  
  public final String fxD()
  {
    AppMethodBeat.i(223319);
    String str = b.aSE() + "transition/";
    AppMethodBeat.o(223319);
    return str;
  }
  
  public final String fxE()
  {
    return "WeChatVideoTransitionResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditTransitionResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.f
 * JD-Core Version:    0.7.0.1
 */