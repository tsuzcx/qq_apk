package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"})
public final class af
{
  private static ConcurrentHashMap<String, Bitmap> yEs;
  public static final af yEt;
  
  static
  {
    AppMethodBeat.i(120966);
    yEt = new af();
    yEs = new ConcurrentHashMap();
    AppMethodBeat.o(120966);
  }
  
  public static final Bitmap axZ(String paramString)
  {
    AppMethodBeat.i(120964);
    p.h(paramString, "path");
    paramString = (Bitmap)yEs.get(paramString);
    AppMethodBeat.o(120964);
    return paramString;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(120965);
    h.MqF.aO((Runnable)a.yEu);
    AppMethodBeat.o(120965);
  }
  
  public static final void r(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120963);
    p.h(paramString, "path");
    ((Map)yEs).put(paramString, paramBitmap);
    AppMethodBeat.o(120963);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a yEu;
    
    static
    {
      AppMethodBeat.i(120962);
      yEu = new a();
      AppMethodBeat.o(120962);
    }
    
    public final void run()
    {
      AppMethodBeat.i(120961);
      af localaf = af.yEt;
      af.dOI();
      AppMethodBeat.o(120961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.af
 * JD-Core Version:    0.7.0.1
 */