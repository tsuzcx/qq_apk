package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.R.g;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.as.d;
import com.tencent.mm.as.e;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import java.util.HashSet;

final class s$2
  implements am.a
{
  s$2(s params) {}
  
  public final boolean tC()
  {
    if (this.vqG.byx == null) {
      return false;
    }
    c.Ni();
    boolean bool = c.Nj();
    int i = this.vqG.byx.getFirstVisiblePosition();
    int m = this.vqG.byx.getHeaderViewsCount();
    int j = this.vqG.byx.getLastVisiblePosition();
    int k = this.vqG.byx.getHeaderViewsCount();
    com.tencent.mm.ui.chatting.b.b.g localg = (com.tencent.mm.ui.chatting.b.b.g)this.vqG.byx.ac(com.tencent.mm.ui.chatting.b.b.g.class);
    i = Math.max(i - m, 0);
    j = Math.max(Math.min(j - k, localg.getCount()), 0);
    y.d("MicroMsg.ChattingUI.GetImageComponent", "first: " + i + " last: " + j);
    if (j < i)
    {
      y.d("MicroMsg.ChattingUI.GetImageComponent", "start timer to wait listview refresh");
      s.a(this.vqG).S(1000L, 1000L);
      return false;
    }
    o.OK().eni = true;
    while (i <= j)
    {
      bi localbi = localg.GW(i);
      if ((localbi != null) && (localbi.field_isSend == 0) && (localbi.ctB()))
      {
        e locale = o.OJ().bX(localbi.field_msgSvrId);
        if ((!locale.Oq()) && (localbi.cQP != 2)) {
          if (localbi.cQP != 1)
          {
            if (bool)
            {
              c.Ni();
              if (!c.o(localbi)) {}
            }
          }
          else
          {
            f.Nd().eiM.add("image_" + localbi.field_msgId);
            o.OK().a(locale.enp, localbi.field_msgId, 0, Integer.valueOf(i), R.g.chat_img_template, this.vqG);
          }
        }
      }
      i += 1;
    }
    o.OK().Op();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.s.2
 * JD-Core Version:    0.7.0.1
 */