package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ao;

public final class a
  implements b
{
  public final String gjl()
  {
    return null;
  }
  
  public final String gjm()
  {
    return null;
  }
  
  public final void m(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30255);
    paramActivity = ((d)g.af(d.class)).bbA(paramString);
    paramString = new wq();
    paramString.ecI.userName = paramActivity.field_WeAppUser;
    paramString.ecI.ecK = paramActivity.field_WeAppPath;
    paramString.ecI.scene = 1051;
    paramString.ecI.ecL = paramActivity.field_WeAppDebugMode;
    paramString.ecI.dCw = String.format("%s:%s:%s:%s", new Object[] { (String)g.aAh().azQ().get(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    EventCenter.instance.publish(paramString);
    AppMethodBeat.o(30255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */