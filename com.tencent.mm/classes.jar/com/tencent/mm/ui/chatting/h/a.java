package com.tencent.mm.ui.chatting.h;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class a
  extends com.tencent.mm.ax.a
{
  public String aeIo;
  public long aeIp = 0L;
  public String aeIq;
  public int mType;
  
  public a(Map<String, String> paramMap, cc paramcc)
  {
    super(paramMap, paramcc);
  }
  
  public final boolean bAo()
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
      if ((this.hTm == null) || (this.hTm.getType() == 10002)) {
        this.aeIo = ((String)this.values.get(".sysmsg.invokeMessage.preContent"));
      }
    }
    else
    {
      if (this.values.containsKey(".sysmsg.invokeMessage.msgSource")) {
        this.aeIq = ((String)this.values.get(".sysmsg.invokeMessage.msgSource"));
      }
      if (this.values.containsKey(".sysmsg.invokeMessage.timestamp")) {
        this.aeIp = Util.safeParseLong((String)this.values.get(".sysmsg.invokeMessage.timestamp"));
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
            this.aeIo = this.hTm.field_content;
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
        this.oPl.add(str);
        i = str.length();
      }
    }
    label457:
    for (;;)
    {
      break;
      this.oPm.addFirst(Integer.valueOf(localStringBuilder.length() - i));
      this.oPn.add(Integer.valueOf(localStringBuilder.length()));
      this.oPj = localStringBuilder.toString();
      if ((cn.bDv() - this.aeIp >= 300000L) && (!Util.isNullOrNil(this.aeIo))) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(36443);
            a.this.hTm.setType(10002);
            x.a(MMApplicationContext.getContext().getString(R.l.gzs), "", a.this.hTm, "");
            bh.bCz();
            c.bzD().a(a.this.hTm.field_msgId, a.this.hTm);
            Log.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[] { Long.valueOf(a.this.hTm.field_msgId) });
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
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */