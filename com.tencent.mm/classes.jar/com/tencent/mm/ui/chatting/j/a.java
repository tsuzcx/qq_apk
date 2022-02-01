package com.tencent.mm.ui.chatting.j;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  extends com.tencent.mm.az.a
{
  public String PEb;
  public long PEc = 0L;
  public String PEd;
  public int mType;
  
  public a(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
  }
  
  public final boolean aTA()
  {
    AppMethodBeat.i(36444);
    if (this.values == null)
    {
      Log.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(36444);
      return false;
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.preContent")) {
      this.PEb = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.msgSource")) {
      this.PEd = ((String)this.values.get(".sysmsg.invokeMessage.msgSource"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
      this.PEc = Util.safeParseLong((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
    }
    if (this.values.containsKey(".sysmsg.invokeMessage.type")) {
      this.mType = Util.safeParseInt((String)this.values.get(".sysmsg.invokeMessage.type"));
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
        if ((!str.startsWith(".sysmsg.invokeMessage.link.text")) || (Util.isNullOrNil((String)this.values.get(str)))) {
          break label423;
        }
        str = (String)this.values.get(str);
        localStringBuilder.append(str);
        this.jfI.add(str);
        i = str.length();
      }
    }
    label423:
    for (;;)
    {
      break;
      this.jfJ.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.jfK.add(Integer.valueOf(localStringBuilder.length()));
      this.jfG = localStringBuilder.toString();
      if ((cl.aWz() - this.PEc >= 300000L) && (!Util.isNullOrNil(this.PEb))) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36443);
            a.this.dTX.setType(10002);
            w.a(MMApplicationContext.getContext().getString(2131757506), "", a.this.dTX, "");
            bg.aVF();
            c.aSQ().a(a.this.dTX.field_msgId, a.this.dTX);
            Log.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(a.this.dTX.field_msgId) });
            AppMethodBeat.o(36443);
          }
        }, "[checkExpired]");
      }
      AppMethodBeat.o(36444);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.j.a
 * JD-Core Version:    0.7.0.1
 */