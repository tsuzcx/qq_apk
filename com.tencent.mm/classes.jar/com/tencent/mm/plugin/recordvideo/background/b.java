package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "", "onFinish", "", "taskId", "", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-recordvideo_release"})
public abstract interface b
{
  public abstract void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel);
  
  public abstract void acu(String paramString);
  
  public abstract void acv(String paramString);
  
  public abstract void dr(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b
 * JD-Core Version:    0.7.0.1
 */