package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ath
  extends blm
{
  public String euK;
  public int tgK;
  public clr toO;
  public cmv toP;
  public cmq toQ;
  public cnk toR;
  public cmu toS;
  public cmw toT;
  public int toU;
  
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
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.toO != null)
      {
        paramVarArgs.gD(3, this.toO.btq());
        this.toO.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.tgK);
      if (this.toP != null)
      {
        paramVarArgs.gD(5, this.toP.btq());
        this.toP.a(paramVarArgs);
      }
      if (this.toQ != null)
      {
        paramVarArgs.gD(6, this.toQ.btq());
        this.toQ.a(paramVarArgs);
      }
      if (this.toR != null)
      {
        paramVarArgs.gD(7, this.toR.btq());
        this.toR.a(paramVarArgs);
      }
      if (this.toS != null)
      {
        paramVarArgs.gD(8, this.toS.btq());
        this.toS.a(paramVarArgs);
      }
      if (this.toT != null)
      {
        paramVarArgs.gD(9, this.toT.btq());
        this.toT.a(paramVarArgs);
      }
      paramVarArgs.gB(10, this.toU);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1296;
      }
    }
    label1296:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.toO != null) {
        i = paramInt + d.a.a.a.gA(3, this.toO.btq());
      }
      i += d.a.a.a.gy(4, this.tgK);
      paramInt = i;
      if (this.toP != null) {
        paramInt = i + d.a.a.a.gA(5, this.toP.btq());
      }
      i = paramInt;
      if (this.toQ != null) {
        i = paramInt + d.a.a.a.gA(6, this.toQ.btq());
      }
      paramInt = i;
      if (this.toR != null) {
        paramInt = i + d.a.a.a.gA(7, this.toR.btq());
      }
      i = paramInt;
      if (this.toS != null) {
        i = paramInt + d.a.a.a.gA(8, this.toS.btq());
      }
      paramInt = i;
      if (this.toT != null) {
        paramInt = i + d.a.a.a.gA(9, this.toT.btq());
      }
      return paramInt + d.a.a.a.gy(10, this.toU);
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
        ath localath = (ath)paramVarArgs[1];
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
            localath.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localath.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localath.toO = ((clr)localObject1);
            paramInt += 1;
          }
        case 4: 
          localath.tgK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localath.toP = ((cmv)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localath.toQ = ((cmq)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localath.toR = ((cnk)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localath.toS = ((cmu)localObject1);
            paramInt += 1;
          }
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localath.toT = ((cmw)localObject1);
            paramInt += 1;
          }
        }
        localath.toU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ath
 * JD-Core Version:    0.7.0.1
 */