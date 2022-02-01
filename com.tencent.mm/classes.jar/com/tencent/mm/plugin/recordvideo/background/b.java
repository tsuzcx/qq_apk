package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "", "onFinish", "", "taskId", "", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-recordvideo_release"})
public abstract interface b
{
  public abstract void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel);
  
  public abstract void alO(String paramString);
  
  public abstract void alP(String paramString);
  
  public abstract void dO(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b
 * JD-Core Version:    0.7.0.1
 */