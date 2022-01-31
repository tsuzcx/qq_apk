package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bxg
  extends blm
{
  public String sign;
  public String tNl;
  public int tlp;
  public int tlq;
  public bmk tlr;
  public bmk tzn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tlr == null) {
        throw new b("Not all required fields were included: ReqText");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tlp);
      paramVarArgs.gB(3, this.tlq);
      if (this.tlr != null)
      {
        paramVarArgs.gD(4, this.tlr.btq());
        this.tlr.a(paramVarArgs);
      }
      if (this.tzn != null)
      {
        paramVarArgs.gD(5, this.tzn.btq());
        this.tzn.a(paramVarArgs);
      }
      if (this.sign != null) {
        paramVarArgs.d(6, this.sign);
      }
      if (this.tNl != null) {
        paramVarArgs.d(7, this.tNl);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label791;
      }
    }
    label791:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tlp) + d.a.a.a.gy(3, this.tlq);
      paramInt = i;
      if (this.tlr != null) {
        paramInt = i + d.a.a.a.gA(4, this.tlr.btq());
      }
      i = paramInt;
      if (this.tzn != null) {
        i = paramInt + d.a.a.a.gA(5, this.tzn.btq());
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sign);
      }
      i = paramInt;
      if (this.tNl != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tNl);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tlr != null) {
          break;
        }
        throw new b("Not all required fields were included: ReqText");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bxg localbxg = (bxg)paramVarArgs[1];
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
            localbxg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbxg.tlp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbxg.tlq = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localbxg.tlr = ((bmk)localObject1);
            paramInt += 1;
          }
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
            localbxg.tzn = ((bmk)localObject1);
            paramInt += 1;
          }
        case 6: 
          localbxg.sign = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbxg.tNl = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxg
 * JD-Core Version:    0.7.0.1
 */