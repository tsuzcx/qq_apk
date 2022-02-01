package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager;", "", "()V", "TAG", "", "ocrResultMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "getOCRResult", "sessionId", "saveOCRResult", "", "result", "ImageOCRResult", "plugin-scan_release"})
public final class a
{
  private static final ConcurrentHashMap<String, a> INf;
  public static final a INg;
  
  static
  {
    AppMethodBeat.i(222370);
    INg = new a();
    INf = new ConcurrentHashMap();
    AppMethodBeat.o(222370);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(222362);
    p.k(parama, "result");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(222362);
      return;
    }
    Log.d("MicroMsg.BizImageOCRManager", "alvinluo saveOCRResult sessionId: " + paramString + ", sourceUsername: " + parama.IGF);
    ((Map)INf).put(paramString, parama);
    AppMethodBeat.o(222362);
  }
  
  public static a aXm(String paramString)
  {
    AppMethodBeat.i(222364);
    paramString = (a)((Map)INf).get(paramString);
    AppMethodBeat.o(222364);
    return paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "", "()V", "result", "", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "sourceUsername", "getSourceUsername", "setSourceUsername", "plugin-scan_release"})
  public static final class a
  {
    public String IGF = "";
    public String result = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a
 * JD-Core Version:    0.7.0.1
 */