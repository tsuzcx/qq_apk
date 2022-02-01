package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  LinearLayout zaS;
  LinearLayout zaT;
  LinearLayout zaU;
  LinearLayout zaV;
  LinearLayout zaW;
  
  public final void ayy(String paramString)
  {
    AppMethodBeat.i(74625);
    if (paramString.equals("downloading"))
    {
      this.zaS.setVisibility(0);
      this.zaT.setVisibility(8);
      this.zaU.setVisibility(8);
      this.zaV.setVisibility(8);
      this.zaW.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.zaS.setVisibility(8);
      this.zaT.setVisibility(0);
      this.zaU.setVisibility(8);
      this.zaV.setVisibility(8);
      this.zaW.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.zaS.setVisibility(8);
      this.zaT.setVisibility(8);
      this.zaU.setVisibility(0);
      this.zaV.setVisibility(8);
      this.zaW.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("using"))
    {
      this.zaS.setVisibility(8);
      this.zaT.setVisibility(8);
      this.zaU.setVisibility(8);
      this.zaV.setVisibility(0);
      this.zaW.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.zaS.setVisibility(8);
      this.zaT.setVisibility(8);
      this.zaU.setVisibility(8);
      this.zaV.setVisibility(8);
      this.zaW.setVisibility(0);
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