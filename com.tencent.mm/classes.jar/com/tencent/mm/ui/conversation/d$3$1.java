package com.tencent.mm.ui.conversation;

import android.widget.ListView;
import com.tencent.mm.h.c.as;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;

final class d$3$1
  implements Runnable
{
  d$3$1(d.3 param3) {}
  
  public final void run()
  {
    long l = System.currentTimeMillis();
    int j;
    if ((l - this.vPO.vPM < 3000L) && (this.vPO.vPN >= 0)) {
      j = this.vPO.vPN;
    }
    label67:
    label89:
    label346:
    for (;;)
    {
      Object localObject = this.vPO.vPK.vPG;
      int m;
      int i;
      if (this.vPO.vPK.vPF > 0)
      {
        k = 1;
        m = ((h)localObject).getCount();
        if (m <= 0) {
          break label305;
        }
        i = Math.abs((j + 1) % m);
        if (i == j) {
          break label305;
        }
        ak localak = (ak)((h)localObject).FC(i);
        if ((localak == null) || ((localak.field_unReadCount <= 0) && (localak.field_unReadMuteCount <= 0))) {
          break label295;
        }
        if (k == 0) {
          break label292;
        }
        if (h.a(localak, ((h)localObject).i(localak)) != 2) {
          break label295;
        }
        if (i >= 0) {
          break label310;
        }
        BackwardSupportUtil.c.c(this.vPO.vPK.vPc, this.vPO.vPK.vPc.getHeaderViewsCount());
        this.vPO.vPM = l;
        localObject = this.vPO;
        if (i >= 0) {
          break label341;
        }
      }
      for (int k = 0;; k = i)
      {
        ((d.3)localObject).vPN = k;
        y.d("MicroMsg.ConvUnreadHelper", "headerCount %d, scroll from %d to %d", new Object[] { Integer.valueOf(this.vPO.vPK.vPc.getHeaderViewsCount()), Integer.valueOf(j), Integer.valueOf(i) });
        return;
        j = this.vPO.vPK.vPc.getFirstVisiblePosition() - this.vPO.vPK.vPc.getHeaderViewsCount() + 1;
        if (j >= 0) {
          break label346;
        }
        j = 0;
        break;
        k = 0;
        break label67;
        break label146;
        i = (i + 1) % m;
        break label89;
        i = -1;
        break label146;
        BackwardSupportUtil.c.c(this.vPO.vPK.vPc, this.vPO.vPK.vPc.getHeaderViewsCount() + i);
        break label176;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.d.3.1
 * JD-Core Version:    0.7.0.1
 */