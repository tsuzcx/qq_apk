package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  extends com.tencent.mm.az.a
{
  public String KrP;
  public long KrQ = 0L;
  
  public a(Map<String, String> paramMap, bv parambv)
  {
    super(paramMap, parambv);
  }
  
  public final boolean aAs()
  {
    AppMethodBeat.i(36444);
    if (this.values == null)
    {
      ae.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(36444);
      return false;
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
      this.KrP = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
      this.KrQ = bu.aSC((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
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
        if ((!str.startsWith(".sysmsg.invokeMessage.link.text")) || (bu.isNullOrNil((String)this.values.get(str)))) {
          break label356;
        }
        str = (String)this.values.get(str);
        localStringBuilder.append(str);
        this.ikJ.add(str);
        i = str.length();
      }
    }
    label356:
    for (;;)
    {
      break;
      this.ikK.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.ikL.add(Integer.valueOf(localStringBuilder.length()));
      this.ikH = localStringBuilder.toString();
      if ((ch.aDb() - this.KrQ >= 300000L) && (!bu.isNullOrNil(this.KrP))) {
        b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36443);
            a.this.dCi.setType(10002);
            w.a(ak.getContext().getString(2131757292), "", a.this.dCi, "");
            bc.aCg();
            c.azI().a(a.this.dCi.field_msgId, a.this.dCi);
            ae.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(a.this.dCi.field_msgId) });
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