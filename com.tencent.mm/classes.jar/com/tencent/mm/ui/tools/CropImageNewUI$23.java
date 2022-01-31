package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CropImageNewUI$23
  implements Runnable
{
  CropImageNewUI$23(CropImageNewUI paramCropImageNewUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(34837);
    if (this.AqU.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false))
    {
      this.AqU.finish();
      AppMethodBeat.o(34837);
      return;
    }
    CropImageNewUI.e(this.AqU).setVisibility(8);
    CropImageNewUI.p(this.AqU).setVisibility(0);
    CropImageNewUI.q(this.AqU).setVisibility(((Integer)CropImageNewUI.q(this.AqU).getTag()).intValue());
    CropImageNewUI.j(this.AqU).setVisibility(0);
    AppMethodBeat.o(34837);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.23
 * JD-Core Version:    0.7.0.1
 */