package com.tencent.mm.ui.transmit;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.aq.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.i.a;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;

public final class d
{
  public static void a(String paramString, final a parama)
  {
    AppMethodBeat.i(289806);
    h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203342);
        if (u.bBQ(this.pqU) > 1048576L)
        {
          Log.e("MiroMsg.MusicVideoShareUtil", "img size is too large");
          d.a(parama, null);
          AppMethodBeat.o(203342);
          return;
        }
        String str1 = u.n(this.pqU, false);
        d.a locala = parama;
        Log.i("MiroMsg.MusicVideoShareUtil", "alvinluo handleCDNUpload imgPath: %s", new Object[] { str1 });
        g localg = new g();
        long l = System.currentTimeMillis();
        String str2 = com.tencent.mm.aq.c.a("musicvideoimage", l, z.bdN().field_username, String.valueOf(l));
        localg.taskName = "task_AiScanImagetUploadTask";
        localg.field_mediaId = str2;
        localg.field_fullpath = str1;
        localg.field_appType = 202;
        localg.field_fileType = a.iUe;
        localg.field_priority = a.iTU;
        localg.field_needStorage = false;
        localg.field_needCompressImage = true;
        localg.field_isStreamMedia = false;
        localg.field_bzScene = 2;
        localg.iUG = new d.2(locala);
        if (!f.bkg().f(localg)) {
          Log.e("MiroMsg.MusicVideoShareUtil", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { str2 });
        }
        AppMethodBeat.o(203342);
      }
    }, "MusicVideoShareUploadImage");
    AppMethodBeat.o(289806);
  }
  
  public static abstract interface a
  {
    public abstract void aAC(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.d
 * JD-Core Version:    0.7.0.1
 */