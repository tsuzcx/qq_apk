package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class k$a
  extends f.d<a>
{
  protected k$a(a parama)
  {
    super(parama);
  }
  
  public final void run()
  {
    y.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)aci()).rVT });
    Object localObject1 = (a)aci();
    int i = ((a)localObject1).bHv;
    int j = ((a)localObject1).brC;
    int k = ((a)localObject1).bHw;
    label1057:
    label1060:
    label1063:
    for (;;)
    {
      try
      {
        localObject1 = (a)aci();
        localObject1 = new l(((a)localObject1).bHv, ((a)localObject1).brC, ((a)localObject1).filePath, ((a)localObject1).rVU, ((a)localObject1).rVV, ((a)localObject1).rVW, ((a)localObject1).rVX, ((a)localObject1).rWa, ((a)localObject1).bHx, ((a)localObject1).rVY, ((a)localObject1).rVZ, ((a)localObject1).rWc, ((a)localObject1).rWb, ((a)localObject1).url, ((a)localObject1).rWd, ((a)localObject1).rWe, ((a)localObject1).bHw);
        if (((l)localObject1).rWz)
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).rVT });
          ((l)localObject1).rXb = (((l)localObject1).filePath + ".decompressed");
          ((l)localObject1).state = 32;
          if (((l)localObject1).clC() == null) {
            break label1057;
          }
          ((l)localObject1).state = 16;
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).rVT });
          break label1057;
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).clD(), new Object[] { ((l)localObject1).rVT });
          if (16 == ((l)localObject1).state)
          {
            localObject1 = ((l)localObject1).clA().clB().clC();
            if (bk.bl((String)localObject1)) {
              break label855;
            }
            b.c.clv().e(i, j, (String)localObject1, k);
          }
        }
        else
        {
          if (((l)localObject1).rWA)
          {
            y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).rVT });
            ((l)localObject1).rXb = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 32;
            if (((l)localObject1).clC() == null) {
              break label1060;
            }
            ((l)localObject1).state = 16;
            y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).rVT });
            break label1060;
          }
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).rVT });
          ((l)localObject1).rXb = ((l)localObject1).filePath;
          ((l)localObject1).state = 32;
          if (((l)localObject1).clC() == null) {
            break label1063;
          }
          ((l)localObject1).state = 16;
          y.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).rVT });
          break label1063;
        }
        if (((l)localObject1).rWA)
        {
          ((l)localObject1).rXb = ((l)localObject1).filePath;
          ((l)localObject1).rXc = (((l)localObject1).filePath + ".decrypted");
          ((l)localObject1).state = 1;
          continue;
        }
        if (!localObject2.rWz) {
          break label836;
        }
      }
      finally
      {
        if (Thread.interrupted())
        {
          y.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)aci()).rVT });
          com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath);
          com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath + ".decompressed");
        }
      }
      localObject2.rXb = localObject2.filePath;
      localObject2.rXc = (localObject2.filePath + ".decompressed");
      localObject2.state = 2;
      continue;
      label836:
      localObject2.rXb = localObject2.filePath;
      localObject2.state = 4;
      continue;
      label855:
      com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath + ".decrypted");
      com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath + ".decompressed");
      if (Thread.interrupted())
      {
        y.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)aci()).rVT });
        com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath);
        com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.g.a.d.a.Wp(((a)aci()).filePath + ".decompressed");
      }
      a locala = (a)aci();
      q.a.clL().handler.post(new k.a.1(this, locala));
      return;
      continue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.k.a
 * JD-Core Version:    0.7.0.1
 */