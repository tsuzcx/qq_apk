package com.tencent.mm.plugin.recordvideo.plugin;

import a.l;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a.b;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.f.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/plugin/RemuxPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "abaParams", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getContext", "()Landroid/content/Context;", "setContext", "enable", "", "loading", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter$StoryProgressDialog;", "mediaCaptureInfo", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "checkSaveThumb", "", "videoPath", "", "thumbPath", "doFinish", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "getABAPrams", "editConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig;", "encodeConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "getMixer", "Lcom/tencent/mm/plugin/story/model/mix/StoryVideoMixer;", "getTransformInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "runForeGround", "runMixInBackground", "setCaptureInfo", "info", "setMoovHead", "path", "startReMux", "Companion", "plugin-recordvideo_release"})
public final class w
  implements q
{
  public static final w.a qdd;
  public Context context;
  public boolean enable;
  public b oQp;
  public RecordConfigProvider qaF;
  public b.a qdb;
  public int[] qdc;
  
  static
  {
    AppMethodBeat.i(150730);
    qdd = new w.a((byte)0);
    AppMethodBeat.o(150730);
  }
  
  public w(Context paramContext)
  {
    AppMethodBeat.i(150729);
    this.context = paramContext;
    this.qdc = new int[] { 0, 0, 0, 0, 0, 0 };
    this.enable = true;
    AppMethodBeat.o(150729);
  }
  
  public static void XY(String paramString)
  {
    AppMethodBeat.i(150727);
    long l = bo.yB();
    SightVideoJNI.optimizeMP4(paramString);
    ab.d("MicroMsg.RemuxPlugin", "time cost: " + bo.av(l));
    AppMethodBeat.o(150727);
  }
  
  public static void fT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(155503);
    if (e.cN(paramString2))
    {
      AppMethodBeat.o(155503);
      return;
    }
    paramString1 = com.tencent.mm.plugin.mmsight.d.ut(paramString1);
    if (paramString1 != null) {
      com.tencent.mm.sdk.platformtools.d.a(paramString1, 100, Bitmap.CompressFormat.JPEG, paramString2, true);
    }
    AppMethodBeat.o(155503);
  }
  
  public final void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(150728);
    CaptureDataManager.qbh.a(this.context, paramCaptureVideoNormalModel);
    AppMethodBeat.o(150728);
  }
  
  public final boolean cgq()
  {
    return false;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void release() {}
  
  public final void reset() {}
  
  public final void setVisibility(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.w
 * JD-Core Version:    0.7.0.1
 */