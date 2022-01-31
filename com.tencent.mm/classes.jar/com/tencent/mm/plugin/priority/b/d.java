package com.tencent.mm.plugin.priority.b;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  public List<Object> ptv;
  public al ptw;
  public a ptx;
  
  public d()
  {
    AppMethodBeat.i(54899);
    this.ptv = new LinkedList();
    this.ptw = new al("Priority.PriorityTaskRunner");
    this.ptx = new a(this.ptw.oNc.getLooper());
    AppMethodBeat.o(54899);
  }
  
  public final void a(com.tencent.mm.plugin.priority.b.b.a parama)
  {
    AppMethodBeat.i(54901);
    if (this.ptx != null)
    {
      parama = this.ptx.obtainMessage(1, parama);
      this.ptx.sendMessage(parama);
    }
    AppMethodBeat.o(54901);
  }
  
  public final void b(com.tencent.mm.plugin.priority.b.b.a parama)
  {
    AppMethodBeat.i(54902);
    if (this.ptx != null)
    {
      parama = this.ptx.obtainMessage(1, parama);
      this.ptx.sendMessageDelayed(parama, 1000L);
    }
    AppMethodBeat.o(54902);
  }
  
  public final void kQ(long paramLong)
  {
    AppMethodBeat.i(54900);
    if (this.ptx != null)
    {
      if (paramLong == 0L)
      {
        this.ptx.sendEmptyMessage(0);
        AppMethodBeat.o(54900);
        return;
      }
      this.ptx.sendEmptyMessageDelayed(0, paramLong);
    }
    AppMethodBeat.o(54900);
  }
  
  public final class a
    extends ak
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(54898);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(54898);
        return;
        d.this.kQ(120000L);
        if (!com.tencent.mm.plugin.priority.a.a.a.biG()) {
          continue;
        }
        paramMessage = ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CImgAutoDownloader();
        int i;
        if (paramMessage.ptz != 0L)
        {
          e locale = o.ahC().gT(paramMessage.ptz);
          if (o.ahD().a(locale.fDL, paramMessage.ptz, locale.fDP)) {
            i = 1;
          }
        }
        while (i == 0)
        {
          ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CImgAutoDownloader();
          if (!com.tencent.mm.plugin.priority.b.a.a.caQ()) {
            break;
          }
          ((PluginPriority)com.tencent.mm.kernel.g.G(PluginPriority.class)).getC2CImgAutoDownloader().start();
          AppMethodBeat.o(54898);
          return;
          i = 0;
          continue;
          i = 0;
        }
        long l = System.currentTimeMillis();
        paramMessage = (com.tencent.mm.plugin.priority.b.b.a)paramMessage.obj;
        try
        {
          paramMessage.run();
          ab.i("MicroMsg.Priority.PriorityTaskRunner", "Once Run Task %s Use Time %d", new Object[] { paramMessage.getName(), Long.valueOf(System.currentTimeMillis() - l) });
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.Priority.PriorityTaskRunner", localException, "MESSAGE_ONCE_RUN_TASK %s", new Object[] { paramMessage.getName() });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.d
 * JD-Core Version:    0.7.0.1
 */