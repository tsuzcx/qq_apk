package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class awp
  extends com.tencent.mm.bv.a
{
  public String jkV;
  public LinkedList<String> tth = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jkV != null) {
        paramVarArgs.d(1, this.jkV);
      }
      paramVarArgs.d(2, 1, this.tth);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jkV == null) {
        break label228;
      }
    }
    label228:
    for (paramInt = d.a.a.b.b.a.e(1, this.jkV) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.c(2, 1, this.tth);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tth.clear();
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
        awp localawp = (awp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localawp.jkV = locala.xpH.readString();
          return 0;
        }
        localawp.tth.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awp
 * JD-Core Version:    0.7.0.1
 */