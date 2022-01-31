package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.plugin.sport.c.d;
import com.tencent.mm.plugin.sport.c.f;
import com.tencent.mm.plugin.sport.c.h;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.plugin.sport.c.m;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.o;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class c
  implements b
{
  public final List<e> I(long paramLong1, long paramLong2)
  {
    l locall = ((PluginSport)g.t(PluginSport.class)).getSportStepManager();
    y.i("MicroMsg.Sport.SportStepManager", "getSportItemListByPeriod: begin=%s end=%s", new Object[] { locall.ptF.format(new Date(paramLong1)), locall.ptF.format(new Date(paramLong2)) });
    ((PluginSport)g.t(PluginSport.class)).getSportStepStorage();
    return m.J(paramLong1, paramLong2);
  }
  
  public final void O(int paramInt, long paramLong)
  {
    i.S(paramInt, paramLong);
  }
  
  public final void a(long paramLong1, long paramLong2, com.tencent.mm.plugin.sport.b.c paramc)
  {
    l locall = ((PluginSport)g.t(PluginSport.class)).getSportStepManager();
    y.i("MicroMsg.Sport.SportStepManager", "updateSportStepFromServer: begin=%s end=%s", new Object[] { locall.ptF.format(new Date(paramLong1)), locall.ptF.format(new Date(paramLong2)) });
    paramc = new d(paramLong1, paramLong2, paramc);
    g.Dk().a(1734, locall.eeo);
    g.Dk().a(paramc, 0);
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    paramString1 = new f(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, 1);
    g.Dk().a(paramString1, 0);
  }
  
  public final void bKX()
  {
    com.tencent.mm.plugin.sport.c.a locala = ((PluginSport)g.t(PluginSport.class)).getDeviceStepManager();
    y.i("MicroMsg.Sport.DeviceStepManager", "uploadDeviceStep");
    locala.bLi();
    locala.gE(locala.bLh());
  }
  
  public final boolean bKY()
  {
    return n.bKY();
  }
  
  public final void bKZ()
  {
    com.tencent.mm.plugin.sport.a.a locala;
    if (ae.cqV())
    {
      ((PluginSport)g.t(PluginSport.class)).getSportFileStorage().reset();
      locala = ((PluginSport)g.t(PluginSport.class)).getDeviceStepManager().ptg;
      if (locala == null) {}
    }
    try
    {
      locala.bLf();
      label45:
      new File(com.tencent.mm.plugin.sport.b.a.pta).delete();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      break label45;
    }
  }
  
  public final void bLa()
  {
    if (n.ptK != null)
    {
      n.ptK.dismiss();
      n.ptK = null;
    }
  }
  
  public final e bLb()
  {
    ((PluginSport)g.t(PluginSport.class)).getSportStepManager();
    ((PluginSport)g.t(PluginSport.class)).getSportStepStorage();
    return m.bLb();
  }
  
  public final void bLc()
  {
    ((PluginSport)g.t(PluginSport.class)).getSportStepManager();
    y.i("MicroMsg.Sport.SportStepManager", "clearAllSportStep");
    ((PluginSport)g.t(PluginSport.class)).getSportStepStorage();
    m.bLc();
  }
  
  public final void d(Activity paramActivity, String paramString)
  {
    ai.d(new c.1(this, paramActivity, paramString));
  }
  
  public final boolean ej(Context paramContext)
  {
    return n.ej(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c
 * JD-Core Version:    0.7.0.1
 */