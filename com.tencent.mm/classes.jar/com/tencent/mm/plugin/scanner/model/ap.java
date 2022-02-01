package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanTranslationDataHelper;", "", "()V", "TAG", "", "translateBitmapMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Landroid/graphics/Bitmap;", "clear", "", "doClear", "getTranslateBitmap", "path", "saveTranslateBitmap", "bitmap", "scan-translation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ap
{
  public static final ap OTI;
  private static ConcurrentHashMap<String, Bitmap> OTJ;
  
  static
  {
    AppMethodBeat.i(120966);
    OTI = new ap();
    OTJ = new ConcurrentHashMap();
    AppMethodBeat.o(120966);
  }
  
  public static final Bitmap aUP(String paramString)
  {
    AppMethodBeat.i(120964);
    s.u(paramString, "path");
    paramString = (Bitmap)OTJ.get(paramString);
    AppMethodBeat.o(120964);
    return paramString;
  }
  
  public static final void clear()
  {
    AppMethodBeat.i(120965);
    h.ahAA.bm(ap..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(120965);
  }
  
  private static final void gRx()
  {
    AppMethodBeat.i(314290);
    Object localObject = OTJ.keys();
    s.s(localObject, "key");
    localObject = p.a((Enumeration)localObject);
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      Bitmap localBitmap = (Bitmap)OTJ.get(str);
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        Log.d("MicroMsg.ScanTranslationDataHelper", "alvinluo recycle bitmap %s", new Object[] { str });
        localBitmap.recycle();
      }
    }
    OTJ.clear();
    AppMethodBeat.o(314290);
  }
  
  public static final void r(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(120963);
    s.u(paramString, "path");
    ((Map)OTJ).put(paramString, paramBitmap);
    AppMethodBeat.o(120963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ap
 * JD-Core Version:    0.7.0.1
 */