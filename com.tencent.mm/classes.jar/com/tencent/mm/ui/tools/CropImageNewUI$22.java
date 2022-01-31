package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;

final class CropImageNewUI$22
  implements Runnable
{
  CropImageNewUI$22(CropImageNewUI paramCropImageNewUI) {}
  
  public final void run()
  {
    boolean bool = false;
    AppMethodBeat.i(34836);
    if (CropImageNewUI.e(this.AqU) == null)
    {
      AppMethodBeat.o(34836);
      return;
    }
    if (this.AqU.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false))
    {
      localObject1 = this.AqU.getSharedPreferences(ah.dsP(), 0).edit();
      if (CropImageNewUI.e(this.AqU).findViewById(2131823278).getVisibility() == 0) {
        bool = true;
      }
      ((SharedPreferences.Editor)localObject1).putBoolean("CropImage_Filter_Show", bool);
      ((SharedPreferences.Editor)localObject1).commit();
    }
    Object localObject2 = this.AqU.getIntent().getStringExtra("CropImage_OutputPath");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = e.esr + g.w(new StringBuilder().append(CropImageNewUI.o(this.AqU)).append(System.currentTimeMillis()).toString().getBytes()) + "_fiter.jpg";
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("CropImage_Compress_Img", true);
    if (CropImageNewUI.e(this.AqU) != null) {
      ((Intent)localObject2).putExtra("CropImage_filterId", CropImageNewUI.e(this.AqU).getFilterId());
    }
    if (CropImageNewUI.e(this.AqU).getFilterId() == 0)
    {
      ((Intent)localObject2).putExtra("CropImage_OutputPath", CropImageNewUI.o(this.AqU));
      this.AqU.setResult(-1, (Intent)localObject2);
    }
    for (;;)
    {
      this.AqU.finish();
      AppMethodBeat.o(34836);
      return;
      if (CropImageNewUI.a(this.AqU, CropImageNewUI.e(this.AqU).getFilterBmp(), (String)localObject1))
      {
        ((Intent)localObject2).putExtra("CropImage_OutputPath", (String)localObject1);
        this.AqU.setResult(-1, (Intent)localObject2);
      }
      else
      {
        this.AqU.setResult(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.22
 * JD-Core Version:    0.7.0.1
 */