package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil;", "", "()V", "TAG", "", "checkConfigProviderParam", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getVideoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "path", "VideoInfo", "plugin-recordvideo_release"})
public final class c
{
  public static final c yho;
  
  static
  {
    AppMethodBeat.i(76222);
    yho = new c();
    AppMethodBeat.o(76222);
  }
  
  public static c.a axr(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(76221);
    p.h(paramString, "path");
    a locala = e.ayN(paramString);
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
      locala.width = bu.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      locala.height = bu.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      locala.videoBitrate = bu.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label116:
      int k = SightVideoJNI.getMp4RotateVFS(paramString);
      paramString = al.ck(ak.getContext());
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
        paramString = new c.a(locala.width, locala.height, locala.videoDuration, k, locala.videoBitrate, locala.frameRate, bool, locala.yhq, locala.yhr, locala.yhs);
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
    if (paramRecordConfigProvider.xOg == null) {
      switch (paramRecordConfigProvider.scene)
      {
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.MediaRecordParamUtil", "checkConfigProviderParam " + paramRecordConfigProvider.xOg);
      AppMethodBeat.o(76220);
      return;
      d locald = d.aHh();
      p.g(locald, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.xOg = locald.aHk();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.c
 * JD-Core Version:    0.7.0.1
 */