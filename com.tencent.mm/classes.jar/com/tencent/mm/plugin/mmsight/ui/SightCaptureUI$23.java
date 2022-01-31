package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.model.e;

final class SightCaptureUI$23
  implements MMSightRecordButton.c
{
  SightCaptureUI$23(SightCaptureUI paramSightCaptureUI) {}
  
  public final void qm(int paramInt)
  {
    if (SightCaptureUI.h(this.mqB) != null) {
      SightCaptureUI.h(this.mqB).c(true, true, paramInt);
    }
  }
  
  public final void qn(int paramInt)
  {
    if (SightCaptureUI.h(this.mqB) != null) {
      SightCaptureUI.h(this.mqB).c(false, true, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.23
 * JD-Core Version:    0.7.0.1
 */