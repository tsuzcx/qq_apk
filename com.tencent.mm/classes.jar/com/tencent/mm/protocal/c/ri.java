package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ri
  extends com.tencent.mm.bv.a
{
  public String sMR;
  public LinkedList<Integer> sPm = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sMR != null) {
        paramVarArgs.d(1, this.sMR);
      }
      paramVarArgs.d(2, 2, this.sPm);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sMR == null) {
        break label231;
      }
    }
    label231:
    for (paramInt = d.a.a.b.b.a.e(1, this.sMR) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 2, this.sPm);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sPm.clear();
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
        ri localri = (ri)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localri.sMR = locala.xpH.readString();
          return 0;
        }
        localri.sPm.add(Integer.valueOf(locala.xpH.oD()));
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ri
 * JD-Core Version:    0.7.0.1
 */