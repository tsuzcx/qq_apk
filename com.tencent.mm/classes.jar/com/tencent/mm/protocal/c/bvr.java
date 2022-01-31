package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bvr
  extends blm
{
  public String kWm;
  public String kWn;
  public String swQ;
  public int tMt;
  public int tMu;
  public LinkedList<bvt> tMv = new LinkedList();
  public bvq tMw;
  public int tMx;
  public LinkedList<bvq> tMy = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tMt);
      if (this.kWn != null) {
        paramVarArgs.d(3, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(4, this.kWm);
      }
      if (this.swQ != null) {
        paramVarArgs.d(5, this.swQ);
      }
      paramVarArgs.gB(6, this.tMu);
      paramVarArgs.d(7, 8, this.tMv);
      if (this.tMw != null)
      {
        paramVarArgs.gD(8, this.tMw.btq());
        this.tMw.a(paramVarArgs);
      }
      paramVarArgs.gB(9, this.tMx);
      paramVarArgs.d(10, 8, this.tMy);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tMt);
      paramInt = i;
      if (this.kWn != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kWn);
      }
      i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kWm);
      }
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.swQ);
      }
      i = paramInt + d.a.a.a.gy(6, this.tMu) + d.a.a.a.c(7, 8, this.tMv);
      paramInt = i;
      if (this.tMw != null) {
        paramInt = i + d.a.a.a.gA(8, this.tMw.btq());
      }
      return paramInt + d.a.a.a.gy(9, this.tMx) + d.a.a.a.c(10, 8, this.tMy);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tMv.clear();
        this.tMy.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bvr localbvr = (bvr)paramVarArgs[1];
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
            localbvr.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbvr.tMt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbvr.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbvr.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbvr.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbvr.tMu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbvr.tMv.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbvr.tMw = ((bvq)localObject1);
            paramInt += 1;
          }
        case 9: 
          localbvr.tMx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localbvr.tMy.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvr
 * JD-Core Version:    0.7.0.1
 */