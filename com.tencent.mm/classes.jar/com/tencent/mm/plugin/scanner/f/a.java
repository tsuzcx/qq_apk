package com.tencent.mm.plugin.scanner.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager;", "", "()V", "TAG", "", "ocrResultMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "getOCRResult", "sessionId", "saveOCRResult", "", "result", "ImageOCRResult", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a OUi;
  private static final ConcurrentHashMap<String, a> OUj;
  
  static
  {
    AppMethodBeat.i(313473);
    OUi = new a();
    OUj = new ConcurrentHashMap();
    AppMethodBeat.o(313473);
  }
  
  public static void a(String paramString, a parama)
  {
    AppMethodBeat.i(313462);
    s.u(parama, "result");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(313462);
      return;
    }
    Log.d("MicroMsg.BizImageOCRManager", "alvinluo saveOCRResult sessionId: " + paramString + ", sourceUsername: " + parama.OMN);
    ((Map)OUj).put(paramString, parama);
    AppMethodBeat.o(313462);
  }
  
  public static a aUR(String paramString)
  {
    AppMethodBeat.i(313465);
    paramString = (a)((Map)OUj).get(paramString);
    AppMethodBeat.o(313465);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/BizImageOCRManager$ImageOCRResult;", "", "()V", "result", "", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", "sourceUsername", "getSourceUsername", "setSourceUsername", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public String OMN = "";
    public String result = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.a
 * JD-Core Version:    0.7.0.1
 */