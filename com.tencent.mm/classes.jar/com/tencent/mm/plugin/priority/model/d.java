package com.tencent.mm.plugin.priority.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class d
{
  public List<Object> GSm;
  public a GSn;
  
  public d()
  {
    AppMethodBeat.i(87812);
    this.GSm = new LinkedList();
    this.GSn = new a("Priority.PriorityTaskRunner");
    AppMethodBeat.o(87812);
  }
  
  public final void Pd(long paramLong)
  {
    AppMethodBeat.i(87813);
    if (this.GSn != null)
    {
      if (paramLong == 0L)
      {
        this.GSn.sendEmptyMessage(0);
        AppMethodBeat.o(87813);
        return;
      }
      this.GSn.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(87813);
  }
  
  public final void a(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87814);
    if (this.GSn != null)
    {
      parama = this.GSn.obtainMessage(1, parama);
      this.GSn.sendMessage(parama);
    }
    AppMethodBeat.o(87814);
  }
  
  public final void b(com.tencent.mm.plugin.priority.model.b.a parama)
  {
    AppMethodBeat.i(87815);
    if (this.GSn != null)
    {
      parama = this.GSn.obtainMessage(1, parama);
      this.GSn.sendMessageDelayed(parama, 1000L);
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
          g localg;
          Log.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", paramMessage, "handle priority msg", new Object[0]);
          AppMethodBeat.o(87811);
          return;
        }
        Log.v("MicroMsg.Priority.PriorityTaskRunner", "priority runner tick");
        d.a(d.this);
        d.b(d.this);
        paramMessage = ((PluginPriority)h.ag(PluginPriority.class)).getC2CImgAutoDownloader();
        if (paramMessage.GSK != 0L)
        {
          localg = q.bmh().D(paramMessage.talker, paramMessage.GSK);
          if (q.bmi().a(localg.localId, paramMessage.GSK, localg.lNK))
          {
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)h.ag(PluginPriority.class)).getC2CImgAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.c.a.foR()) {
                ((PluginPriority)h.ag(PluginPriority.class)).getC2CImgAutoDownloader().start();
              }
            }
            if (Util.isNullOrNil(((PluginPriority)h.ag(PluginPriority.class)).getC2CFileAutoDownloader().GSz)) {
              break label270;
            }
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)h.ag(PluginPriority.class)).getC2CFileAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.a.b.a.foK()) {
                ((PluginPriority)h.ag(PluginPriority.class)).getC2CFileAutoDownloader().start();
              }
            }
            if (!c.foT()) {
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
        label270:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.d
 * JD-Core Version:    0.7.0.1
 */