package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aaz
  extends blm
{
  public String bOL;
  public int count;
  public String desc;
  public int scene;
  public String sign;
  public String taA;
  public String taB;
  public int taw;
  public int tay;
  public String taz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL == null) {
        throw new b("Not all required fields were included: appid");
      }
      if (this.taA == null) {
        throw new b("Not all required fields were included: busi_id");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.taw);
      if (this.bOL != null) {
        paramVarArgs.d(3, this.bOL);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      paramVarArgs.gB(5, this.tay);
      if (this.taz != null) {
        paramVarArgs.d(6, this.taz);
      }
      paramVarArgs.gB(7, this.count);
      paramVarArgs.gB(8, this.scene);
      if (this.taA != null) {
        paramVarArgs.d(9, this.taA);
      }
      if (this.sign != null) {
        paramVarArgs.d(10, this.sign);
      }
      if (this.taB != null) {
        paramVarArgs.d(11, this.taB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label835;
      }
    }
    label835:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.taw);
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bOL);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.desc);
      }
      i += d.a.a.a.gy(5, this.tay);
      paramInt = i;
      if (this.taz != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.taz);
      }
      i = paramInt + d.a.a.a.gy(7, this.count) + d.a.a.a.gy(8, this.scene);
      paramInt = i;
      if (this.taA != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.taA);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sign);
      }
      paramInt = i;
      if (this.taB != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.taB);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.bOL == null) {
          throw new b("Not all required fields were included: appid");
        }
        if (this.taA != null) {
          break;
        }
        throw new b("Not all required fields were included: busi_id");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aaz localaaz = (aaz)paramVarArgs[1];
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
            localaaz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaaz.taw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localaaz.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaaz.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaaz.tay = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localaaz.taz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localaaz.count = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localaaz.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localaaz.taA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localaaz.sign = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaaz.taB = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aaz
 * JD-Core Version:    0.7.0.1
 */