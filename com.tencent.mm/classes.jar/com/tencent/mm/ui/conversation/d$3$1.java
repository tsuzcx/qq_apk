package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ak;

final class d$3$1
  implements Runnable
{
  d$3$1(d.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(34178);
    long l = System.currentTimeMillis();
    int j;
    if ((l - this.Ahz.Ahx < 3000L) && (this.Ahz.Ahy >= 0)) {
      j = this.Ahz.Ahy;
    }
    label72:
    label94:
    label351:
    label356:
    for (;;)
    {
      Object localObject = this.Ahz.Ahv.Ahr;
      int m;
      int i;
      if (this.Ahz.Ahv.Ahq > 0)
      {
        k = 1;
        m = ((h)localObject).getCount();
        if (m <= 0) {
          break label315;
        }
        i = Math.abs((j + 1) % m);
        if (i == j) {
          break label315;
        }
        ak localak = (ak)((h)localObject).NM(i);
        if ((localak == null) || ((localak.field_unReadCount <= 0) && (localak.field_unReadMuteCount <= 0))) {
          break label305;
        }
        if (k == 0) {
          break label302;
        }
        if (h.a(localak, ((h)localObject).i(localak)) != 2) {
          break label305;
        }
        if (i >= 0) {
          break label320;
        }
        BackwardSupportUtil.c.c(this.Ahz.Ahv.AgN, this.Ahz.Ahv.AgN.getHeaderViewsCount());
        this.Ahz.Ahx = l;
        localObject = this.Ahz;
        if (i >= 0) {
          break label351;
        }
      }
      for (int k = 0;; k = i)
      {
        ((d.3)localObject).Ahy = k;
        ab.d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", new Object[] { Integer.valueOf(this.Ahz.Ahv.AgN.getHeaderViewsCount()), Integer.valueOf(j), Integer.valueOf(i) });
        AppMethodBeat.o(34178);
        return;
        j = this.Ahz.Ahv.AgN.getFirstVisiblePosition() - this.Ahz.Ahv.AgN.getHeaderViewsCount() + 1;
        if (j >= 0) {
          break label356;
        }
        j = 0;
        break;
        k = 0;
        break label72;
        break label151;
        i = (i + 1) % m;
        break label94;
        i = -1;
        break label151;
        BackwardSupportUtil.c.c(this.Ahz.Ahv.AgN, this.Ahz.Ahv.AgN.getHeaderViewsCount() + i);
        break label181;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d.3.1
 * JD-Core Version:    0.7.0.1
 */