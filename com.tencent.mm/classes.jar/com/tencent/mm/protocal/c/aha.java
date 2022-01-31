package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aha
  extends bly
{
  public int sYC;
  public String sYD;
  public String sYE;
  public int sYF;
  public String sYG;
  public String tew;
  public String tey;
  
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
      if (this.tew != null) {
        paramVarArgs.d(2, this.tew);
      }
      paramVarArgs.gB(3, this.sYC);
      if (this.sYD != null) {
        paramVarArgs.d(4, this.sYD);
      }
      if (this.sYE != null) {
        paramVarArgs.d(5, this.sYE);
      }
      paramVarArgs.gB(6, this.sYF);
      if (this.sYG != null) {
        paramVarArgs.d(7, this.sYG);
      }
      if (this.tey != null) {
        paramVarArgs.d(8, this.tey);
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
      int i = paramInt;
      if (this.tew != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tew);
      }
      i += d.a.a.a.gy(3, this.sYC);
      paramInt = i;
      if (this.sYD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sYD);
      }
      i = paramInt;
      if (this.sYE != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sYE);
      }
      i += d.a.a.a.gy(6, this.sYF);
      paramInt = i;
      if (this.sYG != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sYG);
      }
      i = paramInt;
      if (this.tey != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tey);
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
        aha localaha = (aha)paramVarArgs[1];
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
            localaha.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaha.tew = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaha.sYC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localaha.sYD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaha.sYE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaha.sYF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localaha.sYG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaha.tey = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aha
 * JD-Core Version:    0.7.0.1
 */