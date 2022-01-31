package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bjz
  extends blm
{
  public int hQR;
  public int kTR;
  public String sTd;
  public ccg tDN;
  public byn tDO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tDN == null) {
        throw new b("Not all required fields were included: UserPosition");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sTd != null) {
        paramVarArgs.d(2, this.sTd);
      }
      paramVarArgs.gB(3, this.hQR);
      if (this.tDN != null)
      {
        paramVarArgs.gD(4, this.tDN.btq());
        this.tDN.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.kTR);
      if (this.tDO != null)
      {
        paramVarArgs.gD(6, this.tDO.btq());
        this.tDO.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label736;
      }
    }
    label736:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sTd != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sTd);
      }
      i += d.a.a.a.gy(3, this.hQR);
      paramInt = i;
      if (this.tDN != null) {
        paramInt = i + d.a.a.a.gA(4, this.tDN.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.kTR);
      paramInt = i;
      if (this.tDO != null) {
        paramInt = i + d.a.a.a.gA(6, this.tDO.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tDN != null) {
          break;
        }
        throw new b("Not all required fields were included: UserPosition");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bjz localbjz = (bjz)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbjz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbjz.sTd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbjz.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbjz.tDN = ((ccg)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbjz.kTR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byn();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localbjz.tDO = ((byn)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjz
 * JD-Core Version:    0.7.0.1
 */