package com.tencent.mm.protocal.c;

public final class byh
  extends com.tencent.mm.bv.a
{
  public String bUi;
  public long tOF;
  public long tOL;
  public long tOM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bUi != null) {
        paramVarArgs.d(1, this.bUi);
      }
      paramVarArgs.Y(2, this.tOL);
      paramVarArgs.Y(3, this.tOM);
      paramVarArgs.Y(4, this.tOF);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bUi == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = d.a.a.b.b.a.e(1, this.bUi) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.tOL) + d.a.a.a.X(3, this.tOM) + d.a.a.a.X(4, this.tOF);
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
        byh localbyh = (byh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbyh.bUi = locala.xpH.readString();
          return 0;
        case 2: 
          localbyh.tOL = locala.xpH.oE();
          return 0;
        case 3: 
          localbyh.tOM = locala.xpH.oE();
          return 0;
        }
        localbyh.tOF = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byh
 * JD-Core Version:    0.7.0.1
 */