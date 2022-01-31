package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class nk
  extends blm
{
  public int amount;
  public int bUR;
  public String nzf;
  public String sKV;
  public String sKY;
  public String sKZ;
  public int sLa;
  public String sLb;
  public String sLd;
  public String sLe;
  public String sLf;
  public int sLg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sKY == null) {
        throw new b("Not all required fields were included: receiver_name");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sKY != null) {
        paramVarArgs.d(2, this.sKY);
      }
      paramVarArgs.gB(3, this.amount);
      if (this.sKZ != null) {
        paramVarArgs.d(4, this.sKZ);
      }
      if (this.nzf != null) {
        paramVarArgs.d(5, this.nzf);
      }
      paramVarArgs.gB(6, this.sLa);
      paramVarArgs.gB(7, this.bUR);
      if (this.sLb != null) {
        paramVarArgs.d(8, this.sLb);
      }
      if (this.sKV != null) {
        paramVarArgs.d(9, this.sKV);
      }
      if (this.sLd != null) {
        paramVarArgs.d(10, this.sLd);
      }
      if (this.sLe != null) {
        paramVarArgs.d(11, this.sLe);
      }
      if (this.sLf != null) {
        paramVarArgs.d(12, this.sLf);
      }
      paramVarArgs.gB(13, this.sLg);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label913;
      }
    }
    label913:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sKY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sKY);
      }
      i += d.a.a.a.gy(3, this.amount);
      paramInt = i;
      if (this.sKZ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sKZ);
      }
      i = paramInt;
      if (this.nzf != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.nzf);
      }
      i = i + d.a.a.a.gy(6, this.sLa) + d.a.a.a.gy(7, this.bUR);
      paramInt = i;
      if (this.sLb != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sLb);
      }
      i = paramInt;
      if (this.sKV != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sKV);
      }
      paramInt = i;
      if (this.sLd != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sLd);
      }
      i = paramInt;
      if (this.sLe != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sLe);
      }
      paramInt = i;
      if (this.sLf != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.sLf);
      }
      return paramInt + d.a.a.a.gy(13, this.sLg);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sKY != null) {
          break;
        }
        throw new b("Not all required fields were included: receiver_name");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        nk localnk = (nk)paramVarArgs[1];
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
            localnk.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localnk.sKY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localnk.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localnk.sKZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localnk.nzf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localnk.sLa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localnk.bUR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localnk.sLb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localnk.sKV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localnk.sLd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localnk.sLe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localnk.sLf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localnk.sLg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nk
 * JD-Core Version:    0.7.0.1
 */