package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.Size;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "", "checkCurrentInFullScreenState", "", "getContext", "Landroid/content/Context;", "onLocalDataRendererAvailable", "", "ret", "", "width", "height", "onRenderTextureSizeChanged", "size", "Landroid/util/Size;", "side", "onRendererDrawPerFrameCost", "time", "", "type", "onStartCameraError", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e
{
  public abstract void aH(long paramLong, int paramInt);
  
  public abstract void b(Size paramSize, int paramInt);
  
  public abstract void bh(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract Context getContext();
  
  public abstract void hVS();
  
  public abstract boolean hVT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.e
 * JD-Core Version:    0.7.0.1
 */