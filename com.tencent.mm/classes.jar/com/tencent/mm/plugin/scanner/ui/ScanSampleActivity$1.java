package com.tencent.mm.plugin.scanner.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.k;
import com.tencent.scanlib.b;
import com.tencent.scanlib.ui.ScanCodeView.a;

final class ScanSampleActivity$1
  implements ScanCodeView.a
{
  ScanSampleActivity$1(ScanSampleActivity paramScanSampleActivity) {}
  
  public final void aV(Bundle paramBundle)
  {
    AppMethodBeat.i(91051);
    paramBundle = paramBundle.getString("result_content", "");
    if (!b.isNullOrNil(paramBundle)) {
      k.c(this.PaQ, paramBundle, "", true);
    }
    AppMethodBeat.o(91051);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanSampleActivity.1
 * JD-Core Version:    0.7.0.1
 */