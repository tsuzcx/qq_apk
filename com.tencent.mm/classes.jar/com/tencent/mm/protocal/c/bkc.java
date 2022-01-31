package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bkc
  extends blm
{
  public int pyo;
  public bmk sBt;
  public String tDR;
  public String tDS;
  public String tbj;
  public long tbl;
  
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
      paramVarArgs.Y(2, this.tbl);
      if (this.tDR != null) {
        paramVarArgs.d(3, this.tDR);
      }
      if (this.tDS != null) {
        paramVarArgs.d(4, this.tDS);
      }
      if (this.tbj != null) {
        paramVarArgs.d(5, this.tbj);
      }
      if (this.sBt != null)
      {
        paramVarArgs.gD(6, this.sBt.btq());
        this.sBt.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label665;
      }
    }
    label665:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.tbl);
      paramInt = i;
      if (this.tDR != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tDR);
      }
      i = paramInt;
      if (this.tDS != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tDS);
      }
      paramInt = i;
      if (this.tbj != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tbj);
      }
      i = paramInt;
      if (this.sBt != null) {
        i = paramInt + d.a.a.a.gA(6, this.sBt.btq());
      }
      return i + d.a.a.a.gy(7, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        bkc localbkc = (bkc)paramVarArgs[1];
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
            localbkc.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbkc.tbl = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localbkc.tDR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbkc.tDS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbkc.tbj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbkc.sBt = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        localbkc.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bkc
 * JD-Core Version:    0.7.0.1
 */