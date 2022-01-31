package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.be;
import java.util.HashMap;

public class ac
  implements at
{
  private ab pJX;
  private b pKA;
  private v pKz;
  
  public ac()
  {
    AppMethodBeat.i(68060);
    this.pKA = new b();
    AppMethodBeat.o(68060);
  }
  
  private static ac cdP()
  {
    AppMethodBeat.i(68061);
    ac localac = (ac)q.S(ac.class);
    AppMethodBeat.o(68061);
    return localac;
  }
  
  public static v cdQ()
  {
    AppMethodBeat.i(68062);
    g.RJ().QQ();
    if (cdP().pKz == null) {
      cdP().pKz = new v(d.whH, d.eQs);
    }
    v localv = cdP().pKz;
    AppMethodBeat.o(68062);
    return localv;
  }
  
  public static ab cdR()
  {
    AppMethodBeat.i(68063);
    g.RJ().QQ();
    if (cdP().pJX == null) {
      cdP().pJX = new ab();
    }
    ab localab = cdP().pJX;
    AppMethodBeat.o(68063);
    return localab;
  }
  
  public static void cdS()
  {
    AppMethodBeat.i(68066);
    bf.pz("qqmail");
    ((j)g.E(j.class)).YF().arF("qqmail");
    cdQ().clearData();
    AppMethodBeat.o(68066);
  }
  
  public void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(68065);
    if ((paramInt & 0x1) != 0) {
      cdS();
    }
    AppMethodBeat.o(68065);
  }
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(68067);
    com.tencent.mm.sdk.b.a.ymk.c(this.pKA);
    g.RO().ac(new ac.1(this));
    AppMethodBeat.o(68067);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(68064);
    v localv = cdP().pKz;
    if (localv != null) {
      localv.reset();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.pKA);
    AppMethodBeat.o(68064);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ac
 * JD-Core Version:    0.7.0.1
 */