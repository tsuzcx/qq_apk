package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.id;

public final class a
{
  public static a CWN = null;
  public id CWO;
  public int CWP;
  public int CWQ;
  public int CWR;
  public int CWS;
  public int CWT;
  public int CWU;
  public int CWV;
  public long CWW;
  public int CWX;
  public int CWY;
  public int CWZ;
  public int CXa;
  public int CXb;
  public long CXc;
  public long CXd;
  
  public a()
  {
    AppMethodBeat.i(187913);
    this.CWO = null;
    this.CWP = 0;
    this.CWQ = 0;
    this.CWR = 0;
    this.CWS = 0;
    this.CWT = 0;
    this.CWU = 0;
    this.CWV = 0;
    this.CWW = 0L;
    this.CWX = 0;
    this.CWY = 0;
    this.CWZ = 0;
    this.CXa = 0;
    this.CXb = 0;
    this.CXc = 0L;
    this.CXd = 0L;
    this.CWO = new id();
    AppMethodBeat.o(187913);
  }
  
  public static a eSu()
  {
    AppMethodBeat.i(187911);
    if (CWN == null) {
      eSv();
    }
    a locala = CWN;
    AppMethodBeat.o(187911);
    return locala;
  }
  
  public static void eSv()
  {
    AppMethodBeat.i(187912);
    CWN = new a();
    AppMethodBeat.o(187912);
  }
  
  public final void IF(long paramLong)
  {
    this.CWO.eMZ = paramLong;
  }
  
  public final void IG(long paramLong)
  {
    if (paramLong > this.CWW) {
      this.CWO.eNi = (paramLong - this.CWW);
    }
  }
  
  public final void eSw()
  {
    this.CWS += 1;
  }
  
  public final void eSx()
  {
    this.CWT += 1;
  }
  
  public final void eSy()
  {
    this.CWZ += 1;
  }
  
  public final void un(boolean paramBoolean)
  {
    id localid = this.CWO;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localid.eMW = i;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.a
 * JD-Core Version:    0.7.0.1
 */