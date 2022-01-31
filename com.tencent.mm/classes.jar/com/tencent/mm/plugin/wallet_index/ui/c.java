package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_index.c.k;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.wallet_core.c.t;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  String liu;
  public int mCount;
  int prr;
  public ArrayList<String> uAB;
  public ArrayList<String> uAC;
  public String uAD;
  public int uAE;
  List<String> uAF;
  boolean uAG;
  public String uAH;
  public String uAI;
  public String uAa;
  public String uAb;
  public awd uAh;
  public awe uAi;
  public String uAy;
  
  public c()
  {
    AppMethodBeat.i(48227);
    this.uAB = new ArrayList();
    this.uAC = new ArrayList();
    this.mCount = 1;
    this.uAD = null;
    this.uAE = 0;
    this.uAb = null;
    this.uAa = null;
    this.uAy = null;
    this.uAF = new ArrayList();
    this.liu = null;
    this.uAG = false;
    AppMethodBeat.o(48227);
  }
  
  public final m a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(48228);
    if (paramBoolean) {}
    for (int i = 2; this.uAG; i = 1)
    {
      if (!cXg())
      {
        this.uAh.xlA = paramc.mSignature;
        this.uAh.xlx = paramc.uzY;
        this.uAh.pqC = paramc.uAb;
        this.uAh.wYP = paramc.uAa;
        this.uAh.puw = paramc.liu;
        this.uAh.xlz = paramc.uzZ;
      }
      paramc = new k(this.prr, i, paramc.liu, this.uAi, this.uAh);
      AppMethodBeat.o(48228);
      return paramc;
    }
    paramc = new t(paramc.liu, i, this.prr, this.mCount, paramc.uzY, paramc.uzZ, paramc.mSignature, paramc.uAa, paramc.uAb);
    AppMethodBeat.o(48228);
    return paramc;
  }
  
  public final boolean cXg()
  {
    return this.prr == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */