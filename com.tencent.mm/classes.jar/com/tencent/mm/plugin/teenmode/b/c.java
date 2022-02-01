package com.tencent.mm.plugin.teenmode.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;

public final class c
  implements b
{
  public static c gkw()
  {
    return a.Mtx;
  }
  
  public final boolean ZM()
  {
    AppMethodBeat.i(259295);
    Log.w("MicroMsg.TeenModeServiceProxy", "isTeenMode not implemented in non-MM process");
    AppMethodBeat.o(259295);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.teenmode.a.c paramc)
  {
    AppMethodBeat.i(259308);
    Log.w("MicroMsg.TeenModeServiceProxy", "registerTeenModeDataChangedListener not implemented in non-MM process");
    AppMethodBeat.o(259308);
  }
  
  public final void b(com.tencent.mm.plugin.teenmode.a.c paramc)
  {
    AppMethodBeat.i(259309);
    Log.w("MicroMsg.TeenModeServiceProxy", "unregisterTeenModeDataChangedListener not implemented in non-MM process");
    AppMethodBeat.o(259309);
  }
  
  public final int dYS()
  {
    AppMethodBeat.i(259297);
    Log.w("MicroMsg.TeenModeServiceProxy", "getFinderOption not implemented in non-MM process");
    AppMethodBeat.o(259297);
    return 0;
  }
  
  public final void gkq() {}
  
  public final int gkr()
  {
    AppMethodBeat.i(259299);
    Log.w("MicroMsg.TeenModeServiceProxy", "getBizAcctOption not implemented in non-MM process");
    AppMethodBeat.o(259299);
    return 0;
  }
  
  public final int gks()
  {
    AppMethodBeat.i(259300);
    Log.w("MicroMsg.TeenModeServiceProxy", "getMiniProgramOption not implemented in non-MM process");
    AppMethodBeat.o(259300);
    return 0;
  }
  
  public final void gkt()
  {
    AppMethodBeat.i(259311);
    Log.w("MicroMsg.TeenModeServiceProxy", "notifyTeenModeDataChanged not implemented in non-MM process");
    AppMethodBeat.o(259311);
  }
  
  public final boolean gku()
  {
    AppMethodBeat.i(259307);
    Log.w("MicroMsg.TeenModeServiceProxy", "isHideTeenModeEntrance not implemented in non-MM process");
    AppMethodBeat.o(259307);
    return false;
  }
  
  public final void ir(Context paramContext)
  {
    AppMethodBeat.i(259302);
    w.w(paramContext, paramContext.getString(a.g.Mtt), a.f.teen_mode);
    AppMethodBeat.o(259302);
  }
  
  public final void rE(int paramInt)
  {
    AppMethodBeat.i(259303);
    Log.w("MicroMsg.TeenModeServiceProxy", "report not implemented in non-MM process");
    AppMethodBeat.o(259303);
  }
  
  public final void setScene(int paramInt)
  {
    AppMethodBeat.i(259306);
    Log.w("MicroMsg.TeenModeServiceProxy", "setScene not implemented in non-MM process");
    AppMethodBeat.o(259306);
  }
  
  static final class a
  {
    public static c Mtx;
    
    static
    {
      AppMethodBeat.i(259323);
      Mtx = new c((byte)0);
      AppMethodBeat.o(259323);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.c
 * JD-Core Version:    0.7.0.1
 */