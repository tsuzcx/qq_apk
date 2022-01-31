package com.tencent.mm.ui.transmit;

import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t.a;
import com.tencent.mm.modelvideo.t.a.a;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class MsgRetransmitUI$11$1
  implements t.a
{
  MsgRetransmitUI$11$1(MsgRetransmitUI.11 param11) {}
  
  public final void a(t.a.a parama)
  {
    parama = u.oe(parama.fileName);
    if ((parama != null) && (parama.status == 199))
    {
      parama = new MsgRetransmitUI.b((byte)0);
      parama.wgX = new LinkedList();
      parama.wgX.addAll(this.wgI.wgG.wgg);
      Iterator localIterator = this.wgI.wgG.wgg.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        y.i("MicroMsg.MsgRetransmitUI", "copy video after download %s", new Object[] { str });
        MsgRetransmitUI.a(this.wgI.wgG, parama, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.11.1
 * JD-Core Version:    0.7.0.1
 */