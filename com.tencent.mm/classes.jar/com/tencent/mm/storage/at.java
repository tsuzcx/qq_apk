package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.a;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import java.util.ArrayList;
import java.util.HashMap;

public final class at
{
  private static int cNR;
  public static boolean yNA;
  private static ArrayList<EmojiGroupInfo> yNB;
  private static HashMap<String, ArrayList<EmojiInfo>> yNC;
  private static at yNH;
  public final k.a yND;
  public final k.a yNE;
  public final k.a yNF;
  public final com.tencent.mm.sdk.b.c yNG;
  public String yNI;
  public com.tencent.mm.storage.emotion.d yNn;
  public a yNo;
  public com.tencent.mm.storage.emotion.c yNp;
  public p yNq;
  public j yNr;
  public l yNs;
  public com.tencent.mm.storage.emotion.h yNt;
  public n yNu;
  public q yNv;
  public r yNw;
  public f yNx;
  public t yNy;
  public com.tencent.mm.emoji.a.d yNz;
  
  static
  {
    AppMethodBeat.i(62719);
    yNA = false;
    yNB = new ArrayList();
    yNC = new HashMap();
    cNR = -1;
    AppMethodBeat.o(62719);
  }
  
  private at()
  {
    AppMethodBeat.i(62715);
    this.yND = new at.1(this);
    this.yNE = new at.2(this);
    this.yNF = new at.3(this);
    this.yNG = new at.4(this);
    ab.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { bo.dtY() });
    AppMethodBeat.o(62715);
  }
  
  public static at dxt()
  {
    try
    {
      AppMethodBeat.i(62714);
      if (yNH == null)
      {
        localat = new at();
        yNH = localat;
        ab.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localat.yNn == null) {
          localat.dxu();
        }
      }
      at localat = yNH;
      AppMethodBeat.o(62714);
      return localat;
    }
    finally {}
  }
  
  public final com.tencent.mm.storage.emotion.d aUI()
  {
    return this.yNn;
  }
  
  public final int blc()
  {
    AppMethodBeat.i(62716);
    if ((cNR == -1) || (yNA)) {
      cNR = this.yNo.dyX();
    }
    int i = cNR;
    AppMethodBeat.o(62716);
    return i;
  }
  
  public final ArrayList<EmojiInfo> ch(boolean paramBoolean)
  {
    AppMethodBeat.i(62717);
    ArrayList localArrayList = this.yNz.ch(paramBoolean);
    AppMethodBeat.o(62717);
    return localArrayList;
  }
  
  public final void dxu()
  {
    AppMethodBeat.i(154801);
    ab.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((g.RL().eHS == null) || (!g.RL().eHS.isOpen())) {
      ab.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { g.RL().eHS });
    }
    this.yNn = new com.tencent.mm.storage.emotion.d(g.RL().eHS);
    this.yNo = new a(g.RL().eHS);
    this.yNp = new com.tencent.mm.storage.emotion.c(g.RL().eHS);
    this.yNr = new j(g.RL().eHS);
    this.yNs = new l(g.RL().eHS);
    this.yNt = new com.tencent.mm.storage.emotion.h(g.RL().eHS);
    this.yNq = new p(g.RL().eHS);
    this.yNu = new n(g.RL().eHS);
    this.yNv = new q(g.RL().eHS);
    this.yNw = new r(g.RL().eHS);
    this.yNx = new f(g.RL().eHS);
    this.yNy = new t();
    this.yNz = com.tencent.mm.emoji.a.d.Oz();
    AppMethodBeat.o(154801);
  }
  
  public final boolean dxv()
  {
    AppMethodBeat.i(62718);
    if (this.yNI == null) {
      this.yNI = ((String)g.RL().Ru().get(ac.a.yKz, ""));
    }
    if (!bo.isNullOrNil(this.yNI))
    {
      AppMethodBeat.o(62718);
      return true;
    }
    AppMethodBeat.o(62718);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.at
 * JD-Core Version:    0.7.0.1
 */