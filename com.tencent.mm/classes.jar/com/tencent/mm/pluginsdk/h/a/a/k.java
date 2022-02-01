package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.pluginsdk.h.a.c.f;
import com.tencent.mm.pluginsdk.h.a.c.f.a;
import com.tencent.mm.pluginsdk.h.a.c.f.d;
import com.tencent.mm.pluginsdk.h.a.c.q;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;

final class k
  extends f<a>
{
  private final com.tencent.e.b BSR;
  
  k()
  {
    AppMethodBeat.i(151989);
    this.BSR = new f.a(this, "MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, 2147483647, new SynchronousQueue());
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
    if (aBn(parama.BRL))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.BRL });
      AppMethodBeat.o(151991);
      return;
    }
    if (((parama.BRM) && (parama.ddI == parama.BRP) && (parama.BRP >= 0)) || ((!parama.BRM) && (parama.BRN))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151991);
      return;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.BRL });
    try
    {
      super.b(parama);
      AppMethodBeat.o(151991);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      ad.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", new Object[] { parama.BRL, localRejectedExecutionException });
      HF(parama.BRL);
      b(parama).run();
      AppMethodBeat.o(151991);
    }
  }
  
  public final com.tencent.e.b ewx()
  {
    return this.BSR;
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
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)aQq()).BRL });
      Object localObject1 = (a)aQq();
      int i = ((a)localObject1).ddH;
      int j = ((a)localObject1).subType;
      int k = ((a)localObject1).ddI;
      label1087:
      label1090:
      label1093:
      for (;;)
      {
        try
        {
          localObject1 = (a)aQq();
          localObject1 = new l(((a)localObject1).ddH, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).BRM, ((a)localObject1).BRN, ((a)localObject1).BRO, ((a)localObject1).BRP, ((a)localObject1).BRR, ((a)localObject1).ddJ, ((a)localObject1).BRQ, ((a)localObject1).ddK, ((a)localObject1).BRT, ((a)localObject1).BRS, ((a)localObject1).url, ((a)localObject1).BRU, ((a)localObject1).BRV, ((a)localObject1).ddI);
          if (((l)localObject1).BSs)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).BRL });
            ((l)localObject1).BSU = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).ewA() == null) {
              break label1087;
            }
            ((l)localObject1).state = 16;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).BRL });
            break label1087;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).ewC(), new Object[] { ((l)localObject1).BRL });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).ewy().ewz().ewA();
              if (bt.isNullOrNil((String)localObject1)) {
                break label880;
              }
              b.ewn().a(i, j, (String)localObject1, k, ((a)aQq()).ddK);
            }
          }
          else
          {
            if (((l)localObject1).BSt)
            {
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).BRL });
              ((l)localObject1).BSU = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).ewA() == null) {
                break label1090;
              }
              ((l)localObject1).state = 16;
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).BRL });
              break label1090;
            }
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).BRL });
            ((l)localObject1).BSU = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).ewA() == null) {
              break label1093;
            }
            ((l)localObject1).state = 16;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).BRL });
            break label1093;
          }
          if (((l)localObject1).BSt)
          {
            ((l)localObject1).BSU = ((l)localObject1).filePath;
            ((l)localObject1).rDF = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!localObject2.BSs) {
            break label861;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)aQq()).BRL });
            com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath);
            com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath + ".decompressed");
          }
          AppMethodBeat.o(151988);
        }
        localObject2.BSU = localObject2.filePath;
        localObject2.rDF = (localObject2.filePath + ".decompressed");
        localObject2.state = 2;
        continue;
        label861:
        localObject2.BSU = localObject2.filePath;
        localObject2.state = 4;
        continue;
        label880:
        com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath + ".decompressed");
        if (Thread.interrupted())
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)aQq()).BRL });
          com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath);
          com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.h.a.d.a.aBt(((a)aQq()).filePath + ".decompressed");
        }
        final a locala = (a)aQq();
        q.a.ewL().handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151987);
            bl localbl = new bl();
            localbl.ddL.ddH = locala.ddH;
            localbl.ddL.subType = locala.subType;
            localbl.ddL.ddN = locala.BRR;
            localbl.ddL.dbV = 1;
            localbl.ddL.ddM = false;
            com.tencent.mm.sdk.b.a.ESL.l(localbl);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.k
 * JD-Core Version:    0.7.0.1
 */