package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aqm
  extends blm
{
  public int dne;
  public LinkedList<awh> svo = new LinkedList();
  public bml svp;
  public int tmu;
  public String tmv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svp == null) {
        throw new b("Not all required fields were included: ChatRoomName");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.dne);
      paramVarArgs.d(3, 8, this.svo);
      if (this.svp != null)
      {
        paramVarArgs.gD(4, this.svp.btq());
        this.svp.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tmu);
      if (this.tmv != null) {
        paramVarArgs.d(6, this.tmv);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label720;
      }
    }
    label720:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.dne) + d.a.a.a.c(3, 8, this.svo);
      paramInt = i;
      if (this.svp != null) {
        paramInt = i + d.a.a.a.gA(4, this.svp.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.tmu);
      paramInt = i;
      if (this.tmv != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tmv);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.svo.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.svp != null) {
          break;
        }
        throw new b("Not all required fields were included: ChatRoomName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aqm localaqm = (aqm)paramVarArgs[1];
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
            localaqm.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaqm.dne = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaqm.svo.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaqm.svp = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          localaqm.tmu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaqm.tmv = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqm
 * JD-Core Version:    0.7.0.1
 */