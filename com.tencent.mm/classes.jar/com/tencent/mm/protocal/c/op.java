package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class op
  extends blm
{
  public String kRX;
  public String kWm;
  public String kWx;
  public int pyo;
  public int sMb;
  public LinkedList<bml> sMc = new LinkedList();
  public String sMd;
  public String sMe;
  public int swS;
  
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
      paramVarArgs.gB(2, this.swS);
      if (this.kWm != null) {
        paramVarArgs.d(3, this.kWm);
      }
      if (this.kWx != null) {
        paramVarArgs.d(4, this.kWx);
      }
      if (this.kRX != null) {
        paramVarArgs.d(5, this.kRX);
      }
      paramVarArgs.gB(6, this.sMb);
      paramVarArgs.d(7, 8, this.sMc);
      if (this.sMd != null) {
        paramVarArgs.d(8, this.sMd);
      }
      if (this.sMe != null) {
        paramVarArgs.d(9, this.sMe);
      }
      paramVarArgs.gB(10, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.swS);
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kWm);
      }
      i = paramInt;
      if (this.kWx != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kWx);
      }
      paramInt = i;
      if (this.kRX != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kRX);
      }
      i = paramInt + d.a.a.a.gy(6, this.sMb) + d.a.a.a.c(7, 8, this.sMc);
      paramInt = i;
      if (this.sMd != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sMd);
      }
      i = paramInt;
      if (this.sMe != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sMe);
      }
      return i + d.a.a.a.gy(10, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sMc.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        op localop = (op)paramVarArgs[1];
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
            localop.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localop.swS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localop.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localop.kWx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localop.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localop.sMb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localop.sMc.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localop.sMd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localop.sMe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localop.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.op
 * JD-Core Version:    0.7.0.1
 */