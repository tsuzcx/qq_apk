package com.tencent.mm.plugin.priority.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.aw.i;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public List<Object> wKY;
  public a wKZ;
  
  public d()
  {
    AppMethodBeat.i(87812);
    this.wKY = new LinkedList();
    this.wKZ = new a("Priority.PriorityTaskRunner");
    AppMethodBeat.o(87812);
  }
  
  public final void a(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87814);
    if (this.wKZ != null)
    {
      parama = this.wKZ.obtainMessage(1, parama);
      this.wKZ.sendMessage(parama);
    }
    AppMethodBeat.o(87814);
  }
  
  public final void b(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87815);
    if (this.wKZ != null)
    {
      parama = this.wKZ.obtainMessage(1, parama);
      this.wKZ.sendMessageDelayed(parama, 1000L);
    }
    AppMethodBeat.o(87815);
  }
  
  public final void yu(long paramLong)
  {
    AppMethodBeat.i(87813);
    if (this.wKZ != null)
    {
      if (paramLong == 0L)
      {
        this.wKZ.sendEmptyMessage(0);
        AppMethodBeat.o(87813);
        return;
      }
      this.wKZ.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(87813);
  }
  
  public final class a
    extends ap
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
          com.tencent.mm.aw.g localg;
          ad.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", paramMessage, "handle priority msg", new Object[0]);
          AppMethodBeat.o(87811);
          return;
        }
        ad.v("MicroMsg.Priority.PriorityTaskRunner", "priority runner tick");
        paramMessage = d.this;
        if (paramMessage.wKZ != null) {
          paramMessage.wKZ.removeMessages(0);
        }
        d.this.yu(120000L);
        paramMessage = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader();
        if (paramMessage.wLw != 0L)
        {
          localg = q.aIF().G(paramMessage.talker, paramMessage.wLw);
          if (q.aIG().a(localg.dnz, paramMessage.wLw, localg.hZz))
          {
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.c.a.dzp()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
              }
            }
            if (bt.isNullOrNil(((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader().wLl)) {
              break label286;
            }
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.b.a.dzi()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader().start();
              }
            }
            if (!c.dzr()) {
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
          ad.i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", new Object[] { paramMessage.getName(), Long.valueOf(System.currentTimeMillis() - l) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", localException, "MESSAGE_ONCE_RUN_TASK %s", new Object[] { paramMessage.getName() });
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