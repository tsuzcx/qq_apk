package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.z.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.pluginsdk.model.app.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class i
  implements t
{
  public static boolean rTk = false;
  private static i rTl;
  public i.a rTm;
  
  public static i.b VL(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = bn.s(paramString, "PersonalAppSetting");
    if (paramString == null) {
      return null;
    }
    paramString = (String)paramString.get(".PersonalAppSetting.OpenID");
    if (bk.bl(paramString)) {
      return null;
    }
    i.b localb = new i.b();
    localb.rTn = paramString;
    return localb;
  }
  
  public static i cku()
  {
    if (rTl == null) {
      rTl = new i();
    }
    return rTl;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, x paramx)
  {
    if (!au.DK()) {}
    do
    {
      do
      {
        return;
        y.d("MicroMsg.GetUserInfoInAppLogic", "onSceneEnd errType=%s errCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        if (paramx == null)
        {
          y.e("MicroMsg.GetUserInfoInAppLogic", "scene == null");
          return;
        }
      } while ((paramInt1 != 0) || (paramInt2 != 0));
      switch (paramx.getType())
      {
      default: 
        return;
      }
      if ((ae.getContext() == null) || (a.a.bru() == null))
      {
        y.e("MicroMsg.GetUserInfoInAppLogic", "wrong environment");
        return;
      }
      y.e("MicroMsg.GetUserInfoInAppLogic", "NetSceneGetUserInfoInApp come back", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString = (l)paramx;
    } while (this.rTm == null);
    this.rTm.a(paramString);
  }
  
  public final void ckv()
  {
    if (!au.DK()) {
      return;
    }
    ap.brq().a(14, this);
    rTk = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.i
 * JD-Core Version:    0.7.0.1
 */