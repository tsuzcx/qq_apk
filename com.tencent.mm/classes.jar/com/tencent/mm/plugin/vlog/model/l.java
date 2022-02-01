package com.tencent.mm.plugin.vlog.model;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.n.n;
import java.io.IOException;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker;", "", "()V", "getVideoFrameRate", "", "path", "", "getVideoInfo", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "getVideoInfoH264", "getVideoInfoH265", "isH265Video", "", "VideoInfo", "plugin-vlog_release"})
public final class l
{
  public static final l AnC;
  
  static
  {
    AppMethodBeat.i(207542);
    AnC = new l();
    AppMethodBeat.o(207542);
  }
  
  private static float MH(String paramString)
  {
    k = 0;
    int m = 0;
    AppMethodBeat.i(207541);
    localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int n = localMediaExtractor.getTrackCount();
        j = 0;
        i = m;
        if (j < n)
        {
          paramString = localMediaExtractor.getTrackFormat(j);
          String str = paramString.getString("mime");
          k.g(str, "mime");
          if ((!n.nb(str, "video/")) || (!paramString.containsKey("frame-rate"))) {
            continue;
          }
          i = paramString.getInteger("frame-rate");
        }
        localMediaExtractor.release();
      }
      catch (IOException paramString)
      {
        int j;
        float f;
        localMediaExtractor.release();
        int i = k;
        continue;
      }
      finally
      {
        localMediaExtractor.release();
        AppMethodBeat.o(207541);
      }
      f = i;
      AppMethodBeat.o(207541);
      return f * 1.0F;
      j += 1;
    }
  }
  
  public static l.a aye(String paramString)
  {
    AppMethodBeat.i(207538);
    k.h(paramString, "path");
    if (i.eA(paramString))
    {
      k.h(paramString, "path");
      if (SightVideoJNI.isH265VideoVFS(paramString))
      {
        paramString = ayf(paramString);
        AppMethodBeat.o(207538);
        return paramString;
      }
      paramString = ayg(paramString);
      AppMethodBeat.o(207538);
      return paramString;
    }
    AppMethodBeat.o(207538);
    return null;
  }
  
  private static l.a ayf(String paramString)
  {
    AppMethodBeat.i(207539);
    d locald = new d();
    for (;;)
    {
      try
      {
        locald.setDataSource(paramString);
        int i = bs.getInt(locald.extractMetadata(18), 0);
        int j = bs.getInt(locald.extractMetadata(19), 0);
        long l = bs.getLong(locald.extractMetadata(9), 0L);
        int k = SightVideoJNI.getMp4RotateVFS(paramString);
        if (Build.VERSION.SDK_INT >= 23)
        {
          f1 = bs.getFloat(locald.extractMetadata(25), 0.0F);
          float f2 = f1;
          if (f1 == 0.0F) {
            f2 = MH(paramString);
          }
          paramString = new l.a(i, j, f2, l, bs.getInt(locald.extractMetadata(20), 0), k, true);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      finally
      {
        locald.release();
        AppMethodBeat.o(207539);
      }
      float f1 = 0.0F;
    }
  }
  
  private static l.a ayg(String paramString)
  {
    AppMethodBeat.i(207540);
    try
    {
      a locala = e.asx(paramString);
      if (locala != null)
      {
        int i = SightVideoJNI.getMp4RotateVFS(paramString);
        paramString = new l.a(locala.width, locala.height, locala.frameRate, locala.videoDuration, locala.videoBitrate, i);
        AppMethodBeat.o(207540);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(207540);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.l
 * JD-Core Version:    0.7.0.1
 */