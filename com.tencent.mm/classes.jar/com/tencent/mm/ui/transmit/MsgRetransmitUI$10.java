package com.tencent.mm.ui.transmit;

import com.tencent.mm.ah.m;
import com.tencent.mm.as.d.a;
import com.tencent.mm.as.e;
import com.tencent.mm.as.f;
import com.tencent.mm.as.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MsgRetransmitUI$10
  implements d.a
{
  MsgRetransmitUI$10(MsgRetransmitUI paramMsgRetransmitUI, String paramString1, int paramInt, String paramString2, String paramString3) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, m paramm) {}
  
  public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, m paramm)
  {
    if ((paramInt3 == 0) && (paramInt4 == 0)) {}
    for (paramInt1 = 1; (paramObject instanceof HashMap); paramInt1 = 0)
    {
      paramObject = (HashMap)paramObject;
      if (paramObject == null) {
        break;
      }
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        paramm = (Map.Entry)paramObject.next();
        paramString = (Long)paramm.getKey();
        paramm = (e)paramm.getValue();
        this.wgG.fileName = o.OJ().o(f.c(paramm), "", "");
        if (paramInt1 != 0)
        {
          au.Hx();
          c.Fy().fe(paramString.longValue());
          MsgRetransmitUI.a(this.wgG, this.egy, this.nkj, this.vjd, this.vje, MsgRetransmitUI.h(this.wgG));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.10
 * JD-Core Version:    0.7.0.1
 */