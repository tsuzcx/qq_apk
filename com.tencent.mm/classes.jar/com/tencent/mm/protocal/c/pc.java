package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class pc
  extends com.tencent.mm.bv.a
{
  public b sMN;
  public LinkedList<b> sMO = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sMN != null) {
        paramVarArgs.b(1, this.sMN);
      }
      paramVarArgs.d(2, 6, this.sMO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sMN == null) {
        break label222;
      }
    }
    label222:
    for (paramInt = d.a.a.a.a(1, this.sMN) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 6, this.sMO);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sMO.clear();
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
        pc localpc = (pc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localpc.sMN = locala.cUs();
          return 0;
        }
        localpc.sMO.add(locala.cUs());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pc
 * JD-Core Version:    0.7.0.1
 */