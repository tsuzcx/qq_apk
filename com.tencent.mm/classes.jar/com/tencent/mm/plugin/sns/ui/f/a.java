package com.tencent.mm.plugin.sns.ui.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public final class a
  implements com.tencent.mm.plugin.recordvideo.background.b
{
  public agh ATh;
  public VideoMixer.MixConfig ATi;
  public aip ATj;
  private a ATk;
  private MMActivity fNT;
  public String taskId;
  public boolean yrU;
  
  public a(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(100444);
    this.yrU = true;
    ae.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper");
    this.fNT = paramMMActivity;
    this.ATk = parama;
    AppMethodBeat.o(100444);
  }
  
  public final boolean L(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100449);
    if (this.ATh == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.SnsFakeVLogHelper", "doClick %b", new Object[] { Boolean.valueOf(bool) });
      if (this.ATh != null) {
        break;
      }
      AppMethodBeat.o(100449);
      return false;
    }
    try
    {
      Intent localIntent = new Intent(this.fNT, Class.forName("com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity"));
      localIntent.putExtra("intent_taskid", this.taskId);
      localIntent.putExtra("intent_thumbpath", this.ATh.thumbPath);
      localIntent.putExtra("sns_video_scene", 6);
      localIntent.putExtra("img_gallery_left", paramInt1);
      localIntent.putExtra("img_gallery_top", paramInt2);
      localIntent.putExtra("img_gallery_width", paramInt3);
      localIntent.putExtra("img_gallery_height", paramInt4);
      this.fNT.startActivityForResult(localIntent, 12);
      this.fNT.overridePendingTransition(0, 0);
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
    ae.i("MicroMsg.SnsFakeVLogHelper", "onFinish,success:%b taskId:%s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if ((paramString != null) && (paramString.equals(this.taskId)))
    {
      this.yrU = true;
      paramString = com.tencent.mm.plugin.recordvideo.background.a.xJX;
      com.tencent.mm.plugin.recordvideo.background.a.b(7, this);
      paramString = com.tencent.mm.plugin.recordvideo.e.b.yhe;
      com.tencent.mm.plugin.recordvideo.e.b.c(paramCaptureVideoNormalModel);
      this.ATk.d(paramCaptureVideoNormalModel);
    }
    AppMethodBeat.o(100448);
  }
  
  public final void amO(String paramString)
  {
    AppMethodBeat.i(100445);
    ae.i("MicroMsg.SnsFakeVLogHelper", "onInit, taskId:%s", new Object[] { paramString });
    e locale = e.xKl;
    e.awN(paramString).dHX();
    locale = e.xKl;
    e.dIj();
    this.taskId = paramString;
    AppMethodBeat.o(100445);
  }
  
  public final void amP(String paramString)
  {
    AppMethodBeat.i(100447);
    ae.i("MicroMsg.SnsFakeVLogHelper", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100447);
  }
  
  public final void dS(String paramString, int paramInt)
  {
    AppMethodBeat.i(100446);
    ae.i("MicroMsg.SnsFakeVLogHelper", "onRun, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100446);
  }
  
  public final boolean eiy()
  {
    return !this.yrU;
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