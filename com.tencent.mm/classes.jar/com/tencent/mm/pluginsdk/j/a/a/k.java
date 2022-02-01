package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.pluginsdk.j.a.c.f;
import com.tencent.mm.pluginsdk.j.a.c.f.a;
import com.tencent.mm.pluginsdk.j.a.c.f.d;
import com.tencent.mm.pluginsdk.j.a.c.q;
import com.tencent.mm.pluginsdk.j.a.c.q.a;
import com.tencent.mm.pluginsdk.j.a.c.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;

final class k
  extends f<a>
{
  private final com.tencent.e.b FiE;
  
  k()
  {
    AppMethodBeat.i(151989);
    this.FiE = new f.a(this, "MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, 2147483647, new SynchronousQueue());
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
    if (aNB(parama.Fhz))
    {
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.Fhz });
      AppMethodBeat.o(151991);
      return;
    }
    if (((parama.FhA) && (parama.dnA == parama.FhD) && (parama.FhD >= 0)) || ((!parama.FhA) && (parama.FhB))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151991);
      return;
    }
    ae.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.Fhz });
    try
    {
      super.b(parama);
      AppMethodBeat.o(151991);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      ae.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", new Object[] { parama.Fhz, localRejectedExecutionException });
      PL(parama.Fhz);
      b(parama).run();
      AppMethodBeat.o(151991);
    }
  }
  
  public final com.tencent.e.b feC()
  {
    return this.FiE;
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
      ae.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)bbf()).Fhz });
      Object localObject1 = (a)bbf();
      int i = ((a)localObject1).dnz;
      int j = ((a)localObject1).subType;
      int k = ((a)localObject1).dnA;
      label1087:
      label1090:
      label1093:
      for (;;)
      {
        try
        {
          localObject1 = (a)bbf();
          localObject1 = new l(((a)localObject1).dnz, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).FhA, ((a)localObject1).FhB, ((a)localObject1).FhC, ((a)localObject1).FhD, ((a)localObject1).FhF, ((a)localObject1).dnB, ((a)localObject1).FhE, ((a)localObject1).dnC, ((a)localObject1).FhG, ((a)localObject1).DRK, ((a)localObject1).url, ((a)localObject1).FhH, ((a)localObject1).FhI, ((a)localObject1).dnA);
          if (((l)localObject1).Fif)
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).Fhz });
            ((l)localObject1).FiH = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).feF() == null) {
              break label1087;
            }
            ((l)localObject1).state = 16;
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).Fhz });
            break label1087;
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).feH(), new Object[] { ((l)localObject1).Fhz });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).feD().feE().feF();
              if (bu.isNullOrNil((String)localObject1)) {
                break label880;
              }
              b.fes().a(i, j, (String)localObject1, k, ((a)bbf()).dnC);
            }
          }
          else
          {
            if (((l)localObject1).Fig)
            {
              ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).Fhz });
              ((l)localObject1).FiH = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).feF() == null) {
                break label1090;
              }
              ((l)localObject1).state = 16;
              ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).Fhz });
              break label1090;
            }
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).Fhz });
            ((l)localObject1).FiH = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).feF() == null) {
              break label1093;
            }
            ((l)localObject1).state = 16;
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).Fhz });
            break label1093;
          }
          if (((l)localObject1).Fig)
          {
            ((l)localObject1).FiH = ((l)localObject1).filePath;
            ((l)localObject1).tTW = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!localObject2.Fif) {
            break label861;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            ae.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)bbf()).Fhz });
            com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath);
            com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath + ".decompressed");
          }
          AppMethodBeat.o(151988);
        }
        localObject2.FiH = localObject2.filePath;
        localObject2.tTW = (localObject2.filePath + ".decompressed");
        localObject2.state = 2;
        continue;
        label861:
        localObject2.FiH = localObject2.filePath;
        localObject2.state = 4;
        continue;
        label880:
        com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath + ".decompressed");
        if (Thread.interrupted())
        {
          ae.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)bbf()).Fhz });
          com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath);
          com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.j.a.d.a.aNH(((a)bbf()).filePath + ".decompressed");
        }
        final a locala = (a)bbf();
        q.a.feQ().handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151987);
            bo localbo = new bo();
            localbo.dnD.dnz = locala.dnz;
            localbo.dnD.subType = locala.subType;
            localbo.dnD.dnF = locala.FhF;
            localbo.dnD.dlO = 1;
            localbo.dnD.dnE = false;
            com.tencent.mm.sdk.b.a.IvT.l(localbo);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.k
 * JD-Core Version:    0.7.0.1
 */