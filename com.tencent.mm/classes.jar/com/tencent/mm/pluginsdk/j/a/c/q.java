package com.tencent.mm.pluginsdk.j.a.c;

import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;

public final class q
{
  public final t Kak;
  public final n Kal;
  public final i Kam;
  private volatile MMHandler dgG;
  public final MMHandler handler;
  public final boolean lsb;
  
  private q()
  {
    AppMethodBeat.i(152059);
    this.dgG = null;
    r.init();
    this.Kak = t.goc();
    if (this.Kak == null)
    {
      this.lsb = false;
      this.Kal = null;
      this.handler = null;
      this.Kam = null;
      AppMethodBeat.o(152059);
      return;
    }
    this.lsb = true;
    this.handler = new MMHandler("ResDownloader-EventThread");
    this.Kam = new i(cyh());
    this.Kal = new n("ResDownloader-EventThread", this.Kam);
    AppMethodBeat.o(152059);
  }
  
  static n.a c(l paraml)
  {
    AppMethodBeat.i(152062);
    Log.d("MicroMsg.ResDownloaderCore", "getNetworkRequestHandler");
    int i = paraml.avy().hashCode();
    Iterator localIterator = r.gob().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)localIterator.next();
      Log.i("MicroMsg.ResDownloaderCore", "plugin = %s, groupId = %s", new Object[] { localg.getClass().getSimpleName(), localg.avy() });
      if (localg.avy().hashCode() == i)
      {
        paraml = localg.c(paraml);
        AppMethodBeat.o(152062);
        return paraml;
      }
    }
    AppMethodBeat.o(152062);
    return null;
  }
  
  public final void Zb(String paramString)
  {
    AppMethodBeat.i(152067);
    if (this.lsb) {
      this.Kal.bef(paramString);
    }
    AppMethodBeat.o(152067);
  }
  
  public final void aj(Runnable paramRunnable)
  {
    AppMethodBeat.i(152060);
    cyh().postToWorker(new b(paramRunnable, (byte)0));
    AppMethodBeat.o(152060);
  }
  
  public final s beg(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(152064);
    if (this.lsb)
    {
      long l = Util.nowMilliSecond();
      s locals = this.Kak.beg(paramString);
      if (locals != null) {
        bool = true;
      }
      Log.i("MicroMsg.ResDownloaderCore", "doQuery: urlKey = %s, ret = %b, cost = %d", new Object[] { paramString, Boolean.valueOf(bool), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(152064);
      return locals;
    }
    AppMethodBeat.o(152064);
    return null;
  }
  
  public final boolean beh(String paramString)
  {
    AppMethodBeat.i(152066);
    if (this.lsb)
    {
      if ((this.Kal.bec(paramString)) || (this.Kal.bed(paramString)))
      {
        AppMethodBeat.o(152066);
        return true;
      }
      AppMethodBeat.o(152066);
      return false;
    }
    AppMethodBeat.o(152066);
    return false;
  }
  
  final MMHandler cyh()
  {
    AppMethodBeat.i(184269);
    if (this.dgG == null)
    {
      this.dgG = new MMHandler("ResDownloader-WorkerThread");
      this.dgG.setLogging(false);
    }
    MMHandler localMMHandler = this.dgG;
    AppMethodBeat.o(184269);
    return localMMHandler;
  }
  
  public final int d(l paraml)
  {
    AppMethodBeat.i(152065);
    if (this.lsb)
    {
      if (Util.isNullOrNil(paraml.url))
      {
        Log.i("MicroMsg.ResDownloaderCore", "request#%s with null url, ignore", new Object[] { paraml.JYs });
        AppMethodBeat.o(152065);
        return 3;
      }
      Log.i("MicroMsg.ResDownloaderCore", "request#%s post to network worker", new Object[] { paraml.JYs });
      int i = this.Kal.b(paraml);
      AppMethodBeat.o(152065);
      return i;
    }
    AppMethodBeat.o(152065);
    return -1;
  }
  
  public final void h(s params)
  {
    AppMethodBeat.i(152063);
    long l;
    if (this.lsb)
    {
      l = Util.nowMilliSecond();
      if (this.Kak.beg(params.field_urlKey) == null) {
        break label84;
      }
      this.Kak.i(params);
    }
    for (boolean bool = false;; bool = true)
    {
      Log.i("MicroMsg.ResDownloaderCore", "doUpdate: urlKey = %s, opIsInsert(%b) cost = %d", new Object[] { params.field_urlKey, Boolean.valueOf(bool), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(152063);
      return;
      label84:
      this.Kak.j(params);
    }
  }
  
  public static final class a
  {
    private static final q Kan;
    
    static
    {
      AppMethodBeat.i(152057);
      Kan = new q((byte)0);
      AppMethodBeat.o(152057);
    }
  }
  
  static final class b
    implements Runnable
  {
    private final Runnable dQN;
    
    private b(Runnable paramRunnable)
    {
      this.dQN = paramRunnable;
    }
    
    public final void run()
    {
      AppMethodBeat.i(152058);
      if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (Process.getThreadPriority(Process.myTid()) != 10)) {
          Process.setThreadPriority(10);
        }
        if (this.dQN != null) {
          this.dQN.run();
        }
        AppMethodBeat.o(152058);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.c.q
 * JD-Core Version:    0.7.0.1
 */