package com.tencent.mm.plugin.profile;

import android.content.Intent;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

public final class b
  implements ar
{
  private static HashMap<Integer, h.d> dgp = new HashMap();
  private volatile com.tencent.mm.plugin.profile.ui.newbizinfo.d.a mVj;
  
  static
  {
    com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[] { "//usenewprofile" });
    dgp.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new b.1());
  }
  
  public static int S(Intent paramIntent)
  {
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("CONTACT_INFO_UI_SOURCE", 0);
      y.d("MicroMsg.SubCoreProfile", "[getPrefixAddScene] source:" + i);
    }
    return i;
  }
  
  public static com.tencent.mm.plugin.profile.ui.newbizinfo.d.a bsq()
  {
    g.DN().CX();
    if (bsr().mVj == null)
    {
      b localb = bsr();
      au.Hx();
      localb.mVj = new com.tencent.mm.plugin.profile.ui.newbizinfo.d.a(c.Dv());
    }
    return bsr().mVj;
  }
  
  private static b bsr()
  {
    au.Hq();
    b localb2 = (b)bu.iR("plugin.profile");
    b localb1 = localb2;
    if (localb2 == null)
    {
      y.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
      localb1 = new b();
      au.Hq().a("plugin.freewifi", localb1);
    }
    return localb1;
  }
  
  public final void bh(boolean paramBoolean) {}
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b
 * JD-Core Version:    0.7.0.1
 */