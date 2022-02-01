package com.tencent.mm.plugin.multitask;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/MultiTaskLogic;", "", "()V", "CoverImageLoadOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImageLoadOptions", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImgPath", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "getHomeUIImagePath", "plugin-multitask_release"})
public final class h
{
  private static final c FFa;
  public static final h FFb;
  
  static
  {
    AppMethodBeat.i(248593);
    FFb = new h();
    c localc = new c.a().gs(true).bmH().a(Bitmap.Config.RGB_565).bmL();
    p.j(localc, "ImageLoaderOptions.Build…p.Config.RGB_565).build()");
    FFa = localc;
    AppMethodBeat.o(248593);
  }
  
  public static String aQX(String paramString)
  {
    AppMethodBeat.i(248591);
    p.k(paramString, "id");
    StringBuilder localStringBuilder = new StringBuilder();
    i locali = i.FFe;
    paramString = i.fas() + paramString;
    AppMethodBeat.o(248591);
    return paramString;
  }
  
  public static c fap()
  {
    return FFa;
  }
  
  public static String faq()
  {
    AppMethodBeat.i(248589);
    Object localObject = g.FEX;
    localObject = aQX(g.fao());
    AppMethodBeat.o(248589);
    return localObject;
  }
  
  public static String g(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(248587);
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
    paramMultiTaskInfo = aQX(paramMultiTaskInfo);
    AppMethodBeat.o(248587);
    return paramMultiTaskInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.h
 * JD-Core Version:    0.7.0.1
 */