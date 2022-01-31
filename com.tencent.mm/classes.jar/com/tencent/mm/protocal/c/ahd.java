package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ahd
  extends blm
{
  public int pyo;
  public ato sQj;
  public String sYZ;
  public int syV;
  public bmk teH;
  public int teI;
  public int teJ;
  public LinkedList<bep> teK = new LinkedList();
  public int teL;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQj == null) {
        throw new b("Not all required fields were included: Loc");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.syV);
      paramVarArgs.gB(3, this.pyo);
      if (this.teH != null)
      {
        paramVarArgs.gD(4, this.teH.btq());
        this.teH.a(paramVarArgs);
      }
      if (this.sQj != null)
      {
        paramVarArgs.gD(5, this.sQj.btq());
        this.sQj.a(paramVarArgs);
      }
      if (this.sYZ != null) {
        paramVarArgs.d(6, this.sYZ);
      }
      paramVarArgs.gB(7, this.teI);
      paramVarArgs.gB(8, this.teJ);
      paramVarArgs.d(11, 8, this.teK);
      paramVarArgs.gB(12, this.teL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.syV) + d.a.a.a.gy(3, this.pyo);
      paramInt = i;
      if (this.teH != null) {
        paramInt = i + d.a.a.a.gA(4, this.teH.btq());
      }
      i = paramInt;
      if (this.sQj != null) {
        i = paramInt + d.a.a.a.gA(5, this.sQj.btq());
      }
      paramInt = i;
      if (this.sYZ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sYZ);
      }
      return paramInt + d.a.a.a.gy(7, this.teI) + d.a.a.a.gy(8, this.teJ) + d.a.a.a.c(11, 8, this.teK) + d.a.a.a.gy(12, this.teL);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.teK.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sQj != null) {
          break;
        }
        throw new b("Not all required fields were included: Loc");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ahd localahd = (ahd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        case 10: 
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
            localahd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localahd.syV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localahd.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localahd.teH = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ato();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ato)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localahd.sQj = ((ato)localObject1);
            paramInt += 1;
          }
        case 6: 
          localahd.sYZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localahd.teI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localahd.teJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bep();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bep)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localahd.teK.add(localObject1);
            paramInt += 1;
          }
        }
        localahd.teL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ahd
 * JD-Core Version:    0.7.0.1
 */