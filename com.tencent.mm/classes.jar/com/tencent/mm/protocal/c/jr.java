package com.tencent.mm.protocal.c;

public final class jr
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public String iQN;
  public int sEr;
  public int sEs;
  public int sEt;
  public String sEu;
  public int sEv;
  public int sEw;
  public int sEx;
  public String sEy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      paramVarArgs.gB(2, this.sEr);
      paramVarArgs.gB(3, this.sEs);
      if (this.iQN != null) {
        paramVarArgs.d(4, this.iQN);
      }
      paramVarArgs.gB(5, this.sEt);
      if (this.sEu != null) {
        paramVarArgs.d(6, this.sEu);
      }
      paramVarArgs.gB(7, this.sEv);
      paramVarArgs.gB(8, this.sEw);
      paramVarArgs.gB(9, this.sEx);
      if (this.sEy != null) {
        paramVarArgs.d(10, this.sEy);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = d.a.a.b.b.a.e(1, this.bOL) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sEr) + d.a.a.a.gy(3, this.sEs);
      paramInt = i;
      if (this.iQN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iQN);
      }
      i = paramInt + d.a.a.a.gy(5, this.sEt);
      paramInt = i;
      if (this.sEu != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sEu);
      }
      i = paramInt + d.a.a.a.gy(7, this.sEv) + d.a.a.a.gy(8, this.sEw) + d.a.a.a.gy(9, this.sEx);
      paramInt = i;
      if (this.sEy != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sEy);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        jr localjr = (jr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localjr.bOL = locala.xpH.readString();
          return 0;
        case 2: 
          localjr.sEr = locala.xpH.oD();
          return 0;
        case 3: 
          localjr.sEs = locala.xpH.oD();
          return 0;
        case 4: 
          localjr.iQN = locala.xpH.readString();
          return 0;
        case 5: 
          localjr.sEt = locala.xpH.oD();
          return 0;
        case 6: 
          localjr.sEu = locala.xpH.readString();
          return 0;
        case 7: 
          localjr.sEv = locala.xpH.oD();
          return 0;
        case 8: 
          localjr.sEw = locala.xpH.oD();
          return 0;
        case 9: 
          localjr.sEx = locala.xpH.oD();
          return 0;
        }
        localjr.sEy = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jr
 * JD-Core Version:    0.7.0.1
 */