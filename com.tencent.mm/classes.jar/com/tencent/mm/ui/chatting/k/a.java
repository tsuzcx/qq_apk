package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cm;
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
  extends com.tencent.mm.bc.a
{
  public String WYO;
  public long WYP = 0L;
  public String WYQ;
  public int mType;
  
  public a(Map<String, String> paramMap, ca paramca)
  {
    super(paramMap, paramca);
  }
  
  public final boolean bcz()
  {
    AppMethodBeat.i(36444);
    if (this.values == null)
    {
      Log.e("MicroMsg.InvokeMessageNewXmlMsg", "[parseXml] values == null ");
      AppMethodBeat.o(36444);
      return false;
    }
    StringBuilder localStringBuilder;
    Iterator localIterator;
    int i;
    if (this.values.containsKey(".sysmsg.invokeMessage.preContent"))
    {
      if ((this.fNz == null) || (this.fNz.getType() == 10002)) {
        this.WYO = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
      }
    }
    else
    {
      if (this.values.containsKey(".sysmsg.invokeMessage.msgSource")) {
        this.WYQ = ((String)this.values.get(".sysmsg.invokeMessage.msgSource"));
      }
      if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
        this.WYP = Util.safeParseLong((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
      }
      if (this.values.containsKey(".sysmsg.invokeMessage.type")) {
        this.mType = Util.safeParseInt((String)this.values.get(".sysmsg.invokeMessage.type"));
      }
      localStringBuilder = new StringBuilder();
      localIterator = this.values.keySet().iterator();
      i = 0;
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(".sysmsg.invokeMessage.text"))
        {
          if (localStringBuilder.length() > 0)
          {
            localStringBuilder.insert(0, (String)this.values.get(str));
            continue;
            this.WYO = this.fNz.field_content;
            break;
          }
          localStringBuilder.append((String)this.values.get(str));
          continue;
        }
        if ((!str.startsWith(".sysmsg.invokeMessage.link.text")) || (Util.isNullOrNil((String)this.values.get(str)))) {
          break label457;
        }
        str = (String)this.values.get(str);
        localStringBuilder.append(str);
        this.lWj.add(str);
        i = str.length();
      }
    }
    label457:
    for (;;)
    {
      break;
      this.lWk.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.lWl.add(Integer.valueOf(localStringBuilder.length()));
      this.lWg = localStringBuilder.toString();
      if ((cm.bfD() - this.WYP >= 300000L) && (!Util.isNullOrNil(this.WYO))) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36443);
            a.this.fNz.setType(10002);
            w.a(MMApplicationContext.getContext().getString(R.l.ewP), "", a.this.fNz, "");
            bh.beI();
            c.bbO().a(a.this.fNz.field_msgId, a.this.fNz);
            Log.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(a.this.fNz.field_msgId) });
            AppMethodBeat.o(36443);
          }
        }, "[checkExpired]");
      }
      AppMethodBeat.o(36444);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a
 * JD-Core Version:    0.7.0.1
 */