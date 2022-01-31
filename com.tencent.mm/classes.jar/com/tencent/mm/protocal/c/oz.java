package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class oz
  extends bly
{
  public String iQn;
  public int ino;
  public String inp;
  public String lLm;
  public long sMA;
  public String sMB;
  public String sMC;
  public long sMz;
  
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
      paramVarArgs.Y(4, this.sMz);
      paramVarArgs.Y(5, this.sMA);
      if (this.sMB != null) {
        paramVarArgs.d(6, this.sMB);
      }
      if (this.sMC != null) {
        paramVarArgs.d(7, this.sMC);
      }
      if (this.lLm != null) {
        paramVarArgs.d(8, this.lLm);
      }
      if (this.iQn != null) {
        paramVarArgs.d(9, this.iQn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label705;
      }
    }
    label705:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt + d.a.a.a.X(4, this.sMz) + d.a.a.a.X(5, this.sMA);
      paramInt = i;
      if (this.sMB != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sMB);
      }
      i = paramInt;
      if (this.sMC != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sMC);
      }
      paramInt = i;
      if (this.lLm != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.lLm);
      }
      i = paramInt;
      if (this.iQn != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.iQn);
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
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        oz localoz = (oz)paramVarArgs[1];
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
            localoz.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localoz.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localoz.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localoz.sMz = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localoz.sMA = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localoz.sMB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localoz.sMC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localoz.lLm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localoz.iQn = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.oz
 * JD-Core Version:    0.7.0.1
 */