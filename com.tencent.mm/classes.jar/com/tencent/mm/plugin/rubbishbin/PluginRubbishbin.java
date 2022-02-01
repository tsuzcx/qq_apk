package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public class PluginRubbishbin
  extends f
  implements com.tencent.mm.kernel.api.c
{
  private static boolean vKQ = false;
  private com.tencent.mm.sdk.b.c<fh> vKR;
  
  public PluginRubbishbin()
  {
    AppMethodBeat.i(146670);
    this.vKR = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(146670);
  }
  
  public static void enableRubbishBin(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(146672);
    try
    {
      Intent localIntent = new Intent(paramContext, RubbishBinServiceImpl.class);
      localIntent.putExtra("exec_time", paramInt1);
      localIntent.putExtra("interval", paramInt2);
      localIntent.putExtra("exec_tag", paramString);
      paramContext.startService(localIntent);
      AppMethodBeat.o(146672);
      return;
    }
    catch (IllegalStateException paramContext)
    {
      AppMethodBeat.o(146672);
      return;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(146672);
    }
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(146671);
    if (((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppx, false))
    {
      int i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppy, 0);
      paramc = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppA, "Default");
      int j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.ppz, 1);
      ad.i("Rubbish", "[sunny]ec:%d,t:%s,itv:%d", new Object[] { Integer.valueOf(i), paramc, Integer.valueOf(j) });
      enableRubbishBin(aj.getContext(), i, j * 1000, paramc);
      AppMethodBeat.o(146671);
      return;
    }
    try
    {
      if ((!vKQ) && (!a.ESL.e(this.vKR)))
      {
        a.ESL.b(this.vKR);
        vKQ = true;
      }
      AppMethodBeat.o(146671);
      return;
    }
    catch (Exception paramc)
    {
      AppMethodBeat.o(146671);
    }
  }
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.PluginRubbishbin
 * JD-Core Version:    0.7.0.1
 */