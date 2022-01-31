package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aku
  extends blm
{
  public String hRf;
  public String jxi;
  public bmk sBt;
  public String syH;
  public String tgR;
  public String tgS;
  public String tgT;
  public String tgU;
  public String tgV;
  public int tgW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sBt == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sBt != null)
      {
        paramVarArgs.gD(2, this.sBt.btq());
        this.sBt.a(paramVarArgs);
      }
      if (this.tgR != null) {
        paramVarArgs.d(3, this.tgR);
      }
      if (this.tgS != null) {
        paramVarArgs.d(4, this.tgS);
      }
      if (this.hRf != null) {
        paramVarArgs.d(5, this.hRf);
      }
      if (this.tgT != null) {
        paramVarArgs.d(6, this.tgT);
      }
      if (this.tgU != null) {
        paramVarArgs.d(7, this.tgU);
      }
      if (this.tgV != null) {
        paramVarArgs.d(8, this.tgV);
      }
      paramVarArgs.gB(9, this.tgW);
      if (this.jxi != null) {
        paramVarArgs.d(10, this.jxi);
      }
      if (this.syH != null) {
        paramVarArgs.d(11, this.syH);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label945;
      }
    }
    label945:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sBt != null) {
        paramInt = i + d.a.a.a.gA(2, this.sBt.btq());
      }
      i = paramInt;
      if (this.tgR != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tgR);
      }
      paramInt = i;
      if (this.tgS != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tgS);
      }
      i = paramInt;
      if (this.hRf != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hRf);
      }
      paramInt = i;
      if (this.tgT != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tgT);
      }
      i = paramInt;
      if (this.tgU != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tgU);
      }
      paramInt = i;
      if (this.tgV != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tgV);
      }
      i = paramInt + d.a.a.a.gy(9, this.tgW);
      paramInt = i;
      if (this.jxi != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.jxi);
      }
      i = paramInt;
      if (this.syH != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.syH);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sBt != null) {
          break;
        }
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aku localaku = (aku)paramVarArgs[1];
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
            localaku.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaku.sBt = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localaku.tgR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaku.tgS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaku.hRf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaku.tgT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localaku.tgU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localaku.tgV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localaku.tgW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localaku.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaku.syH = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aku
 * JD-Core Version:    0.7.0.1
 */