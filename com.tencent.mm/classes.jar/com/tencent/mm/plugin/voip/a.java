package com.tencent.mm.plugin.voip;

import android.content.Context;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.plugin.voip.video.f.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/BaseVoipMgr;", "Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;", "Lcom/tencent/mm/plugin/voip/model/VoipUiCallBacks;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "Lcom/tencent/mm/plugin/voip/video/VoipFaceDetector$FaceDetectCallback;", "Lcom/tencent/mm/plugin/voip/model/VoipNetStatusChecker$OnNetStatusChangeCallback;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "()V", "getRiskTips", "", "getState", "", "getUserName", "getiInterruptCnt", "getlInterruptEndTime", "", "getlInterruptStartTime", "isForeCamera", "", "isOutCall", "isVideoCall", "resetStateMachine", "", "resumeCamera", "startVoIP", "context", "Landroid/content/Context;", "userName", "roomKey", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  implements SurfaceTexture.OnFrameAvailableListener, r.a, x, com.tencent.mm.plugin.voip.ui.c, com.tencent.mm.plugin.voip.video.camera.a.c, f.a
{
  public abstract void Gh(boolean paramBoolean);
  
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract void fwc();
  
  public abstract int getState();
  
  public abstract String getUserName();
  
  public abstract boolean hVh();
  
  public abstract boolean hVi();
  
  public abstract String hVj();
  
  public abstract long hVk();
  
  public abstract long hVl();
  
  public abstract int hVm();
  
  public abstract boolean hVn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a
 * JD-Core Version:    0.7.0.1
 */