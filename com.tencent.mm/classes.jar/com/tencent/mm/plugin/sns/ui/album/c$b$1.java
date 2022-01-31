package com.tencent.mm.plugin.sns.ui.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$b$1
  implements View.OnClickListener
{
  c$b$1(c.b paramb, c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39980);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof c.c)) && (this.seF.seD.seB != null)) {
      this.seF.seD.seB.bi(((c.c)paramView.getTag()).cIp, ((c.c)paramView.getTag()).cBO);
    }
    AppMethodBeat.o(39980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c.b.1
 * JD-Core Version:    0.7.0.1
 */