package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class adr
  extends bly
{
  public String inn;
  public String tbK;
  public mj tbL;
  public int tbM;
  public boo tbN;
  
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
      if (this.inn != null) {
        paramVarArgs.d(2, this.inn);
      }
      if (this.tbK != null) {
        paramVarArgs.d(3, this.tbK);
      }
      if (this.tbL != null)
      {
        paramVarArgs.gD(4, this.tbL.btq());
        this.tbL.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tbM);
      if (this.tbN != null)
      {
        paramVarArgs.gD(6, this.tbN.btq());
        this.tbN.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label752;
      }
    }
    label752:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.inn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.inn);
      }
      i = paramInt;
      if (this.tbK != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tbK);
      }
      paramInt = i;
      if (this.tbL != null) {
        paramInt = i + d.a.a.a.gA(4, this.tbL.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.tbM);
      paramInt = i;
      if (this.tbN != null) {
        paramInt = i + d.a.a.a.gA(6, this.tbN.btq());
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
        adr localadr = (adr)paramVarArgs[1];
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
            localadr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localadr.inn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localadr.tbK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localadr.tbL = ((mj)localObject1);
            paramInt += 1;
          }
        case 5: 
          localadr.tbM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localadr.tbN = ((boo)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.adr
 * JD-Core Version:    0.7.0.1
 */