package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SingleTopScanUI
  extends BaseScanUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.SingleTopScanUI
 * JD-Core Version:    0.7.0.1
 */