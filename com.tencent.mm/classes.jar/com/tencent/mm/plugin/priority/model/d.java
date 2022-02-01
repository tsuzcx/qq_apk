package com.tencent.mm.plugin.priority.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public List<Object> xaM;
  public a xaN;
  
  public d()
  {
    AppMethodBeat.i(87812);
    this.xaM = new LinkedList();
    this.xaN = new a("Priority.PriorityTaskRunner");
    AppMethodBeat.o(87812);
  }
  
  public final void a(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87814);
    if (this.xaN != null)
    {
      parama = this.xaN.obtainMessage(1, parama);
      this.xaN.sendMessage(parama);
    }
    AppMethodBeat.o(87814);
  }
  
  public final void b(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87815);
    if (this.xaN != null)
    {
      parama = this.xaN.obtainMessage(1, parama);
      this.xaN.sendMessageDelayed(parama, 1000L);
    }
    AppMethodBeat.o(87815);
  }
  
  public final void yT(long paramLong)
  {
    AppMethodBeat.i(87813);
    if (this.xaN != null)
    {
      if (paramLong == 0L)
      {
        this.xaN.sendEmptyMessage(0);
        AppMethodBeat.o(87813);
        return;
      }
      this.xaN.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(87813);
  }
  
  public final class a
    extends aq
  {
    a(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(87811);
      for (;;)
      {
        try
        {
          i = paramMessage.what;
          switch (i)
          {
          default: 
            AppMethodBeat.o(87811);
            return;
          }
        }
        catch (Exception paramMessage)
        {
          com.tencent.mm.av.g localg;
          ae.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", paramMessage, "handle priority msg", new Object[0]);
          AppMethodBeat.o(87811);
          return;
        }
        ae.v("MicroMsg.Priority.PriorityTaskRunner", "priority runner tick");
        paramMessage = d.this;
        if (paramMessage.xaN != null) {
          paramMessage.xaN.removeMessages(0);
        }
        d.this.yT(120000L);
        paramMessage = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader();
        if (paramMessage.xbk != 0L)
        {
          localg = q.aIX().G(paramMessage.talker, paramMessage.xbk);
          if (q.aIY().a(localg.doE, paramMessage.xbk, localg.icr))
          {
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.c.a.dCG()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
              }
            }
            if (bu.isNullOrNil(((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader().xaZ)) {
              break label286;
            }
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.b.a.dCz()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader().start();
              }
            }
            if (!c.dCI()) {
              continue;
            }
            d.this.a(new c());
            AppMethodBeat.o(87811);
            return;
          }
          i = 0;
          continue;
        }
        int i = 0;
        continue;
        label286:
        i = 0;
        continue;
        long l = System.currentTimeMillis();
        paramMessage = (com.tencent.mm.plugin.priority.model.b.a)paramMessage.obj;
        try
        {
          paramMessage.run();
          ae.i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", new Object[] { paramMessage.getName(), Long.valueOf(System.currentTimeMillis() - l) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", localException, "MESSAGE_ONCE_RUN_TASK %s", new Object[] { paramMessage.getName() });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.d
 * JD-Core Version:    0.7.0.1
 */