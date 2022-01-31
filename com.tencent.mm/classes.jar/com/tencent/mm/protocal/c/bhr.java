package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bhr
  extends bly
{
  public int amount;
  public int iHq;
  public String iHr;
  public String kDH;
  public String nvA;
  public String nvB;
  public int state;
  public String tCq;
  public int tCr;
  public String tCs;
  public String tCt;
  public String tCu;
  public String tCv;
  
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
      paramVarArgs.gB(2, this.iHq);
      if (this.iHr != null) {
        paramVarArgs.d(3, this.iHr);
      }
      paramVarArgs.gB(4, this.state);
      if (this.tCq != null) {
        paramVarArgs.d(5, this.tCq);
      }
      paramVarArgs.gB(6, this.amount);
      paramVarArgs.gB(7, this.tCr);
      if (this.nvA != null) {
        paramVarArgs.d(8, this.nvA);
      }
      if (this.tCs != null) {
        paramVarArgs.d(9, this.tCs);
      }
      if (this.nvB != null) {
        paramVarArgs.d(10, this.nvB);
      }
      if (this.tCt != null) {
        paramVarArgs.d(11, this.tCt);
      }
      if (this.tCu != null) {
        paramVarArgs.d(12, this.tCu);
      }
      if (this.tCv != null) {
        paramVarArgs.d(14, this.tCv);
      }
      if (this.kDH != null) {
        paramVarArgs.d(15, this.kDH);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label976;
      }
    }
    label976:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt + d.a.a.a.gy(4, this.state);
      paramInt = i;
      if (this.tCq != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tCq);
      }
      i = paramInt + d.a.a.a.gy(6, this.amount) + d.a.a.a.gy(7, this.tCr);
      paramInt = i;
      if (this.nvA != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.nvA);
      }
      i = paramInt;
      if (this.tCs != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.tCs);
      }
      paramInt = i;
      if (this.nvB != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.nvB);
      }
      i = paramInt;
      if (this.tCt != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.tCt);
      }
      paramInt = i;
      if (this.tCu != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tCu);
      }
      i = paramInt;
      if (this.tCv != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.tCv);
      }
      paramInt = i;
      if (this.kDH != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.kDH);
      }
      return paramInt;
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
        bhr localbhr = (bhr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
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
            localbhr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbhr.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbhr.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbhr.state = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbhr.tCq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbhr.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbhr.tCr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbhr.nvA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbhr.tCs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbhr.nvB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbhr.tCt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localbhr.tCu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbhr.tCv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbhr.kDH = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bhr
 * JD-Core Version:    0.7.0.1
 */