package com.tencent.mm.plugin.story.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/model/mix/VLogMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "()V", "TAG", "", "onFinish", "", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public static final b BeB;
  
  static
  {
    AppMethodBeat.i(118971);
    BeB = new b();
    AppMethodBeat.o(118971);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118970);
    p.h(paramString, "taskId");
    ae.i("MicroMsg.VLogMixManager", "onFinish, taskId:" + paramString + " success:" + paramBoolean + " model:" + paramCaptureVideoNormalModel);
    a.Beu.a(paramString, paramBoolean, paramCaptureVideoNormalModel);
    paramString = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    com.tencent.mm.plugin.recordvideo.e.b.c(paramCaptureVideoNormalModel);
    AppMethodBeat.o(118970);
  }
  
  public final void amO(String paramString)
  {
    AppMethodBeat.i(118967);
    p.h(paramString, "taskId");
    ae.i("MicroMsg.VLogMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = e.xKl;
    c localc = e.awN(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(118967);
      return;
    }
    localObject = localc.dHX();
    if (localObject != null)
    {
      localObject = ((aip)localObject).xOt;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      new com.tencent.mm.ac.b("runMixInBackground");
      a locala = a.Beu;
      a.a(localc, (String)localObject, new dkf(), (d.g.a.b)new a(paramString));
      AppMethodBeat.o(118967);
      return;
    }
  }
  
  public final void amP(String paramString)
  {
    AppMethodBeat.i(118969);
    p.h(paramString, "taskId");
    AppMethodBeat.o(118969);
  }
  
  public final void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(118968);
    p.h(paramString, "taskId");
    ae.i("MicroMsg.VLogMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt + ' ');
    AppMethodBeat.o(118968);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "storyLocalId", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<Integer, z>
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.b
 * JD-Core Version:    0.7.0.1
 */