package com.tencent.mm.plugin.voip;

import android.content.Context;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.f;
import com.tencent.mm.plugin.voip.video.k.a;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/BaseVoipMgr;", "Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;", "Lcom/tencent/mm/plugin/voip/model/VoipUiCallBacks;", "Lcom/tencent/mm/plugin/voip/video/ICaptureRenderListener;", "Lcom/tencent/mm/plugin/voip/video/VoipFaceDetector$FaceDetectCallback;", "Lcom/tencent/mm/plugin/voip/model/VoipNetStatusChecker$OnNetStatusChangeCallback;", "Lcom/tencent/mm/sdk/platformtools/SensorController$SensorEventCallBack;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "()V", "getRiskTips", "", "getState", "", "getUserName", "getiInterruptCnt", "getlInterruptEndTime", "", "getlInterruptStartTime", "isOutCall", "", "isVideoCall", "resetStateMachine", "", "startVoIP", "context", "Landroid/content/Context;", "userName", "roomKey", "plugin-voip_release"})
public abstract class a
  implements SurfaceTexture.OnFrameAvailableListener, r.a, x, c, f, k.a, SensorController.a
{
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract boolean euF();
  
  public abstract boolean euG();
  
  public abstract String euH();
  
  public abstract long euI();
  
  public abstract long euJ();
  
  public abstract int euK();
  
  public abstract int getState();
  
  public abstract String getUserName();
  
  public abstract void ta(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a
 * JD-Core Version:    0.7.0.1
 */