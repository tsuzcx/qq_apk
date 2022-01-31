package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bfn
  extends blm
{
  public String kWx;
  public int mPQ;
  public String syc;
  public String tAh;
  public String tAi;
  public int tAj;
  
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
      if (this.syc != null) {
        paramVarArgs.d(2, this.syc);
      }
      if (this.tAh != null) {
        paramVarArgs.d(3, this.tAh);
      }
      if (this.tAi != null) {
        paramVarArgs.d(4, this.tAi);
      }
      paramVarArgs.gB(5, this.mPQ);
      if (this.kWx != null) {
        paramVarArgs.d(7, this.kWx);
      }
      paramVarArgs.gB(8, this.tAj);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label575;
      }
    }
    label575:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.syc);
      }
      i = paramInt;
      if (this.tAh != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tAh);
      }
      paramInt = i;
      if (this.tAi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tAi);
      }
      i = paramInt + d.a.a.a.gy(5, this.mPQ);
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.kWx);
      }
      return paramInt + d.a.a.a.gy(8, this.tAj);
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
        bfn localbfn = (bfn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbfn.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbfn.syc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbfn.tAh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbfn.tAi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbfn.mPQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbfn.kWx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbfn.tAj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfn
 * JD-Core Version:    0.7.0.1
 */