package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aru
  extends bly
{
  public com.tencent.mm.bv.b hPF;
  public String kVn;
  public String suv;
  public aqz tnb;
  public bna tni;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.tnb != null)
      {
        paramVarArgs.gD(2, this.tnb.btq());
        this.tnb.a(paramVarArgs);
      }
      if (this.hPF != null) {
        paramVarArgs.b(3, this.hPF);
      }
      if (this.tni != null)
      {
        paramVarArgs.gD(4, this.tni.btq());
        this.tni.a(paramVarArgs);
      }
      if (this.kVn != null) {
        paramVarArgs.d(5, this.kVn);
      }
      if (this.suv != null) {
        paramVarArgs.d(6, this.suv);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label765;
      }
    }
    label765:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnb != null) {
        paramInt = i + d.a.a.a.gA(2, this.tnb.btq());
      }
      i = paramInt;
      if (this.hPF != null) {
        i = paramInt + d.a.a.a.a(3, this.hPF);
      }
      paramInt = i;
      if (this.tni != null) {
        paramInt = i + d.a.a.a.gA(4, this.tni.btq());
      }
      i = paramInt;
      if (this.kVn != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kVn);
      }
      paramInt = i;
      if (this.suv != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.suv);
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
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aru localaru = (aru)paramVarArgs[1];
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
            localaru.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aqz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aqz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaru.tnb = ((aqz)localObject1);
            paramInt += 1;
          }
        case 3: 
          localaru.hPF = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bna();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bna)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaru.tni = ((bna)localObject1);
            paramInt += 1;
          }
        case 5: 
          localaru.kVn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaru.suv = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aru
 * JD-Core Version:    0.7.0.1
 */