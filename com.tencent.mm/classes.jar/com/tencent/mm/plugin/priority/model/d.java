package com.tencent.mm.plugin.priority.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.f;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class d
{
  public List<Object> MPQ;
  public a MPR;
  
  public d()
  {
    AppMethodBeat.i(87812);
    this.MPQ = new LinkedList();
    this.MPR = new a("Priority.PriorityTaskRunner");
    AppMethodBeat.o(87812);
  }
  
  public final void a(com.tencent.mm.plugin.priority.model.a.a parama)
  {
    AppMethodBeat.i(87814);
    if (this.MPR != null)
    {
      parama = this.MPR.obtainMessage(1, parama);
      this.MPR.sendMessage(parama);
    }
    AppMethodBeat.o(87814);
  }
  
  public final void b(com.tencent.mm.plugin.priority.model.a.a parama)
  {
    AppMethodBeat.i(87815);
    if (this.MPR != null)
    {
      parama = this.MPR.obtainMessage(1, parama);
      this.MPR.sendMessageDelayed(parama, 1000L);
    }
    AppMethodBeat.o(87815);
  }
  
  public final void tf(long paramLong)
  {
    AppMethodBeat.i(87813);
    if (this.MPR != null)
    {
      if (paramLong == 0L)
      {
        this.MPR.sendEmptyMessage(0);
        AppMethodBeat.o(87813);
        return;
      }
      this.MPR.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(87813);
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
          com.tencent.mm.modelimage.h localh;
          Log.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", paramMessage, "handle priority msg", new Object[0]);
          AppMethodBeat.o(87811);
          return;
        }
        Log.v("MicroMsg.Priority.PriorityTaskRunner", "priority runner tick");
        d.a(d.this);
        d.b(d.this);
        paramMessage = ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CImgAutoDownloader();
        if (paramMessage.MQo != 0L)
        {
          localh = r.bKa().H(paramMessage.talker, paramMessage.MQo);
          if ((localh != null) && (r.bKb().c(localh.localId, paramMessage.MQo, localh.oGu)))
          {
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CImgAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.c2c.img.a.gzV()) {
                ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CImgAutoDownloader().start();
              }
            }
            if (Util.isNullOrNil(((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CFileAutoDownloader().MQd)) {
              break label275;
            }
            i = 1;
            if (i == 0)
            {
              ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CFileAutoDownloader();
              if (com.tencent.mm.plugin.priority.model.c2c.b.a.gzN()) {
                ((PluginPriority)com.tencent.mm.kernel.h.az(PluginPriority.class)).getC2CFileAutoDownloader().start();
              }
            }
            if (!c.gzX()) {
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
        label275:
        i = 0;
        continue;
        long l = System.currentTimeMillis();
        paramMessage = (com.tencent.mm.plugin.priority.model.a.a)paramMessage.obj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.d
 * JD-Core Version:    0.7.0.1
 */