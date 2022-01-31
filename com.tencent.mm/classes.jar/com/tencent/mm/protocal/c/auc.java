package com.tencent.mm.protocal.c;

public final class auc
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public int hQq;
  public String hRf;
  public String nFs;
  public String sLD;
  public String sLE;
  public String tac;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.nFs != null) {
        paramVarArgs.d(1, this.nFs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      paramVarArgs.gB(3, this.hQq);
      if (this.sLD != null) {
        paramVarArgs.d(4, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(5, this.sLE);
      }
      if (this.hRf != null) {
        paramVarArgs.d(6, this.hRf);
      }
      if (this.tac != null) {
        paramVarArgs.d(7, this.tac);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.nFs == null) {
        break label497;
      }
    }
    label497:
    for (paramInt = d.a.a.b.b.a.e(1, this.nFs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.hPY);
      }
      i += d.a.a.a.gy(3, this.hQq);
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sLE);
      }
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.hRf);
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tac);
      }
      return i;
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
        auc localauc = (auc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localauc.nFs = locala.xpH.readString();
          return 0;
        case 2: 
          localauc.hPY = locala.xpH.readString();
          return 0;
        case 3: 
          localauc.hQq = locala.xpH.oD();
          return 0;
        case 4: 
          localauc.sLD = locala.xpH.readString();
          return 0;
        case 5: 
          localauc.sLE = locala.xpH.readString();
          return 0;
        case 6: 
          localauc.hRf = locala.xpH.readString();
          return 0;
        }
        localauc.tac = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.auc
 * JD-Core Version:    0.7.0.1
 */