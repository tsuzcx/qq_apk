package com.tencent.mm.plugin.recordvideo.b;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/config/CameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-recordvideo_release"})
public final class a$b
  implements com.tencent.mm.media.widget.camerarecordview.a.a
{
  public final int Xh()
  {
    AppMethodBeat.i(150562);
    c localc = c.qbf;
    if (c.isInit())
    {
      localc = c.qbf;
      i = c.cgk();
      AppMethodBeat.o(150562);
      return i;
    }
    int i = this.qaT.qaF.qbo;
    AppMethodBeat.o(150562);
    return i;
  }
  
  public final String Xi()
  {
    AppMethodBeat.i(150564);
    String str = this.qaT.qaF.thumbPath;
    j.p(str, "configProvider.thumbPath");
    AppMethodBeat.o(150564);
    return str;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(150563);
    String str = this.qaT.qaF.qbA;
    j.p(str, "configProvider.inputVideoPath");
    AppMethodBeat.o(150563);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.a.b
 * JD-Core Version:    0.7.0.1
 */