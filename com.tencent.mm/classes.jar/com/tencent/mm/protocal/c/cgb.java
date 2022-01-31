package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cgb
  extends blm
{
  public int sIh;
  public bmk sIi;
  public int sST;
  public long sSU;
  public String tAY;
  public long tSJ;
  public cey tVl;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sIi == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      if (this.tVl == null) {
        throw new b("Not all required fields were included: OpLog");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tAY != null) {
        paramVarArgs.d(2, this.tAY);
      }
      paramVarArgs.gB(3, this.sST);
      if (this.sIi != null)
      {
        paramVarArgs.gD(4, this.sIi.btq());
        this.sIi.a(paramVarArgs);
      }
      if (this.tVl != null)
      {
        paramVarArgs.gD(5, this.tVl.btq());
        this.tVl.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.sSU);
      paramVarArgs.gB(7, this.sIh);
      paramVarArgs.Y(8, this.tSJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label846;
      }
    }
    label846:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tAY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tAY);
      }
      i += d.a.a.a.gy(3, this.sST);
      paramInt = i;
      if (this.sIi != null) {
        paramInt = i + d.a.a.a.gA(4, this.sIi.btq());
      }
      i = paramInt;
      if (this.tVl != null) {
        i = paramInt + d.a.a.a.gA(5, this.tVl.btq());
      }
      return i + d.a.a.a.X(6, this.sSU) + d.a.a.a.gy(7, this.sIh) + d.a.a.a.X(8, this.tSJ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sIi == null) {
          throw new b("Not all required fields were included: KeyBuf");
        }
        if (this.tVl != null) {
          break;
        }
        throw new b("Not all required fields were included: OpLog");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cgb localcgb = (cgb)paramVarArgs[1];
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
            localcgb.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcgb.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcgb.sST = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localcgb.sIi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cey();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cey)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcgb.tVl = ((cey)localObject1);
            paramInt += 1;
          }
        case 6: 
          localcgb.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          localcgb.sIh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcgb.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cgb
 * JD-Core Version:    0.7.0.1
 */