package com.tencent.mm.plugin.sns.ui.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class a
  implements b
{
  public boolean CsL;
  public aio FdN;
  public VideoMixer.MixConfig FdO;
  public ald FdP;
  private a FdQ;
  private MMActivity gte;
  public String taskId;
  
  public a(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(100444);
    this.CsL = true;
    Log.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper");
    this.gte = paramMMActivity;
    this.FdQ = parama;
    AppMethodBeat.o(100444);
  }
  
  public final boolean M(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100449);
    if (this.FdN == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsFakeVLogHelper", "doClick %b", new Object[] { Boolean.valueOf(bool) });
      if (this.FdN != null) {
        break;
      }
      AppMethodBeat.o(100449);
      return false;
    }
    try
    {
      Intent localIntent = new Intent(this.gte, Class.forName("com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity"));
      localIntent.putExtra("intent_taskid", this.taskId);
      localIntent.putExtra("intent_thumbpath", this.FdN.thumbPath);
      localIntent.putExtra("sns_video_scene", 6);
      localIntent.putExtra("img_gallery_left", paramInt1);
      localIntent.putExtra("img_gallery_top", paramInt2);
      localIntent.putExtra("img_gallery_width", paramInt3);
      localIntent.putExtra("img_gallery_height", paramInt4);
      this.gte.startActivityForResult(localIntent, 12);
      this.gte.overridePendingTransition(0, 0);
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
    Log.i("MicroMsg.SnsFakeVLogHelper", "onFinish,success:%b taskId:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if ((paramString != null) && (paramString.equals(this.taskId)))
    {
      this.CsL = true;
      paramString = com.tencent.mm.plugin.recordvideo.background.a.BKb;
      com.tencent.mm.plugin.recordvideo.background.a.b(7, this);
      paramString = com.tencent.mm.plugin.recordvideo.e.c.Cic;
      com.tencent.mm.plugin.recordvideo.e.c.c(paramCaptureVideoNormalModel);
      this.FdQ.d(paramCaptureVideoNormalModel);
    }
    AppMethodBeat.o(100448);
  }
  
  public final void aAd(String paramString)
  {
    AppMethodBeat.i(100445);
    Log.i("MicroMsg.SnsFakeVLogHelper", "onInit, taskId:%s", new Object[] { paramString });
    e locale = e.BKp;
    e.aLf(paramString).eIK();
    locale = e.BKp;
    e.eIW();
    this.taskId = paramString;
    AppMethodBeat.o(100445);
  }
  
  public final void aAe(String paramString)
  {
    AppMethodBeat.i(100447);
    Log.i("MicroMsg.SnsFakeVLogHelper", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100447);
  }
  
  public final void eh(String paramString, int paramInt)
  {
    AppMethodBeat.i(100446);
    Log.i("MicroMsg.SnsFakeVLogHelper", "onRun, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100446);
  }
  
  public final boolean fkY()
  {
    return !this.CsL;
  }
  
  public static abstract interface a
  {
    public abstract void d(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.f.a
 * JD-Core Version:    0.7.0.1
 */