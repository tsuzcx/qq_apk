package com.tencent.mm.plugin.welab.e;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.b.eu;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.storage.aq;

public final class a
  implements b
{
  public final String iDG()
  {
    return null;
  }
  
  public final String iDH()
  {
    return null;
  }
  
  public final void p(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(30255);
    paramActivity = ((d)h.ax(d.class)).bno(paramString);
    paramString = new zp();
    paramString.icM.userName = paramActivity.field_WeAppUser;
    paramString.icM.icO = paramActivity.field_WeAppPath;
    paramString.icM.scene = 1051;
    paramString.icM.icP = paramActivity.field_WeAppDebugMode;
    paramString.icM.hzx = String.format("%s:%s:%s:%s", new Object[] { (String)h.baE().ban().d(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    paramString.publish();
    AppMethodBeat.o(30255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.e.a
 * JD-Core Version:    0.7.0.1
 */