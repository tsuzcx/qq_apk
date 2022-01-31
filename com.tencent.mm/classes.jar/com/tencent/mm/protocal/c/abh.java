package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class abh
  extends bly
{
  public String sCw;
  public String sCx;
  public baq taJ;
  public int taK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.taJ == null) {
        throw new b("Not all required fields were included: AppInfo");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.taJ != null)
      {
        paramVarArgs.gD(2, this.taJ.btq());
        this.taJ.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.taK);
      if (this.sCx != null) {
        paramVarArgs.d(4, this.sCx);
      }
      if (this.sCw != null) {
        paramVarArgs.d(5, this.sCw);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label635;
      }
    }
    label635:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.taJ != null) {
        i = paramInt + d.a.a.a.gA(2, this.taJ.btq());
      }
      i += d.a.a.a.gy(3, this.taK);
      paramInt = i;
      if (this.sCx != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sCx);
      }
      i = paramInt;
      if (this.sCw != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sCw);
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
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.taJ != null) {
          break;
        }
        throw new b("Not all required fields were included: AppInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        abh localabh = (abh)paramVarArgs[1];
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
            localabh.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new baq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((baq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localabh.taJ = ((baq)localObject1);
            paramInt += 1;
          }
        case 3: 
          localabh.taK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localabh.sCx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localabh.sCw = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.abh
 * JD-Core Version:    0.7.0.1
 */