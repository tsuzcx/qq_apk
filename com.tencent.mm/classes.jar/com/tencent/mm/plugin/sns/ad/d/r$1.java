package com.tencent.mm.plugin.sns.ad.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.lite.api.b;
import com.tencent.mm.plugin.lite.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

final class r$1
  implements Runnable
{
  r$1(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(310103);
    try
    {
      if (Util.isNullOrNil(this.etl))
      {
        Log.e("LiteAppPreviewHelper", "appId is null or nil");
        AppMethodBeat.o(310103);
        return;
      }
      final long l = System.currentTimeMillis();
      final SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("ad_finder_room_preview_lite_app_update", 0);
      if (l - localSharedPreferences.getLong(this.etl, 0L) >= 21600000L)
      {
        ((c)h.ax(c.class)).a(this.etl, new b()
        {
          public final void b(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
          {
            AppMethodBeat.i(310015);
            try
            {
              long l = System.currentTimeMillis();
              localSharedPreferences.edit().putLong(r.1.this.etl, l).commit();
              Log.i("LiteAppPreviewHelper", "checkFinderRoomPreview success, checkTimeInterval is " + (l - l));
              AppMethodBeat.o(310015);
              return;
            }
            finally
            {
              Log.e("LiteAppPreviewHelper", paramAnonymousWxaLiteAppInfo.toString());
              AppMethodBeat.o(310015);
            }
          }
          
          public final void csy()
          {
            AppMethodBeat.i(310022);
            long l = System.currentTimeMillis();
            Log.i("LiteAppPreviewHelper", "checkFinderRoomPreview fail, checkTimeInterval is " + (l - l));
            AppMethodBeat.o(310022);
          }
        });
        AppMethodBeat.o(310103);
        return;
      }
    }
    finally
    {
      Log.e("LiteAppPreviewHelper", localObject.toString());
      AppMethodBeat.o(310103);
      return;
    }
    Log.d("LiteAppPreviewHelper", "checkFinderRoomPreview but time interval is not over 6h");
    AppMethodBeat.o(310103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.r.1
 * JD-Core Version:    0.7.0.1
 */