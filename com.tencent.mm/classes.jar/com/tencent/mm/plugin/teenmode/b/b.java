package com.tencent.mm.plugin.teenmode.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.teenmode.a.c;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class b
  implements com.tencent.mm.plugin.teenmode.a.b
{
  private Set<c> FWj;
  
  private b()
  {
    AppMethodBeat.i(187371);
    this.FWj = new CopyOnWriteArraySet();
    AppMethodBeat.o(187371);
  }
  
  public static b fvs()
  {
    return a.FWk;
  }
  
  public final boolean Vt()
  {
    AppMethodBeat.i(187361);
    boolean bool = Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.OaV, false)));
    Log.d("MicroMsg.TeenModeService", "isTeenMode:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(187361);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(187368);
    if (paramc != null) {
      this.FWj.add(paramc);
    }
    AppMethodBeat.o(187368);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(187369);
    if (paramc != null) {
      this.FWj.remove(paramc);
    }
    AppMethodBeat.o(187369);
  }
  
  public final int dxW()
  {
    AppMethodBeat.i(187362);
    int i = g.aAh().azQ().getInt(ar.a.OaW, 0);
    Log.d("MicroMsg.TeenModeService", "getFinderOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(187362);
    return i;
  }
  
  public final int fvo()
  {
    AppMethodBeat.i(187363);
    int i = g.aAh().azQ().getInt(ar.a.OaX, 0);
    Log.d("MicroMsg.TeenModeService", "getBizAcctOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(187363);
    return i;
  }
  
  public final int fvp()
  {
    AppMethodBeat.i(187364);
    int i = g.aAh().azQ().getInt(ar.a.OaY, 0);
    Log.d("MicroMsg.TeenModeService", "getMiniProgramOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(187364);
    return i;
  }
  
  public final void fvq()
  {
    AppMethodBeat.i(187370);
    Log.d("MicroMsg.TeenModeService", "notifyTeenModeDataChanged %d", new Object[] { Integer.valueOf(this.FWj.size()) });
    Iterator localIterator = this.FWj.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).onDataChanged();
    }
    AppMethodBeat.o(187370);
  }
  
  public final boolean fvr()
  {
    AppMethodBeat.i(187367);
    String str = (String)g.aAh().azQ().get(274436, null);
    if ((!Util.isNullOrNil(str)) && (str.toUpperCase().equals("CN"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, not in china, hide entrance.");
      AppMethodBeat.o(187367);
      return true;
    }
    str = ((a)g.af(a.class)).aqJ().getValue("ShowTeenagerMode");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, ShowTeenagerMode is null");
      AppMethodBeat.o(187367);
      return false;
    }
    i = Integer.parseInt(str);
    Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, val is %s", new Object[] { Integer.valueOf(i) });
    if ((str != null) && (1 == i))
    {
      AppMethodBeat.o(187367);
      return true;
    }
    AppMethodBeat.o(187367);
    return false;
  }
  
  public final void hr(Context paramContext)
  {
    AppMethodBeat.i(187365);
    u.u(paramContext, paramContext.getString(2131766685), 2131691605);
    AppMethodBeat.o(187365);
  }
  
  public final void pl(int paramInt)
  {
    AppMethodBeat.i(187366);
    h.CyF.a(20917, new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(187366);
  }
  
  static final class a
  {
    public static b FWk;
    
    static
    {
      AppMethodBeat.i(187360);
      FWk = new b((byte)0);
      AppMethodBeat.o(187360);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.b
 * JD-Core Version:    0.7.0.1
 */