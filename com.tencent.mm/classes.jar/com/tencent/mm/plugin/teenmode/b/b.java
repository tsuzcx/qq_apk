package com.tencent.mm.plugin.teenmode.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.c;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.w;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class b
  implements com.tencent.mm.plugin.teenmode.a.b
{
  private int Mtu;
  private Set<c> Mtv;
  
  private b()
  {
    AppMethodBeat.i(259393);
    this.Mtu = 0;
    this.Mtv = new CopyOnWriteArraySet();
    AppMethodBeat.o(259393);
  }
  
  public static b gkv()
  {
    return a.Mtw;
  }
  
  public final boolean ZM()
  {
    AppMethodBeat.i(259362);
    boolean bool = Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VoX, false)));
    Log.d("MicroMsg.TeenModeService", "isTeenMode:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(259362);
    return bool;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(259382);
    if (paramc != null) {
      this.Mtv.add(paramc);
    }
    AppMethodBeat.o(259382);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(259385);
    if (paramc != null) {
      this.Mtv.remove(paramc);
    }
    AppMethodBeat.o(259385);
  }
  
  public final int dYS()
  {
    AppMethodBeat.i(259368);
    int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VoY, 0);
    Log.d("MicroMsg.TeenModeService", "getFinderOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(259368);
    return i;
  }
  
  public final void gkq()
  {
    AppMethodBeat.i(259365);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoX, Boolean.FALSE);
    com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VoW, Boolean.TRUE);
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkt();
    ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).rE(4);
    bmy localbmy = new bmy();
    localbmy.SXP = 59;
    localbmy.HmX = 2;
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(new k.a(23, localbmy));
    AppMethodBeat.o(259365);
  }
  
  public final int gkr()
  {
    AppMethodBeat.i(259370);
    int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.VoZ, 0);
    Log.d("MicroMsg.TeenModeService", "getBizAcctOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(259370);
    return i;
  }
  
  public final int gks()
  {
    AppMethodBeat.i(259372);
    int i = com.tencent.mm.kernel.h.aHG().aHp().getInt(ar.a.Vpa, 0);
    Log.d("MicroMsg.TeenModeService", "getMiniProgramOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(259372);
    return i;
  }
  
  public final void gkt()
  {
    AppMethodBeat.i(259388);
    Log.d("MicroMsg.TeenModeService", "notifyTeenModeDataChanged %d", new Object[] { Integer.valueOf(this.Mtv.size()) });
    Iterator localIterator = this.Mtv.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).onDataChanged();
    }
    AppMethodBeat.o(259388);
  }
  
  public final boolean gku()
  {
    AppMethodBeat.i(259379);
    String str = (String)com.tencent.mm.kernel.h.aHG().aHp().b(274436, null);
    if ((!Util.isNullOrNil(str)) && (str.toUpperCase().equals("CN"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, not in china, hide entrance.");
      AppMethodBeat.o(259379);
      return true;
    }
    str = ((a)com.tencent.mm.kernel.h.ae(a.class)).axc().getValue("ShowTeenagerMode");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, ShowTeenagerMode is null");
      AppMethodBeat.o(259379);
      return false;
    }
    i = Integer.parseInt(str);
    Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, val is %s", new Object[] { Integer.valueOf(i) });
    if ((str != null) && (1 == i))
    {
      AppMethodBeat.o(259379);
      return true;
    }
    AppMethodBeat.o(259379);
    return false;
  }
  
  public final void ir(Context paramContext)
  {
    AppMethodBeat.i(259373);
    w.w(paramContext, paramContext.getString(a.g.Mtt), a.f.teen_mode);
    AppMethodBeat.o(259373);
  }
  
  public final void rE(int paramInt)
  {
    AppMethodBeat.i(259374);
    com.tencent.mm.plugin.report.service.h.IzE.a(20917, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Mtu) });
    AppMethodBeat.o(259374);
  }
  
  public final void setScene(int paramInt)
  {
    this.Mtu = paramInt;
  }
  
  static final class a
  {
    public static b Mtw;
    
    static
    {
      AppMethodBeat.i(259604);
      Mtw = new b((byte)0);
      AppMethodBeat.o(259604);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.b
 * JD-Core Version:    0.7.0.1
 */