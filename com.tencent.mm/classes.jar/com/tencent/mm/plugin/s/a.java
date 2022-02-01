package com.tencent.mm.plugin.s;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mediabase/MediaFilePathUtil;", "", "()V", "AAC_SUFFIX", "", "EXPORT_PATH", "H264_SUFFIX", "HEVC_SUFFIX", "MUX_PATH", "PARENT_PATH", "TAG", "VFSStrategyRegiester", "", "getAppCacheDir", "getMediaFilePath", "fileName", "getMediaMuxAACFilePath", "getMediaMuxH264FilePath", "getMediaMuxParentPath", "plugin-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a KOy;
  
  static
  {
    AppMethodBeat.i(260300);
    KOy = new a();
    AppMethodBeat.o(260300);
  }
  
  public static String aLb(String paramString)
  {
    AppMethodBeat.i(260295);
    am localam = am.aixg;
    paramString = String.format(Locale.ENGLISH, s.X(gaE(), "/%s"), Arrays.copyOf(new Object[] { paramString }, 1));
    s.s(paramString, "java.lang.String.format(locale, format, *args)");
    AppMethodBeat.o(260295);
    return paramString;
  }
  
  public static String gaE()
  {
    AppMethodBeat.i(260289);
    if ((MMApplicationContext.getContext() == null) || (MMApplicationContext.getContext().getCacheDir() == null))
    {
      Log.e("MicroMsg.MediaFilePathUtil", "path is empty, MMApplicationContext.getContext() == null");
      AppMethodBeat.o(260289);
      return "";
    }
    String str = MMApplicationContext.getContext().getCacheDir().getAbsolutePath();
    s.s(str, "getContext().cacheDir.absolutePath");
    str = s.X(str, "/mux");
    u localu = new u(str);
    if (!localu.jKS())
    {
      localu.jKY();
      Log.i("MicroMsg.MediaFilePathUtil", "path is not exists, mkdir path: %s", new Object[] { str });
    }
    Log.i("MicroMsg.MediaFilePathUtil", "WechatSight ffmpegMuxerPath parent path is %s", new Object[] { str });
    AppMethodBeat.o(260289);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a
 * JD-Core Version:    0.7.0.1
 */