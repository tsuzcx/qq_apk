package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.plugin.sport.model.a;
import com.tencent.mm.plugin.sport.model.a.3;
import com.tencent.mm.plugin.sport.model.f;
import com.tencent.mm.plugin.sport.model.j;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.model.m;
import com.tencent.mm.plugin.sport.model.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class b
  implements com.tencent.mm.plugin.sport.a.b
{
  public final List<com.tencent.mm.plugin.sport.a.e> X(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93623);
    Object localObject = ((PluginSport)g.G(PluginSport.class)).getSportStepManager();
    ab.i("MicroMsg.Sport.SportStepManager", "getSportItemListByPeriod: begin=%s end=%s", new Object[] { ((l)localObject).spW.format(new Date(paramLong1)), ((l)localObject).spW.format(new Date(paramLong2)) });
    ((PluginSport)g.G(PluginSport.class)).getSportStepStorage();
    localObject = m.Y(paramLong1, paramLong2);
    AppMethodBeat.o(93623);
    return localObject;
  }
  
  public final void a(long paramLong1, long paramLong2, c paramc)
  {
    AppMethodBeat.i(93625);
    l locall = ((PluginSport)g.G(PluginSport.class)).getSportStepManager();
    ab.i("MicroMsg.Sport.SportStepManager", "updateSportStepFromServer: begin=%s end=%s", new Object[] { locall.spW.format(new Date(paramLong1)), locall.spW.format(new Date(paramLong2)) });
    paramc = new com.tencent.mm.plugin.sport.model.d(paramLong1, paramLong2, paramc);
    g.Rc().a(1734, locall.fur);
    g.Rc().a(paramc, 0);
    AppMethodBeat.o(93625);
  }
  
  public final void b(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    AppMethodBeat.i(93617);
    if (g.RG())
    {
      paramString1 = new f(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, 1);
      g.Rc().a(paramString1, 0);
    }
    AppMethodBeat.o(93617);
  }
  
  public final void cyt()
  {
    AppMethodBeat.i(93616);
    if (((PluginSport)g.G(PluginSport.class)).getDeviceStepManager() != null) {
      ((PluginSport)g.G(PluginSport.class)).getDeviceStepManager().cyz();
    }
    AppMethodBeat.o(93616);
  }
  
  public final boolean cyu()
  {
    AppMethodBeat.i(93619);
    boolean bool = n.cyu();
    AppMethodBeat.o(93619);
    return bool;
  }
  
  public final void cyv()
  {
    AppMethodBeat.i(93620);
    if (ah.brt())
    {
      ((PluginSport)g.G(PluginSport.class)).getSportFileStorage().reset();
      a locala = ((PluginSport)g.G(PluginSport.class)).getDeviceStepManager();
      com.tencent.mm.sdk.g.d.ysm.b(new a.3(locala), "Sport.clearConfigToPush");
    }
    AppMethodBeat.o(93620);
  }
  
  public final void cyw()
  {
    AppMethodBeat.i(93622);
    n.czc();
    AppMethodBeat.o(93622);
  }
  
  public final com.tencent.mm.plugin.sport.a.e cyx()
  {
    AppMethodBeat.i(93624);
    ((PluginSport)g.G(PluginSport.class)).getSportStepManager();
    ((PluginSport)g.G(PluginSport.class)).getSportStepStorage();
    com.tencent.mm.plugin.sport.a.e locale = m.cyx();
    AppMethodBeat.o(93624);
    return locale;
  }
  
  public final void cyy()
  {
    AppMethodBeat.i(93626);
    ((PluginSport)g.G(PluginSport.class)).getSportStepManager();
    ab.i("MicroMsg.Sport.SportStepManager", "clearAllSportStep");
    ((PluginSport)g.G(PluginSport.class)).getSportStepStorage();
    m.cyy();
    AppMethodBeat.o(93626);
  }
  
  public final void f(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(93621);
    al.d(new b.1(this, paramActivity, paramString));
    AppMethodBeat.o(93621);
  }
  
  public final boolean fa(Context paramContext)
  {
    AppMethodBeat.i(93618);
    boolean bool = n.fa(paramContext);
    AppMethodBeat.o(93618);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.b
 * JD-Core Version:    0.7.0.1
 */