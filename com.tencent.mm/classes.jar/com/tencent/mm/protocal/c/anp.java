package com.tencent.mm.protocal.c;

public final class anp
  extends com.tencent.mm.bv.a
{
  public String sRX;
  public String tjI;
  public String tjJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sRX != null) {
        paramVarArgs.d(1, this.sRX);
      }
      if (this.tjI != null) {
        paramVarArgs.d(2, this.tjI);
      }
      if (this.tjJ != null) {
        paramVarArgs.d(3, this.tjJ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sRX == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.sRX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tjI != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tjI);
      }
      i = paramInt;
      if (this.tjJ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tjJ);
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
        anp localanp = (anp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localanp.sRX = locala.xpH.readString();
          return 0;
        case 2: 
          localanp.tjI = locala.xpH.readString();
          return 0;
        }
        localanp.tjJ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.anp
 * JD-Core Version:    0.7.0.1
 */