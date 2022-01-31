package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aoy
  extends com.tencent.mm.bv.a
{
  public gb tkL;
  public lh tkM;
  public awj tkN;
  public bvx tkO;
  public bnb tkP;
  public qx tkQ;
  public zb tkR;
  public zs tkS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tkL != null)
      {
        paramVarArgs.gD(1, this.tkL.btq());
        this.tkL.a(paramVarArgs);
      }
      if (this.tkM != null)
      {
        paramVarArgs.gD(2, this.tkM.btq());
        this.tkM.a(paramVarArgs);
      }
      if (this.tkN != null)
      {
        paramVarArgs.gD(3, this.tkN.btq());
        this.tkN.a(paramVarArgs);
      }
      if (this.tkO != null)
      {
        paramVarArgs.gD(4, this.tkO.btq());
        this.tkO.a(paramVarArgs);
      }
      if (this.tkP != null)
      {
        paramVarArgs.gD(6, this.tkP.btq());
        this.tkP.a(paramVarArgs);
      }
      if (this.tkQ != null)
      {
        paramVarArgs.gD(7, this.tkQ.btq());
        this.tkQ.a(paramVarArgs);
      }
      if (this.tkR != null)
      {
        paramVarArgs.gD(8, this.tkR.btq());
        this.tkR.a(paramVarArgs);
      }
      if (this.tkS != null)
      {
        paramVarArgs.gD(9, this.tkS.btq());
        this.tkS.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tkL == null) {
        break label1312;
      }
    }
    label1312:
    for (int i = d.a.a.a.gA(1, this.tkL.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tkM != null) {
        paramInt = i + d.a.a.a.gA(2, this.tkM.btq());
      }
      i = paramInt;
      if (this.tkN != null) {
        i = paramInt + d.a.a.a.gA(3, this.tkN.btq());
      }
      paramInt = i;
      if (this.tkO != null) {
        paramInt = i + d.a.a.a.gA(4, this.tkO.btq());
      }
      i = paramInt;
      if (this.tkP != null) {
        i = paramInt + d.a.a.a.gA(6, this.tkP.btq());
      }
      paramInt = i;
      if (this.tkQ != null) {
        paramInt = i + d.a.a.a.gA(7, this.tkQ.btq());
      }
      i = paramInt;
      if (this.tkR != null) {
        i = paramInt + d.a.a.a.gA(8, this.tkR.btq());
      }
      paramInt = i;
      if (this.tkS != null) {
        paramInt = i + d.a.a.a.gA(9, this.tkS.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aoy localaoy = (aoy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaoy.tkL = ((gb)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaoy.tkM = ((lh)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaoy.tkN = ((awj)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaoy.tkO = ((bvx)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaoy.tkP = ((bnb)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaoy.tkQ = ((qx)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaoy.tkR = ((zb)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zs();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaoy.tkS = ((zs)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aoy
 * JD-Core Version:    0.7.0.1
 */