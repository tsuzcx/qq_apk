package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cbq
  extends bly
{
  public int ndm;
  public long ndp;
  public String sGQ;
  public String swQ;
  public int tQE;
  public int trB;
  
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
      if (this.swQ != null) {
        paramVarArgs.d(2, this.swQ);
      }
      paramVarArgs.gB(3, this.ndm);
      paramVarArgs.gB(4, this.trB);
      paramVarArgs.gB(5, this.tQE);
      paramVarArgs.Y(6, this.ndp);
      if (this.sGQ != null) {
        paramVarArgs.d(7, this.sGQ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.swQ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.swQ);
      }
      i = i + d.a.a.a.gy(3, this.ndm) + d.a.a.a.gy(4, this.trB) + d.a.a.a.gy(5, this.tQE) + d.a.a.a.X(6, this.ndp);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sGQ);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        cbq localcbq = (cbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localcbq.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcbq.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcbq.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcbq.trB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcbq.tQE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcbq.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localcbq.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbq
 * JD-Core Version:    0.7.0.1
 */