package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  LinearLayout Jlq;
  LinearLayout Jlr;
  LinearLayout Jls;
  LinearLayout Jlt;
  LinearLayout Jlu;
  
  public final void aXR(String paramString)
  {
    AppMethodBeat.i(74625);
    if (paramString.equals("downloading"))
    {
      this.Jlq.setVisibility(0);
      this.Jlr.setVisibility(8);
      this.Jls.setVisibility(8);
      this.Jlt.setVisibility(8);
      this.Jlu.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.Jlq.setVisibility(8);
      this.Jlr.setVisibility(0);
      this.Jls.setVisibility(8);
      this.Jlt.setVisibility(8);
      this.Jlu.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.Jlq.setVisibility(8);
      this.Jlr.setVisibility(8);
      this.Jls.setVisibility(0);
      this.Jlt.setVisibility(8);
      this.Jlu.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("using"))
    {
      this.Jlq.setVisibility(8);
      this.Jlr.setVisibility(8);
      this.Jls.setVisibility(8);
      this.Jlt.setVisibility(0);
      this.Jlu.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.Jlq.setVisibility(8);
      this.Jlr.setVisibility(8);
      this.Jls.setVisibility(8);
      this.Jlt.setVisibility(8);
      this.Jlu.setVisibility(0);
      AppMethodBeat.o(74625);
      return;
    }
    AppMethodBeat.o(74625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.b
 * JD-Core Version:    0.7.0.1
 */