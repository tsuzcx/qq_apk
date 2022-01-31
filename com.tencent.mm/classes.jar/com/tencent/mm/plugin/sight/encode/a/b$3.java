package com.tencent.mm.plugin.sight.encode.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.a.e;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, String paramString1, b.a parama, String paramString2, int paramInt) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightRecorderHelper", "do prepare sight message for %s", new Object[] { this.bxX });
    Object localObject1 = t.nR(this.bxX);
    if (-1L == u.a((String)localObject1, this.bxX, null, 62))
    {
      y.e("MicroMsg.SightRecorderHelper", "prepare sight error, filename %s", new Object[] { localObject1 });
      b.a(this.ohr, -1);
      return;
    }
    String str = d.ME(this.gwa);
    Object localObject2;
    if (!e.bK(str))
    {
      y.w("MicroMsg.SightRecorderHelper", "thumb data not found, try to create thumb");
      localObject2 = d.ab(this.gwa, 320, 240);
    }
    try
    {
      c.a((Bitmap)localObject2, 60, Bitmap.CompressFormat.JPEG, str, true);
      o.Sr();
      e.r(str, t.nT((String)localObject1));
      o.Sr();
      localObject2 = t.nS((String)localObject1);
      long l = e.r(this.gwa, (String)localObject2);
      y.i("MicroMsg.SightRecorderHelper", "prepare to send sight to %s, sightFileSize %d bytes", new Object[] { this.bxX, Long.valueOf(l) });
      if (l <= 0L)
      {
        y.e("MicroMsg.SightRecorderHelper", "copy remux video path from %s to %s error", new Object[] { this.gwa, localObject2 });
        b.a(this.ohr, -1);
        u.nX((String)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SightRecorderHelper", localException, "", new Object[0]);
        y.e("MicroMsg.SightRecorderHelper", "save bitmap to image error");
      }
      u.l((String)localObject1, this.ohs, 62);
      u.nZ((String)localObject1);
      localObject1 = this.ohr;
      if (localObject1 != null) {
        ai.d(new b.2((b.a)localObject1));
      }
      e.deleteFile(this.gwa);
      e.deleteFile(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.encode.a.b.3
 * JD-Core Version:    0.7.0.1
 */