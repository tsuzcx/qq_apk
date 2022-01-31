package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class m
  extends bly
{
  public String iHC;
  public String iHD;
  public int iHq = 268513600;
  public String iHr = "请求不成功，请稍候再试";
  public int srE;
  public int srF;
  public int srG;
  public long srH;
  public long srI;
  
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
      paramVarArgs.gB(4, this.srE);
      paramVarArgs.gB(5, this.srF);
      paramVarArgs.gB(6, this.srG);
      paramVarArgs.Y(7, this.srH);
      paramVarArgs.Y(8, this.srI);
      if (this.iHC != null) {
        paramVarArgs.d(9, this.iHC);
      }
      if (this.iHD != null) {
        paramVarArgs.d(10, this.iHD);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label708;
      }
    }
    label708:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt + d.a.a.a.gy(4, this.srE) + d.a.a.a.gy(5, this.srF) + d.a.a.a.gy(6, this.srG) + d.a.a.a.X(7, this.srH) + d.a.a.a.X(8, this.srI);
      paramInt = i;
      if (this.iHC != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.iHC);
      }
      i = paramInt;
      if (this.iHD != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.iHD);
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
        m localm = (m)paramVarArgs[1];
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
            localm.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localm.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localm.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localm.srE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localm.srF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localm.srG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localm.srH = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 8: 
          localm.srI = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 9: 
          localm.iHC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localm.iHD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.m
 * JD-Core Version:    0.7.0.1
 */