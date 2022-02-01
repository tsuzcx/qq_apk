package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"})
public final class ab
{
  private static ConcurrentHashMap<String, Bitmap> xau;
  public static final ab xav;
  
  static
  {
    AppMethodBeat.i(120966);
    xav = new ab();
    xau = new ConcurrentHashMap();
    AppMethodBeat.o(120966);
  }
  
  public static final Bitmap arJ(String paramString)
  {
    AppMethodBeat.i(120964);
    k.h(paramString, "path");
    paramString = (Bitmap)xau.get(paramString);
    AppMethodBeat.o(120964);
    return paramString;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(120965);
    h.JZN.aS((Runnable)a.xaw);
    AppMethodBeat.o(120965);
  }
  
  public static final void r(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120963);
    k.h(paramString, "path");
    ((Map)xau).put(paramString, paramBitmap);
    AppMethodBeat.o(120963);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a xaw;
    
    static
    {
      AppMethodBeat.i(120962);
      xaw = new a();
      AppMethodBeat.o(120962);
    }
    
    public final void run()
    {
      AppMethodBeat.i(120961);
      ab localab = ab.xav;
      ab.dzP();
      AppMethodBeat.o(120961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ab
 * JD-Core Version:    0.7.0.1
 */