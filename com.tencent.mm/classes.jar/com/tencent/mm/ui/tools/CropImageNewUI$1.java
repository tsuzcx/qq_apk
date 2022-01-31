package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class CropImageNewUI$1
  implements Runnable
{
  CropImageNewUI$1(CropImageNewUI paramCropImageNewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34814);
    if (!CropImageNewUI.a(this.AqU))
    {
      AppMethodBeat.o(34814);
      return;
    }
    if ((!CropImageNewUI.b(this.AqU)) && (!CropImageNewUI.c(this.AqU)) && (this.AqU.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)))
    {
      CropImageNewUI.d(this.AqU);
      if (!this.AqU.getSharedPreferences(ah.dsP(), 0).getBoolean("CropImage_Filter_Show", true)) {
        CropImageNewUI.e(this.AqU).findViewById(2131823278).setVisibility(4);
      }
      AppMethodBeat.o(34814);
      return;
    }
    if (1 == CropImageNewUI.f(this.AqU)) {
      CropImageNewUI.g(this.AqU);
    }
    AppMethodBeat.o(34814);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.1
 * JD-Core Version:    0.7.0.1
 */