package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
{
  LinearLayout PxP;
  LinearLayout PxQ;
  LinearLayout PxR;
  LinearLayout PxS;
  LinearLayout PxT;
  
  public final void aVJ(String paramString)
  {
    AppMethodBeat.i(74625);
    if (paramString.equals("downloading"))
    {
      this.PxP.setVisibility(0);
      this.PxQ.setVisibility(8);
      this.PxR.setVisibility(8);
      this.PxS.setVisibility(8);
      this.PxT.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("downloaded"))
    {
      this.PxP.setVisibility(8);
      this.PxQ.setVisibility(0);
      this.PxR.setVisibility(8);
      this.PxS.setVisibility(8);
      this.PxT.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("undownloaded"))
    {
      this.PxP.setVisibility(8);
      this.PxQ.setVisibility(8);
      this.PxR.setVisibility(0);
      this.PxS.setVisibility(8);
      this.PxT.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("using"))
    {
      this.PxP.setVisibility(8);
      this.PxQ.setVisibility(8);
      this.PxR.setVisibility(8);
      this.PxS.setVisibility(0);
      this.PxT.setVisibility(8);
      AppMethodBeat.o(74625);
      return;
    }
    if (paramString.equals("canceling"))
    {
      this.PxP.setVisibility(8);
      this.PxQ.setVisibility(8);
      this.PxR.setVisibility(8);
      this.PxS.setVisibility(8);
      this.PxT.setVisibility(0);
      AppMethodBeat.o(74625);
      return;
    }
    AppMethodBeat.o(74625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.f
 * JD-Core Version:    0.7.0.1
 */