package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class us
  extends bly
{
  public apl sBD;
  public jv sBE;
  public ays sBF;
  public String sRr;
  public bsd sys;
  
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
      if (this.sRr != null) {
        paramVarArgs.d(2, this.sRr);
      }
      if (this.sBE != null)
      {
        paramVarArgs.gD(3, this.sBE.btq());
        this.sBE.a(paramVarArgs);
      }
      if (this.sBD != null)
      {
        paramVarArgs.gD(4, this.sBD.btq());
        this.sBD.a(paramVarArgs);
      }
      if (this.sys != null)
      {
        paramVarArgs.gD(5, this.sys.btq());
        this.sys.a(paramVarArgs);
      }
      if (this.sBF != null)
      {
        paramVarArgs.gD(6, this.sBF.btq());
        this.sBF.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label952;
      }
    }
    label952:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sRr != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sRr);
      }
      i = paramInt;
      if (this.sBE != null) {
        i = paramInt + d.a.a.a.gA(3, this.sBE.btq());
      }
      paramInt = i;
      if (this.sBD != null) {
        paramInt = i + d.a.a.a.gA(4, this.sBD.btq());
      }
      i = paramInt;
      if (this.sys != null) {
        i = paramInt + d.a.a.a.gA(5, this.sys.btq());
      }
      paramInt = i;
      if (this.sBF != null) {
        paramInt = i + d.a.a.a.gA(6, this.sBF.btq());
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
        us localus = (us)paramVarArgs[1];
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
            localus.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localus.sRr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localus.sBE = ((jv)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localus.sBD = ((apl)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localus.sys = ((bsd)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ays();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ays)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localus.sBF = ((ays)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.us
 * JD-Core Version:    0.7.0.1
 */