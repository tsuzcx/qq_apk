package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ae;

final class CropImageNewUI$22
  implements Runnable
{
  CropImageNewUI$22(CropImageNewUI paramCropImageNewUI) {}
  
  public final void run()
  {
    boolean bool = false;
    if (CropImageNewUI.e(this.vYH) == null) {
      return;
    }
    if (this.vYH.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false))
    {
      localObject1 = this.vYH.getSharedPreferences(ae.cqR(), 0).edit();
      if (CropImageNewUI.e(this.vYH).findViewById(R.h.cropimage_filter_gallery).getVisibility() == 0) {
        bool = true;
      }
      ((SharedPreferences.Editor)localObject1).putBoolean("CropImage_Filter_Show", bool);
      ((SharedPreferences.Editor)localObject1).commit();
    }
    Object localObject2 = this.vYH.getIntent().getStringExtra("CropImage_OutputPath");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = e.dzD + g.o(new StringBuilder().append(CropImageNewUI.o(this.vYH)).append(System.currentTimeMillis()).toString().getBytes()) + "_fiter.jpg";
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("CropImage_Compress_Img", true);
    if (CropImageNewUI.e(this.vYH) != null) {
      ((Intent)localObject2).putExtra("CropImage_filterId", CropImageNewUI.e(this.vYH).getFilterId());
    }
    if (CropImageNewUI.e(this.vYH).getFilterId() == 0)
    {
      ((Intent)localObject2).putExtra("CropImage_OutputPath", CropImageNewUI.o(this.vYH));
      this.vYH.setResult(-1, (Intent)localObject2);
    }
    for (;;)
    {
      this.vYH.finish();
      return;
      if (CropImageNewUI.a(this.vYH, CropImageNewUI.e(this.vYH).getFilterBmp(), (String)localObject1))
      {
        ((Intent)localObject2).putExtra("CropImage_OutputPath", (String)localObject1);
        this.vYH.setResult(-1, (Intent)localObject2);
      }
      else
      {
        this.vYH.setResult(-1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.22
 * JD-Core Version:    0.7.0.1
 */