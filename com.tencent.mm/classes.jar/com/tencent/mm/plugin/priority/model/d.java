package com.tencent.mm.plugin.priority.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.e;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public List<Object> AYo;
  public a AYp;
  
  public d()
  {
    AppMethodBeat.i(87812);
    this.AYo = new LinkedList();
    this.AYp = new a("Priority.PriorityTaskRunner");
    AppMethodBeat.o(87812);
  }
  
  public final void HJ(long paramLong)
  {
    AppMethodBeat.i(87813);
    if (this.AYp != null)
    {
      if (paramLong == 0L)
      {
        this.AYp.sendEmptyMessage(0);
        AppMethodBeat.o(87813);
        return;
      }
      this.AYp.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(87813);
  }
  
  public final void a(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87814);
    if (this.AYp != null)
    {
      parama = this.AYp.obtainMessage(1, parama);
      this.AYp.sendMessage(parama);
    }
    AppMethodBeat.o(87814);
  }
  
  public final void b(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87815);
    if (this.AYp != null)
    {
      parama = this.AYp.obtainMessage(1, parama);
      this.AYp.sendMessageDelayed(parama, 1000L);
    }
    AppMethodBeat.o(87815);
  }
  
  public final class a
    extends MMHandler
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
          Log.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", paramMessage, "handle priority msg", new Object[0]);
          AppMethodBeat.o(87811);
          return;
        }
        Log.v("MicroMsg.Priority.PriorityTaskRunner", "priority runner tick");
        paramMessage = d.this;
        if (paramMessage.AYp != null) {
          paramMessage.AYp.removeMessages(0);
        }
        d.this.HJ(120000L);
        paramMessage = ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CImgAutoDownloader();
        if (paramMessage.AYM != 0L)
        {
          localg = q.bcR().H(paramMessage.talker, paramMessage.AYM);
          if (q.bcS().a(localg.localId, paramMessage.AYM, localg.iXp))
          {
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CImgAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.c.a.eCY()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
              }
            }
            if (Util.isNullOrNil(((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CFileAutoDownloader().AYB)) {
              break label286;
            }
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CFileAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.b.a.eCR()) {
                ((PluginPriority)com.tencent.mm.kernel.g.ah(PluginPriority.class)).getC2CFileAutoDownloader().start();
              }
            }
            if (!c.eDa()) {
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
          Log.i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", new Object[] { paramMessage.getName(), Long.valueOf(System.currentTimeMillis() - l) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", localException, "MESSAGE_ONCE_RUN_TASK %s", new Object[] { paramMessage.getName() });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.d
 * JD-Core Version:    0.7.0.1
 */