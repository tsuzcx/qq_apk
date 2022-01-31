package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.n.a;

final class NormalUserHeaderPreference$6
  implements Runnable
{
  NormalUserHeaderPreference$6(NormalUserHeaderPreference paramNormalUserHeaderPreference) {}
  
  public final void run()
  {
    NormalUserHeaderPreference.f(this.siZ);
    NormalUserHeaderPreference.g(this.siZ);
    NormalUserHeaderPreference.h(this.siZ);
    FMessageListView localFMessageListView;
    if (NormalUserHeaderPreference.i(this.siZ) != null)
    {
      localFMessageListView = NormalUserHeaderPreference.i(this.siZ);
      if (a.gR(NormalUserHeaderPreference.b(this.siZ).field_type)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      localFMessageListView.setReplyBtnVisible(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.6
 * JD-Core Version:    0.7.0.1
 */