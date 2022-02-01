package com.tencent.mm.ui.chatting.i;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ce;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  extends com.tencent.mm.az.a
{
  public String Ifk;
  public long Ifl = 0L;
  
  public a(Map<String, String> paramMap, bo parambo)
  {
    super(paramMap, parambo);
  }
  
  public final boolean axn()
  {
    AppMethodBeat.i(36444);
    if (this.values == null)
    {
      ac.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(36444);
      return false;
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
      this.Ifk = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
      this.Ifl = bs.aLz((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
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
        if ((!str.startsWith(".sysmsg.invokeMessage.link.text")) || (bs.isNullOrNil((String)this.values.get(str)))) {
          break label356;
        }
        str = (String)this.values.get(str);
        localStringBuilder.append(str);
        this.hOC.add(str);
        i = str.length();
      }
    }
    label356:
    for (;;)
    {
      break;
      this.hOD.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.hOE.add(Integer.valueOf(localStringBuilder.length()));
      this.hOA = localStringBuilder.toString();
      if ((ce.azI() - this.Ifl >= 300000L) && (!bs.isNullOrNil(this.Ifk))) {
        b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36443);
            a.this.dpq.setType(10002);
            v.a(ai.getContext().getString(2131757292), "", a.this.dpq, "");
            az.ayM();
            c.awD().a(a.this.dpq.field_msgId, a.this.dpq);
            ac.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(a.this.dpq.field_msgId) });
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
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a
 * JD-Core Version:    0.7.0.1
 */