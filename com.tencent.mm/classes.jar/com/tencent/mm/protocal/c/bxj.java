package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bxj
  extends bly
{
  public int ndf;
  public int ndg;
  public int tNm;
  public LinkedList<bml> tNn = new LinkedList();
  public int tby;
  public int tbz;
  public int tzC;
  
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
      paramVarArgs.gB(2, this.ndg);
      paramVarArgs.gB(3, this.ndf);
      paramVarArgs.gB(4, this.tby);
      paramVarArgs.gB(5, this.tbz);
      paramVarArgs.gB(6, this.tNm);
      paramVarArgs.d(7, 8, this.tNn);
      paramVarArgs.gB(8, this.tzC);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label664;
      }
    }
    label664:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf) + d.a.a.a.gy(4, this.tby) + d.a.a.a.gy(5, this.tbz) + d.a.a.a.gy(6, this.tNm) + d.a.a.a.c(7, 8, this.tNn) + d.a.a.a.gy(8, this.tzC);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tNn.clear();
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
        bxj localbxj = (bxj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        int i;
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
            localbxj.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbxj.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbxj.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbxj.tby = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbxj.tbz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbxj.tNm = ((d.a.a.a.a)localObject1).xpH.oD();
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
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbxj.tNn.add(localObject1);
            paramInt += 1;
          }
        }
        localbxj.tzC = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxj
 * JD-Core Version:    0.7.0.1
 */