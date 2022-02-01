package com.tencent.mm.plugin.recordvideo.background;

import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/IBgMixCallback;", "", "onFinish", "", "taskId", "", "success", "", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "onInit", "onRun", "runNum", "", "onWait", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface b
{
  public abstract void a(String paramString, boolean paramBoolean, CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel);
  
  public abstract void aGD(String paramString);
  
  public abstract void aGE(String paramString);
  
  public abstract void fv(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b
 * JD-Core Version:    0.7.0.1
 */