package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.f.c.eg;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ao;

public final class a
  implements b
{
  public final String hcY()
  {
    return null;
  }
  
  public final String hcZ()
  {
    return null;
  }
  
  public final void m(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30255);
    paramActivity = ((d)h.ae(d.class)).bnA(paramString);
    paramString = new xw();
    paramString.fWN.userName = paramActivity.field_WeAppUser;
    paramString.fWN.fWP = paramActivity.field_WeAppPath;
    paramString.fWN.scene = 1051;
    paramString.fWN.fWQ = paramActivity.field_WeAppDebugMode;
    paramString.fWN.fvd = String.format("%s:%s:%s:%s", new Object[] { (String)h.aHG().aHp().b(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(30255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */