package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cfy
  extends blm
{
  public long tSJ;
  public cfx tTF;
  public cfx tVf;
  public cfx tVg;
  public cfx tVh;
  public cfx tVi;
  public int tVj;
  public LinkedList<bml> tVk = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tTF == null) {
        throw new b("Not all required fields were included: ReportData");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tTF != null)
      {
        paramVarArgs.gD(2, this.tTF.btq());
        this.tTF.a(paramVarArgs);
      }
      if (this.tVf != null)
      {
        paramVarArgs.gD(3, this.tVf.btq());
        this.tVf.a(paramVarArgs);
      }
      if (this.tVg != null)
      {
        paramVarArgs.gD(4, this.tVg.btq());
        this.tVg.a(paramVarArgs);
      }
      if (this.tVh != null)
      {
        paramVarArgs.gD(5, this.tVh.btq());
        this.tVh.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.tSJ);
      if (this.tVi != null)
      {
        paramVarArgs.gD(7, this.tVi.btq());
        this.tVi.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.tVj);
      paramVarArgs.d(9, 8, this.tVk);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1257;
      }
    }
    label1257:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tTF != null) {
        paramInt = i + d.a.a.a.gA(2, this.tTF.btq());
      }
      i = paramInt;
      if (this.tVf != null) {
        i = paramInt + d.a.a.a.gA(3, this.tVf.btq());
      }
      paramInt = i;
      if (this.tVg != null) {
        paramInt = i + d.a.a.a.gA(4, this.tVg.btq());
      }
      i = paramInt;
      if (this.tVh != null) {
        i = paramInt + d.a.a.a.gA(5, this.tVh.btq());
      }
      i += d.a.a.a.X(6, this.tSJ);
      paramInt = i;
      if (this.tVi != null) {
        paramInt = i + d.a.a.a.gA(7, this.tVi.btq());
      }
      return paramInt + d.a.a.a.gy(8, this.tVj) + d.a.a.a.c(9, 8, this.tVk);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tVk.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tTF != null) {
          break;
        }
        throw new b("Not all required fields were included: ReportData");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cfy localcfy = (cfy)paramVarArgs[1];
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
            localcfy.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfy.tTF = ((cfx)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfy.tVf = ((cfx)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfy.tVg = ((cfx)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfy.tVh = ((cfx)localObject1);
            paramInt += 1;
          }
        case 6: 
          localcfy.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfy.tVi = ((cfx)localObject1);
            paramInt += 1;
          }
        case 8: 
          localcfy.tVj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localcfy.tVk.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfy
 * JD-Core Version:    0.7.0.1
 */