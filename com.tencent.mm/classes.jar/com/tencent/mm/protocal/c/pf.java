package com.tencent.mm.protocal.c;

public final class pf
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String ljr;
  public int pyo;
  public String sMR;
  public String sMS;
  public String sMT;
  public String sMU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.pyo);
      paramVarArgs.gB(2, this.hQR);
      if (this.sMR != null) {
        paramVarArgs.d(3, this.sMR);
      }
      if (this.sMS != null) {
        paramVarArgs.d(4, this.sMS);
      }
      if (this.ljr != null) {
        paramVarArgs.d(5, this.ljr);
      }
      if (this.sMT != null) {
        paramVarArgs.d(6, this.sMT);
      }
      if (this.sMU != null) {
        paramVarArgs.d(7, this.sMU);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.pyo) + 0 + d.a.a.a.gy(2, this.hQR);
      paramInt = i;
      if (this.sMR != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sMR);
      }
      i = paramInt;
      if (this.sMS != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sMS);
      }
      paramInt = i;
      if (this.ljr != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.ljr);
      }
      i = paramInt;
      if (this.sMT != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sMT);
      }
      paramInt = i;
    } while (this.sMU == null);
    return i + d.a.a.b.b.a.e(7, this.sMU);
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      pf localpf = (pf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localpf.pyo = locala.xpH.oD();
        return 0;
      case 2: 
        localpf.hQR = locala.xpH.oD();
        return 0;
      case 3: 
        localpf.sMR = locala.xpH.readString();
        return 0;
      case 4: 
        localpf.sMS = locala.xpH.readString();
        return 0;
      case 5: 
        localpf.ljr = locala.xpH.readString();
        return 0;
      case 6: 
        localpf.sMT = locala.xpH.readString();
        return 0;
      }
      localpf.sMU = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pf
 * JD-Core Version:    0.7.0.1
 */