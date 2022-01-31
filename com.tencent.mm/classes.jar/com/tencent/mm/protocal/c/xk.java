package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class xk
  extends bly
{
  public int jMS;
  public LinkedList<atb> sKO = new LinkedList();
  public bfr sTX;
  public String sTY;
  public String sTZ;
  public String sUa;
  public String sUb;
  public float sUc;
  public String sUd;
  public String sUe;
  
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
      paramVarArgs.d(2, 8, this.sKO);
      if (this.sTX != null)
      {
        paramVarArgs.gD(3, this.sTX.btq());
        this.sTX.a(paramVarArgs);
      }
      if (this.sTY != null) {
        paramVarArgs.d(4, this.sTY);
      }
      if (this.sTZ != null) {
        paramVarArgs.d(5, this.sTZ);
      }
      if (this.sUa != null) {
        paramVarArgs.d(6, this.sUa);
      }
      if (this.sUb != null) {
        paramVarArgs.d(7, this.sUb);
      }
      paramVarArgs.m(8, this.sUc);
      paramVarArgs.gB(9, this.jMS);
      if (this.sUd != null) {
        paramVarArgs.d(10, this.sUd);
      }
      if (this.sUe != null) {
        paramVarArgs.d(11, this.sUe);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1003;
      }
    }
    label1003:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.sKO);
      paramInt = i;
      if (this.sTX != null) {
        paramInt = i + d.a.a.a.gA(3, this.sTX.btq());
      }
      i = paramInt;
      if (this.sTY != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sTY);
      }
      paramInt = i;
      if (this.sTZ != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sTZ);
      }
      i = paramInt;
      if (this.sUa != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sUa);
      }
      paramInt = i;
      if (this.sUb != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sUb);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(8) + 4) + d.a.a.a.gy(9, this.jMS);
      paramInt = i;
      if (this.sUd != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sUd);
      }
      i = paramInt;
      if (this.sUe != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sUe);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sKO.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        xk localxk = (xk)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localxk.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localxk.sKO.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localxk.sTX = ((bfr)localObject1);
            paramInt += 1;
          }
        case 4: 
          localxk.sTY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localxk.sTZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localxk.sUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localxk.sUb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localxk.sUc = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 9: 
          localxk.jMS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localxk.sUd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localxk.sUe = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xk
 * JD-Core Version:    0.7.0.1
 */