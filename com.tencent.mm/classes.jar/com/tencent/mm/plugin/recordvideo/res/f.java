package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VideoEditTransitionResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "RES_FILE_PAG", "RES_FILE_SVG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getResParentPath", "getResType", "", "getTag", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a
{
  private static final h NRP;
  public static final f NRS;
  
  static
  {
    AppMethodBeat.i(279646);
    NRS = new f();
    NRP = new h(20);
    AppMethodBeat.o(279646);
  }
  
  public final int gJq()
  {
    return 76;
  }
  
  public final String[] gJr()
  {
    return new String[] { "pag" };
  }
  
  public final String gJs()
  {
    AppMethodBeat.i(279650);
    String str = s.X(b.bms(), "transition/");
    AppMethodBeat.o(279650);
    return str;
  }
  
  public final String gJt()
  {
    return "WeChatVideoTransitionResource/";
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoEditTransitionResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.f
 * JD-Core Version:    0.7.0.1
 */