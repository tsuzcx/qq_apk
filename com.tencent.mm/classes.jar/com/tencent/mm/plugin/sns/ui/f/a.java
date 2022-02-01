package com.tencent.mm.plugin.sns.ui.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;

public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  private MMActivity iMV;
  public String taskId;
  public boolean wOv;
  public adp zjF;
  public VideoMixer.MixConfig zjG;
  public afq zjH;
  private a zjI;
  
  public a(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(100444);
    this.wOv = true;
    ac.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper");
    this.iMV = paramMMActivity;
    this.zjI = parama;
    AppMethodBeat.o(100444);
  }
  
  public final boolean L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100449);
    if (this.zjF == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.SnsFakeVLogHelper", "doClick %b", new Object[] { Boolean.valueOf(bool) });
      if (this.zjF != null) {
        break;
      }
      AppMethodBeat.o(100449);
      return false;
    }
    try
    {
      Intent localIntent = new Intent(this.iMV, Class.forName("com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity"));
      localIntent.putExtra("intent_taskid", this.taskId);
      localIntent.putExtra("intent_thumbpath", this.zjF.thumbPath);
      localIntent.putExtra("sns_video_scene", 6);
      localIntent.putExtra("img_gallery_left", paramInt1);
      localIntent.putExtra("img_gallery_top", paramInt2);
      localIntent.putExtra("img_gallery_width", paramInt3);
      localIntent.putExtra("img_gallery_height", paramInt4);
      this.iMV.startActivityForResult(localIntent, 12);
      this.iMV.overridePendingTransition(0, 0);
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
    ac.i("MicroMsg.SnsFakeVLogHelper", "onFinish,success:%b taskId:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if ((paramString != null) && (paramString.equals(this.taskId)))
    {
      this.wOv = true;
      paramString = com.tencent.mm.plugin.recordvideo.background.a.wme;
      com.tencent.mm.plugin.recordvideo.background.a.b(7, this);
      paramString = com.tencent.mm.plugin.recordvideo.e.b.wDE;
      com.tencent.mm.plugin.recordvideo.e.b.c(paramCaptureVideoNormalModel);
      this.zjI.d(paramCaptureVideoNormalModel);
    }
    AppMethodBeat.o(100448);
  }
  
  public final void ahm(String paramString)
  {
    AppMethodBeat.i(100445);
    ac.i("MicroMsg.SnsFakeVLogHelper", "onInit, taskId:%s", new Object[] { paramString });
    g localg = g.wmx;
    g.aqy(paramString).duk();
    localg = g.wmx;
    g.duw();
    this.taskId = paramString;
    AppMethodBeat.o(100445);
  }
  
  public final void ahn(String paramString)
  {
    AppMethodBeat.i(100447);
    ac.i("MicroMsg.SnsFakeVLogHelper", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100447);
  }
  
  public final boolean dSx()
  {
    return !this.wOv;
  }
  
  public final void dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(100446);
    ac.i("MicroMsg.SnsFakeVLogHelper", "onRun, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100446);
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