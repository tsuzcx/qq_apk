package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cdp
  extends com.tencent.mm.bv.a
{
  public rn tSk;
  public boolean tSl = true;
  public cdm tSm;
  public String tSn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tSk != null)
      {
        paramVarArgs.gD(1, this.tSk.btq());
        this.tSk.a(paramVarArgs);
      }
      paramVarArgs.aA(2, this.tSl);
      if (this.tSm != null)
      {
        paramVarArgs.gD(3, this.tSm.btq());
        this.tSm.a(paramVarArgs);
      }
      if (this.tSn != null) {
        paramVarArgs.d(4, this.tSn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tSk == null) {
        break label509;
      }
    }
    label509:
    for (paramInt = d.a.a.a.gA(1, this.tSk.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 1);
      paramInt = i;
      if (this.tSm != null) {
        paramInt = i + d.a.a.a.gA(3, this.tSm.btq());
      }
      i = paramInt;
      if (this.tSn != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tSn);
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
        cdp localcdp = (cdp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcdp.tSk = ((rn)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcdp.tSl = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdm();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcdp.tSm = ((cdm)localObject1);
            paramInt += 1;
          }
        }
        localcdp.tSn = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdp
 * JD-Core Version:    0.7.0.1
 */