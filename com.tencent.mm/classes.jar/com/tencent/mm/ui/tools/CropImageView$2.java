package com.tencent.mm.ui.tools;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class CropImageView$2
  extends ak
{
  CropImageView$2(CropImageView paramCropImageView) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(107601);
    if (paramMessage.what == 4653) {
      if ((CropImageView.a(this.Arw) != null) && (CropImageView.m(this.Arw) != null))
      {
        CropImageView.m(this.Arw).cancel();
        CropImageView.n(this.Arw);
      }
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      AppMethodBeat.o(107601);
      return;
      CropImageView.o(this.Arw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageView.2
 * JD-Core Version:    0.7.0.1
 */