package com.tencent.mm.plugin.websearch.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;

final class a$3
  implements Runnable
{
  a$3(a parama, View paramView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(116593);
    try
    {
      final Bitmap localBitmap = f.fy(this.val$view);
      if (localBitmap != null) {
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116592);
            try
            {
              u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "saving widget preview", new Object[0]);
              String str = com.tencent.mm.loader.j.b.aia().replace("/data/user/0", "/data/data") + "/fts_cache";
              str = q.B(new e(new StringBuilder().append(str).append("/").toString(), new StringBuilder("widget_frame_").append(a.3.this.AIC).append("_").append(System.currentTimeMillis()).toString()).fhU()) + ".jpg";
              f.a(localBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
              Bundle localBundle = new Bundle();
              localBundle.putString("widgetId", a.3.this.AIC);
              localBundle.putString("path", str);
              h.a("com.tencent.mm", localBundle, a.c.class, new d() {});
              AppMethodBeat.o(116592);
              return;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localException, "", new Object[0]);
              AppMethodBeat.o(116592);
            }
          }
        }, "saveWidgetPreview");
      }
      AppMethodBeat.o(116593);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localThrowable, "", new Object[0]);
      AppMethodBeat.o(116593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.3
 * JD-Core Version:    0.7.0.1
 */