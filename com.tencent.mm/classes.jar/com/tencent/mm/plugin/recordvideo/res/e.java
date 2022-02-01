package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditFontResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_PATH", "", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"})
public final class e
  extends a
{
  private static final h HUY;
  public static final e HVb;
  
  static
  {
    AppMethodBeat.i(222684);
    HVb = new e();
    HUY = new h(0);
    AppMethodBeat.o(222684);
  }
  
  public final int fxB()
  {
    return 75;
  }
  
  public final String[] fxC()
  {
    return new String[] { "path" };
  }
  
  public final String fxD()
  {
    AppMethodBeat.i(222683);
    String str = b.aSE() + "fonts/";
    AppMethodBeat.o(222683);
    return str;
  }
  
  public final String fxE()
  {
    return "WeChatFontResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditFontResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.e
 * JD-Core Version:    0.7.0.1
 */