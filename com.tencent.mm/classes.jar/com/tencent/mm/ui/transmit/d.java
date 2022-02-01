package com.tencent.mm.ui.transmit;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.g.a;
import com.tencent.mm.g.c;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.io.ByteArrayOutputStream;

public final class d
{
  public static void a(String paramString, final a parama)
  {
    AppMethodBeat.i(250925);
    com.tencent.threadpool.h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(250870);
        if (y.bEl(d.this) > 1048576L)
        {
          Log.e("MiroMsg.MusicVideoShareUtil", "img size is too large");
          d.a(parama, null);
          AppMethodBeat.o(250870);
          return;
        }
        String str1 = y.n(d.this, false);
        d.a locala = parama;
        Log.i("MiroMsg.MusicVideoShareUtil", "alvinluo handleCDNUpload imgPath: %s", new Object[] { str1 });
        com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
        long l = System.currentTimeMillis();
        String str2 = com.tencent.mm.modelcdntran.h.a("musicvideoimage", l, z.bBF().field_username, String.valueOf(l));
        localg.taskName = "task_AiScanImagetUploadTask";
        localg.field_mediaId = str2;
        localg.field_fullpath = str1;
        localg.field_appType = 202;
        localg.field_fileType = a.lwj;
        localg.field_priority = a.lvZ;
        localg.field_needStorage = false;
        localg.field_needCompressImage = true;
        localg.field_isStreamMedia = false;
        localg.field_bzScene = 2;
        localg.lwL = new d.2(locala);
        if (!k.bHW().g(localg)) {
          Log.e("MiroMsg.MusicVideoShareUtil", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { str2 });
        }
        AppMethodBeat.o(250870);
      }
    }, "MusicVideoShareUploadImage");
    AppMethodBeat.o(250925);
  }
  
  public static abstract interface a
  {
    public abstract void auK(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.d
 * JD-Core Version:    0.7.0.1
 */