package com.tencent.mm.protocal.c;

public final class cli
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public int sEs;
  public String tYD;
  public String tYE;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      paramVarArgs.gB(2, this.sEs);
      if (this.tYD != null) {
        paramVarArgs.d(3, this.tYD);
      }
      if (this.tYE != null) {
        paramVarArgs.d(4, this.tYE);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = d.a.a.b.b.a.e(1, this.bOL) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sEs);
      paramInt = i;
      if (this.tYD != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tYD);
      }
      i = paramInt;
      if (this.tYE != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tYE);
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
        cli localcli = (cli)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcli.bOL = locala.xpH.readString();
          return 0;
        case 2: 
          localcli.sEs = locala.xpH.oD();
          return 0;
        case 3: 
          localcli.tYD = locala.xpH.readString();
          return 0;
        }
        localcli.tYE = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cli
 * JD-Core Version:    0.7.0.1
 */