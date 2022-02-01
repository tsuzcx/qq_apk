package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.c.b.b;
import com.tencent.matrix.report.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ce;
import com.tencent.mm.pluginsdk.res.downloader.model.f;
import com.tencent.mm.pluginsdk.res.downloader.model.f.a;
import com.tencent.mm.pluginsdk.res.downloader.model.f.d;
import com.tencent.mm.pluginsdk.res.downloader.model.p;
import com.tencent.mm.pluginsdk.res.downloader.model.p.a;
import com.tencent.mm.pluginsdk.res.downloader.model.r;
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
  private final com.tencent.threadpool.b XWf;
  
  k()
  {
    AppMethodBeat.i(151989);
    this.XWf = new f.a(this, "MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", 0, 2147483647, new SynchronousQueue());
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
    if (bqn(parama.XUX))
    {
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "URLKey(%s) is already decrypting, skip repeated task", new Object[] { parama.XUX });
      AppMethodBeat.o(151991);
      return;
    }
    if (((parama.XUY) && (parama.hCi == parama.XVb) && (parama.XVb >= 0)) || ((!parama.XUY) && (parama.XUZ))) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(151991);
      return;
    }
    Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "request#URLKey(%s) posted to decryptWorker", new Object[] { parama.XUX });
    try
    {
      super.b(parama);
      AppMethodBeat.o(151991);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      Log.e("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "submitRequest(%s) get rejected[%s]", new Object[] { parama.XUX, localRejectedExecutionException });
      ZJ(parama.XUX);
      b(parama).run();
      AppMethodBeat.o(151991);
    }
  }
  
  public final void dB(boolean paramBoolean)
  {
    AppMethodBeat.i(245049);
    if ((com.tencent.matrix.c.a.ni(81)) && (paramBoolean) && (!this.XWv.isEmpty()))
    {
      Log.w("MicroMsg.ResDownloader.CheckResUpdate.DecryptExecutor", "#onAppLowEnergy, cancel all bg tasks");
      e.a.ns(81);
      cancelAll();
    }
    AppMethodBeat.o(245049);
  }
  
  public final com.tencent.threadpool.b iJs()
  {
    return this.XWf;
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
      Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)cgY()).XUX });
      Object localObject1 = (a)cgY();
      int i = ((a)localObject1).hCh;
      int j = ((a)localObject1).subType;
      int k = ((a)localObject1).hCi;
      label1087:
      label1090:
      label1093:
      for (;;)
      {
        try
        {
          localObject1 = (a)cgY();
          localObject1 = new l(((a)localObject1).hCh, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).XUY, ((a)localObject1).XUZ, ((a)localObject1).XVa, ((a)localObject1).XVb, ((a)localObject1).XVd, ((a)localObject1).hCj, ((a)localObject1).XVc, ((a)localObject1).hCk, ((a)localObject1).XVe, ((a)localObject1).Wmc, ((a)localObject1).url, ((a)localObject1).XVf, ((a)localObject1).XVg, ((a)localObject1).hCi);
          if (((l)localObject1).XVF)
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).XUX });
            ((l)localObject1).XWi = (((l)localObject1).filePath + ".decompressed");
            ((l)localObject1).state = 32;
            if (((l)localObject1).iJv() == null) {
              break label1087;
            }
            ((l)localObject1).state = 16;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).XUX });
            break label1087;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).iJx(), new Object[] { ((l)localObject1).XUX });
            if (16 == ((l)localObject1).state)
            {
              localObject1 = ((l)localObject1).iJt().iJu().iJv();
              if (Util.isNullOrNil((String)localObject1)) {
                break label880;
              }
              b.iJf().c(i, j, (String)localObject1, k, ((a)cgY()).hCk);
            }
          }
          else
          {
            if (((l)localObject1).XVG)
            {
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).XUX });
              ((l)localObject1).XWi = (((l)localObject1).filePath + ".decrypted");
              ((l)localObject1).state = 32;
              if (((l)localObject1).iJv() == null) {
                break label1090;
              }
              ((l)localObject1).state = 16;
              Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).XUX });
              break label1090;
            }
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).XUX });
            ((l)localObject1).XWi = ((l)localObject1).filePath;
            ((l)localObject1).state = 32;
            if (((l)localObject1).iJv() == null) {
              break label1093;
            }
            ((l)localObject1).state = 16;
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).XUX });
            break label1093;
          }
          if (((l)localObject1).XVG)
          {
            ((l)localObject1).XWi = ((l)localObject1).filePath;
            ((l)localObject1).HJP = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 1;
            continue;
          }
          if (!localObject2.XVF) {
            break label861;
          }
        }
        finally
        {
          if (Thread.interrupted())
          {
            Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)cgY()).XUX });
            com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath);
            com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath + ".decrypted");
            com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath + ".decompressed");
          }
          AppMethodBeat.o(151988);
        }
        localObject2.XWi = localObject2.filePath;
        localObject2.HJP = (localObject2.filePath + ".decompressed");
        localObject2.state = 2;
        continue;
        label861:
        localObject2.XWi = localObject2.filePath;
        localObject2.state = 4;
        continue;
        label880:
        com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath + ".decompressed");
        if (Thread.interrupted())
        {
          Log.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)cgY()).XUX });
          com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath);
          com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.res.downloader.b.a.bqu(((a)cgY()).filePath + ".decompressed");
        }
        final a locala = (a)cgY();
        p.a.iJK().handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(151987);
            ce localce = new ce();
            localce.hCl.hCh = locala.hCh;
            localce.hCl.subType = locala.subType;
            localce.hCl.hCn = locala.XVd;
            localce.hCl.hAf = 1;
            localce.hCl.hCm = false;
            localce.publish();
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
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.k
 * JD-Core Version:    0.7.0.1
 */