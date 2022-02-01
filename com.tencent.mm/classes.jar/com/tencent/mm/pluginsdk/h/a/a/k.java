package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.pluginsdk.h.a.c.f;
import com.tencent.mm.pluginsdk.h.a.c.f.a;
import com.tencent.mm.pluginsdk.h.a.c.f.d;
import com.tencent.mm.pluginsdk.h.a.c.q;
import com.tencent.mm.pluginsdk.h.a.c.q.a;
import com.tencent.mm.pluginsdk.h.a.c.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;

final class k
  extends f<a>
{
  private final com.tencent.e.b Dlh;
  
  k()
  {
    AppMethodBeat.i(151989);
    this.Dlh = new f.a(this, "MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, 2147483647, new SynchronousQueue());
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
    if (aGF(parama.Dkb))
    {
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.Dkb });
      AppMethodBeat.o(151991);
      return;
    }
    if (((parama.Dkc) && (parama.dbe == parama.Dkf) && (parama.Dkf >= 0)) || ((!parama.Dkc) && (parama.Dkd))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151991);
      return;
    }
    ac.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.Dkb });
    try
    {
      super.b(parama);
      AppMethodBeat.o(151991);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      ac.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", new Object[] { parama.Dkb, localRejectedExecutionException });
      LJ(parama.Dkb);
      b(parama).run();
      AppMethodBeat.o(151991);
    }
  }
  
  public final com.tencent.e.b eLR()
  {
    return this.Dlh;
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
      ac.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)aXi()).Dkb });
      Object localObject1 = (a)aXi();
      int i = ((a)localObject1).dbd;
      int j = ((a)localObject1).subType;
      int k = ((a)localObject1).dbe;
      label1087:
      label1090:
      label1093:
      for (;;)
      {
        try
        {
          localObject1 = (a)aXi();
          localObject1 = new l(((a)localObject1).dbd, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).Dkc, ((a)localObject1).Dkd, ((a)localObject1).Dke, ((a)localObject1).Dkf, ((a)localObject1).Dkh, ((a)localObject1).dbf, ((a)localObject1).Dkg, ((a)localObject1).dbg, ((a)localObject1).Dkj, ((a)localObject1).Dki, ((a)localObject1).url, ((a)localObject1).Dkk, ((a)localObject1).Dkl, ((a)localObject1).dbe);
          if (((l)localObject1).DkI)
          {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).Dkb });
            ((l)localObject1).Dlk = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).eLU() == null) {
              break label1087;
            }
            ((l)localObject1).state = 16;
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).Dkb });
            break label1087;
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).eLW(), new Object[] { ((l)localObject1).Dkb });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).eLS().eLT().eLU();
              if (bs.isNullOrNil((String)localObject1)) {
                break label880;
              }
              b.eLH().a(i, j, (String)localObject1, k, ((a)aXi()).dbg);
            }
          }
          else
          {
            if (((l)localObject1).DkJ)
            {
              ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).Dkb });
              ((l)localObject1).Dlk = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).eLU() == null) {
                break label1090;
              }
              ((l)localObject1).state = 16;
              ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).Dkb });
              break label1090;
            }
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).Dkb });
            ((l)localObject1).Dlk = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).eLU() == null) {
              break label1093;
            }
            ((l)localObject1).state = 16;
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).Dkb });
            break label1093;
          }
          if (((l)localObject1).DkJ)
          {
            ((l)localObject1).Dlk = ((l)localObject1).filePath;
            ((l)localObject1).sMx = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!localObject2.DkI) {
            break label861;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            ac.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)aXi()).Dkb });
            com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath);
            com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath + ".decompressed");
          }
          AppMethodBeat.o(151988);
        }
        localObject2.Dlk = localObject2.filePath;
        localObject2.sMx = (localObject2.filePath + ".decompressed");
        localObject2.state = 2;
        continue;
        label861:
        localObject2.Dlk = localObject2.filePath;
        localObject2.state = 4;
        continue;
        label880:
        com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath + ".decompressed");
        if (Thread.interrupted())
        {
          ac.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)aXi()).Dkb });
          com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath);
          com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.h.a.d.a.aGL(((a)aXi()).filePath + ".decompressed");
        }
        final a locala = (a)aXi();
        q.a.eMf().handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151987);
            bl localbl = new bl();
            localbl.dbh.dbd = locala.dbd;
            localbl.dbh.subType = locala.subType;
            localbl.dbh.dbj = locala.Dkh;
            localbl.dbh.cZu = 1;
            localbl.dbh.dbi = false;
            com.tencent.mm.sdk.b.a.GpY.l(localbl);
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
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.k
 * JD-Core Version:    0.7.0.1
 */