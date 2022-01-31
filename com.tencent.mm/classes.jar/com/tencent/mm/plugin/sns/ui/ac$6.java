package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

final class ac$6
  implements Runnable
{
  ac$6(ac paramac) {}
  
  public final void run()
  {
    AppMethodBeat.i(38344);
    ab.i("MicroMsg.SightWidget", "showProgress");
    ac localac = this.rIQ;
    MMActivity localMMActivity = this.rIQ.cmc;
    this.rIQ.cmc.getString(2131297087);
    localac.eeN = h.b(localMMActivity, this.rIQ.cmc.getString(2131303961), false, new ac.6.1(this));
    AppMethodBeat.o(38344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac.6
 * JD-Core Version:    0.7.0.1
 */