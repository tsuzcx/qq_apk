package com.tencent.mm.plugin.nearlife.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;

final class NearLifeCreatePoiUI$8
  implements DialogInterface.OnClickListener
{
  NearLifeCreatePoiUI$8(NearLifeCreatePoiUI paramNearLifeCreatePoiUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(11138, new Object[] { "3", "0", NearLifeCreatePoiUI.b(this.mFF) });
    this.mFF.setResult(0, new Intent());
    this.mFF.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.NearLifeCreatePoiUI.8
 * JD-Core Version:    0.7.0.1
 */