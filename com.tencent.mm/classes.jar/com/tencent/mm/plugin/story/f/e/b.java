package com.tencent.mm.plugin.story.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/model/mix/VLogMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "()V", "TAG", "", "onFinish", "", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public static final b zve;
  
  static
  {
    AppMethodBeat.i(118971);
    zve = new b();
    AppMethodBeat.o(118971);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118970);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.VLogMixManager", "onFinish, taskId:" + paramString + " success:" + paramBoolean + " model:" + paramCaptureVideoNormalModel);
    a.zuX.a(paramString, paramBoolean, paramCaptureVideoNormalModel);
    paramString = com.tencent.mm.plugin.recordvideo.e.b.wDE;
    com.tencent.mm.plugin.recordvideo.e.b.c(paramCaptureVideoNormalModel);
    AppMethodBeat.o(118970);
  }
  
  public final void ahm(String paramString)
  {
    AppMethodBeat.i(118967);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.VLogMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = g.wmx;
    e locale = g.aqy(paramString);
    if (locale == null)
    {
      AppMethodBeat.o(118967);
      return;
    }
    localObject = locale.duk();
    if (localObject != null)
    {
      localObject = ((afq)localObject).wqG;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      new com.tencent.mm.ac.b("runMixInBackground");
      a locala = a.zuX;
      a.a(locale, (String)localObject, new ddx(), (d.g.a.b)new a(paramString));
      AppMethodBeat.o(118967);
      return;
    }
  }
  
  public final void ahn(String paramString)
  {
    AppMethodBeat.i(118969);
    k.h(paramString, "taskId");
    AppMethodBeat.o(118969);
  }
  
  public final void dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(118968);
    k.h(paramString, "taskId");
    ac.i("MicroMsg.VLogMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt + ' ');
    AppMethodBeat.o(118968);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "storyLocalId", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<Integer, y>
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.b
 * JD-Core Version:    0.7.0.1
 */