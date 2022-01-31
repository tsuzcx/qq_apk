package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.applet.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

final class NormalUserFooterPreference$c$5
  implements am.b.a
{
  NormalUserFooterPreference$c$5(NormalUserFooterPreference.c paramc, a parama, String paramString, LinkedList paramLinkedList) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    au.Hx();
    paramString = c.Fw().abl(NormalUserFooterPreference.a(this.mYO.mYC).field_username);
    if (paramString != null) {}
    for (paramString = bk.aM(paramString.cCQ, "");; paramString = "")
    {
      this.mYR.WA(paramString);
      this.mYR.b(NormalUserFooterPreference.a(this.mYO.mYC).field_username, this.mYS, this.mYT);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c.5
 * JD-Core Version:    0.7.0.1
 */