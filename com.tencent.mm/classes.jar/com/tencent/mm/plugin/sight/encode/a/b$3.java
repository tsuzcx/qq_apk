package com.tencent.mm.plugin.sight.encode.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, String paramString1, b.a parama, String paramString2, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(70360);
    ab.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", new Object[] { this.bZZ });
    Object localObject1 = t.ve(this.bZZ);
    if (-1L == u.a((String)localObject1, this.bZZ, null, 62))
    {
      ab.e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", new Object[] { localObject1 });
      b.a(this.qVG, -1);
      AppMethodBeat.o(70360);
      return;
    }
    String str = com.tencent.mm.plugin.sight.base.d.TW(this.hRL);
    Object localObject2;
    if (!e.cN(str))
    {
      ab.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
      localObject2 = com.tencent.mm.plugin.sight.base.d.as(this.hRL, 320, 240);
    }
    try
    {
      com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject2, 60, Bitmap.CompressFormat.JPEG, str, true);
      o.alE();
      e.C(str, t.vg((String)localObject1));
      o.alE();
      localObject2 = t.vf((String)localObject1);
      long l = e.C(this.hRL, (String)localObject2);
      ab.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[] { this.bZZ, Long.valueOf(l) });
      if (l <= 0L)
      {
        ab.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", new Object[] { this.hRL, localObject2 });
        b.a(this.qVG, -1);
        u.vk((String)localObject1);
        AppMethodBeat.o(70360);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
        ab.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
      }
      u.v((String)localObject1, this.qVH, 62);
      u.vm((String)localObject1);
      localObject1 = this.qVG;
      if (localObject1 != null) {
        al.d(new b.2((b.a)localObject1));
      }
      e.deleteFile(this.hRL);
      e.deleteFile(str);
      AppMethodBeat.o(70360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.b.3
 * JD-Core Version:    0.7.0.1
 */