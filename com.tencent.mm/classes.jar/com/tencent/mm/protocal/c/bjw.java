package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bjw
  extends bly
{
  public int ino;
  public String inp;
  public String lnT;
  public String mOY;
  public int status;
  public boolean tDD;
  public boolean tDE;
  public String tDF;
  public String tDG;
  public String tDH;
  public int tzY;
  
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
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      paramVarArgs.aA(4, this.tDD);
      paramVarArgs.aA(5, this.tDE);
      paramVarArgs.gB(6, this.status);
      if (this.tDF != null) {
        paramVarArgs.d(7, this.tDF);
      }
      if (this.tDG != null) {
        paramVarArgs.d(8, this.tDG);
      }
      paramVarArgs.gB(9, this.tzY);
      if (this.lnT != null) {
        paramVarArgs.d(10, this.lnT);
      }
      if (this.mOY != null) {
        paramVarArgs.d(11, this.mOY);
      }
      if (this.tDH != null) {
        paramVarArgs.d(12, this.tDH);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(4) + 1) + (d.a.a.b.b.a.dQ(5) + 1) + d.a.a.a.gy(6, this.status);
      paramInt = i;
      if (this.tDF != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tDF);
      }
      i = paramInt;
      if (this.tDG != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tDG);
      }
      i += d.a.a.a.gy(9, this.tzY);
      paramInt = i;
      if (this.lnT != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.lnT);
      }
      i = paramInt;
      if (this.mOY != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.mOY);
      }
      paramInt = i;
      if (this.tDH != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tDH);
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
        bjw localbjw = (bjw)paramVarArgs[1];
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
            localbjw.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbjw.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbjw.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbjw.tDD = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 5: 
          localbjw.tDE = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 6: 
          localbjw.status = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbjw.tDF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbjw.tDG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbjw.tzY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localbjw.lnT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbjw.mOY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbjw.tDH = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjw
 * JD-Core Version:    0.7.0.1
 */