package com.tencent.mm.plugin.textstatus.e;

import android.graphics.Bitmap;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r.a;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
final class a$c
  implements r.a
{
  a$c(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void a(String paramString1, final Bitmap paramBitmap, String paramString2)
  {
    AppMethodBeat.i(258418);
    h.RTc.aX((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(258417);
        Log.i("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb update " + this.UrR.Gdu + ' ' + this.UrR.msC);
        Object localObject = f.FXJ;
        localObject = f.fvM().aTl(this.UrR.hLl);
        if (localObject != null)
        {
          if (Util.isEqual(this.UrR.Gdu, ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_StatusID))
          {
            Log.i("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb update " + this.UrR.msC + ' ' + this.UrR.Gdu);
            localObject = a.FYI;
            localObject = paramBitmap;
            p.g(localObject, "bitmap");
            a.j((Bitmap)localObject, this.UrR.msC);
            localObject = BitmapUtil.decodeFileWithSample(this.UrR.msC);
            q.bcQ();
            com.tencent.mm.av.d.g(this.UrR.UrL, (Bitmap)localObject);
            AppMethodBeat.o(258417);
            return;
          }
          Log.e("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb getLatest:" + ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_StatusID);
          AppMethodBeat.o(258417);
          return;
        }
        Log.e("MicroMsg.TxtStatus.StatusImgHandler", "triggerDownloadThumb TextStatus is null");
        AppMethodBeat.o(258417);
      }
    });
    AppMethodBeat.o(258418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.a.c
 * JD-Core Version:    0.7.0.1
 */