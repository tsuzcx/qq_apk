package com.tencent.mm.util;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.util.g;
import com.tencent.mm.media.util.g.a;
import com.tencent.mm.videocomposition.j.b;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/util/VideoColorSpaceHelper;", "", "()V", "DECODE_TIMEOUT", "", "TAG", "", "TIMEOUT", "buildColorSpaceReportJson", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "loadColorSpaceToOutputConfig", "", "src", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j agtw;
  
  static
  {
    AppMethodBeat.i(233971);
    agtw = new j();
    AppMethodBeat.o(233971);
  }
  
  public static String a(j.b paramb)
  {
    AppMethodBeat.i(233969);
    s.u(paramb, "config");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("colorRange", paramb.colorRange);
    localJSONObject.put("colorStandard", paramb.colorStandard);
    localJSONObject.put("colorTransfer", paramb.colorTransfer);
    paramb = localJSONObject.toString();
    s.s(paramb, "jsonObj.toString()");
    paramb = n.bV(paramb, ",", ";");
    AppMethodBeat.o(233969);
    return paramb;
  }
  
  public static void a(String paramString, j.b paramb)
  {
    AppMethodBeat.i(233966);
    s.u(paramString, "src");
    s.u(paramb, "config");
    if (Build.VERSION.SDK_INT >= 24)
    {
      g localg = g.nFH;
      paramString = g.GU(paramString);
      if (paramString != null)
      {
        paramb.colorRange = paramString.colorRange;
        paramb.colorStandard = paramString.colorStandard;
        paramb.colorTransfer = paramString.colorTransfer;
      }
    }
    AppMethodBeat.o(233966);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.util.j
 * JD-Core Version:    0.7.0.1
 */