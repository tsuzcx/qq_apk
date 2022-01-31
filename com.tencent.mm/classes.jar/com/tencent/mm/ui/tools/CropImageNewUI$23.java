package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;

final class CropImageNewUI$23
  implements Runnable
{
  CropImageNewUI$23(CropImageNewUI paramCropImageNewUI) {}
  
  public final void run()
  {
    if (this.vYH.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false))
    {
      this.vYH.finish();
      return;
    }
    CropImageNewUI.e(this.vYH).setVisibility(8);
    CropImageNewUI.p(this.vYH).setVisibility(0);
    CropImageNewUI.q(this.vYH).setVisibility(((Integer)CropImageNewUI.q(this.vYH).getTag()).intValue());
    CropImageNewUI.j(this.vYH).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.23
 * JD-Core Version:    0.7.0.1
 */