package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class azf
  extends com.tencent.mm.bv.a
{
  public int pyo;
  public int sIh;
  public bmk sIi;
  public String syI;
  public qw tvu;
  public int tvv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tvu == null) {
        throw new b("Not all required fields were included: Oplog");
      }
      if (this.sIi == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      if (this.tvu != null)
      {
        paramVarArgs.gD(1, this.tvu.btq());
        this.tvu.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.sIh);
      if (this.sIi != null)
      {
        paramVarArgs.gD(3, this.sIi.btq());
        this.sIi.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.pyo);
      if (this.syI != null) {
        paramVarArgs.d(5, this.syI);
      }
      paramVarArgs.gB(6, this.tvv);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tvu == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = d.a.a.a.gA(1, this.tvu.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sIh);
      paramInt = i;
      if (this.sIi != null) {
        paramInt = i + d.a.a.a.gA(3, this.sIi.btq());
      }
      i = paramInt + d.a.a.a.gy(4, this.pyo);
      paramInt = i;
      if (this.syI != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.syI);
      }
      return paramInt + d.a.a.a.gy(6, this.tvv);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tvu == null) {
          throw new b("Not all required fields were included: Oplog");
        }
        if (this.sIi != null) {
          break;
        }
        throw new b("Not all required fields were included: KeyBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        azf localazf = (azf)paramVarArgs[1];
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
            localObject1 = new qw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localazf.tvu = ((qw)localObject1);
            paramInt += 1;
          }
        case 2: 
          localazf.sIh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localazf.sIi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localazf.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localazf.syI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localazf.tvv = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azf
 * JD-Core Version:    0.7.0.1
 */