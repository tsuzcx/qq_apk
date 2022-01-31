package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  LinearLayout qLM;
  LinearLayout qLN;
  LinearLayout qLO;
  LinearLayout qLP;
  LinearLayout qLQ;
  
  public final void YY(String paramString)
  {
    AppMethodBeat.i(127689);
    if (paramString.equals("downloading"))
    {
      this.qLM.setVisibility(0);
      this.qLN.setVisibility(8);
      this.qLO.setVisibility(8);
      this.qLP.setVisibility(8);
      this.qLQ.setVisibility(8);
      AppMethodBeat.o(127689);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.qLM.setVisibility(8);
      this.qLN.setVisibility(0);
      this.qLO.setVisibility(8);
      this.qLP.setVisibility(8);
      this.qLQ.setVisibility(8);
      AppMethodBeat.o(127689);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.qLM.setVisibility(8);
      this.qLN.setVisibility(8);
      this.qLO.setVisibility(0);
      this.qLP.setVisibility(8);
      this.qLQ.setVisibility(8);
      AppMethodBeat.o(127689);
      return;
    }
    if (paramString.equals("using"))
    {
      this.qLM.setVisibility(8);
      this.qLN.setVisibility(8);
      this.qLO.setVisibility(8);
      this.qLP.setVisibility(0);
      this.qLQ.setVisibility(8);
      AppMethodBeat.o(127689);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.qLM.setVisibility(8);
      this.qLN.setVisibility(8);
      this.qLO.setVisibility(8);
      this.qLP.setVisibility(8);
      this.qLQ.setVisibility(0);
      AppMethodBeat.o(127689);
      return;
    }
    AppMethodBeat.o(127689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.b
 * JD-Core Version:    0.7.0.1
 */