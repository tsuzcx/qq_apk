package com.tencent.mm.plugin.scanner.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager;", "", "()V", "TAG", "", "ocrResultMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "getOCRResult", "sessionId", "saveOCRResult", "", "result", "ImageOCRResult", "plugin-scan_release"})
public final class a
{
  private static final ConcurrentHashMap<String, a> CHT;
  public static final a CHU;
  
  static
  {
    AppMethodBeat.i(240482);
    CHU = new a();
    CHT = new ConcurrentHashMap();
    AppMethodBeat.o(240482);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(240480);
    p.h(parama, "result");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(240480);
      return;
    }
    Log.d("MicroMsg.BizImageOCRManager", "alvinluo saveOCRResult sessionId: " + paramString + ", sourceUsername: " + parama.CAZ);
    ((Map)CHT).put(paramString, parama);
    AppMethodBeat.o(240480);
  }
  
  public static a aMF(String paramString)
  {
    AppMethodBeat.i(240481);
    paramString = (a)((Map)CHT).get(paramString);
    AppMethodBeat.o(240481);
    return paramString;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "", "()V", "result", "", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "sourceUsername", "getSourceUsername", "setSourceUsername", "plugin-scan_release"})
  public static final class a
  {
    public String CAZ = "";
    public String result = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a
 * JD-Core Version:    0.7.0.1
 */