package com.tencent.mm.plugin.teenmode.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public final class c
  implements b
{
  public static c fvt()
  {
    return a.FWl;
  }
  
  public final boolean Vt()
  {
    AppMethodBeat.i(187373);
    Log.w("MicroMsg.TeenModeServiceProxy", "isTeenMode not implemented in non-MM process");
    AppMethodBeat.o(187373);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.teenmode.a.c paramc)
  {
    AppMethodBeat.i(187380);
    Log.w("MicroMsg.TeenModeServiceProxy", "registerTeenModeDataChangedListener not implemented in non-MM process");
    AppMethodBeat.o(187380);
  }
  
  public final void b(com.tencent.mm.plugin.teenmode.a.c paramc)
  {
    AppMethodBeat.i(187381);
    Log.w("MicroMsg.TeenModeServiceProxy", "unregisterTeenModeDataChangedListener not implemented in non-MM process");
    AppMethodBeat.o(187381);
  }
  
  public final int dxW()
  {
    AppMethodBeat.i(187374);
    Log.w("MicroMsg.TeenModeServiceProxy", "getFinderOption not implemented in non-MM process");
    AppMethodBeat.o(187374);
    return 0;
  }
  
  public final int fvo()
  {
    AppMethodBeat.i(187375);
    Log.w("MicroMsg.TeenModeServiceProxy", "getBizAcctOption not implemented in non-MM process");
    AppMethodBeat.o(187375);
    return 0;
  }
  
  public final int fvp()
  {
    AppMethodBeat.i(187376);
    Log.w("MicroMsg.TeenModeServiceProxy", "getMiniProgramOption not implemented in non-MM process");
    AppMethodBeat.o(187376);
    return 0;
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(187382);
    Log.w("MicroMsg.TeenModeServiceProxy", "notifyTeenModeDataChanged not implemented in non-MM process");
    AppMethodBeat.o(187382);
  }
  
  public final boolean fvr()
  {
    AppMethodBeat.i(187379);
    Log.w("MicroMsg.TeenModeServiceProxy", "isHideTeenModeEntrance not implemented in non-MM process");
    AppMethodBeat.o(187379);
    return false;
  }
  
  public final void hr(Context paramContext)
  {
    AppMethodBeat.i(187377);
    u.u(paramContext, paramContext.getString(2131766685), 2131691605);
    AppMethodBeat.o(187377);
  }
  
  public final void pl(int paramInt)
  {
    AppMethodBeat.i(187378);
    Log.w("MicroMsg.TeenModeServiceProxy", "report not implemented in non-MM process");
    AppMethodBeat.o(187378);
  }
  
  static final class a
  {
    public static c FWl;
    
    static
    {
      AppMethodBeat.i(187372);
      FWl = new c((byte)0);
      AppMethodBeat.o(187372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.c
 * JD-Core Version:    0.7.0.1
 */