package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class byc
  extends com.tencent.mm.bv.a
{
  public String kVs;
  public int tDg;
  public LinkedList<String> tDi = new LinkedList();
  public long tOf;
  public int tOg;
  public int tcY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kVs != null) {
        paramVarArgs.d(1, this.kVs);
      }
      paramVarArgs.Y(2, this.tOf);
      paramVarArgs.gB(3, this.tDg);
      paramVarArgs.gB(4, this.tOg);
      paramVarArgs.gB(5, this.tcY);
      paramVarArgs.d(6, 1, this.tDi);
      return 0;
    }
    if (paramInt == 1) {
      if (this.kVs == null) {
        break label372;
      }
    }
    label372:
    for (paramInt = d.a.a.b.b.a.e(1, this.kVs) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.X(2, this.tOf) + d.a.a.a.gy(3, this.tDg) + d.a.a.a.gy(4, this.tOg) + d.a.a.a.gy(5, this.tcY) + d.a.a.a.c(6, 1, this.tDi);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tDi.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        byc localbyc = (byc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbyc.kVs = locala.xpH.readString();
          return 0;
        case 2: 
          localbyc.tOf = locala.xpH.oE();
          return 0;
        case 3: 
          localbyc.tDg = locala.xpH.oD();
          return 0;
        case 4: 
          localbyc.tOg = locala.xpH.oD();
          return 0;
        case 5: 
          localbyc.tcY = locala.xpH.oD();
          return 0;
        }
        localbyc.tDi.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byc
 * JD-Core Version:    0.7.0.1
 */