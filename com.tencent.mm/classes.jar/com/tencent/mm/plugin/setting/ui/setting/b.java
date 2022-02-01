package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  LinearLayout wkH;
  LinearLayout wkI;
  LinearLayout wkJ;
  LinearLayout wkK;
  LinearLayout wkL;
  
  public final void amZ(String paramString)
  {
    AppMethodBeat.i(74625);
    if (paramString.equals("downloading"))
    {
      this.wkH.setVisibility(0);
      this.wkI.setVisibility(8);
      this.wkJ.setVisibility(8);
      this.wkK.setVisibility(8);
      this.wkL.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.wkH.setVisibility(8);
      this.wkI.setVisibility(0);
      this.wkJ.setVisibility(8);
      this.wkK.setVisibility(8);
      this.wkL.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.wkH.setVisibility(8);
      this.wkI.setVisibility(8);
      this.wkJ.setVisibility(0);
      this.wkK.setVisibility(8);
      this.wkL.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("using"))
    {
      this.wkH.setVisibility(8);
      this.wkI.setVisibility(8);
      this.wkJ.setVisibility(8);
      this.wkK.setVisibility(0);
      this.wkL.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.wkH.setVisibility(8);
      this.wkI.setVisibility(8);
      this.wkJ.setVisibility(8);
      this.wkK.setVisibility(8);
      this.wkL.setVisibility(0);
      AppMethodBeat.o(74625);
      return;
    }
    AppMethodBeat.o(74625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.b
 * JD-Core Version:    0.7.0.1
 */