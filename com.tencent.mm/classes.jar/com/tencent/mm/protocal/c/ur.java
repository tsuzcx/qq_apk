package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ur
  extends blm
{
  public String jxi;
  public String sAY;
  public String sBC;
  public bmk sBt;
  public String sRo;
  public String sRp;
  public int sRq;
  public String syH;
  public int syV;
  
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
      paramVarArgs.gB(3, this.syV);
      if (this.sAY != null) {
        paramVarArgs.d(4, this.sAY);
      }
      if (this.jxi != null) {
        paramVarArgs.d(5, this.jxi);
      }
      if (this.sBC != null) {
        paramVarArgs.d(6, this.sBC);
      }
      if (this.sRo != null) {
        paramVarArgs.d(7, this.sRo);
      }
      if (this.syH != null) {
        paramVarArgs.d(8, this.syH);
      }
      if (this.sRp != null) {
        paramVarArgs.d(9, this.sRp);
      }
      paramVarArgs.gB(10, this.sRq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label870;
      }
    }
    label870:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sBt != null) {
        i = paramInt + d.a.a.a.gA(2, this.sBt.btq());
      }
      i += d.a.a.a.gy(3, this.syV);
      paramInt = i;
      if (this.sAY != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sAY);
      }
      i = paramInt;
      if (this.jxi != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.jxi);
      }
      paramInt = i;
      if (this.sBC != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sBC);
      }
      i = paramInt;
      if (this.sRo != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sRo);
      }
      paramInt = i;
      if (this.syH != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.syH);
      }
      i = paramInt;
      if (this.sRp != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sRp);
      }
      return i + d.a.a.a.gy(10, this.sRq);
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
        ur localur = (ur)paramVarArgs[1];
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
            localur.tEX = ((gc)localObject1);
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
            localur.sBt = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localur.syV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localur.sAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localur.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localur.sBC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localur.sRo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localur.syH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localur.sRp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localur.sRq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ur
 * JD-Core Version:    0.7.0.1
 */