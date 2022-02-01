package com.tencent.mm.plugin.websearch.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

final class a$3
  implements Runnable
{
  a$3(a parama, View paramView, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(116593);
    try
    {
      final Bitmap localBitmap = BitmapUtil.getBitmapFromView(this.val$view);
      if (localBitmap != null) {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116592);
            try
            {
              u.i("MicroMsg.WebSearch.FTSSearchWidgetMgr", "saving widget preview", new Object[0]);
              String str = b.aKC().replace("/data/user/0", "/data/data") + "/fts_cache";
              str = aa.z(new o(new StringBuilder().append(str).append("/").toString(), new StringBuilder("widget_frame_").append(a.3.this.IHG).append("_").append(System.currentTimeMillis()).toString()).her()) + ".jpg";
              BitmapUtil.saveBitmapToImage(localBitmap, 100, Bitmap.CompressFormat.JPEG, str, true);
              Bundle localBundle = new Bundle();
              localBundle.putString("widgetId", a.3.this.IHG);
              localBundle.putString("path", str);
              h.a(MainProcessIPCService.dkO, localBundle, a.c.class, new d() {});
              AppMethodBeat.o(116592);
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localException, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.WebSearch.FTSSearchWidgetMgr", localThrowable, "", new Object[0]);
      AppMethodBeat.o(116593);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.3
 * JD-Core Version:    0.7.0.1
 */