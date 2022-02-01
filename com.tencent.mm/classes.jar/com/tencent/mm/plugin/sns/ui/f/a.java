package com.tencent.mm.plugin.sns.ui.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public afy ABG;
  public VideoMixer.MixConfig ABH;
  public aif ABI;
  private a ABJ;
  private MMActivity fLP;
  public String taskId;
  public boolean ycd;
  
  public a(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(100444);
    this.ycd = true;
    ad.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper");
    this.fLP = paramMMActivity;
    this.ABJ = parama;
    AppMethodBeat.o(100444);
  }
  
  public final boolean L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100449);
    if (this.ABG == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsFakeVLogHelper", "doClick %b", new Object[] { Boolean.valueOf(bool) });
      if (this.ABG != null) {
        break;
      }
      AppMethodBeat.o(100449);
      return false;
    }
    try
    {
      Intent localIntent = new Intent(this.fLP, Class.forName("com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity"));
      localIntent.putExtra("intent_taskid", this.taskId);
      localIntent.putExtra("intent_thumbpath", this.ABG.thumbPath);
      localIntent.putExtra("sns_video_scene", 6);
      localIntent.putExtra("img_gallery_left", paramInt1);
      localIntent.putExtra("img_gallery_top", paramInt2);
      localIntent.putExtra("img_gallery_width", paramInt3);
      localIntent.putExtra("img_gallery_height", paramInt4);
      this.fLP.startActivityForResult(localIntent, 12);
      this.fLP.overridePendingTransition(0, 0);
      label166:
      AppMethodBeat.o(100449);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label166;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel)
  {
    AppMethodBeat.i(100448);
    ad.i("MicroMsg.SnsFakeVLogHelper", "onFinish,success:%b taskId:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if ((paramString != null) && (paramString.equals(this.taskId)))
    {
      this.ycd = true;
      paramString = com.tencent.mm.plugin.recordvideo.background.a.xua;
      com.tencent.mm.plugin.recordvideo.background.a.b(7, this);
      paramString = com.tencent.mm.plugin.recordvideo.e.b.xRl;
      com.tencent.mm.plugin.recordvideo.e.b.c(paramCaptureVideoNormalModel);
      this.ABJ.d(paramCaptureVideoNormalModel);
    }
    AppMethodBeat.o(100448);
  }
  
  public final void alO(String paramString)
  {
    AppMethodBeat.i(100445);
    ad.i("MicroMsg.SnsFakeVLogHelper", "onInit, taskId:%s", new Object[] { paramString });
    e locale = e.xuo;
    e.avy(paramString).dEG();
    locale = e.xuo;
    e.dES();
    this.taskId = paramString;
    AppMethodBeat.o(100445);
  }
  
  public final void alP(String paramString)
  {
    AppMethodBeat.i(100447);
    ad.i("MicroMsg.SnsFakeVLogHelper", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100447);
  }
  
  public final void dO(String paramString, int paramInt)
  {
    AppMethodBeat.i(100446);
    ad.i("MicroMsg.SnsFakeVLogHelper", "onRun, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100446);
  }
  
  public final boolean eeR()
  {
    return !this.ycd;
  }
  
  public static abstract interface a
  {
    public abstract void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.a
 * JD-Core Version:    0.7.0.1
 */