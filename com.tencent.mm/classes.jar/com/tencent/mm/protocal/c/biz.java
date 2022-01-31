package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class biz
  extends bly
{
  public String jFa;
  public biw tCP;
  public int tDd;
  public int tDe;
  public String tDf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tCP == null) {
        throw new b("Not all required fields were included: rcptinfolist");
      }
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tCP != null)
      {
        paramVarArgs.gD(1, this.tCP.btq());
        this.tCP.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tDd);
      if (this.tFx != null)
      {
        paramVarArgs.gD(3, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.jFa != null) {
        paramVarArgs.d(4, this.jFa);
      }
      paramVarArgs.gB(5, this.tDe);
      if (this.tDf != null) {
        paramVarArgs.d(6, this.tDf);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tCP == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = d.a.a.a.gA(1, this.tCP.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tDd);
      paramInt = i;
      if (this.tFx != null) {
        paramInt = i + d.a.a.a.gA(3, this.tFx.btq());
      }
      i = paramInt;
      if (this.jFa != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.jFa);
      }
      i += d.a.a.a.gy(5, this.tDe);
      paramInt = i;
      if (this.tDf != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tDf);
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
        if (this.tCP == null) {
          throw new b("Not all required fields were included: rcptinfolist");
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        biz localbiz = (biz)paramVarArgs[1];
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
            localObject1 = new biw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((biw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbiz.tCP = ((biw)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbiz.tDd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbiz.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 4: 
          localbiz.jFa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbiz.tDe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbiz.tDf = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.biz
 * JD-Core Version:    0.7.0.1
 */