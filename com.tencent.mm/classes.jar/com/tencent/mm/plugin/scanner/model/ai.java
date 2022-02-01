package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"})
public final class ai
{
  private static ConcurrentHashMap<String, Bitmap> CHs;
  public static final ai CHt;
  
  static
  {
    AppMethodBeat.i(120966);
    CHt = new ai();
    CHs = new ConcurrentHashMap();
    AppMethodBeat.o(120966);
  }
  
  public static final Bitmap aMD(String paramString)
  {
    AppMethodBeat.i(120964);
    p.h(paramString, "path");
    paramString = (Bitmap)CHs.get(paramString);
    AppMethodBeat.o(120964);
    return paramString;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(120965);
    h.RTc.aX((Runnable)a.CHu);
    AppMethodBeat.o(120965);
  }
  
  public static final void r(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120963);
    p.h(paramString, "path");
    ((Map)CHs).put(paramString, paramBitmap);
    AppMethodBeat.o(120963);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a CHu;
    
    static
    {
      AppMethodBeat.i(120962);
      CHu = new a();
      AppMethodBeat.o(120962);
    }
    
    public final void run()
    {
      AppMethodBeat.i(120961);
      ai localai = ai.CHt;
      ai.eQp();
      AppMethodBeat.o(120961);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ai
 * JD-Core Version:    0.7.0.1
 */