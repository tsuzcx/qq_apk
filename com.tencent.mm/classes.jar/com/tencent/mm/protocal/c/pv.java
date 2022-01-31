package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class pv
  extends bly
{
  public int hQQ;
  public String jnU;
  public String sND;
  public int sNE;
  public LinkedList<bxy> sNF = new LinkedList();
  
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
      paramVarArgs.gB(2, this.hQQ);
      if (this.sND != null) {
        paramVarArgs.d(3, this.sND);
      }
      if (this.jnU != null) {
        paramVarArgs.d(4, this.jnU);
      }
      paramVarArgs.gB(5, this.sNE);
      paramVarArgs.d(6, 8, this.sNF);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.hQQ);
      paramInt = i;
      if (this.sND != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sND);
      }
      i = paramInt;
      if (this.jnU != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.jnU);
      }
      return i + d.a.a.a.gy(5, this.sNE) + d.a.a.a.c(6, 8, this.sNF);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sNF.clear();
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
        pv localpv = (pv)paramVarArgs[1];
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
            localpv.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localpv.hQQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localpv.sND = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localpv.jnU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localpv.sNE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localpv.sNF.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pv
 * JD-Core Version:    0.7.0.1
 */