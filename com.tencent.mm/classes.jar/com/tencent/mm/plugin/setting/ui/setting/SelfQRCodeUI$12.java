package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.i;

final class SelfQRCodeUI$12
  implements Runnable
{
  SelfQRCodeUI$12(SelfQRCodeUI paramSelfQRCodeUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(299016);
    Toast.makeText(this.PpF, b.i.save_image_err, 1).show();
    AppMethodBeat.o(299016);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI.12
 * JD-Core Version:    0.7.0.1
 */