package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$2
  implements ap.a
{
  b$2(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(135319);
    b.a(this.tLv).setText(ah.getContext().getString(2131304672));
    b.b(this.tLv).setVisibility(0);
    com.tencent.mm.plugin.voip_cs.c.b localb = b.c(this.tLv);
    TextView localTextView = b.b(this.tLv);
    Object localObject = b.tCt;
    if ((localObject == null) || (localTextView == null)) {
      ab.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
    }
    for (;;)
    {
      AppMethodBeat.o(135319);
      return true;
      localb.cOZ();
      localb.tCJ = 0;
      localb.tCH = ((int[])localObject);
      localb.md = localTextView;
      localb.tCI = 500;
      if (localb.bAz != null)
      {
        localObject = localb.bAz;
        long l = localb.tCI;
        ((ap)localObject).ag(l, l);
      }
      ab.a("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(localTextView)), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.2
 * JD-Core Version:    0.7.0.1
 */