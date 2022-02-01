package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.b;
import com.tencent.mm.plugin.recordvideo.plugin.c;
import com.tencent.mm.plugin.recordvideo.plugin.d;
import com.tencent.mm.plugin.recordvideo.plugin.e;
import com.tencent.mm.plugin.recordvideo.plugin.f;
import com.tencent.mm.plugin.recordvideo.plugin.m;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/VideoPluginNameUtil;", "", "()V", "nameTranslate", "", "export", "plugin-recordvideo_release"})
public final class j
{
  public static final j Ifp;
  
  static
  {
    AppMethodBeat.i(226669);
    Ifp = new j();
    AppMethodBeat.o(226669);
  }
  
  public static String aWw(String paramString)
  {
    AppMethodBeat.i(226667);
    Log.i("MicroMsg.VideoPluginNameUtil", "nameTranslate ".concat(String.valueOf(paramString)));
    if (p.h(paramString, b.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_emoji";
    }
    if (p.h(paramString, d.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_text";
    }
    if (p.h(paramString, com.tencent.mm.plugin.recordvideo.plugin.a.a.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_music";
    }
    if (p.h(paramString, com.tencent.mm.plugin.recordvideo.plugin.cropvideo.a.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_video_crop";
    }
    if (p.h(paramString, m.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_photo_crop";
    }
    if (p.h(paramString, f.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_back";
    }
    if (p.h(paramString, e.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_tip";
    }
    if (p.h(paramString, c.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_poi";
    }
    if (p.h(paramString, com.tencent.mm.plugin.recordvideo.plugin.j.class.getName()))
    {
      AppMethodBeat.o(226667);
      return "plugin_menu";
    }
    AppMethodBeat.o(226667);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.j
 * JD-Core Version:    0.7.0.1
 */