package com.tencent.mm.plugin.priority.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public List<Object> vDS;
  public a vDT;
  
  public d()
  {
    AppMethodBeat.i(87812);
    this.vDS = new LinkedList();
    this.vDT = new a("Priority.PriorityTaskRunner");
    AppMethodBeat.o(87812);
  }
  
  public final void a(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87814);
    if (this.vDT != null)
    {
      parama = this.vDT.obtainMessage(1, parama);
      this.vDT.sendMessage(parama);
    }
    AppMethodBeat.o(87814);
  }
  
  public final void b(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87815);
    if (this.vDT != null)
    {
      parama = this.vDT.obtainMessage(1, parama);
      this.vDT.sendMessageDelayed(parama, 1000L);
    }
    AppMethodBeat.o(87815);
  }
  
  public final void wj(long paramLong)
  {
    AppMethodBeat.i(87813);
    if (this.vDT != null)
    {
      if (paramLong == 0L)
      {
        this.vDT.sendEmptyMessage(0);
        AppMethodBeat.o(87813);
        return;
      }
      this.vDT.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(87813);
  }
  
  public final class a
    extends ao
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
          e locale;
          ac.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", paramMessage, "handle priority msg", new Object[0]);
          AppMethodBeat.o(87811);
          return;
        }
        ac.v("MicroMsg.Priority.PriorityTaskRunner", "priority runner tick");
        paramMessage = d.this;
        if (paramMessage.vDT != null) {
          paramMessage.vDT.removeMessages(0);
        }
        d.this.wj(120000L);
        paramMessage = ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader();
        if (paramMessage.vEq != 0L)
        {
          locale = o.aFx().qg(paramMessage.vEq);
          if (o.aFy().a(locale.dcd, paramMessage.vEq, locale.hGP))
          {
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.c.a.doN()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CImgAutoDownloader().start();
              }
            }
            if (bs.isNullOrNil(((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader().vEf)) {
              break label282;
            }
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.b.a.doG()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ad(PluginPriority.class)).getC2CFileAutoDownloader().start();
              }
            }
            if (!c.doP()) {
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
        label282:
        i = 0;
        continue;
        long l = System.currentTimeMillis();
        paramMessage = (com.tencent.mm.plugin.priority.model.b.a)paramMessage.obj;
        try
        {
          paramMessage.run();
          ac.i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", new Object[] { paramMessage.getName(), Long.valueOf(System.currentTimeMillis() - l) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", localException, "MESSAGE_ONCE_RUN_TASK %s", new Object[] { paramMessage.getName() });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.d
 * JD-Core Version:    0.7.0.1
 */