package com.tencent.mm.protocal.c;

public final class clm
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String ndQ;
  public String tYI;
  public String tYJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tYI != null) {
        paramVarArgs.d(1, this.tYI);
      }
      if (this.bQZ != null) {
        paramVarArgs.d(2, this.bQZ);
      }
      if (this.ndQ != null) {
        paramVarArgs.d(3, this.ndQ);
      }
      if (this.tYJ != null) {
        paramVarArgs.d(4, this.tYJ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tYI == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.tYI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bQZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bQZ);
      }
      i = paramInt;
      if (this.ndQ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ndQ);
      }
      paramInt = i;
      if (this.tYJ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tYJ);
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
        clm localclm = (clm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localclm.tYI = locala.xpH.readString();
          return 0;
        case 2: 
          localclm.bQZ = locala.xpH.readString();
          return 0;
        case 3: 
          localclm.ndQ = locala.xpH.readString();
          return 0;
        }
        localclm.tYJ = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clm
 * JD-Core Version:    0.7.0.1
 */