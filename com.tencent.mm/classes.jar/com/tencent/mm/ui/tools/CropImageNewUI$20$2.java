package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.n.d;

final class CropImageNewUI$20$2
  implements n.d
{
  CropImageNewUI$20$2(CropImageNewUI.20 param20) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(34833);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(34833);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("CropImage_OutputPath", this.AqZ.AqU.getIntent().getStringExtra("CropImage_OutputPath"));
      paramMenuItem.putExtra("OP_CODE", 1);
      this.AqZ.AqU.setResult(-1, paramMenuItem);
      this.AqZ.AqU.finish();
      AppMethodBeat.o(34833);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("CropImage_OutputPath", this.AqZ.AqU.getIntent().getStringExtra("CropImage_OutputPath"));
      paramMenuItem.putExtra("OP_CODE", 2);
      this.AqZ.AqU.setResult(-1, paramMenuItem);
      this.AqZ.AqU.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.20.2
 * JD-Core Version:    0.7.0.1
 */