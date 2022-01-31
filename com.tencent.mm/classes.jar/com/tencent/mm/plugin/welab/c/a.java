package com.tencent.mm.plugin.welab.c;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class a
  implements b
{
  public final String dhr()
  {
    AppMethodBeat.i(26577);
    String str = ac.agv("discoverRecommendEntry").optString("labIcon");
    AppMethodBeat.o(26577);
    return str;
  }
  
  public final String dhs()
  {
    AppMethodBeat.i(26578);
    String str = ac.agv("discoverRecommendEntry").optString("wording");
    if (bo.isNullOrNil(str))
    {
      str = ah.getContext().getString(2131299915);
      AppMethodBeat.o(26578);
      return str;
    }
    AppMethodBeat.o(26578);
    return str;
  }
  
  public final void h(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(26576);
    if (!aa.Je(0))
    {
      ab.e("MicroMsg.FTS.LookOneLookOpener", "fts h5 template not avail");
      AppMethodBeat.o(26576);
      return;
    }
    paramString = ac.agv("discoverRecommendEntry").optString("wording");
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.FTS.LookOneLookOpener", "empty query");
      AppMethodBeat.o(26576);
      return;
    }
    ((m)g.E(m.class)).a(ah.getContext(), new a.1(this, paramString, paramActivity));
    AppMethodBeat.o(26576);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.c.a
 * JD-Core Version:    0.7.0.1
 */