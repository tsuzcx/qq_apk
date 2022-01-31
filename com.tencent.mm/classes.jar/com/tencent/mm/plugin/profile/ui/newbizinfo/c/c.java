package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static final void cg(String paramString, int paramInt)
  {
    Object localObject = b.bsq().Lb(paramString);
    if (localObject != null) {}
    for (localObject = ((d)localObject).field_decryptUserName;; localObject = "")
    {
      y.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d decryptUserName:%s", new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject });
      h.nFQ.f(13307, new Object[] { paramString, Integer.valueOf(3), Integer.valueOf(paramInt), Integer.valueOf(4), localObject });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.c.c
 * JD-Core Version:    0.7.0.1
 */