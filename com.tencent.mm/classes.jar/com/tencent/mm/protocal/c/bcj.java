package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bcj
  extends bly
{
  public String iHC;
  public String iHD;
  public int iHq;
  public String iHr;
  public int txM;
  public int txN;
  public String txO;
  
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
      paramVarArgs.gB(4, this.txM);
      paramVarArgs.gB(5, this.txN);
      if (this.iHC != null) {
        paramVarArgs.d(6, this.iHC);
      }
      if (this.iHD != null) {
        paramVarArgs.d(7, this.iHD);
      }
      if (this.txO != null) {
        paramVarArgs.d(8, this.txO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt + d.a.a.a.gy(4, this.txM) + d.a.a.a.gy(5, this.txN);
      paramInt = i;
      if (this.iHC != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.iHC);
      }
      i = paramInt;
      if (this.iHD != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.iHD);
      }
      paramInt = i;
      if (this.txO != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.txO);
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
        bcj localbcj = (bcj)paramVarArgs[1];
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
            localbcj.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbcj.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbcj.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbcj.txM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbcj.txN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbcj.iHC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbcj.iHD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbcj.txO = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcj
 * JD-Core Version:    0.7.0.1
 */