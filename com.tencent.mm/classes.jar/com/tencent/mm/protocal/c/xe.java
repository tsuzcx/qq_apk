package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class xe
  extends bly
{
  public int iHq;
  public String iHr;
  public String jxR;
  public String lMg;
  public String lNA;
  public String lNz;
  public int sTQ;
  
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
      if (this.lMg != null) {
        paramVarArgs.d(4, this.lMg);
      }
      if (this.jxR != null) {
        paramVarArgs.d(5, this.jxR);
      }
      paramVarArgs.gB(6, this.sTQ);
      if (this.lNA != null) {
        paramVarArgs.d(7, this.lNA);
      }
      if (this.lNz != null) {
        paramVarArgs.d(8, this.lNz);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.iHq);
      paramInt = i;
      if (this.iHr != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iHr);
      }
      i = paramInt;
      if (this.lMg != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lMg);
      }
      paramInt = i;
      if (this.jxR != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.jxR);
      }
      i = paramInt + d.a.a.a.gy(6, this.sTQ);
      paramInt = i;
      if (this.lNA != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.lNA);
      }
      i = paramInt;
      if (this.lNz != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.lNz);
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
        xe localxe = (xe)paramVarArgs[1];
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
            localxe.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localxe.iHq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localxe.iHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localxe.lMg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localxe.jxR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localxe.sTQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localxe.lNA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localxe.lNz = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xe
 * JD-Core Version:    0.7.0.1
 */