package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class blr
  extends com.tencent.mm.bv.a
{
  public int rWB;
  public int sGq;
  public int tAu;
  public blu tFh;
  public blt tFi;
  public int tFj;
  public String tFk;
  public int tFl;
  public int tFm;
  public int tFn;
  public int tea;
  public int tly;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFk == null) {
        throw new b("Not all required fields were included: SampleId");
      }
      paramVarArgs.gB(1, this.tAu);
      if (this.tFh != null)
      {
        paramVarArgs.gD(2, this.tFh.btq());
        this.tFh.a(paramVarArgs);
      }
      if (this.tFi != null)
      {
        paramVarArgs.gD(3, this.tFi.btq());
        this.tFi.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.tea);
      paramVarArgs.gB(5, this.tFj);
      if (this.tFk != null) {
        paramVarArgs.d(6, this.tFk);
      }
      paramVarArgs.gB(7, this.sGq);
      paramVarArgs.gB(8, this.tFl);
      paramVarArgs.gB(9, this.rWB);
      paramVarArgs.gB(10, this.tFm);
      paramVarArgs.gB(11, this.tFn);
      paramVarArgs.gB(12, this.tly);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.tAu) + 0;
      paramInt = i;
      if (this.tFh != null) {
        paramInt = i + d.a.a.a.gA(2, this.tFh.btq());
      }
      i = paramInt;
      if (this.tFi != null) {
        i = paramInt + d.a.a.a.gA(3, this.tFi.btq());
      }
      i = i + d.a.a.a.gy(4, this.tea) + d.a.a.a.gy(5, this.tFj);
      paramInt = i;
      if (this.tFk != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tFk);
      }
      return paramInt + d.a.a.a.gy(7, this.sGq) + d.a.a.a.gy(8, this.tFl) + d.a.a.a.gy(9, this.rWB) + d.a.a.a.gy(10, this.tFm) + d.a.a.a.gy(11, this.tFn) + d.a.a.a.gy(12, this.tly);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tFk == null) {
        throw new b("Not all required fields were included: SampleId");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      blr localblr = (blr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localblr.tAu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blu();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localblr.tFh = ((blu)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new blt();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((blt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localblr.tFi = ((blt)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        localblr.tea = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localblr.tFj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localblr.tFk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        localblr.sGq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localblr.tFl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localblr.rWB = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localblr.tFm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        localblr.tFn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localblr.tly = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blr
 * JD-Core Version:    0.7.0.1
 */