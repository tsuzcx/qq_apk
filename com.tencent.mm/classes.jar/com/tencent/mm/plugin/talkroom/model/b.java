package com.tencent.mm.plugin.talkroom.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.network.n;
import java.util.HashMap;

public final class b
  implements at
{
  private n qwx;
  g tbX;
  private d tbY;
  public c tbZ;
  private e tca;
  f tcb;
  
  public b()
  {
    AppMethodBeat.i(25757);
    this.tbY = new d();
    this.tbZ = new c();
    this.qwx = new b.1(this);
    AppMethodBeat.o(25757);
  }
  
  public static b cHr()
  {
    AppMethodBeat.i(25758);
    aw.aat();
    b localb2 = (b)bw.pF("plugin.talkroom");
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      aw.aat().a("plugin.talkroom", localb1);
    }
    AppMethodBeat.o(25758);
    return localb1;
  }
  
  public static g cHs()
  {
    AppMethodBeat.i(25759);
    if (cHr().tbX == null) {
      cHr().tbX = new g();
    }
    g localg = cHr().tbX;
    AppMethodBeat.o(25759);
    return localg;
  }
  
  public static e cHt()
  {
    AppMethodBeat.i(25760);
    if (cHr().tca == null) {
      cHr().tca = new e();
    }
    e locale = cHr().tca;
    AppMethodBeat.o(25760);
    return locale;
  }
  
  public static String cHu()
  {
    AppMethodBeat.i(25761);
    Object localObject = new StringBuilder();
    aw.aaz();
    localObject = com.tencent.mm.model.c.Rp() + "talkroom/";
    AppMethodBeat.o(25761);
    return localObject;
  }
  
  public static f cHv()
  {
    AppMethodBeat.i(25762);
    if (cHr().tcb == null) {
      cHr().tcb = new f();
    }
    f localf = cHr().tcb;
    AppMethodBeat.o(25762);
    return localf;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25763);
    e.d.a(Integer.valueOf(56), this.tbY);
    aw.a(this.qwx);
    com.tencent.mm.bg.g.fUM = cHt();
    com.tencent.mm.bg.g.fUN = cHs();
    AppMethodBeat.o(25763);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25764);
    e.d.b(Integer.valueOf(56), this.tbY);
    aw.b(this.qwx);
    com.tencent.mm.bg.g.fUM = null;
    com.tencent.mm.bg.g.fUN = null;
    if (this.tbX != null)
    {
      this.tbX.cHH();
      this.tbX = null;
    }
    AppMethodBeat.o(25764);
  }
  
  public final void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.b
 * JD-Core Version:    0.7.0.1
 */