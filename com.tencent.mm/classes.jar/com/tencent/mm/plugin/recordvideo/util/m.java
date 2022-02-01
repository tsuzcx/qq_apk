package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.c;
import com.tencent.mm.plugin.recordvideo.plugin.d;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.g;
import com.tencent.mm.plugin.recordvideo.plugin.k;
import com.tencent.mm.plugin.recordvideo.plugin.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/VideoPluginNameUtil;", "", "()V", "nameTranslate", "", "export", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m ObJ;
  
  static
  {
    AppMethodBeat.i(279544);
    ObJ = new m();
    AppMethodBeat.o(279544);
  }
  
  public static String aTK(String paramString)
  {
    AppMethodBeat.i(279533);
    Log.i("MicroMsg.VideoPluginNameUtil", s.X("nameTranslate ", paramString));
    if (s.p(paramString, c.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_emoji";
    }
    if (s.p(paramString, e.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_text";
    }
    if (s.p(paramString, com.tencent.mm.plugin.recordvideo.plugin.a.a.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_music";
    }
    if (s.p(paramString, com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_video_crop";
    }
    if (s.p(paramString, n.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_photo_crop";
    }
    if (s.p(paramString, g.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_back";
    }
    if (s.p(paramString, f.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_tip";
    }
    if (s.p(paramString, d.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_poi";
    }
    if (s.p(paramString, k.class.getName()))
    {
      AppMethodBeat.o(279533);
      return "plugin_menu";
    }
    AppMethodBeat.o(279533);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.m
 * JD-Core Version:    0.7.0.1
 */