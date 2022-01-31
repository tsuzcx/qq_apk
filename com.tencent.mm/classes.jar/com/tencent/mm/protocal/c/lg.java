package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class lg
  extends bly
{
  public String kWm;
  public String kWn;
  public int mPL;
  public long ndp;
  public String sGF;
  public String sGQ;
  public String sGU;
  
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
      if (this.sGF != null) {
        paramVarArgs.d(3, this.sGF);
      }
      if (this.kWn != null) {
        paramVarArgs.d(4, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(5, this.kWm);
      }
      paramVarArgs.gB(9, this.mPL);
      paramVarArgs.Y(10, this.ndp);
      if (this.sGQ != null) {
        paramVarArgs.d(11, this.sGQ);
      }
      if (this.sGU != null) {
        paramVarArgs.d(12, this.sGU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label682;
      }
    }
    label682:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sGF != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sGF);
      }
      i = paramInt;
      if (this.kWn != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kWn);
      }
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kWm);
      }
      i = paramInt + d.a.a.a.gy(9, this.mPL) + d.a.a.a.X(10, this.ndp);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sGQ);
      }
      i = paramInt;
      if (this.sGU != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.sGU);
      }
      return i;
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
        lg locallg = (lg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 6: 
        case 7: 
        case 8: 
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
            locallg.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 3: 
          locallg.sGF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          locallg.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          locallg.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          locallg.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          locallg.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 11: 
          locallg.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        locallg.sGU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.lg
 * JD-Core Version:    0.7.0.1
 */