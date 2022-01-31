package com.tencent.mm.protocal.c;

public final class avo
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String lRE;
  public String lRF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bQZ != null) {
        paramVarArgs.d(1, this.bQZ);
      }
      if (this.lRE != null) {
        paramVarArgs.d(2, this.lRE);
      }
      if (this.lRF != null) {
        paramVarArgs.d(4, this.lRF);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bQZ == null) {
        break label293;
      }
    }
    label293:
    for (int i = d.a.a.b.b.a.e(1, this.bQZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lRE != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.lRE);
      }
      i = paramInt;
      if (this.lRF != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lRF);
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
        avo localavo = (avo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 3: 
        default: 
          return -1;
        case 1: 
          localavo.bQZ = locala.xpH.readString();
          return 0;
        case 2: 
          localavo.lRE = locala.xpH.readString();
          return 0;
        }
        localavo.lRF = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avo
 * JD-Core Version:    0.7.0.1
 */