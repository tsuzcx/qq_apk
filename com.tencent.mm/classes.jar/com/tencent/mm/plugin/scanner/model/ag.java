package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"})
public final class ag
{
  private static ConcurrentHashMap<String, Bitmap> IME;
  public static final ag IMF;
  
  static
  {
    AppMethodBeat.i(120966);
    IMF = new ag();
    IME = new ConcurrentHashMap();
    AppMethodBeat.o(120966);
  }
  
  public static final Bitmap aXk(String paramString)
  {
    AppMethodBeat.i(120964);
    p.k(paramString, "path");
    paramString = (Bitmap)IME.get(paramString);
    AppMethodBeat.o(120964);
    return paramString;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(120965);
    h.ZvG.be((Runnable)a.IMG);
    AppMethodBeat.o(120965);
  }
  
  public static final void r(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120963);
    p.k(paramString, "path");
    ((Map)IME).put(paramString, paramBitmap);
    AppMethodBeat.o(120963);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a IMG;
    
    static
    {
      AppMethodBeat.i(120962);
      IMG = new a();
      AppMethodBeat.o(120962);
    }
    
    public final void run()
    {
      AppMethodBeat.i(120961);
      ag localag = ag.IMF;
      ag.fDl();
      AppMethodBeat.o(120961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ag
 * JD-Core Version:    0.7.0.1
 */