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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/TPUtil;", "", "()V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateVideoContainsLayoutParams", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "width", "", "height", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "videoFlag", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "tag", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "", "getMediaRate", "hwRate", "plugin-thumbplayer_release"})
public final class b
{
  public static final b MPi;
  
  static
  {
    AppMethodBeat.i(191237);
    MPi = new b();
    AppMethodBeat.o(191237);
  }
  
  public static h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, h.a parama, String paramString8)
  {
    AppMethodBeat.i(191233);
    p.k(paramString1, "mediaId");
    p.k(paramString2, "url");
    p.k(paramString3, "path");
    p.k(paramString4, "fileFormat");
    p.k(paramString5, "urlToken");
    p.k(paramString8, "tag");
    h localh = new h();
    localh.taskName = "task_TPPlayUtil";
    localh.field_mediaId = paramString1;
    localh.url = (paramString2 + paramString5);
    localh.iUK = 60;
    localh.iUL = 60;
    localh.iVd = 1;
    localh.iUX = 8;
    localh.iVk = 0;
    localh.field_requestVideoFormat = paramInt;
    localh.field_fullpath = paramString3;
    localh.concurrentCount = 4;
    localh.connectionCount = 4;
    localh.snsCipherKey = paramString6;
    localh.iVn = parama;
    localh.iVl = true;
    localh.iVm = true;
    localh.videoFlag = paramString7;
    Log.i(paramString8, "[createVideoPlayCDNTask] finder video, reqFormat=" + paramInt + " fileFormat=" + paramString4 + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + localh.url + ' ');
    AppMethodBeat.o(191233);
    return localh;
  }
  
  public static Bundle l(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = 0.5625F;
    AppMethodBeat.i(191220);
    p.k(paramContext, "context");
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ((Activity)paramContext).getBaseContext();
    }
    p.j(localContext, "baseContext");
    paramContext = localContext.getResources();
    p.j(paramContext, "baseContext.resources");
    int i = paramContext.getDisplayMetrics().widthPixels;
    paramContext = localContext.getResources();
    p.j(paramContext, "baseContext.resources");
    i = Math.min(i, paramContext.getDisplayMetrics().heightPixels);
    float f1 = paramInt2 * 1.0F / paramInt1;
    paramContext = new Bundle();
    paramContext.putInt("scaleType", ImageView.ScaleType.CENTER_CROP.ordinal());
    if (Math.abs(paramInt1 - paramInt2) <= 10)
    {
      paramContext.putInt("width", i);
      paramContext.putInt("height", i);
      AppMethodBeat.o(191220);
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
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.b
 * JD-Core Version:    0.7.0.1
 */