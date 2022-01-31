package com.tencent.mm.protocal.c;

public final class apf
  extends com.tencent.mm.bv.a
{
  public String bVO;
  public int ilo;
  public String imz;
  public String sMy;
  public long sQd;
  public String tef;
  public int tlh;
  public long tli;
  public long tlj;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sMy != null) {
        paramVarArgs.d(1, this.sMy);
      }
      paramVarArgs.Y(2, this.sQd);
      paramVarArgs.gB(3, this.tlh);
      paramVarArgs.Y(4, this.tli);
      paramVarArgs.Y(5, this.tlj);
      if (this.tef != null) {
        paramVarArgs.d(6, this.tef);
      }
      if (this.imz != null) {
        paramVarArgs.d(7, this.imz);
      }
      paramVarArgs.gB(8, this.ilo);
      if (this.bVO != null) {
        paramVarArgs.d(9, this.bVO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sMy == null) {
        break label539;
      }
    }
    label539:
    for (paramInt = d.a.a.b.b.a.e(1, this.sMy) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.sQd) + d.a.a.a.gy(3, this.tlh) + d.a.a.a.X(4, this.tli) + d.a.a.a.X(5, this.tlj);
      paramInt = i;
      if (this.tef != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tef);
      }
      i = paramInt;
      if (this.imz != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.imz);
      }
      i += d.a.a.a.gy(8, this.ilo);
      paramInt = i;
      if (this.bVO != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.bVO);
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
        apf localapf = (apf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localapf.sMy = locala.xpH.readString();
          return 0;
        case 2: 
          localapf.sQd = locala.xpH.oE();
          return 0;
        case 3: 
          localapf.tlh = locala.xpH.oD();
          return 0;
        case 4: 
          localapf.tli = locala.xpH.oE();
          return 0;
        case 5: 
          localapf.tlj = locala.xpH.oE();
          return 0;
        case 6: 
          localapf.tef = locala.xpH.readString();
          return 0;
        case 7: 
          localapf.imz = locala.xpH.readString();
          return 0;
        case 8: 
          localapf.ilo = locala.xpH.oD();
          return 0;
        }
        localapf.bVO = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apf
 * JD-Core Version:    0.7.0.1
 */