package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.pluginsdk.j.a.c.f;
import com.tencent.mm.pluginsdk.j.a.c.f.a;
import com.tencent.mm.pluginsdk.j.a.c.f.d;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;

final class k
  extends f<a>
{
  private final com.tencent.e.b EQj;
  
  k()
  {
    AppMethodBeat.i(151989);
    this.EQj = new f.a(this, "MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, 2147483647, new SynchronousQueue());
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
    if (aMf(parama.EPe))
    {
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.EPe });
      AppMethodBeat.o(151991);
      return;
    }
    if (((parama.EPf) && (parama.dmy == parama.EPi) && (parama.EPi >= 0)) || ((!parama.EPf) && (parama.EPg))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151991);
      return;
    }
    ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.EPe });
    try
    {
      super.b(parama);
      AppMethodBeat.o(151991);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      ad.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", new Object[] { parama.EPe, localRejectedExecutionException });
      Pd(parama.EPe);
      b(parama).run();
      AppMethodBeat.o(151991);
    }
  }
  
  public final com.tencent.e.b faO()
  {
    return this.EQj;
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
      ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)baG()).EPe });
      Object localObject1 = (a)baG();
      int i = ((a)localObject1).dmx;
      int j = ((a)localObject1).subType;
      int k = ((a)localObject1).dmy;
      label1087:
      label1090:
      label1093:
      for (;;)
      {
        try
        {
          localObject1 = (a)baG();
          localObject1 = new l(((a)localObject1).dmx, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).EPf, ((a)localObject1).EPg, ((a)localObject1).EPh, ((a)localObject1).EPi, ((a)localObject1).EPk, ((a)localObject1).dmz, ((a)localObject1).EPj, ((a)localObject1).dmA, ((a)localObject1).EPl, ((a)localObject1).DAq, ((a)localObject1).url, ((a)localObject1).EPm, ((a)localObject1).EPn, ((a)localObject1).dmy);
          if (((l)localObject1).EPK)
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).EPe });
            ((l)localObject1).EQm = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).faR() == null) {
              break label1087;
            }
            ((l)localObject1).state = 16;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).EPe });
            break label1087;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).faT(), new Object[] { ((l)localObject1).EPe });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).faP().faQ().faR();
              if (bt.isNullOrNil((String)localObject1)) {
                break label880;
              }
              b.faE().a(i, j, (String)localObject1, k, ((a)baG()).dmA);
            }
          }
          else
          {
            if (((l)localObject1).EPL)
            {
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).EPe });
              ((l)localObject1).EQm = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).faR() == null) {
                break label1090;
              }
              ((l)localObject1).state = 16;
              ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).EPe });
              break label1090;
            }
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).EPe });
            ((l)localObject1).EQm = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).faR() == null) {
              break label1093;
            }
            ((l)localObject1).state = 16;
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).EPe });
            break label1093;
          }
          if (((l)localObject1).EPL)
          {
            ((l)localObject1).EQm = ((l)localObject1).filePath;
            ((l)localObject1).tJf = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!localObject2.EPK) {
            break label861;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)baG()).EPe });
            com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath);
            com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath + ".decompressed");
          }
          AppMethodBeat.o(151988);
        }
        localObject2.EQm = localObject2.filePath;
        localObject2.tJf = (localObject2.filePath + ".decompressed");
        localObject2.state = 2;
        continue;
        label861:
        localObject2.EQm = localObject2.filePath;
        localObject2.state = 4;
        continue;
        label880:
        com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath + ".decompressed");
        if (Thread.interrupted())
        {
          ad.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)baG()).EPe });
          com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath);
          com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.j.a.d.a.aMl(((a)baG()).filePath + ".decompressed");
        }
        final a locala = (a)baG();
        q.a.fbc().handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151987);
            bo localbo = new bo();
            localbo.dmB.dmx = locala.dmx;
            localbo.dmB.subType = locala.subType;
            localbo.dmB.dmD = locala.EPk;
            localbo.dmB.dkM = 1;
            localbo.dmB.dmC = false;
            com.tencent.mm.sdk.b.a.IbL.l(localbo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.k
 * JD-Core Version:    0.7.0.1
 */