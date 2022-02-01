package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"})
public final class ae
{
  private static ConcurrentHashMap<String, Bitmap> yot;
  public static final ae you;
  
  static
  {
    AppMethodBeat.i(120966);
    you = new ae();
    yot = new ConcurrentHashMap();
    AppMethodBeat.o(120966);
  }
  
  public static final Bitmap awK(String paramString)
  {
    AppMethodBeat.i(120964);
    p.h(paramString, "path");
    paramString = (Bitmap)yot.get(paramString);
    AppMethodBeat.o(120964);
    return paramString;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(120965);
    h.LTJ.aR((Runnable)a.yov);
    AppMethodBeat.o(120965);
  }
  
  public static final void r(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120963);
    p.h(paramString, "path");
    ((Map)yot).put(paramString, paramBitmap);
    AppMethodBeat.o(120963);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a yov;
    
    static
    {
      AppMethodBeat.i(120962);
      yov = new a();
      AppMethodBeat.o(120962);
    }
    
    public final void run()
    {
      AppMethodBeat.i(120961);
      ae localae = ae.you;
      ae.dLp();
      AppMethodBeat.o(120961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ae
 * JD-Core Version:    0.7.0.1
 */