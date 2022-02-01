package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.pluginsdk.j.a.c.f;
import com.tencent.mm.pluginsdk.j.a.c.f.a;
import com.tencent.mm.pluginsdk.j.a.c.f.d;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;

final class k
  extends f<a>
{
  private final com.tencent.f.b JZy;
  
  k()
  {
    AppMethodBeat.i(151989);
    this.JZy = new f.a(this, "MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, 2147483647, new SynchronousQueue());
    AppMethodBeat.o(151989);
  }
  
  private static f.d b(a parama)
  {
    AppMethodBeat.i(151992);
    parama = new a(parama);
    AppMethodBeat.o(151992);
    return parama;
  }
  
  static void g(s params)
  {
    AppMethodBeat.i(151990);
    new a(a.a(params)).run();
    AppMethodBeat.o(151990);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(151991);
    if (bed(parama.JYs))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.JYs });
      AppMethodBeat.o(151991);
      return;
    }
    if (((parama.JYt) && (parama.dEP == parama.JYw) && (parama.JYw >= 0)) || ((!parama.JYt) && (parama.JYu))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151991);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.JYs });
    try
    {
      super.b(parama);
      AppMethodBeat.o(151991);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", new Object[] { parama.JYs, localRejectedExecutionException });
      Zb(parama.JYs);
      b(parama).run();
      AppMethodBeat.o(151991);
    }
  }
  
  public final com.tencent.f.b gnM()
  {
    return this.JZy;
  }
  
  static final class a
    extends f.d<a>
  {
    protected a(a parama)
    {
      super();
    }
    
    public final void run()
    {
      AppMethodBeat.i(151988);
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)bwt()).JYs });
      Object localObject1 = (a)bwt();
      int i = ((a)localObject1).dEO;
      int j = ((a)localObject1).subType;
      int k = ((a)localObject1).dEP;
      label1087:
      label1090:
      label1093:
      for (;;)
      {
        try
        {
          localObject1 = (a)bwt();
          localObject1 = new l(((a)localObject1).dEO, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).JYt, ((a)localObject1).JYu, ((a)localObject1).JYv, ((a)localObject1).JYw, ((a)localObject1).JYy, ((a)localObject1).dEQ, ((a)localObject1).JYx, ((a)localObject1).dER, ((a)localObject1).JYz, ((a)localObject1).IBJ, ((a)localObject1).url, ((a)localObject1).JYA, ((a)localObject1).JYB, ((a)localObject1).dEP);
          if (((l)localObject1).JYZ)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).JYs });
            ((l)localObject1).JZB = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).gnP() == null) {
              break label1087;
            }
            ((l)localObject1).state = 16;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).JYs });
            break label1087;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).gnR(), new Object[] { ((l)localObject1).JYs });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).gnN().gnO().gnP();
              if (Util.isNullOrNil((String)localObject1)) {
                break label880;
              }
              b.gnC().a(i, j, (String)localObject1, k, ((a)bwt()).dER);
            }
          }
          else
          {
            if (((l)localObject1).JZa)
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).JYs });
              ((l)localObject1).JZB = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).gnP() == null) {
                break label1090;
              }
              ((l)localObject1).state = 16;
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).JYs });
              break label1090;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).JYs });
            ((l)localObject1).JZB = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).gnP() == null) {
              break label1093;
            }
            ((l)localObject1).state = 16;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).JYs });
            break label1093;
          }
          if (((l)localObject1).JZa)
          {
            ((l)localObject1).JZB = ((l)localObject1).filePath;
            ((l)localObject1).xli = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!localObject2.JYZ) {
            break label861;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)bwt()).JYs });
            com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath);
            com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath + ".decompressed");
          }
          AppMethodBeat.o(151988);
        }
        localObject2.JZB = localObject2.filePath;
        localObject2.xli = (localObject2.filePath + ".decompressed");
        localObject2.state = 2;
        continue;
        label861:
        localObject2.JZB = localObject2.filePath;
        localObject2.state = 4;
        continue;
        label880:
        com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath + ".decompressed");
        if (Thread.interrupted())
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)bwt()).JYs });
          com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath);
          com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.j.a.d.a.bej(((a)bwt()).filePath + ".decompressed");
        }
        final a locala = (a)bwt();
        q.a.goa().handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151987);
            bq localbq = new bq();
            localbq.dES.dEO = locala.dEO;
            localbq.dES.subType = locala.subType;
            localbq.dES.dEU = locala.JYy;
            localbq.dES.dDe = 1;
            localbq.dES.dET = false;
            EventCenter.instance.publish(localbq);
            AppMethodBeat.o(151987);
          }
        });
        AppMethodBeat.o(151988);
        return;
        continue;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.k
 * JD-Core Version:    0.7.0.1
 */