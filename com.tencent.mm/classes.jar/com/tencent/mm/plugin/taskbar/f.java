package com.tencent.mm.plugin.taskbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/taskbar/TaskBarLogic;", "", "()V", "generateTaskBarImageCacheKey", "", "path", "imageLoaderOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImgPath", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "plugin-taskbar_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f SQy;
  
  static
  {
    AppMethodBeat.i(263979);
    SQy = new f();
    AppMethodBeat.o(263979);
  }
  
  public static String aNP(String paramString)
  {
    AppMethodBeat.i(263973);
    s.u(paramString, "id");
    g localg = g.SQz;
    paramString = s.X(g.hCV(), paramString);
    AppMethodBeat.o(263973);
    return paramString;
  }
  
  public static String f(String paramString, c paramc)
  {
    AppMethodBeat.i(263965);
    s.u(paramString, "path");
    s.u(paramc, "imageLoaderOptions");
    String str = paramString;
    if (paramc.nrc) {
      str = paramString + "round" + paramc.oKI;
    }
    paramString = str;
    if (!Util.isNullOrNil(paramc.oKG)) {
      paramString = s.X(str, paramc.oKG);
    }
    paramString = paramString + "size" + paramc.npU + paramc.npV;
    AppMethodBeat.o(263965);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.f
 * JD-Core Version:    0.7.0.1
 */