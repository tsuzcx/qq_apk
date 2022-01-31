package com.tencent.mm.protocal.c;

public final class aps
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kSC;
  public String kVn;
  public String tlJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kSC != null) {
        paramVarArgs.d(1, this.kSC);
      }
      if (this.bGw != null) {
        paramVarArgs.d(2, this.bGw);
      }
      if (this.tlJ != null) {
        paramVarArgs.d(3, this.tlJ);
      }
      if (this.kVn != null) {
        paramVarArgs.d(4, this.kVn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kSC == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.kSC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bGw);
      }
      i = paramInt;
      if (this.tlJ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tlJ);
      }
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kVn);
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
        aps localaps = (aps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaps.kSC = locala.xpH.readString();
          return 0;
        case 2: 
          localaps.bGw = locala.xpH.readString();
          return 0;
        case 3: 
          localaps.tlJ = locala.xpH.readString();
          return 0;
        }
        localaps.kVn = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aps
 * JD-Core Version:    0.7.0.1
 */