package com.tencent.mm.pluginsdk.ui.preference;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bv;

final class NormalUserHeaderPreference$7
  implements Runnable
{
  NormalUserHeaderPreference$7(NormalUserHeaderPreference paramNormalUserHeaderPreference, bv parambv) {}
  
  public final void run()
  {
    if ((NormalUserHeaderPreference.b(this.siZ) != null) && (this.mVQ != null) && (NormalUserHeaderPreference.b(this.siZ).field_username.equals(this.mVQ.field_encryptUsername)))
    {
      NormalUserHeaderPreference.b(this.siZ).df(this.mVQ.field_conRemark);
      if (!NormalUserHeaderPreference.j(this.siZ)) {
        y.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + NormalUserHeaderPreference.k(this.siZ) + "contact = " + NormalUserHeaderPreference.b(this.siZ).field_username);
      }
    }
    else
    {
      return;
    }
    NormalUserHeaderPreference.f(this.siZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference.7
 * JD-Core Version:    0.7.0.1
 */