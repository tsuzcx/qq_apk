package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bra
  extends bly
{
  public int hPS;
  public String mSC;
  public int sze;
  public LinkedList<bqy> tHM = new LinkedList();
  public int tHN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.hPS);
      paramVarArgs.d(3, 8, this.tHM);
      if (this.mSC != null) {
        paramVarArgs.d(4, this.mSC);
      }
      paramVarArgs.gB(5, this.tHN);
      paramVarArgs.gB(6, this.sze);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hPS) + d.a.a.a.c(3, 8, this.tHM);
      paramInt = i;
      if (this.mSC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.mSC);
      }
      return paramInt + d.a.a.a.gy(5, this.tHN) + d.a.a.a.gy(6, this.sze);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tHM.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bra localbra = (bra)paramVarArgs[1];
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
            localbra.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbra.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqy();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbra.tHM.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localbra.mSC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbra.tHN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbra.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bra
 * JD-Core Version:    0.7.0.1
 */