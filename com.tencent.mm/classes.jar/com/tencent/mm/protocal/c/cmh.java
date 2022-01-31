package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cmh
  extends com.tencent.mm.bv.a
{
  public int sCy;
  public LinkedList<ml> sQk = new LinkedList();
  public int tZj;
  public String tZk;
  public String tZl;
  public int tZm;
  public du tZn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sCy);
      paramVarArgs.gB(2, this.tZj);
      if (this.tZk != null) {
        paramVarArgs.d(3, this.tZk);
      }
      if (this.tZl != null) {
        paramVarArgs.d(4, this.tZl);
      }
      paramVarArgs.gB(5, this.tZm);
      paramVarArgs.d(6, 8, this.sQk);
      if (this.tZn != null)
      {
        paramVarArgs.gD(7, this.tZn.btq());
        this.tZn.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sCy) + 0 + d.a.a.a.gy(2, this.tZj);
      paramInt = i;
      if (this.tZk != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tZk);
      }
      i = paramInt;
      if (this.tZl != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tZl);
      }
      i = i + d.a.a.a.gy(5, this.tZm) + d.a.a.a.c(6, 8, this.sQk);
      paramInt = i;
    } while (this.tZn == null);
    return i + d.a.a.a.gA(7, this.tZn.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sQk.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      cmh localcmh = (cmh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localcmh.sCy = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localcmh.tZj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localcmh.tZk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localcmh.tZl = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localcmh.tZm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcmh.sQk.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new du();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((du)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localcmh.tZn = ((du)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cmh
 * JD-Core Version:    0.7.0.1
 */