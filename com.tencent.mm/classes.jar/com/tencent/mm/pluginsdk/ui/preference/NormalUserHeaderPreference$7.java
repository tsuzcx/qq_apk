package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;

final class NormalUserHeaderPreference$7
  implements Runnable
{
  NormalUserHeaderPreference$7(NormalUserHeaderPreference paramNormalUserHeaderPreference, bv parambv) {}
  
  public final void run()
  {
    AppMethodBeat.i(28080);
    if ((NormalUserHeaderPreference.a(this.wbA) != null) && (this.wbC != null) && (NormalUserHeaderPreference.a(this.wbA).field_username.equals(this.wbC.field_encryptUsername)))
    {
      NormalUserHeaderPreference.a(this.wbA).jn(this.wbC.field_conRemark);
      if (!NormalUserHeaderPreference.j(this.wbA))
      {
        ab.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.k(this.wbA) + "contact = " + NormalUserHeaderPreference.a(this.wbA).field_username);
        AppMethodBeat.o(28080);
        return;
      }
      NormalUserHeaderPreference.f(this.wbA);
    }
    AppMethodBeat.o(28080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.7
 * JD-Core Version:    0.7.0.1
 */