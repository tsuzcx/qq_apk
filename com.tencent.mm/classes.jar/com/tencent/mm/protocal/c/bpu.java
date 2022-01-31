package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bpu
  extends blm
{
  public String kVs;
  public int pyo;
  public ato sQj;
  public int tHv;
  
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
      if (this.sQj != null)
      {
        paramVarArgs.gD(2, this.sQj.btq());
        this.sQj.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tHv);
      paramVarArgs.gB(4, this.pyo);
      if (this.kVs != null) {
        paramVarArgs.d(5, this.kVs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label583;
      }
    }
    label583:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sQj != null) {
        i = paramInt + d.a.a.a.gA(2, this.sQj.btq());
      }
      i = i + d.a.a.a.gy(3, this.tHv) + d.a.a.a.gy(4, this.pyo);
      paramInt = i;
      if (this.kVs != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kVs);
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
        if (this.sQj != null) {
          break;
        }
        throw new b("Not all required fields were included: Loc");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bpu localbpu = (bpu)paramVarArgs[1];
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
            localbpu.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ato();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ato)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbpu.sQj = ((ato)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbpu.tHv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbpu.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbpu.kVs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bpu
 * JD-Core Version:    0.7.0.1
 */