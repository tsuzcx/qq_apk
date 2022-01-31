package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bmy
  extends blm
{
  public int pyo;
  public bfa tGc;
  public float tGd;
  public float tGe;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tGc == null) {
        throw new b("Not all required fields were included: UserPos");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tGc != null)
      {
        paramVarArgs.gD(2, this.tGc.btq());
        this.tGc.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.pyo);
      paramVarArgs.m(4, this.tGd);
      paramVarArgs.m(5, this.tGe);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label559;
      }
    }
    label559:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tGc != null) {
        i = paramInt + d.a.a.a.gA(2, this.tGc.btq());
      }
      return i + d.a.a.a.gy(3, this.pyo) + (d.a.a.b.b.a.dQ(4) + 4) + (d.a.a.b.b.a.dQ(5) + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tGc != null) {
          break;
        }
        throw new b("Not all required fields were included: UserPos");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bmy localbmy = (bmy)paramVarArgs[1];
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
            localbmy.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfa();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfa)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbmy.tGc = ((bfa)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbmy.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbmy.tGd = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        }
        localbmy.tGe = ((d.a.a.a.a)localObject1).xpH.readFloat();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bmy
 * JD-Core Version:    0.7.0.1
 */