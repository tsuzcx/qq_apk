package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class afc
  extends bly
{
  public int hPS;
  public LinkedList<vh> hPT = new LinkedList();
  public int tcS;
  public String tcT;
  public int tcU;
  
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
      paramVarArgs.d(3, 8, this.hPT);
      paramVarArgs.gB(4, this.tcS);
      if (this.tcT != null) {
        paramVarArgs.d(5, this.tcT);
      }
      paramVarArgs.gB(6, this.tcU);
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
      int i = paramInt + d.a.a.a.gy(2, this.hPS) + d.a.a.a.c(3, 8, this.hPT) + d.a.a.a.gy(4, this.tcS);
      paramInt = i;
      if (this.tcT != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tcT);
      }
      return paramInt + d.a.a.a.gy(6, this.tcU);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.hPT.clear();
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
        afc localafc = (afc)paramVarArgs[1];
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
            localafc.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafc.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafc.hPT.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localafc.tcS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localafc.tcT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localafc.tcU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afc
 * JD-Core Version:    0.7.0.1
 */