package com.tencent.mm.plugin.sns.ui.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  private MMActivity imP;
  public String taskId;
  public boolean vEq;
  public acq xWK;
  public VideoMixer.MixConfig xWL;
  public aer xWM;
  private a xWN;
  
  public a(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(100444);
    this.vEq = true;
    ad.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper");
    this.imP = paramMMActivity;
    this.xWN = parama;
    AppMethodBeat.o(100444);
  }
  
  public final boolean J(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100449);
    if (this.xWK == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.SnsFakeVLogHelper", "doClick %b", new Object[] { Boolean.valueOf(bool) });
      if (this.xWK != null) {
        break;
      }
      AppMethodBeat.o(100449);
      return false;
    }
    try
    {
      Intent localIntent = new Intent(this.imP, Class.forName("com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity"));
      localIntent.putExtra("intent_taskid", this.taskId);
      localIntent.putExtra("intent_thumbpath", this.xWK.thumbPath);
      localIntent.putExtra("sns_video_scene", 6);
      localIntent.putExtra("img_gallery_left", paramInt1);
      localIntent.putExtra("img_gallery_top", paramInt2);
      localIntent.putExtra("img_gallery_width", paramInt3);
      localIntent.putExtra("img_gallery_height", paramInt4);
      this.imP.startActivityForResult(localIntent, 12);
      this.imP.overridePendingTransition(0, 0);
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
      this.vEq = true;
      paramString = com.tencent.mm.plugin.recordvideo.background.a.vdo;
      com.tencent.mm.plugin.recordvideo.background.a.b(7, this);
      paramString = com.tencent.mm.plugin.recordvideo.e.b.vtE;
      com.tencent.mm.plugin.recordvideo.e.b.d(paramCaptureVideoNormalModel);
      this.xWN.e(paramCaptureVideoNormalModel);
    }
    AppMethodBeat.o(100448);
  }
  
  public final void acu(String paramString)
  {
    AppMethodBeat.i(100445);
    ad.i("MicroMsg.SnsFakeVLogHelper", "onInit, taskId:%s", new Object[] { paramString });
    f localf = f.vdH;
    f.alz(paramString).dgC();
    localf = f.vdH;
    f.dgO();
    this.taskId = paramString;
    AppMethodBeat.o(100445);
  }
  
  public final void acv(String paramString)
  {
    AppMethodBeat.i(100447);
    ad.i("MicroMsg.SnsFakeVLogHelper", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100447);
  }
  
  public final boolean dDZ()
  {
    return !this.vEq;
  }
  
  public final void dr(String paramString, int paramInt)
  {
    AppMethodBeat.i(100446);
    ad.i("MicroMsg.SnsFakeVLogHelper", "onRun, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100446);
  }
  
  public static abstract interface a
  {
    public abstract void e(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.a
 * JD-Core Version:    0.7.0.1
 */