package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class fe
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public int syS;
  public bfh syT;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.gB(2, this.syS);
      if (this.syT != null)
      {
        paramVarArgs.gD(3, this.syT.btq());
        this.syT.a(paramVarArgs);
      }
      if (this.bOL != null) {
        paramVarArgs.d(10, this.bOL);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.syS);
      paramInt = i;
      if (this.syT != null) {
        paramInt = i + d.a.a.a.gA(3, this.syT.btq());
      }
      i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.bOL);
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
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        fe localfe = (fe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localfe.username = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localfe.syS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bfh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localfe.syT = ((bfh)localObject1);
            paramInt += 1;
          }
        }
        localfe.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fe
 * JD-Core Version:    0.7.0.1
 */