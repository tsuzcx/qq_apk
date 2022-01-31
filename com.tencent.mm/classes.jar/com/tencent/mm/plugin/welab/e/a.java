package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.g.c.cv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.storage.z;

public final class a
  implements b
{
  public final String dhr()
  {
    return null;
  }
  
  public final String dhs()
  {
    return null;
  }
  
  public final void h(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(26582);
    paramActivity = ((d)g.E(d.class)).ajt(paramString);
    paramString = new so();
    paramString.cIQ.userName = paramActivity.field_WeAppUser;
    paramString.cIQ.cIS = paramActivity.field_WeAppPath;
    paramString.cIQ.scene = 1051;
    paramString.cIQ.cIT = paramActivity.field_WeAppDebugMode;
    paramString.cIQ.cmF = String.format("%s:%s:%s:%s", new Object[] { (String)g.RL().Ru().get(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    com.tencent.mm.sdk.b.a.ymk.l(paramString);
    AppMethodBeat.o(26582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */