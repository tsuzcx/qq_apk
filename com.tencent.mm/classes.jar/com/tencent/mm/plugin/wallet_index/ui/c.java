package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_index.c.m;
import com.tencent.mm.protocal.protobuf.bhi;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.wallet_core.c.v;
import java.util.ArrayList;
import java.util.List;

public final class c
{
  public String AxB;
  public ArrayList<String> AxE;
  public ArrayList<String> AxF;
  public String AxG;
  public int AxH;
  List<String> AxI;
  boolean AxJ;
  public String AxK;
  public String AxL;
  public String Axc;
  public String Axd;
  public bhi Axj;
  public bhj Axk;
  public int mCount;
  String oyw;
  int uqr;
  
  public c()
  {
    AppMethodBeat.i(71861);
    this.AxE = new ArrayList();
    this.AxF = new ArrayList();
    this.mCount = 1;
    this.AxG = null;
    this.AxH = 0;
    this.Axd = null;
    this.Axc = null;
    this.AxB = null;
    this.AxI = new ArrayList();
    this.oyw = null;
    this.AxJ = false;
    AppMethodBeat.o(71861);
  }
  
  public final n a(com.tencent.mm.plugin.wallet_index.b.a.c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(71862);
    if (paramBoolean) {}
    for (int i = 2; this.AxJ; i = 1)
    {
      if (!efB())
      {
        this.Axj.DFn = paramc.bXk;
        this.Axj.DFk = paramc.Axa;
        this.Axj.upC = paramc.Axd;
        this.Axj.DqC = paramc.Axc;
        this.Axj.uwi = paramc.oyw;
        this.Axj.DFm = paramc.Axb;
      }
      paramc = new m(this.uqr, i, paramc.oyw, this.Axk, this.Axj);
      AppMethodBeat.o(71862);
      return paramc;
    }
    paramc = new v(paramc.oyw, i, this.uqr, this.mCount, paramc.Axa, paramc.Axb, paramc.bXk, paramc.Axc, paramc.Axd);
    AppMethodBeat.o(71862);
    return paramc;
  }
  
  public final boolean efB()
  {
    return this.uqr == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.ui.c
 * JD-Core Version:    0.7.0.1
 */