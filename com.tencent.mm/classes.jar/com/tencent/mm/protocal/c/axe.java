package com.tencent.mm.protocal.c;

public final class axe
  extends com.tencent.mm.bv.a
{
  public String kRN;
  public String ttJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ttJ != null) {
        paramVarArgs.d(1, this.ttJ);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ttJ == null) {
        break label234;
      }
    }
    label234:
    for (paramInt = d.a.a.b.b.a.e(1, this.ttJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kRN != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kRN);
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
        axe localaxe = (axe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaxe.ttJ = locala.xpH.readString();
          return 0;
        }
        localaxe.kRN = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axe
 * JD-Core Version:    0.7.0.1
 */