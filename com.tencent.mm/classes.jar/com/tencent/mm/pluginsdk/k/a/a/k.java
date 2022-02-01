package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.c.b.b;
import com.tencent.matrix.report.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.bv;
import com.tencent.mm.pluginsdk.k.a.c.f;
import com.tencent.mm.pluginsdk.k.a.c.f.a;
import com.tencent.mm.pluginsdk.k.a.c.f.d;
import com.tencent.mm.pluginsdk.k.a.c.p;
import com.tencent.mm.pluginsdk.k.a.c.p.a;
import com.tencent.mm.pluginsdk.k.a.c.r;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;

final class k
  extends f<a>
  implements b.b
{
  private final com.tencent.e.b Rab;
  
  k()
  {
    AppMethodBeat.i(151989);
    this.Rab = new f.a(this, "MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, 2147483647, new SynchronousQueue());
    com.tencent.matrix.c.b.a(this);
    AppMethodBeat.o(151989);
  }
  
  private static f.d b(a parama)
  {
    AppMethodBeat.i(151992);
    parama = new a(parama);
    AppMethodBeat.o(151992);
    return parama;
  }
  
  static void g(r paramr)
  {
    AppMethodBeat.i(151990);
    new a(a.a(paramr)).run();
    AppMethodBeat.o(151990);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(151991);
    if (bqz(parama.QYU))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.QYU });
      AppMethodBeat.o(151991);
      return;
    }
    if (((parama.QYV) && (parama.fxD == parama.QYY) && (parama.QYY >= 0)) || ((!parama.QYV) && (parama.QYW))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151991);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.QYU });
    try
    {
      super.b(parama);
      AppMethodBeat.o(151991);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", new Object[] { parama.QYU, localRejectedExecutionException });
      agN(parama.QYU);
      b(parama).run();
      AppMethodBeat.o(151991);
    }
  }
  
  public final void cT(boolean paramBoolean)
  {
    AppMethodBeat.i(200127);
    if ((com.tencent.matrix.c.a.jC(81)) && (paramBoolean) && (!this.Raq.isEmpty()))
    {
      Log.w("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "#onAppLowEnergy, cancel all bg tasks");
      d.a.jD(81);
      cancelAll();
    }
    AppMethodBeat.o(200127);
  }
  
  public final com.tencent.e.b hit()
  {
    return this.Rab;
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
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)bHA()).QYU });
      Object localObject1 = (a)bHA();
      int i = ((a)localObject1).fxC;
      int j = ((a)localObject1).subType;
      int k = ((a)localObject1).fxD;
      label1087:
      label1090:
      label1093:
      for (;;)
      {
        try
        {
          localObject1 = (a)bHA();
          localObject1 = new l(((a)localObject1).fxC, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).QYV, ((a)localObject1).QYW, ((a)localObject1).QYX, ((a)localObject1).QYY, ((a)localObject1).QZa, ((a)localObject1).fxE, ((a)localObject1).QYZ, ((a)localObject1).fxF, ((a)localObject1).QZb, ((a)localObject1).PvW, ((a)localObject1).url, ((a)localObject1).QZc, ((a)localObject1).QZd, ((a)localObject1).fxD);
          if (((l)localObject1).QZB)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).QYU });
            ((l)localObject1).Rae = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).hiw() == null) {
              break label1087;
            }
            ((l)localObject1).state = 16;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).QYU });
            break label1087;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).hiy(), new Object[] { ((l)localObject1).QYU });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).hiu().hiv().hiw();
              if (Util.isNullOrNil((String)localObject1)) {
                break label880;
              }
              b.hii().b(i, j, (String)localObject1, k, ((a)bHA()).fxF);
            }
          }
          else
          {
            if (((l)localObject1).QZC)
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).QYU });
              ((l)localObject1).Rae = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).hiw() == null) {
                break label1090;
              }
              ((l)localObject1).state = 16;
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).QYU });
              break label1090;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).QYU });
            ((l)localObject1).Rae = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).hiw() == null) {
              break label1093;
            }
            ((l)localObject1).state = 16;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).QYU });
            break label1093;
          }
          if (((l)localObject1).QZC)
          {
            ((l)localObject1).Rae = ((l)localObject1).filePath;
            ((l)localObject1).BXC = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!localObject2.QZB) {
            break label861;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)bHA()).QYU });
            com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath);
            com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath + ".decompressed");
          }
          AppMethodBeat.o(151988);
        }
        localObject2.Rae = localObject2.filePath;
        localObject2.BXC = (localObject2.filePath + ".decompressed");
        localObject2.state = 2;
        continue;
        label861:
        localObject2.Rae = localObject2.filePath;
        localObject2.state = 4;
        continue;
        label880:
        com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath + ".decompressed");
        if (Thread.interrupted())
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)bHA()).QYU });
          com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath);
          com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.k.a.d.a.bqF(((a)bHA()).filePath + ".decompressed");
        }
        final a locala = (a)bHA();
        p.a.hiK().handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151987);
            bv localbv = new bv();
            localbv.fxG.fxC = locala.fxC;
            localbv.fxG.subType = locala.subType;
            localbv.fxG.fxI = locala.QZa;
            localbv.fxG.fvK = 1;
            localbv.fxG.fxH = false;
            EventCenter.instance.publish(localbv);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.k
 * JD-Core Version:    0.7.0.1
 */