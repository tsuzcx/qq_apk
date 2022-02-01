package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b
{
  LinearLayout DfK;
  LinearLayout DfL;
  LinearLayout DfM;
  LinearLayout DfN;
  LinearLayout DfO;
  
  public final void aNi(String paramString)
  {
    AppMethodBeat.i(74625);
    if (paramString.equals("downloading"))
    {
      this.DfK.setVisibility(0);
      this.DfL.setVisibility(8);
      this.DfM.setVisibility(8);
      this.DfN.setVisibility(8);
      this.DfO.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.DfK.setVisibility(8);
      this.DfL.setVisibility(0);
      this.DfM.setVisibility(8);
      this.DfN.setVisibility(8);
      this.DfO.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.DfK.setVisibility(8);
      this.DfL.setVisibility(8);
      this.DfM.setVisibility(0);
      this.DfN.setVisibility(8);
      this.DfO.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("using"))
    {
      this.DfK.setVisibility(8);
      this.DfL.setVisibility(8);
      this.DfM.setVisibility(8);
      this.DfN.setVisibility(0);
      this.DfO.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.DfK.setVisibility(8);
      this.DfL.setVisibility(8);
      this.DfM.setVisibility(8);
      this.DfN.setVisibility(8);
      this.DfO.setVisibility(0);
      AppMethodBeat.o(74625);
      return;
    }
    AppMethodBeat.o(74625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.b
 * JD-Core Version:    0.7.0.1
 */