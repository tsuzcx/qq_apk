package com.tencent.mm.plugin.multitask;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/MultiTaskLogic;", "", "()V", "CoverImageLoadOptions", "Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImageLoadOptions", "()Lcom/tencent/mm/modelimage/loader/cfg/ImageLoaderOptions;", "getCoverImgPath", "", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "id", "getHomeUIImagePath", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h LBd;
  private static final c LBe;
  
  static
  {
    AppMethodBeat.i(303834);
    LBd = new h();
    Object localObject = new c.a();
    ((c.a)localObject).oKn = true;
    ((c.a)localObject).oKs = 1;
    ((c.a)localObject).bitmapConfig = Bitmap.Config.RGB_565;
    localObject = ((c.a)localObject).bKx();
    s.s(localObject, "Builder().setCacheInMemo…p.Config.RGB_565).build()");
    LBe = (c)localObject;
    AppMethodBeat.o(303834);
  }
  
  public static String aNP(String paramString)
  {
    AppMethodBeat.i(303826);
    s.u(paramString, "id");
    i locali = i.LBf;
    paramString = s.X(i.gjx(), paramString);
    AppMethodBeat.o(303826);
    return paramString;
  }
  
  public static String g(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(303815);
    if (paramMultiTaskInfo == null) {
      paramMultiTaskInfo = "";
    }
    for (;;)
    {
      paramMultiTaskInfo = aNP(paramMultiTaskInfo);
      AppMethodBeat.o(303815);
      return paramMultiTaskInfo;
      String str = paramMultiTaskInfo.field_id;
      paramMultiTaskInfo = str;
      if (str == null) {
        paramMultiTaskInfo = "";
      }
    }
  }
  
  public static c gju()
  {
    return LBe;
  }
  
  public static String gjv()
  {
    AppMethodBeat.i(303822);
    Object localObject = g.LBa;
    localObject = aNP(g.gjt());
    AppMethodBeat.o(303822);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.h
 * JD-Core Version:    0.7.0.1
 */