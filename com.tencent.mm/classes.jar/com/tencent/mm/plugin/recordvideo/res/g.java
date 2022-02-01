package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.xlabeffect.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/res/VideoLabelModelResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "TAG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "afterUnZipRes", "", "success", "", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getModelFilePath", "getResParentPath", "getResType", "", "getTag", "isModelReady", "plugin-recordvideo_release"})
public final class g
  extends a
{
  private static final h BYk;
  public static final g BYp;
  
  static
  {
    AppMethodBeat.i(237499);
    BYp = new g();
    BYk = new h(75);
    AppMethodBeat.o(237499);
  }
  
  public final int eLi()
  {
    return 80;
  }
  
  public final String[] eLj()
  {
    return new String[] { "path" };
  }
  
  public final String eLk()
  {
    AppMethodBeat.i(237495);
    String str = b.aKC() + "ImageLabel/";
    AppMethodBeat.o(237495);
    return str;
  }
  
  public final String eLl()
  {
    return "ImageLabelModel/";
  }
  
  public final String eLy()
  {
    AppMethodBeat.i(237496);
    String str = eLk() + "ImageLabel.xnet";
    AppMethodBeat.o(237496);
    return str;
  }
  
  public final boolean eLz()
  {
    AppMethodBeat.i(237497);
    if ((this.BXZ) && (s.YS(eLy())))
    {
      AppMethodBeat.o(237497);
      return true;
    }
    AppMethodBeat.o(237497);
    return false;
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoLabelModelResLogic";
  }
  
  public final void tu(boolean paramBoolean)
  {
    AppMethodBeat.i(237498);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VideoLabelModelResLogic", "afterUnZipRes, success:".concat(String.valueOf(paramBoolean)));
      Object localObject = new StringBuilder();
      e locale = e.JRF;
      localObject = ((StringBuilder)localObject).append(e.glu()).append("/");
      locale = e.JRF;
      localObject = e.glv();
      s.nx(eLy(), (String)localObject);
      Log.i("MicroMsg.VideoLabelModelResLogic", "afterUnZipRes, copy image label model path, from:" + eLy() + " to " + (String)localObject);
    }
    AppMethodBeat.o(237498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.g
 * JD-Core Version:    0.7.0.1
 */