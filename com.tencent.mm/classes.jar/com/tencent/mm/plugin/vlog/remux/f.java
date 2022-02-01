package com.tencent.mm.plugin.vlog.remux;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.g;
import com.tencent.mm.media.k.g.a;
import com.tencent.mm.videocomposition.j.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VideoColorSpaceHelper;", "", "()V", "DECODE_TIMEOUT", "", "TAG", "", "TIMEOUT", "buildColorSpaceReportJson", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "loadColorSpaceToOutputConfig", "", "src", "plugin-vlog_release"})
public final class f
{
  public static final f NqU;
  
  static
  {
    AppMethodBeat.i(225573);
    NqU = new f();
    AppMethodBeat.o(225573);
  }
  
  public static String a(j.b paramb)
  {
    AppMethodBeat.i(225572);
    p.k(paramb, "config");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("colorRange", paramb.colorRange);
    localJSONObject.put("colorStandard", paramb.colorStandard);
    localJSONObject.put("colorTransfer", paramb.colorTransfer);
    paramb = localJSONObject.toString();
    p.j(paramb, "jsonObj.toString()");
    paramb = n.l(paramb, ",", ";", false);
    AppMethodBeat.o(225572);
    return paramb;
  }
  
  public static void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(225568);
    p.k(paramString, "src");
    p.k(paramb, "config");
    if (Build.VERSION.SDK_INT >= 24)
    {
      g localg = g.laC;
      paramString = g.OE(paramString);
      if (paramString != null)
      {
        paramb.colorRange = paramString.colorRange;
        paramb.colorStandard = paramString.colorStandard;
        paramb.colorTransfer = paramString.colorTransfer;
      }
    }
    AppMethodBeat.o(225568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.f
 * JD-Core Version:    0.7.0.1
 */