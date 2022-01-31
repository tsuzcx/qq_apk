package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ea
  extends bly
{
  public com.tencent.mm.bv.b sxA;
  public int sxF;
  public int sxG;
  public ef sxH;
  public eb sxI;
  
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
      paramVarArgs.gB(2, this.sxF);
      paramVarArgs.gB(3, this.sxG);
      if (this.sxA != null) {
        paramVarArgs.b(4, this.sxA);
      }
      if (this.sxH != null)
      {
        paramVarArgs.gD(5, this.sxH.btq());
        this.sxH.a(paramVarArgs);
      }
      if (this.sxI != null)
      {
        paramVarArgs.gD(6, this.sxI.btq());
        this.sxI.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label729;
      }
    }
    label729:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sxF) + d.a.a.a.gy(3, this.sxG);
      paramInt = i;
      if (this.sxA != null) {
        paramInt = i + d.a.a.a.a(4, this.sxA);
      }
      i = paramInt;
      if (this.sxH != null) {
        i = paramInt + d.a.a.a.gA(5, this.sxH.btq());
      }
      paramInt = i;
      if (this.sxI != null) {
        paramInt = i + d.a.a.a.gA(6, this.sxI.btq());
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
        ea localea = (ea)paramVarArgs[1];
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
            localea.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localea.sxF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localea.sxG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localea.sxA = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ef();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ef)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localea.sxH = ((ef)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eb();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localea.sxI = ((eb)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ea
 * JD-Core Version:    0.7.0.1
 */