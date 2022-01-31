package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class caz
  extends blm
{
  public int euw;
  public String hPY;
  public bmk ndi;
  public int sDT;
  public int sxP;
  public int sxS;
  public String tQb;
  public int tQc;
  public int tQd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ndi == null) {
        throw new b("Not all required fields were included: Data");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      if (this.ndi != null)
      {
        paramVarArgs.gD(3, this.ndi.btq());
        this.ndi.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.sDT);
      if (this.tQb != null) {
        paramVarArgs.d(5, this.tQb);
      }
      paramVarArgs.gB(6, this.euw);
      paramVarArgs.gB(7, this.tQc);
      paramVarArgs.gB(8, this.sxS);
      paramVarArgs.gB(9, this.tQd);
      paramVarArgs.gB(10, this.sxP);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label798;
      }
    }
    label798:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.ndi != null) {
        i = paramInt + d.a.a.a.gA(3, this.ndi.btq());
      }
      i += d.a.a.a.gy(4, this.sDT);
      paramInt = i;
      if (this.tQb != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tQb);
      }
      return paramInt + d.a.a.a.gy(6, this.euw) + d.a.a.a.gy(7, this.tQc) + d.a.a.a.gy(8, this.sxS) + d.a.a.a.gy(9, this.tQd) + d.a.a.a.gy(10, this.sxP);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ndi != null) {
          break;
        }
        throw new b("Not all required fields were included: Data");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        caz localcaz = (caz)paramVarArgs[1];
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
            localcaz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcaz.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcaz.ndi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localcaz.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcaz.tQb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localcaz.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcaz.tQc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcaz.sxS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcaz.tQd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcaz.sxP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.caz
 * JD-Core Version:    0.7.0.1
 */