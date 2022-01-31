package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bmd
  extends blm
{
  public String kWm;
  public String kWn;
  public int mPL;
  public String swQ;
  public int tFB;
  public int tFC;
  public int tFD;
  public long tFE;
  
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
      if (this.swQ != null) {
        paramVarArgs.d(2, this.swQ);
      }
      paramVarArgs.gB(3, this.tFB);
      paramVarArgs.gB(4, this.mPL);
      paramVarArgs.gB(5, this.tFC);
      if (this.kWn != null) {
        paramVarArgs.d(6, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(7, this.kWm);
      }
      paramVarArgs.gB(8, this.tFD);
      paramVarArgs.Y(9, this.tFE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label633;
      }
    }
    label633:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.swQ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.swQ);
      }
      i = i + d.a.a.a.gy(3, this.tFB) + d.a.a.a.gy(4, this.mPL) + d.a.a.a.gy(5, this.tFC);
      paramInt = i;
      if (this.kWn != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kWn);
      }
      i = paramInt;
      if (this.kWm != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.kWm);
      }
      return i + d.a.a.a.gy(8, this.tFD) + d.a.a.a.X(9, this.tFE);
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
        bmd localbmd = (bmd)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbmd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbmd.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbmd.tFB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbmd.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbmd.tFC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbmd.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbmd.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbmd.tFD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbmd.tFE = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bmd
 * JD-Core Version:    0.7.0.1
 */