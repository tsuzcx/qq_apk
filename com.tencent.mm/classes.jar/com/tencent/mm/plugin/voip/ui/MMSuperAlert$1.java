package com.tencent.mm.plugin.voip.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class MMSuperAlert$1
  implements Runnable
{
  MMSuperAlert$1(MMSuperAlert paramMMSuperAlert, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(4782);
    String str1;
    if (this.tBW == 0)
    {
      str1 = "";
      if (this.tBX != 0) {
        break label78;
      }
    }
    label78:
    for (String str2 = "";; str2 = this.tBZ.getString(this.tBX))
    {
      h.a(this.tBZ, str1, str2, this.tBY, new MMSuperAlert.1.1(this), new MMSuperAlert.1.2(this));
      AppMethodBeat.o(4782);
      return;
      str1 = this.tBZ.getString(this.tBW);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.MMSuperAlert.1
 * JD-Core Version:    0.7.0.1
 */