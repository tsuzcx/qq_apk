package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cmm
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b sCF;
  public LinkedList<cmj> sCG = new LinkedList();
  public String tMY;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tMY == null) {
        throw new d.a.a.b("Not all required fields were included: WxaUserName");
      }
      if (this.tMY != null) {
        paramVarArgs.d(1, this.tMY);
      }
      if (this.sCF != null) {
        paramVarArgs.b(2, this.sCF);
      }
      paramVarArgs.d(3, 8, this.sCG);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tMY == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = d.a.a.b.b.a.e(1, this.tMY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sCF != null) {
        i = paramInt + d.a.a.a.a(2, this.sCF);
      }
      return i + d.a.a.a.c(3, 8, this.sCG);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sCG.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tMY != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: WxaUserName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cmm localcmm = (cmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcmm.tMY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localcmm.sCF = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmj();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cmj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcmm.sCG.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmm
 * JD-Core Version:    0.7.0.1
 */