package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bxi
  extends blm
{
  public int kSW;
  public int ndf;
  public int ndg;
  public bmk sPG;
  public int sRf;
  public String trv;
  public int tzA;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sPG == null) {
        throw new b("Not all required fields were included: Content");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.kSW);
      paramVarArgs.gB(3, this.tzA);
      if (this.sPG != null)
      {
        paramVarArgs.gD(4, this.sPG.btq());
        this.sPG.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.ndg);
      paramVarArgs.gB(6, this.ndf);
      if (this.trv != null) {
        paramVarArgs.d(7, this.trv);
      }
      paramVarArgs.gB(8, this.sRf);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label704;
      }
    }
    label704:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.kSW) + d.a.a.a.gy(3, this.tzA);
      paramInt = i;
      if (this.sPG != null) {
        paramInt = i + d.a.a.a.gA(4, this.sPG.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.ndg) + d.a.a.a.gy(6, this.ndf);
      paramInt = i;
      if (this.trv != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.trv);
      }
      return paramInt + d.a.a.a.gy(8, this.sRf);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sPG != null) {
          break;
        }
        throw new b("Not all required fields were included: Content");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bxi localbxi = (bxi)paramVarArgs[1];
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
            localbxi.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbxi.kSW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbxi.tzA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbxi.sPG = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbxi.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbxi.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbxi.trv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbxi.sRf = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxi
 * JD-Core Version:    0.7.0.1
 */