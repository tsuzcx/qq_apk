package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class lj
  extends com.tencent.mm.bv.a
{
  public String sHc;
  public LinkedList<String> sHd = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sHc != null) {
        paramVarArgs.d(1, this.sHc);
      }
      paramVarArgs.d(2, 1, this.sHd);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sHc == null) {
        break label228;
      }
    }
    label228:
    for (paramInt = d.a.a.b.b.a.e(1, this.sHc) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 1, this.sHd);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sHd.clear();
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
        lj locallj = (lj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locallj.sHc = locala.xpH.readString();
          return 0;
        }
        locallj.sHd.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lj
 * JD-Core Version:    0.7.0.1
 */