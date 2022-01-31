package com.tencent.mm.protocal.c;

public final class t
  extends com.tencent.mm.bv.a
{
  public String srM;
  public long srN;
  public int srO;
  public long srz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.srM != null) {
        paramVarArgs.d(1, this.srM);
      }
      paramVarArgs.Y(2, this.srz);
      paramVarArgs.Y(3, this.srN);
      paramVarArgs.gB(4, this.srO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.srM == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = d.a.a.b.b.a.e(1, this.srM) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.srz) + d.a.a.a.X(3, this.srN) + d.a.a.a.gy(4, this.srO);
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
        t localt = (t)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localt.srM = locala.xpH.readString();
          return 0;
        case 2: 
          localt.srz = locala.xpH.oE();
          return 0;
        case 3: 
          localt.srN = locala.xpH.oE();
          return 0;
        }
        localt.srO = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.t
 * JD-Core Version:    0.7.0.1
 */