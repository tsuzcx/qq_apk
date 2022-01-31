package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class azg
  extends com.tencent.mm.bv.a
{
  public int hQq;
  public int sFD;
  public bmk sIi;
  public qw sIl;
  public int sze;
  public int tvw;
  public int tvx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sIl == null) {
        throw new b("Not all required fields were included: CmdList");
      }
      if (this.sIi == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      paramVarArgs.gB(1, this.sze);
      if (this.sIl != null)
      {
        paramVarArgs.gD(2, this.sIl.btq());
        this.sIl.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.sFD);
      if (this.sIi != null)
      {
        paramVarArgs.gD(4, this.sIi.btq());
        this.sIi.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.hQq);
      paramVarArgs.gB(6, this.tvw);
      paramVarArgs.gB(7, this.tvx);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.sze) + 0;
      paramInt = i;
      if (this.sIl != null) {
        paramInt = i + d.a.a.a.gA(2, this.sIl.btq());
      }
      i = paramInt + d.a.a.a.gy(3, this.sFD);
      paramInt = i;
      if (this.sIi != null) {
        paramInt = i + d.a.a.a.gA(4, this.sIi.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.hQq) + d.a.a.a.gy(6, this.tvw) + d.a.a.a.gy(7, this.tvx);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sIl == null) {
        throw new b("Not all required fields were included: CmdList");
      }
      if (this.sIi == null) {
        throw new b("Not all required fields were included: KeyBuf");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      azg localazg = (azg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localazg.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localazg.sIl = ((qw)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localazg.sFD = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localazg.sIi = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localazg.hQq = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localazg.tvw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localazg.tvx = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azg
 * JD-Core Version:    0.7.0.1
 */