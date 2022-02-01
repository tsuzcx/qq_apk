package com.tencent.mm.plugin.voip;

import android.content.Context;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.model.x;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.video.camera.a.b;
import com.tencent.mm.plugin.voip.video.f.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/BaseVoipMgr;", "Lcom/tencent/mm/plugin/voip/ui/IVoipUIListener;", "Lcom/tencent/mm/plugin/voip/model/VoipUiCallBacks;", "Lcom/tencent/mm/plugin/voip/video/camera/common/ICaptureRenderListener;", "Lcom/tencent/mm/plugin/voip/video/VoipFaceDetector$FaceDetectCallback;", "Lcom/tencent/mm/plugin/voip/model/VoipNetStatusChecker$OnNetStatusChangeCallback;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "()V", "getRiskTips", "", "getState", "", "getUserName", "getiInterruptCnt", "getlInterruptEndTime", "", "getlInterruptStartTime", "isOutCall", "", "isVideoCall", "resetStateMachine", "", "startVoIP", "context", "Landroid/content/Context;", "userName", "roomKey", "plugin-voip_release"})
public abstract class a
  implements SurfaceTexture.OnFrameAvailableListener, r.a, x, c, b, f.a
{
  public abstract void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract boolean fEZ();
  
  public abstract boolean fFa();
  
  public abstract String fFb();
  
  public abstract long fFc();
  
  public abstract long fFd();
  
  public abstract int fFe();
  
  public abstract int getState();
  
  public abstract String getUserName();
  
  public abstract void wQ(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a
 * JD-Core Version:    0.7.0.1
 */