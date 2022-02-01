package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil;", "", "()V", "TAG", "", "checkConfigProviderParam", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getVideoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "path", "VideoInfo", "plugin-recordvideo_release"})
public final class d
{
  public static final d Cin;
  
  static
  {
    AppMethodBeat.i(76222);
    Cin = new d();
    AppMethodBeat.o(76222);
  }
  
  public static d.a aLQ(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(76221);
    p.h(paramString, "path");
    a locala = com.tencent.mm.plugin.sight.base.e.aNx(paramString);
    if (locala == null)
    {
      AppMethodBeat.o(76221);
      return null;
    }
    if ((locala.height <= 0) || (locala.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      locala.width = Util.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      locala.height = Util.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      locala.videoBitrate = Util.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label116:
      int k = SightVideoJNI.getMp4RotateVFS(paramString);
      paramString = ao.az(MMApplicationContext.getContext());
      int j;
      int i;
      if ((k == 270) || (k == 90))
      {
        j = 1;
        if (j == 0) {
          break label254;
        }
        i = locala.height;
        label153:
        if (j == 0) {
          break label263;
        }
        j = locala.width;
        label163:
        if (Math.abs(i / j - paramString.x / paramString.y) > 0.01D) {
          break label272;
        }
      }
      for (;;)
      {
        paramString = new d.a(locala.width, locala.height, locala.videoDuration, k, locala.videoBitrate, locala.frameRate, bool, locala.Cip, locala.Ciq, locala.Cir);
        AppMethodBeat.o(76221);
        return paramString;
        j = 0;
        break;
        label254:
        i = locala.width;
        break label153;
        label263:
        j = locala.height;
        break label163;
        label272:
        bool = false;
      }
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  public static void h(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76220);
    p.h(paramRecordConfigProvider, "configProvider");
    if (paramRecordConfigProvider.BOm == null) {
      switch (paramRecordConfigProvider.scene)
      {
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MediaRecordParamUtil", "checkConfigProviderParam " + paramRecordConfigProvider.BOm);
      AppMethodBeat.o(76220);
      return;
      com.tencent.mm.modelcontrol.e locale = com.tencent.mm.modelcontrol.e.baZ();
      p.g(locale, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.BOm = locale.bbc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.d
 * JD-Core Version:    0.7.0.1
 */