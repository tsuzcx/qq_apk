package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bep
  extends com.tencent.mm.bv.a
{
  public ato sQj;
  public int sSK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQj != null)
      {
        paramVarArgs.gD(1, this.sQj.btq());
        this.sQj.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.sSK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sQj == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.a.gA(1, this.sQj.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.sSK);
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
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bep localbep = (bep)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ato();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ato)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbep.sQj = ((ato)localObject1);
            paramInt += 1;
          }
        }
        localbep.sSK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bep
 * JD-Core Version:    0.7.0.1
 */