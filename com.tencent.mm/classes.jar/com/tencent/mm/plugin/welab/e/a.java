package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.g.c.dm;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.storage.ae;

public final class a
  implements b
{
  public final String eHB()
  {
    return null;
  }
  
  public final String eHC()
  {
    return null;
  }
  
  public final void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30255);
    paramActivity = ((d)g.ab(d.class)).aEo(paramString);
    paramString = new ut();
    paramString.dxt.userName = paramActivity.field_WeAppUser;
    paramString.dxt.dxv = paramActivity.field_WeAppPath;
    paramString.dxt.scene = 1051;
    paramString.dxt.dxw = paramActivity.field_WeAppDebugMode;
    paramString.dxt.cYP = String.format("%s:%s:%s:%s", new Object[] { (String)g.agR().agA().get(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    com.tencent.mm.sdk.b.a.GpY.l(paramString);
    AppMethodBeat.o(30255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */