package com.tencent.mm.plugin.welab.d;

import android.app.Activity;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.h.c.co;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.welab.a.a.b;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.storage.z;

public final class a
  implements b
{
  public final String chj()
  {
    return null;
  }
  
  public final String chk()
  {
    return null;
  }
  
  public final void f(Activity paramActivity, String paramString)
  {
    paramActivity = ((d)g.r(d.class)).Ug(paramString);
    paramString = new rc();
    paramString.caq.userName = paramActivity.field_WeAppUser;
    paramString.caq.cas = paramActivity.field_WeAppPath;
    paramString.caq.scene = 1051;
    paramString.caq.cat = paramActivity.field_WeAppDebugMode;
    paramString.caq.bFv = String.format("%s:%s:%s:%s", new Object[] { (String)g.DP().Dz().get(2, null), paramActivity.field_expId, paramActivity.field_LabsAppId, Long.valueOf(System.currentTimeMillis() / 1000L) });
    com.tencent.mm.sdk.b.a.udP.m(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.welab.d.a
 * JD-Core Version:    0.7.0.1
 */