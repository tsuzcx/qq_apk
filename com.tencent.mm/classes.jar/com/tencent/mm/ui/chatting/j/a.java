package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  extends com.tencent.mm.ba.a
{
  public String JVx;
  public long JVy = 0L;
  
  public a(Map<String, String> paramMap, bu parambu)
  {
    super(paramMap, parambu);
  }
  
  public final boolean aAc()
  {
    AppMethodBeat.i(36444);
    if (this.values == null)
    {
      ad.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(36444);
      return false;
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
      this.JVx = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
      this.JVy = bt.aRf((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.values.keySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(".sysmsg.invokeMessage.text"))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.insert(0, (String)this.values.get(str));
        } else {
          localStringBuilder.append((String)this.values.get(str));
        }
      }
      else
      {
        if ((!str.startsWith(".sysmsg.invokeMessage.link.text")) || (bt.isNullOrNil((String)this.values.get(str)))) {
          break label356;
        }
        str = (String)this.values.get(str);
        localStringBuilder.append(str);
        this.ihQ.add(str);
        i = str.length();
      }
    }
    label356:
    for (;;)
    {
      break;
      this.ihR.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.ihS.add(Integer.valueOf(localStringBuilder.length()));
      this.ihO = localStringBuilder.toString();
      if ((cf.aCL() - this.JVy >= 300000L) && (!bt.isNullOrNil(this.JVx))) {
        b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36443);
            a.this.dBd.setType(10002);
            v.a(aj.getContext().getString(2131757292), "", a.this.dBd, "");
            ba.aBQ();
            c.azs().a(a.this.dBd.field_msgId, a.this.dBd);
            ad.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(a.this.dBd.field_msgId) });
            AppMethodBeat.o(36443);
          }
        }, "[checkExpired]");
      }
      AppMethodBeat.o(36444);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a
 * JD-Core Version:    0.7.0.1
 */