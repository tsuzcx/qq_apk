package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class bl$2
  implements View.OnClickListener
{
  bl$2(bl parambl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99725);
    boolean bool = paramView.getTag() instanceof s;
    ac.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(99725);
      return;
    }
    paramView = (s)paramView.getTag();
    bl.a(this.yYB, paramView);
    AppMethodBeat.o(99725);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bl.2
 * JD-Core Version:    0.7.0.1
 */