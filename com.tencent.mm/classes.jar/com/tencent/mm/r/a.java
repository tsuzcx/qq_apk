package com.tencent.mm.r;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.lk.b;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.wv.a;
import com.tencent.mm.g.a.yr;
import com.tencent.mm.g.a.yr.a;
import com.tencent.mm.model.ah;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;

public final class a
{
  private static ah cNf;
  
  public static ah Lv()
  {
    AppMethodBeat.i(150036);
    if (cNf == null) {
      cNf = com.tencent.mm.booter.a.Ti();
    }
    ah localah = cNf;
    AppMethodBeat.o(150036);
    return localah;
  }
  
  public static boolean aad()
  {
    AppMethodBeat.i(150032);
    lk locallk = new lk();
    locallk.dpZ.action = 1;
    com.tencent.mm.sdk.b.a.ESL.l(locallk);
    boolean bool = locallk.dqa.isStart;
    AppMethodBeat.o(150032);
    return bool;
  }
  
  public static boolean cc(Context paramContext)
  {
    AppMethodBeat.i(150031);
    if (aad())
    {
      ad.i("MicroMsg.DeviceOccupy", "isMultiTalking");
      h.a(paramContext, "", paramContext.getString(2131761414), paramContext.getString(2131755792), new a.1());
      AppMethodBeat.o(150031);
      return true;
    }
    AppMethodBeat.o(150031);
    return false;
  }
  
  public static boolean ccn()
  {
    AppMethodBeat.i(203563);
    yr localyr = new yr();
    com.tencent.mm.sdk.b.a.ESL.l(localyr);
    ad.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localyr.aUM.isStart), Boolean.valueOf(localyr.aUM.aWl) });
    if ((localyr.aUM.isStart) && (localyr.aUM.aWl))
    {
      AppMethodBeat.o(203563);
      return true;
    }
    AppMethodBeat.o(203563);
    return false;
  }
  
  public static boolean cd(Context paramContext)
  {
    AppMethodBeat.i(150033);
    wv localwv = new wv();
    com.tencent.mm.sdk.b.a.ESL.l(localwv);
    if (localwv.dCl.dCn)
    {
      ad.i("MicroMsg.DeviceOccupy", "isCameraUsing");
      h.a(paramContext, "", n(paramContext, localwv.dCl.dCm), paramContext.getString(2131755792), new a.2());
      bool = localwv.dCl.dCn;
      AppMethodBeat.o(150033);
      return bool;
    }
    boolean bool = dV(paramContext);
    AppMethodBeat.o(150033);
    return bool;
  }
  
  public static boolean ce(Context paramContext)
  {
    AppMethodBeat.i(150034);
    wv localwv = new wv();
    com.tencent.mm.sdk.b.a.ESL.l(localwv);
    if (localwv.dCl.dCo)
    {
      ad.i("MicroMsg.DeviceOccupy", "isVoiceUsing");
      h.a(paramContext, "", n(paramContext, localwv.dCl.dCm), paramContext.getString(2131755792), new a.4());
      bool = localwv.dCl.dCo;
      AppMethodBeat.o(150034);
      return bool;
    }
    boolean bool = dV(paramContext);
    AppMethodBeat.o(150034);
    return bool;
  }
  
  public static boolean dV(Context paramContext)
  {
    AppMethodBeat.i(203562);
    yr localyr = new yr();
    com.tencent.mm.sdk.b.a.ESL.l(localyr);
    ad.i("MicroMsg.DeviceOccupy", "isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(localyr.aUM.isStart), Boolean.valueOf(localyr.aUM.aWl) });
    boolean bool = localyr.aUM.isStart;
    if (bool) {
      h.a(paramContext, "", paramContext.getString(2131766620), paramContext.getString(2131755792), new a.3());
    }
    AppMethodBeat.o(203562);
    return bool;
  }
  
  private static String n(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(150035);
    if (paramBoolean)
    {
      paramContext = paramContext.getString(2131756776);
      AppMethodBeat.o(150035);
      return paramContext;
    }
    paramContext = paramContext.getString(2131756777);
    AppMethodBeat.o(150035);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.r.a
 * JD-Core Version:    0.7.0.1
 */