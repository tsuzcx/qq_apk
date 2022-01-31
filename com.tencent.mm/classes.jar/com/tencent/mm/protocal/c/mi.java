package com.tencent.mm.protocal.c;

public final class mi
  extends com.tencent.mm.bv.a
{
  public int hQq;
  public String sJe;
  public long sJf;
  public int sJg;
  public int svy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sJe != null) {
        paramVarArgs.d(1, this.sJe);
      }
      paramVarArgs.Y(2, this.sJf);
      paramVarArgs.gB(3, this.sJg);
      paramVarArgs.gB(4, this.svy);
      paramVarArgs.gB(5, this.hQq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sJe == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = d.a.a.b.b.a.e(1, this.sJe) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.sJf) + d.a.a.a.gy(3, this.sJg) + d.a.a.a.gy(4, this.svy) + d.a.a.a.gy(5, this.hQq);
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
        mi localmi = (mi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localmi.sJe = locala.xpH.readString();
          return 0;
        case 2: 
          localmi.sJf = locala.xpH.oE();
          return 0;
        case 3: 
          localmi.sJg = locala.xpH.oD();
          return 0;
        case 4: 
          localmi.svy = locala.xpH.oD();
          return 0;
        }
        localmi.hQq = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mi
 * JD-Core Version:    0.7.0.1
 */