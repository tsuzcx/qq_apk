package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/render/IVoIPRendererEvent;", "", "getContext", "Landroid/content/Context;", "onLocalDataRendererAvailable", "", "ret", "", "width", "height", "onRendererDrawPerFrameCost", "time", "", "type", "onStartCameraError", "plugin-voip_release"})
public abstract interface c
{
  public abstract void aB(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void ag(long paramLong, int paramInt);
  
  public abstract void fFE();
  
  public abstract Context getContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.c
 * JD-Core Version:    0.7.0.1
 */