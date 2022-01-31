package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.o;

final class i$1
  implements View.OnClickListener
{
  i$1(i parami) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27955);
    if ((this.vYT.vYS != null) && (this.vYT.vYO != null)) {
      this.vYT.vYS.ams(this.vYT.vYO.vYL);
    }
    this.vYT.vYP.dismiss();
    AppMethodBeat.o(27955);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i.1
 * JD-Core Version:    0.7.0.1
 */