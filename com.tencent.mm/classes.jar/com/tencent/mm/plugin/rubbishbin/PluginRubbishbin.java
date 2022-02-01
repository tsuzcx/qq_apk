package com.tencent.mm.plugin.rubbishbin;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gh;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.sdk.event.IListener;

public class PluginRubbishbin
  extends com.tencent.mm.kernel.b.f
  implements c
{
  private static boolean OGt = false;
  private IListener<gh> qlY;
  
  public PluginRubbishbin()
  {
    AppMethodBeat.i(146670);
    this.qlY = new IListener(com.tencent.mm.app.f.hfK) {};
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
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(146671);
    AppMethodBeat.o(146671);
  }
  
  public void onAccountRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.rubbishbin.PluginRubbishbin
 * JD-Core Version:    0.7.0.1
 */