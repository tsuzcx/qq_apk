package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.n.a;

final class NormalUserHeaderPreference$6
  implements Runnable
{
  NormalUserHeaderPreference$6(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void run()
  {
    AppMethodBeat.i(28079);
    NormalUserHeaderPreference.f(this.wbA);
    NormalUserHeaderPreference.g(this.wbA);
    NormalUserHeaderPreference.h(this.wbA);
    FMessageListView localFMessageListView;
    if (NormalUserHeaderPreference.i(this.wbA) != null)
    {
      localFMessageListView = NormalUserHeaderPreference.i(this.wbA);
      if (a.je(NormalUserHeaderPreference.a(this.wbA).field_type)) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      localFMessageListView.setReplyBtnVisible(bool);
      AppMethodBeat.o(28079);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.6
 * JD-Core Version:    0.7.0.1
 */