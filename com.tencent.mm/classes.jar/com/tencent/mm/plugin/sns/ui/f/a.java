package com.tencent.mm.plugin.sns.ui.f;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.VideoMixer.MixConfig;
import com.tencent.mm.plugin.recordvideo.background.b;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.e.d;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;

public final class a
  implements b
{
  public boolean Iqp;
  public ajd Lss;
  public VideoMixer.MixConfig Lst;
  public ame Lsu;
  private a Lsv;
  private MMActivity iXq;
  public String taskId;
  
  public a(MMActivity paramMMActivity, a parama)
  {
    AppMethodBeat.i(100444);
    this.Iqp = true;
    Log.i("MicroMsg.SnsFakeVLogHelper", "SnsFakeVLogHelper");
    this.iXq = paramMMActivity;
    this.Lsv = parama;
    AppMethodBeat.o(100444);
  }
  
  public final boolean R(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100449);
    if (this.Lss == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.SnsFakeVLogHelper", "doClick %b", new Object[] { Boolean.valueOf(bool) });
      if (this.Lss != null) {
        break;
      }
      AppMethodBeat.o(100449);
      return false;
    }
    try
    {
      Intent localIntent = new Intent(this.iXq, Class.forName("com.tencent.mm.plugin.vlog.ui.fake.VLogFakePlayActivity"));
      localIntent.putExtra("intent_taskid", this.taskId);
      localIntent.putExtra("intent_thumbpath", this.Lss.thumbPath);
      localIntent.putExtra("sns_video_scene", 6);
      localIntent.putExtra("img_gallery_left", paramInt1);
      localIntent.putExtra("img_gallery_top", paramInt2);
      localIntent.putExtra("img_gallery_width", paramInt3);
      localIntent.putExtra("img_gallery_height", paramInt4);
      this.iXq.startActivityForResult(localIntent, 12);
      this.iXq.overridePendingTransition(0, 0);
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
      this.Iqp = true;
      paramString = com.tencent.mm.plugin.recordvideo.background.a.HGl;
      com.tencent.mm.plugin.recordvideo.background.a.b(7, this);
      paramString = d.IeU;
      d.c(paramCaptureVideoNormalModel);
      this.Lsv.d(paramCaptureVideoNormalModel);
    }
    AppMethodBeat.o(100448);
  }
  
  public final void aJO(String paramString)
  {
    AppMethodBeat.i(100445);
    Log.i("MicroMsg.SnsFakeVLogHelper", "onInit, taskId:%s", new Object[] { paramString });
    e locale = e.HGz;
    e.aVH(paramString).fuP();
    locale = e.HGz;
    e.fva();
    this.taskId = paramString;
    AppMethodBeat.o(100445);
  }
  
  public final void aJP(String paramString)
  {
    AppMethodBeat.i(100447);
    Log.i("MicroMsg.SnsFakeVLogHelper", "onWait, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100447);
  }
  
  public final void eF(String paramString, int paramInt)
  {
    AppMethodBeat.i(100446);
    Log.i("MicroMsg.SnsFakeVLogHelper", "onRun, taskId:%s", new Object[] { paramString });
    AppMethodBeat.o(100446);
  }
  
  public final boolean fZs()
  {
    return !this.Iqp;
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