package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cmg
  extends com.tencent.mm.bv.a
{
  public String tIu;
  public boolean tYS;
  public String tZh;
  public brv tZi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tZh != null) {
        paramVarArgs.d(1, this.tZh);
      }
      if (this.tIu != null) {
        paramVarArgs.d(2, this.tIu);
      }
      if (this.tZi != null)
      {
        paramVarArgs.gD(3, this.tZi.btq());
        this.tZi.a(paramVarArgs);
      }
      paramVarArgs.aA(4, this.tYS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tZh == null) {
        break label415;
      }
    }
    label415:
    for (int i = d.a.a.b.b.a.e(1, this.tZh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tIu != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tIu);
      }
      i = paramInt;
      if (this.tZi != null) {
        i = paramInt + d.a.a.a.gA(3, this.tZi.btq());
      }
      return i + (d.a.a.b.b.a.dQ(4) + 1);
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
        cmg localcmg = (cmg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcmg.tZh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localcmg.tIu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((brv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcmg.tZi = ((brv)localObject1);
            paramInt += 1;
          }
        }
        localcmg.tYS = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmg
 * JD-Core Version:    0.7.0.1
 */