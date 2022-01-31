package com.tencent.mm.pluginsdk.ui.preference;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.plugin.story.api.n;

final class NormalUserHeaderPreference$2
  implements View.OnClickListener
{
  NormalUserHeaderPreference$2(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28072);
    n.aS(NormalUserHeaderPreference.b(this.wbA), NormalUserHeaderPreference.a(this.wbA).field_username);
    AppMethodBeat.o(28072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.2
 * JD-Core Version:    0.7.0.1
 */