package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  LinearLayout yKI;
  LinearLayout yKJ;
  LinearLayout yKK;
  LinearLayout yKL;
  LinearLayout yKM;
  
  public final void axi(String paramString)
  {
    AppMethodBeat.i(74625);
    if (paramString.equals("downloading"))
    {
      this.yKI.setVisibility(0);
      this.yKJ.setVisibility(8);
      this.yKK.setVisibility(8);
      this.yKL.setVisibility(8);
      this.yKM.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.yKI.setVisibility(8);
      this.yKJ.setVisibility(0);
      this.yKK.setVisibility(8);
      this.yKL.setVisibility(8);
      this.yKM.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.yKI.setVisibility(8);
      this.yKJ.setVisibility(8);
      this.yKK.setVisibility(0);
      this.yKL.setVisibility(8);
      this.yKM.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("using"))
    {
      this.yKI.setVisibility(8);
      this.yKJ.setVisibility(8);
      this.yKK.setVisibility(8);
      this.yKL.setVisibility(0);
      this.yKM.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.yKI.setVisibility(8);
      this.yKJ.setVisibility(8);
      this.yKK.setVisibility(8);
      this.yKL.setVisibility(8);
      this.yKM.setVisibility(0);
      AppMethodBeat.o(74625);
      return;
    }
    AppMethodBeat.o(74625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.b
 * JD-Core Version:    0.7.0.1
 */