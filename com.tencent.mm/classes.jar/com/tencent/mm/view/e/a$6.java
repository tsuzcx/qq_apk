package com.tencent.mm.view.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

final class a$6
  implements k.a
{
  a$6(a parama) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(63028);
    if ((!TextUtils.isEmpty(paramString)) && ((paramString.equals("event_update_group")) || (paramString.equalsIgnoreCase("productID"))))
    {
      ab.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "modify emoji group .");
      this.AUz.dRo();
    }
    AppMethodBeat.o(63028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.e.a.6
 * JD-Core Version:    0.7.0.1
 */