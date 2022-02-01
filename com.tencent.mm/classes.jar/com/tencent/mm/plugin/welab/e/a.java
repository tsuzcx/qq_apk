package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.dw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.storage.aj;

public final class a
  implements b
{
  public final String fag()
  {
    return null;
  }
  
  public final String fah()
  {
    return null;
  }
  
  public final void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30255);
    paramActivity = ((d)g.ab(d.class)).aLk(paramString);
    paramString = new vq();
    paramString.dKT.userName = paramActivity.field_WeAppUser;
    paramString.dKT.dKV = paramActivity.field_WeAppPath;
    paramString.dKT.scene = 1051;
    paramString.dKT.dKW = paramActivity.field_WeAppDebugMode;
    paramString.dKT.dlj = String.format("%s:%s:%s:%s", new Object[] { (String)g.ajR().ajA().get(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    com.tencent.mm.sdk.b.a.IvT.l(paramString);
    AppMethodBeat.o(30255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */