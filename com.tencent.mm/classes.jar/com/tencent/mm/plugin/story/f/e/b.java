package com.tencent.mm.plugin.story.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.eds;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/model/mix/VLogMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "()V", "TAG", "", "onFinish", "", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public static final b Fps;
  
  static
  {
    AppMethodBeat.i(118971);
    Fps = new b();
    AppMethodBeat.o(118971);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118970);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onFinish, taskId:" + paramString + " success:" + paramBoolean + " model:" + paramCaptureVideoNormalModel);
    a.Fpl.a(paramString, paramBoolean, paramCaptureVideoNormalModel);
    paramString = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    com.tencent.mm.plugin.recordvideo.e.c.c(paramCaptureVideoNormalModel);
    AppMethodBeat.o(118970);
  }
  
  public final void aAd(String paramString)
  {
    AppMethodBeat.i(118967);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = e.BKp;
    com.tencent.mm.plugin.recordvideo.background.c localc = e.aLf(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(118967);
      return;
    }
    localObject = localc.eIK();
    if (localObject != null)
    {
      localObject = ((ald)localObject).BOA;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      new com.tencent.mm.ac.c("runMixInBackground");
      a locala = a.Fpl;
      a.a(localc, (String)localObject, new eds(), (kotlin.g.a.b)new a(paramString));
      AppMethodBeat.o(118967);
      return;
    }
  }
  
  public final void aAe(String paramString)
  {
    AppMethodBeat.i(118969);
    p.h(paramString, "taskId");
    AppMethodBeat.o(118969);
  }
  
  public final void eh(String paramString, int paramInt)
  {
    AppMethodBeat.i(118968);
    p.h(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt + ' ');
    AppMethodBeat.o(118968);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "storyLocalId", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<Integer, x>
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.b
 * JD-Core Version:    0.7.0.1
 */