package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.d;

final class SightSettingsUI$b$1
  implements h.d
{
  SightSettingsUI$b$1(SightSettingsUI.b paramb) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = this.mqT.mqR[paramInt1];
      SightSettingsUI.b(this.mqT.mqM).set(this.mqT.mqS, Integer.valueOf(paramInt1));
      SightSettingsUI.c(this.mqT.mqM).notifyDataSetChanged();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SightSettingsUI", localException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightSettingsUI.b.1
 * JD-Core Version:    0.7.0.1
 */