package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"})
public final class z
{
  private static ConcurrentHashMap<String, Bitmap> vPN;
  public static final z vPO;
  
  static
  {
    AppMethodBeat.i(120966);
    vPO = new z();
    vPN = new ConcurrentHashMap();
    AppMethodBeat.o(120966);
  }
  
  public static final Bitmap amA(String paramString)
  {
    AppMethodBeat.i(120964);
    k.h(paramString, "path");
    paramString = (Bitmap)vPN.get(paramString);
    AppMethodBeat.o(120964);
    return paramString;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(120965);
    h.Iye.aP((Runnable)a.vPP);
    AppMethodBeat.o(120965);
  }
  
  public static final void s(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120963);
    k.h(paramString, "path");
    ((Map)vPN).put(paramString, paramBitmap);
    AppMethodBeat.o(120963);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a vPP;
    
    static
    {
      AppMethodBeat.i(120962);
      vPP = new a();
      AppMethodBeat.o(120962);
    }
    
    public final void run()
    {
      AppMethodBeat.i(120961);
      z localz = z.vPO;
      z.dlJ();
      AppMethodBeat.o(120961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z
 * JD-Core Version:    0.7.0.1
 */