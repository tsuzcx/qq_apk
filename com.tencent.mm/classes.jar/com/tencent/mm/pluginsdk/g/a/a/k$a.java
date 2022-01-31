package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

final class k$a
  extends f.d<a>
{
  protected k$a(a parama)
  {
    super(parama);
  }
  
  public final void run()
  {
    AppMethodBeat.i(79545);
    ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[] { ((a)avY()).vMK });
    Object localObject1 = (a)avY();
    int i = ((a)localObject1).coJ;
    int j = ((a)localObject1).subType;
    int k = ((a)localObject1).coK;
    label1087:
    label1090:
    label1093:
    for (;;)
    {
      try
      {
        localObject1 = (a)avY();
        localObject1 = new l(((a)localObject1).coJ, ((a)localObject1).subType, ((a)localObject1).filePath, ((a)localObject1).vML, ((a)localObject1).vMM, ((a)localObject1).vMN, ((a)localObject1).vMO, ((a)localObject1).vMQ, ((a)localObject1).coL, ((a)localObject1).vMP, ((a)localObject1).coM, ((a)localObject1).vMS, ((a)localObject1).vMR, ((a)localObject1).url, ((a)localObject1).vMT, ((a)localObject1).vMU, ((a)localObject1).coK);
        if (((l)localObject1).vNr)
        {
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[] { ((l)localObject1).vMK });
          ((l)localObject1).vNT = (((l)localObject1).filePath + ".decompressed");
          ((l)localObject1).state = 32;
          if (((l)localObject1).dmo() == null) {
            break label1087;
          }
          ((l)localObject1).state = 16;
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).vMK });
          break label1087;
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + ((l)localObject1).dmq(), new Object[] { ((l)localObject1).vMK });
          if (16 == ((l)localObject1).state)
          {
            localObject1 = ((l)localObject1).dmm().dmn().dmo();
            if (bo.isNullOrNil((String)localObject1)) {
              break label880;
            }
            b.c.dmg().a(i, j, (String)localObject1, k, ((a)avY()).coM);
          }
        }
        else
        {
          if (((l)localObject1).vNs)
          {
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[] { ((l)localObject1).vMK });
            ((l)localObject1).vNT = (((l)localObject1).filePath + ".decrypted");
            ((l)localObject1).state = 32;
            if (((l)localObject1).dmo() == null) {
              break label1090;
            }
            ((l)localObject1).state = 16;
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).vMK });
            break label1090;
          }
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[] { ((l)localObject1).vMK });
          ((l)localObject1).vNT = ((l)localObject1).filePath;
          ((l)localObject1).state = 32;
          if (((l)localObject1).dmo() == null) {
            break label1093;
          }
          ((l)localObject1).state = 16;
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[] { ((l)localObject1).vMK });
          break label1093;
        }
        if (((l)localObject1).vNs)
        {
          ((l)localObject1).vNT = ((l)localObject1).filePath;
          ((l)localObject1).vNU = (((l)localObject1).filePath + ".decrypted");
          ((l)localObject1).state = 1;
          continue;
        }
        if (!localObject2.vNr) {
          break label861;
        }
      }
      finally
      {
        if (Thread.interrupted())
        {
          ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)avY()).vMK });
          com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath);
          com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath + ".decrypted");
          com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath + ".decompressed");
        }
        AppMethodBeat.o(79545);
      }
      localObject2.vNT = localObject2.filePath;
      localObject2.vNU = (localObject2.filePath + ".decompressed");
      localObject2.state = 2;
      continue;
      label861:
      localObject2.vNT = localObject2.filePath;
      localObject2.state = 4;
      continue;
      label880:
      com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath + ".decrypted");
      com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath + ".decompressed");
      if (Thread.interrupted())
      {
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[] { ((a)avY()).vMK });
        com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath);
        com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath + ".decrypted");
        com.tencent.mm.pluginsdk.g.a.d.a.alT(((a)avY()).filePath + ".decompressed");
      }
      a locala = (a)avY();
      q.a.dmz().handler.post(new k.a.1(this, locala));
      AppMethodBeat.o(79545);
      return;
      continue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.k.a
 * JD-Core Version:    0.7.0.1
 */