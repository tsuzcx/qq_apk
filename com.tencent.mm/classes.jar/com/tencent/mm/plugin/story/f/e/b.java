package com.tencent.mm.plugin.story.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.ent;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/model/mix/VLogMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "()V", "TAG", "", "onFinish", "", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public static final b LJu;
  
  static
  {
    AppMethodBeat.i(118971);
    LJu = new b();
    AppMethodBeat.o(118971);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118970);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onFinish, taskId:" + paramString + " success:" + paramBoolean + " model:" + paramCaptureVideoNormalModel);
    a.LJn.a(paramString, paramBoolean, paramCaptureVideoNormalModel);
    paramString = d.IeU;
    d.c(paramCaptureVideoNormalModel);
    AppMethodBeat.o(118970);
  }
  
  public final void aJO(String paramString)
  {
    AppMethodBeat.i(118967);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = e.HGz;
    com.tencent.mm.plugin.recordvideo.background.c localc = e.aVH(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(118967);
      return;
    }
    localObject = localc.fuP();
    if (localObject != null)
    {
      localObject = ((ame)localObject).HLg;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      new com.tencent.mm.ae.c("runMixInBackground");
      a locala = a.LJn;
      a.a(localc, (String)localObject, new ent(), (kotlin.g.a.b)new a(paramString));
      AppMethodBeat.o(118967);
      return;
    }
  }
  
  public final void aJP(String paramString)
  {
    AppMethodBeat.i(118969);
    p.k(paramString, "taskId");
    AppMethodBeat.o(118969);
  }
  
  public final void eF(String paramString, int paramInt)
  {
    AppMethodBeat.i(118968);
    p.k(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt + ' ');
    AppMethodBeat.o(118968);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "storyLocalId", "", "invoke"})
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