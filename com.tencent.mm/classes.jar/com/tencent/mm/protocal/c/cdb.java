package com.tencent.mm.protocal.c;

public final class cdb
  extends com.tencent.mm.bv.a
{
  public String nFs;
  public String tFA;
  public String tRS;
  public int tRT;
  public String tRU;
  public String tRV;
  public int tRW;
  public String tRX;
  public String tac;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.nFs != null) {
        paramVarArgs.d(1, this.nFs);
      }
      if (this.tRS != null) {
        paramVarArgs.d(2, this.tRS);
      }
      if (this.tac != null) {
        paramVarArgs.d(3, this.tac);
      }
      paramVarArgs.gB(4, this.tRT);
      if (this.tFA != null) {
        paramVarArgs.d(5, this.tFA);
      }
      if (this.tRU != null) {
        paramVarArgs.d(6, this.tRU);
      }
      if (this.tRV != null) {
        paramVarArgs.d(7, this.tRV);
      }
      paramVarArgs.gB(8, this.tRW);
      if (this.tRX != null) {
        paramVarArgs.d(9, this.tRX);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.nFs == null) {
        break label595;
      }
    }
    label595:
    for (int i = d.a.a.b.b.a.e(1, this.nFs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tRS != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tRS);
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tac);
      }
      i += d.a.a.a.gy(4, this.tRT);
      paramInt = i;
      if (this.tFA != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tFA);
      }
      i = paramInt;
      if (this.tRU != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tRU);
      }
      paramInt = i;
      if (this.tRV != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tRV);
      }
      i = paramInt + d.a.a.a.gy(8, this.tRW);
      paramInt = i;
      if (this.tRX != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tRX);
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
        cdb localcdb = (cdb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcdb.nFs = locala.xpH.readString();
          return 0;
        case 2: 
          localcdb.tRS = locala.xpH.readString();
          return 0;
        case 3: 
          localcdb.tac = locala.xpH.readString();
          return 0;
        case 4: 
          localcdb.tRT = locala.xpH.oD();
          return 0;
        case 5: 
          localcdb.tFA = locala.xpH.readString();
          return 0;
        case 6: 
          localcdb.tRU = locala.xpH.readString();
          return 0;
        case 7: 
          localcdb.tRV = locala.xpH.readString();
          return 0;
        case 8: 
          localcdb.tRW = locala.xpH.oD();
          return 0;
        }
        localcdb.tRX = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdb
 * JD-Core Version:    0.7.0.1
 */