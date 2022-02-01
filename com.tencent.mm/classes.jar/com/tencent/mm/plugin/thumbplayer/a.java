package com.tencent.mm.plugin.thumbplayer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/thumbplayer/TPUtil;", "", "()V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateVideoContainsLayoutParams", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "width", "", "height", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "tag", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "", "getMediaRate", "hwRate", "plugin-thumbplayer_release"})
public final class a
{
  public static final a Ggt;
  
  static
  {
    AppMethodBeat.i(238615);
    Ggt = new a();
    AppMethodBeat.o(238615);
  }
  
  public static h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, h.a parama, String paramString7)
  {
    AppMethodBeat.i(238614);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "url");
    p.h(paramString3, "path");
    p.h(paramString4, "fileFormat");
    p.h(paramString5, "urlToken");
    p.h(paramString7, "tag");
    h localh = new h();
    localh.taskName = "task_TPPlayUtil";
    localh.field_mediaId = paramString1;
    localh.url = (paramString2 + paramString5);
    localh.gqC = 60;
    localh.gqD = 60;
    localh.gqU = 1;
    localh.gqP = 8;
    localh.grb = 0;
    localh.field_requestVideoFormat = paramInt;
    localh.field_fullpath = paramString3;
    localh.concurrentCount = 4;
    localh.connectionCount = 4;
    localh.snsCipherKey = paramString6;
    localh.gre = parama;
    localh.grc = true;
    localh.grd = true;
    Log.i(paramString7, "[createVideoPlayCDNTask] finder video, reqFormat=" + paramInt + " fileFormat=" + paramString4 + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + localh.url + ' ');
    AppMethodBeat.o(238614);
    return localh;
  }
  
  public static Bundle k(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = 0.5625F;
    AppMethodBeat.i(238613);
    p.h(paramContext, "context");
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ((Activity)paramContext).getBaseContext();
    }
    p.g(localContext, "baseContext");
    paramContext = localContext.getResources();
    p.g(paramContext, "baseContext.resources");
    int i = paramContext.getDisplayMetrics().widthPixels;
    paramContext = localContext.getResources();
    p.g(paramContext, "baseContext.resources");
    i = Math.min(i, paramContext.getDisplayMetrics().heightPixels);
    float f1 = paramInt2 * 1.0F / paramInt1;
    paramContext = new Bundle();
    paramContext.putInt("scaleType", ImageView.ScaleType.CENTER_CROP.ordinal());
    if (Math.abs(paramInt1 - paramInt2) <= 10)
    {
      paramContext.putInt("width", i);
      paramContext.putInt("height", i);
      AppMethodBeat.o(238613);
      return paramContext;
    }
    if (f1 < 0.5625F) {}
    for (f1 = f2;; f1 = 1.316667F) {
      do
      {
        paramContext.putInt("width", i);
        paramContext.putInt("height", (int)(f1 * i));
        break;
      } while ((f1 < 1.0F) || (f1 < 1.316667F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.a
 * JD-Core Version:    0.7.0.1
 */