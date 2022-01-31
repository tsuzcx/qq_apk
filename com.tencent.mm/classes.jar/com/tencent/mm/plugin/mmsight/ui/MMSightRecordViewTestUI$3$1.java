package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;

final class MMSightRecordViewTestUI$3$1
  implements MMSightRecordView.g
{
  MMSightRecordViewTestUI$3$1(MMSightRecordViewTestUI.3 param3) {}
  
  public final void D(Bitmap paramBitmap)
  {
    AppMethodBeat.i(55118);
    if (paramBitmap != null) {
      ((ImageView)this.oOl.oOk.findViewById(2131822243)).setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(55118);
  }
  
  public final void aCO() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.3.1
 * JD-Core Version:    0.7.0.1
 */