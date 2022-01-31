package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;

final class ab$4
  implements View.OnClickListener
{
  ab$4(ab paramab) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38328);
    if (a.aiw())
    {
      this.rIu.ctM();
      AppMethodBeat.o(38328);
      return;
    }
    paramView = this.rIu;
    if (paramView.rHF == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
      AppMethodBeat.o(38328);
      return;
    }
    new ak(paramView.cmc.getMainLooper()).post(new ab.3(paramView));
    AppMethodBeat.o(38328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ab.4
 * JD-Core Version:    0.7.0.1
 */