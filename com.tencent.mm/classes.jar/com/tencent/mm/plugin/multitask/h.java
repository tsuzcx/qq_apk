package com.tencent.mm.plugin.multitask;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/MultiTaskLogic;", "", "()V", "CoverImageLoadOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImageLoadOptions", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImgPath", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "getHomeUIImagePath", "plugin-multitask_release"})
public final class h
{
  private static final c zZm;
  public static final h zZn;
  
  static
  {
    AppMethodBeat.i(200304);
    zZn = new h();
    c localc = new c.a().bdo().bdr().bdv();
    p.g(localc, "ImageLoaderOptions.Build…ns.LoadFrom.FILE).build()");
    zZm = localc;
    AppMethodBeat.o(200304);
  }
  
  public static String aGJ(String paramString)
  {
    AppMethodBeat.i(200303);
    p.h(paramString, "id");
    StringBuilder localStringBuilder = new StringBuilder();
    i locali = i.zZq;
    paramString = i.eqC() + paramString;
    AppMethodBeat.o(200303);
    return paramString;
  }
  
  public static String eqA()
  {
    AppMethodBeat.i(200302);
    Object localObject = g.zZj;
    localObject = aGJ(g.eqy());
    AppMethodBeat.o(200302);
    return localObject;
  }
  
  public static c eqz()
  {
    return zZm;
  }
  
  public static String g(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(200301);
    if (paramMultiTaskInfo != null)
    {
      String str = paramMultiTaskInfo.field_id;
      paramMultiTaskInfo = str;
      if (str != null) {}
    }
    else
    {
      paramMultiTaskInfo = "";
    }
    paramMultiTaskInfo = aGJ(paramMultiTaskInfo);
    AppMethodBeat.o(200301);
    return paramMultiTaskInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.h
 * JD-Core Version:    0.7.0.1
 */