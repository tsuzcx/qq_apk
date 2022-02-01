package com.tencent.mm.plugin.story.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.fir;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/model/mix/VLogMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "()V", "TAG", "", "onFinish", "", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public static final b SmN;
  
  static
  {
    AppMethodBeat.i(118971);
    SmN = new b();
    AppMethodBeat.o(118971);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118970);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onFinish, taskId:" + paramString + " success:" + paramBoolean + " model:" + paramCaptureVideoNormalModel);
    a.SmE.a(paramString, paramBoolean, paramCaptureVideoNormalModel);
    paramString = f.Obq;
    f.c(paramCaptureVideoNormalModel);
    AppMethodBeat.o(118970);
  }
  
  public final void aGD(String paramString)
  {
    AppMethodBeat.i(118967);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", s.X("onInit, taskId:", paramString));
    Object localObject = e.NDU;
    com.tencent.mm.plugin.recordvideo.background.c localc = e.aSP(paramString);
    if (localc == null)
    {
      AppMethodBeat.o(118967);
      return;
    }
    localObject = localc.gGF();
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      new com.tencent.mm.ae.c("runMixInBackground");
      a locala = a.SmE;
      a.a(localc, (String)localObject, new fir(), (kotlin.g.a.b)new a(paramString));
      AppMethodBeat.o(118967);
      return;
      localObject = ((apw)localObject).NIe;
      if (localObject == null) {
        localObject = "";
      }
    }
  }
  
  public final void aGE(String paramString)
  {
    AppMethodBeat.i(118969);
    s.u(paramString, "taskId");
    AppMethodBeat.o(118969);
  }
  
  public final void fv(String paramString, int paramInt)
  {
    AppMethodBeat.i(118968);
    s.u(paramString, "taskId");
    Log.i("MicroMsg.VLogMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt + ' ');
    AppMethodBeat.o(118968);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "storyLocalId", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Integer, ah>
  {
    a(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.model.e.b
 * JD-Core Version:    0.7.0.1
 */