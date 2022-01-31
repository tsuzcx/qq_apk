package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aea
  extends bly
{
  public int hQq;
  public int tcc;
  public int tcd;
  public int tce;
  public int tcf;
  public String tcg;
  public int tch;
  
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
      paramVarArgs.gB(2, this.hQq);
      paramVarArgs.gB(3, this.tcc);
      paramVarArgs.gB(4, this.tcd);
      paramVarArgs.gB(5, this.tce);
      paramVarArgs.gB(6, this.tcf);
      if (this.tcg != null) {
        paramVarArgs.d(7, this.tcg);
      }
      paramVarArgs.gB(8, this.tch);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQq) + d.a.a.a.gy(3, this.tcc) + d.a.a.a.gy(4, this.tcd) + d.a.a.a.gy(5, this.tce) + d.a.a.a.gy(6, this.tcf);
      paramInt = i;
      if (this.tcg != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tcg);
      }
      return paramInt + d.a.a.a.gy(8, this.tch);
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
        aea localaea = (aea)paramVarArgs[1];
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
            localaea.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaea.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localaea.tcc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localaea.tcd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localaea.tce = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localaea.tcf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localaea.tcg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaea.tch = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aea
 * JD-Core Version:    0.7.0.1
 */