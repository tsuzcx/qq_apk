package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.plugin.appbrand.u.b;
import com.tencent.mm.plugin.appbrand.u.q.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;

final class s$1
  implements q.a
{
  private String version;
  
  s$1(Context paramContext)
  {
    paramContext = b.getPackageInfo(this.fkT, ae.getPackageName());
    if (paramContext != null)
    {
      this.version = e.ag(null, com.tencent.mm.protocal.d.spa);
      this.version = (this.version + "." + paramContext.versionCode);
      this.version = (this.version + "(" + com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION + ")");
    }
  }
  
  public final String pJ()
  {
    return " MicroMessenger/";
  }
  
  public final String pK()
  {
    return this.version;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.s.1
 * JD-Core Version:    0.7.0.1
 */