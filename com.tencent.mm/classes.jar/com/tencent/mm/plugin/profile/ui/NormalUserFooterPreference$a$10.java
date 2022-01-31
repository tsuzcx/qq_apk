package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.ui.MMActivity;

final class NormalUserFooterPreference$a$10
  implements Runnable
{
  NormalUserFooterPreference$a$10(NormalUserFooterPreference.a parama) {}
  
  public final void run()
  {
    if (NormalUserFooterPreference.b(this.mYE.mYC).isFinishing()) {
      return;
    }
    b.T(NormalUserFooterPreference.b(this.mYE.mYC), NormalUserFooterPreference.a(this.mYE.mYC).field_username);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.10
 * JD-Core Version:    0.7.0.1
 */