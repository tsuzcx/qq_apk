package com.tencent.mm.plugin.story.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/model/mix/VLogMixManager;", "Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "()V", "TAG", "", "onFinish", "", "taskId", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-story_release"})
public final class b
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public static final b yif;
  
  static
  {
    AppMethodBeat.i(118971);
    yif = new b();
    AppMethodBeat.o(118971);
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(118970);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.VLogMixManager", "onFinish, taskId:" + paramString + " success:" + paramBoolean + " model:" + paramCaptureVideoNormalModel);
    a.yhX.a(paramString, paramBoolean, paramCaptureVideoNormalModel);
    paramString = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    com.tencent.mm.plugin.recordvideo.e.b.d(paramCaptureVideoNormalModel);
    AppMethodBeat.o(118970);
  }
  
  public final void acu(String paramString)
  {
    AppMethodBeat.i(118967);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.VLogMixManager", "onInit, taskId:".concat(String.valueOf(paramString)));
    Object localObject = f.vdH;
    d locald = f.alz(paramString);
    if (locald == null)
    {
      AppMethodBeat.o(118967);
      return;
    }
    localObject = locald.dgC();
    if (localObject != null)
    {
      localObject = ((aer)localObject).vhU;
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    for (;;)
    {
      new com.tencent.mm.ad.b("runMixInBackground");
      a locala = a.yhX;
      a.a(locald, (String)localObject, new cyl(), (d.g.a.b)new a(paramString));
      AppMethodBeat.o(118967);
      return;
    }
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(118969);
    k.h(paramString, "taskId");
    AppMethodBeat.o(118969);
  }
  
  public final void dr(String paramString, int paramInt)
  {
    AppMethodBeat.i(118968);
    k.h(paramString, "taskId");
    ad.i("MicroMsg.VLogMixManager", "onRun, taskId:" + paramString + " runNum:" + paramInt + ' ');
    AppMethodBeat.o(118968);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "storyLocalId", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.e.b
 * JD-Core Version:    0.7.0.1
 */