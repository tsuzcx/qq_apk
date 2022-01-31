package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.ah.b.c;
import com.tencent.mm.protocal.c.alz;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.ccj;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class a$1
  implements am.a
{
  a$1(a parama) {}
  
  public final boolean tC()
  {
    if (this.pvs.pvr < 0) {
      return false;
    }
    alz localalz = (alz)this.pvs.dmK.ecF.ecN;
    try
    {
      Object localObject1 = (ccj)localalz.tig.get(this.pvs.pvr);
      if ((localObject1 != null) && (((ccj)localObject1).tRF != null) && (((ccj)localObject1).tRF.tFM != null) && (((ccj)localObject1).tRE != null) && (((ccj)localObject1).tRE.tFM != null))
      {
        y.d("MicroMsg.NetSceneGetVUserInfo", "onGYNetEnd ver:" + localalz.hQQ + " idx:" + this.pvs.pvr + " id:" + Integer.toHexString(((ccj)localObject1).bxH) + " size:" + ((ccj)localObject1).tRE.tFK + " hdsize:" + ((ccj)localObject1).tRF.tFK);
        a.a(((ccj)localObject1).bxH, true, ((ccj)localObject1).tRF.tFM.toByteArray());
        a.a(((ccj)localObject1).bxH, false, ((ccj)localObject1).tRE.tFM.toByteArray());
      }
      localObject1 = this.pvs;
      ((a)localObject1).pvr -= 1;
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneGetVUserInfo", "get item :" + this.pvs.pvr + " not Found");
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a.a.1
 * JD-Core Version:    0.7.0.1
 */