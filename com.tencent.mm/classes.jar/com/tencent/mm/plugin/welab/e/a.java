package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.storage.ai;

public final class a
  implements b
{
  public final String eWu()
  {
    return null;
  }
  
  public final String eWv()
  {
    return null;
  }
  
  public final void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30255);
    paramActivity = ((d)g.ab(d.class)).aJO(paramString);
    paramString = new vm();
    paramString.dJF.userName = paramActivity.field_WeAppUser;
    paramString.dJF.dJH = paramActivity.field_WeAppPath;
    paramString.dJF.scene = 1051;
    paramString.dJF.dJI = paramActivity.field_WeAppDebugMode;
    paramString.dJF.dkh = String.format("%s:%s:%s:%s", new Object[] { (String)g.ajC().ajl().get(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    com.tencent.mm.sdk.b.a.IbL.l(paramString);
    AppMethodBeat.o(30255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */