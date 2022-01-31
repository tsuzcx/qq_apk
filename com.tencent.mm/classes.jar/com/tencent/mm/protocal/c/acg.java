package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class acg
  extends blm
{
  public int hQR;
  public int pyo;
  public bmk sBt;
  public String tbj;
  public int tbk;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.hQR);
      paramVarArgs.gB(3, this.pyo);
      if (this.tbj != null) {
        paramVarArgs.d(4, this.tbj);
      }
      if (this.sBt != null)
      {
        paramVarArgs.gD(5, this.sBt.btq());
        this.sBt.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.tbk);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQR) + d.a.a.a.gy(3, this.pyo);
      paramInt = i;
      if (this.tbj != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tbj);
      }
      i = paramInt;
      if (this.sBt != null) {
        i = paramInt + d.a.a.a.gA(5, this.sBt.btq());
      }
      return i + d.a.a.a.gy(6, this.tbk);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        acg localacg = (acg)paramVarArgs[1];
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
            localacg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localacg.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localacg.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localacg.tbj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localacg.sBt = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        localacg.tbk = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.acg
 * JD-Core Version:    0.7.0.1
 */