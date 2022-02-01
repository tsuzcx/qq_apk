package com.tencent.mm.plugin.recordvideo.res;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.xlabeffect.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/res/VideoLabelModelResLogic;", "Lcom/tencent/mm/plugin/recordvideo/res/BaseVideoResLogic;", "()V", "RES_FILE_NAME", "", "TAG", "reporter", "Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "getReporter", "()Lcom/tencent/mm/plugin/recordvideo/res/VideoResIDKeyReport;", "afterUnZipRes", "", "success", "", "getFileDirName", "getFilePathKeys", "", "()[Ljava/lang/String;", "getModelFilePath", "getResParentPath", "getResType", "", "getTag", "isModelReady", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  private static final h NRP;
  public static final g NRT;
  
  static
  {
    AppMethodBeat.i(279647);
    NRT = new g();
    NRP = new h(75);
    AppMethodBeat.o(279647);
  }
  
  public final void Bq(boolean paramBoolean)
  {
    AppMethodBeat.i(279681);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VideoLabelModelResLogic", s.X("afterUnZipRes, success:", Boolean.valueOf(paramBoolean)));
      Object localObject = new StringBuilder();
      d locald = d.XJR;
      localObject = ((StringBuilder)localObject).append(d.iFJ()).append('/');
      locald = d.XJR;
      localObject = d.iFO();
      y.qn(getModelFilePath(), (String)localObject);
      Log.i("MicroMsg.VideoLabelModelResLogic", "afterUnZipRes, copy image label model path, from:" + getModelFilePath() + " to " + (String)localObject);
    }
    AppMethodBeat.o(279681);
  }
  
  public final boolean gJF()
  {
    AppMethodBeat.i(279673);
    if ((this.NRG) && (y.ZC(getModelFilePath())))
    {
      AppMethodBeat.o(279673);
      return true;
    }
    AppMethodBeat.o(279673);
    return false;
  }
  
  public final int gJq()
  {
    return 80;
  }
  
  public final String[] gJr()
  {
    return new String[] { "path" };
  }
  
  public final String gJs()
  {
    AppMethodBeat.i(279657);
    String str = s.X(b.bms(), "ImageLabel/");
    AppMethodBeat.o(279657);
    return str;
  }
  
  public final String gJt()
  {
    return "ImageLabelModel/";
  }
  
  public final String getModelFilePath()
  {
    AppMethodBeat.i(279668);
    String str = s.X(gJs(), "ImageLabel.xnet");
    AppMethodBeat.o(279668);
    return str;
  }
  
  public final String getTag()
  {
    return "MicroMsg.VideoLabelModelResLogic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.res.g
 * JD-Core Version:    0.7.0.1
 */