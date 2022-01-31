package com.tencent.mm.plugin.voip_cs.a;

import com.tencent.mm.h.a.tb;
import com.tencent.mm.h.a.tb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip_cs.b.e;
import com.tencent.mm.protocal.c.cen;
import com.tencent.mm.protocal.c.ceu;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class a
  extends com.tencent.mm.sdk.b.c<tb>
{
  public a()
  {
    this.udX = tb.class.getName().hashCode();
  }
  
  private static boolean a(tb paramtb)
  {
    if ((!(paramtb instanceof tb)) || (!g.DK())) {}
    e locale;
    do
    {
      return false;
      locale = com.tencent.mm.plugin.voip_cs.b.c.bSP();
      localObject = paramtb.ccC.ccD;
    } while ((localObject == null) || (localObject.length == 0));
    paramtb = new byte[localObject.length - 1];
    System.arraycopy(localObject, 1, paramtb, 0, paramtb.length);
    Object localObject = new cen();
    try
    {
      ((cen)localObject).aH(paramtb);
      y.i("MicroMsg.voipcs.VoipCSService", "notify status = " + ((cen)localObject).tTA + ",notifySeq = " + locale.qdV);
      paramtb = new ceu();
      paramtb.tTo = ((cen)localObject).tTo;
      paramtb.sSU = ((cen)localObject).sSU;
      paramtb.tTy = ((cen)localObject).tTy;
      paramtb.tTA = ((cen)localObject).tTA;
      paramtb.tTB = ((cen)localObject).tTB;
      paramtb.tTC = ((cen)localObject).tTC;
      paramtb.tTz = ((cen)localObject).tTz;
      locale.a(paramtb);
      return false;
    }
    catch (IOException paramtb)
    {
      y.e("MicroMsg.voipcs.VoipCSService", "csNotify.parseFrom content error!", new Object[] { paramtb });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.a.a
 * JD-Core Version:    0.7.0.1
 */