package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  LinearLayout xvX;
  LinearLayout xvY;
  LinearLayout xvZ;
  LinearLayout xwa;
  LinearLayout xwb;
  
  public final void asi(String paramString)
  {
    AppMethodBeat.i(74625);
    if (paramString.equals("downloading"))
    {
      this.xvX.setVisibility(0);
      this.xvY.setVisibility(8);
      this.xvZ.setVisibility(8);
      this.xwa.setVisibility(8);
      this.xwb.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.xvX.setVisibility(8);
      this.xvY.setVisibility(0);
      this.xvZ.setVisibility(8);
      this.xwa.setVisibility(8);
      this.xwb.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.xvX.setVisibility(8);
      this.xvY.setVisibility(8);
      this.xvZ.setVisibility(0);
      this.xwa.setVisibility(8);
      this.xwb.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("using"))
    {
      this.xvX.setVisibility(8);
      this.xvY.setVisibility(8);
      this.xvZ.setVisibility(8);
      this.xwa.setVisibility(0);
      this.xwb.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.xvX.setVisibility(8);
      this.xvY.setVisibility(8);
      this.xvZ.setVisibility(8);
      this.xwa.setVisibility(8);
      this.xwb.setVisibility(0);
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