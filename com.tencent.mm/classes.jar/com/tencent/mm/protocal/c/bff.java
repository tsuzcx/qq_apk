package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bff
  extends bly
{
  public String content;
  public boolean hkG;
  public String imZ;
  public int status;
  public String stm;
  public String stn;
  public String tzQ;
  public String tzR;
  public String tzS;
  public String tzT;
  public String tzU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.stm != null) {
        paramVarArgs.d(2, this.stm);
      }
      if (this.stn != null) {
        paramVarArgs.d(3, this.stn);
      }
      paramVarArgs.gB(4, this.status);
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      if (this.imZ != null) {
        paramVarArgs.d(6, this.imZ);
      }
      if (this.tzQ != null) {
        paramVarArgs.d(7, this.tzQ);
      }
      paramVarArgs.aA(8, this.hkG);
      if (this.tzR != null) {
        paramVarArgs.d(9, this.tzR);
      }
      if (this.tzS != null) {
        paramVarArgs.d(10, this.tzS);
      }
      if (this.tzT != null) {
        paramVarArgs.d(11, this.tzT);
      }
      if (this.tzU != null) {
        paramVarArgs.d(12, this.tzU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label855;
      }
    }
    label855:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.stm != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.stm);
      }
      i = paramInt;
      if (this.stn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.stn);
      }
      i += d.a.a.a.gy(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt;
      if (this.imZ != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.imZ);
      }
      paramInt = i;
      if (this.tzQ != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tzQ);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(8) + 1);
      paramInt = i;
      if (this.tzR != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tzR);
      }
      i = paramInt;
      if (this.tzS != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.tzS);
      }
      paramInt = i;
      if (this.tzT != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tzT);
      }
      i = paramInt;
      if (this.tzU != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.tzU);
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bff localbff = (bff)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbff.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbff.stm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbff.stn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbff.status = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbff.content = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbff.imZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbff.tzQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbff.hkG = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 9: 
          localbff.tzR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbff.tzS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbff.tzT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbff.tzU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bff
 * JD-Core Version:    0.7.0.1
 */