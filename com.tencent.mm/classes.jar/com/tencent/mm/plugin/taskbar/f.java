package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/taskbar/TaskBarLogic;", "", "()V", "generateTaskBarImageCacheKey", "", "path", "imageLoaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImgPath", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "plugin-taskbar_release"})
public final class f
{
  public static final f Mnf;
  
  static
  {
    AppMethodBeat.i(214926);
    Mnf = new f();
    AppMethodBeat.o(214926);
  }
  
  public static String aQX(String paramString)
  {
    AppMethodBeat.i(214924);
    p.k(paramString, "id");
    StringBuilder localStringBuilder = new StringBuilder();
    g localg = g.Mni;
    paramString = g.giV() + paramString;
    AppMethodBeat.o(214924);
    return paramString;
  }
  
  public static String f(String paramString, c paramc)
  {
    AppMethodBeat.i(214923);
    p.k(paramString, "path");
    p.k(paramc, "imageLoaderOptions");
    String str = paramString;
    if (paramc.bmC()) {
      str = paramString + "round" + paramc.bmD();
    }
    paramString = str;
    if (!Util.isNullOrNil(paramc.bmE())) {
      paramString = str + paramc.bmE();
    }
    paramString = paramString + "size" + paramc.bmA() + paramc.bmB();
    AppMethodBeat.o(214923);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.f
 * JD-Core Version:    0.7.0.1
 */