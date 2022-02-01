package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/res/VideoLabelModelResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "TAG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "afterUnZipRes", "", "success", "", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getModelFilePath", "getResParentPath", "getResType", "", "getTag", "isModelReady", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private static final h HUY;
  public static final g HVd;
  
  static
  {
    AppMethodBeat.i(218659);
    HVd = new g();
    HUY = new h(75);
    AppMethodBeat.o(218659);
  }
  
  public final int fxB()
  {
    return 80;
  }
  
  public final String[] fxC()
  {
    return new String[] { "path" };
  }
  
  public final String fxD()
  {
    AppMethodBeat.i(218651);
    String str = b.aSE() + "ImageLabel/";
    AppMethodBeat.o(218651);
    return str;
  }
  
  public final String fxE()
  {
    return "ImageLabelModel/";
  }
  
  public final String fxR()
  {
    AppMethodBeat.i(218653);
    String str = fxD() + "ImageLabel.xnet";
    AppMethodBeat.o(218653);
    return str;
  }
  
  public final boolean fxS()
  {
    AppMethodBeat.i(218654);
    if ((this.HUN) && (u.agG(fxR())))
    {
      AppMethodBeat.o(218654);
      return true;
    }
    AppMethodBeat.o(218654);
    return false;
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoLabelModelResLogic";
  }
  
  public final void wQ(boolean paramBoolean)
  {
    AppMethodBeat.i(218656);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VideoLabelModelResLogic", "afterUnZipRes, success:".concat(String.valueOf(paramBoolean)));
      Object localObject = new StringBuilder();
      com.tencent.mm.plugin.xlabeffect.h localh = com.tencent.mm.plugin.xlabeffect.h.QQH;
      localObject = ((StringBuilder)localObject).append(com.tencent.mm.plugin.xlabeffect.h.hfj()).append("/");
      localh = com.tencent.mm.plugin.xlabeffect.h.QQH;
      localObject = com.tencent.mm.plugin.xlabeffect.h.hfl();
      u.oo(fxR(), (String)localObject);
      Log.i("MicroMsg.VideoLabelModelResLogic", "afterUnZipRes, copy image label model path, from:" + fxR() + " to " + (String)localObject);
    }
    AppMethodBeat.o(218656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.g
 * JD-Core Version:    0.7.0.1
 */