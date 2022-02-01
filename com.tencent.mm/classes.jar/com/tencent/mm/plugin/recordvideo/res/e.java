package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditFontResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_PATH", "", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  private static final h NRP;
  public static final e NRR;
  
  static
  {
    AppMethodBeat.i(279645);
    NRR = new e();
    NRP = new h(0);
    AppMethodBeat.o(279645);
  }
  
  public final int gJq()
  {
    return 75;
  }
  
  public final String[] gJr()
  {
    return new String[] { "path" };
  }
  
  public final String gJs()
  {
    AppMethodBeat.i(279648);
    String str = s.X(b.bms(), "fonts/");
    AppMethodBeat.o(279648);
    return str;
  }
  
  public final String gJt()
  {
    return "WeChatFontResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditFontResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.e
 * JD-Core Version:    0.7.0.1
 */