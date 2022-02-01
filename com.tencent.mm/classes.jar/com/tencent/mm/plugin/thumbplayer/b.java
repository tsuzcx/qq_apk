package com.tencent.mm.plugin.thumbplayer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h;
import com.tencent.mm.g.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/TPUtil;", "", "()V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateVideoContainsLayoutParams", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", "width", "", "height", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "", "url", "path", "reqFormat", "fileFormat", "urlToken", "decodeKey", "videoFlag", "videoCallback", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "tag", "createVideoPreloadCDNTask", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "preloadCallback", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskPreloadCallback;", "preloadPercent", "preloadMinSize", "", "getMediaRate", "hwRate", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b TBI;
  
  static
  {
    AppMethodBeat.i(272038);
    TBI = new b();
    AppMethodBeat.o(272038);
  }
  
  public static h a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, String paramString6, String paramString7, h.a parama, String paramString8)
  {
    AppMethodBeat.i(272032);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "url");
    s.u(paramString3, "path");
    s.u(paramString4, "fileFormat");
    s.u(paramString5, "urlToken");
    s.u(paramString8, "tag");
    h localh = new h();
    localh.taskName = "task_TPPlayUtil";
    localh.field_mediaId = paramString1;
    localh.url = s.X(paramString2, paramString5);
    localh.lwP = 60;
    localh.lwQ = 60;
    localh.lxi = 1;
    localh.lxc = 8;
    localh.lxp = 0;
    localh.field_requestVideoFormat = paramInt;
    localh.field_fullpath = paramString3;
    localh.concurrentCount = 4;
    localh.connectionCount = 4;
    localh.snsCipherKey = paramString6;
    localh.lxs = parama;
    localh.lxq = true;
    localh.lxr = true;
    if (paramString7 != null) {
      localh.videoFlag = paramString7;
    }
    Log.i(paramString8, "[createVideoPlayCDNTask] finder video, reqFormat=" + paramInt + " fileFormat=" + paramString4 + ", decodeKey=" + paramString6 + ' ' + paramString5 + " mediaId=" + paramString1 + " url=" + localh.url + ' ');
    AppMethodBeat.o(272032);
    return localh;
  }
  
  public static Bundle p(Context paramContext, int paramInt1, int paramInt2)
  {
    float f2 = 0.5625F;
    AppMethodBeat.i(272026);
    s.u(paramContext, "context");
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = ((Activity)paramContext).getBaseContext();
    }
    int i = Math.min(localContext.getResources().getDisplayMetrics().widthPixels, localContext.getResources().getDisplayMetrics().heightPixels);
    float f1 = paramInt2 * 1.0F / paramInt1;
    paramContext = new Bundle();
    paramContext.putInt("scaleType", ImageView.ScaleType.CENTER_CROP.ordinal());
    if (Math.abs(paramInt1 - paramInt2) <= 10)
    {
      paramContext.putInt("width", i);
      paramContext.putInt("height", i);
      AppMethodBeat.o(272026);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.b
 * JD-Core Version:    0.7.0.1
 */