package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class clw
  extends bly
{
  public String bIW;
  public String bQC;
  public int tBf;
  public int tYP;
  public int tYQ;
  public String url;
  public int version;
  
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
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.bIW != null) {
        paramVarArgs.d(3, this.bIW);
      }
      paramVarArgs.gB(4, this.version);
      paramVarArgs.gB(5, this.tYP);
      paramVarArgs.gB(6, this.tBf);
      paramVarArgs.gB(7, this.tYQ);
      if (this.bQC != null) {
        paramVarArgs.d(8, this.bQC);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label626;
      }
    }
    label626:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.bIW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bIW);
      }
      i = i + d.a.a.a.gy(4, this.version) + d.a.a.a.gy(5, this.tYP) + d.a.a.a.gy(6, this.tBf) + d.a.a.a.gy(7, this.tYQ);
      paramInt = i;
      if (this.bQC != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.bQC);
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
        clw localclw = (clw)paramVarArgs[1];
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
            localclw.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localclw.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localclw.bIW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localclw.version = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localclw.tYP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localclw.tBf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localclw.tYQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localclw.bQC = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clw
 * JD-Core Version:    0.7.0.1
 */