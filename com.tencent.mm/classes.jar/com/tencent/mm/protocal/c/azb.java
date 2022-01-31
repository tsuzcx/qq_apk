package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class azb
  extends bly
{
  public int euw;
  public String nGV;
  public String nGW;
  public LinkedList<bzb> tec = new LinkedList();
  public com.tencent.mm.bv.b tuQ;
  public float tuU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.euw);
      paramVarArgs.d(3, 8, this.tec);
      if (this.tuQ != null) {
        paramVarArgs.b(4, this.tuQ);
      }
      paramVarArgs.m(5, this.tuU);
      if (this.nGV != null) {
        paramVarArgs.d(6, this.nGV);
      }
      if (this.nGW != null) {
        paramVarArgs.d(7, this.nGW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.euw) + d.a.a.a.c(3, 8, this.tec);
      paramInt = i;
      if (this.tuQ != null) {
        paramInt = i + d.a.a.a.a(4, this.tuQ);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(5) + 4);
      paramInt = i;
      if (this.nGV != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.nGV);
      }
      i = paramInt;
      if (this.nGW != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.nGW);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tec.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        azb localazb = (azb)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazb.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localazb.euw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazb.tec.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localazb.tuQ = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 5: 
          localazb.tuU = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 6: 
          localazb.nGV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localazb.nGW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azb
 * JD-Core Version:    0.7.0.1
 */