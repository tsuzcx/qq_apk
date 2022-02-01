package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.dk;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.storage.ab;

public final class a
  implements b
{
  public final String esh()
  {
    return null;
  }
  
  public final String esi()
  {
    return null;
  }
  
  public final void i(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30255);
    paramActivity = ((d)g.ab(d.class)).ayX(paramString);
    paramString = new uj();
    paramString.dzH.userName = paramActivity.field_WeAppUser;
    paramString.dzH.dzJ = paramActivity.field_WeAppPath;
    paramString.dzH.scene = 1051;
    paramString.dzH.dzK = paramActivity.field_WeAppDebugMode;
    paramString.dzH.dbt = String.format("%s:%s:%s:%s", new Object[] { (String)g.afB().afk().get(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    com.tencent.mm.sdk.b.a.ESL.l(paramString);
    AppMethodBeat.o(30255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */