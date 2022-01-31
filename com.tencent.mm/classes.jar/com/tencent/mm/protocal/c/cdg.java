package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cdg
  extends blm
{
  public int tDX;
  public int tDZ;
  public cdt tSf;
  public String til;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tSf == null) {
        throw new b("Not all required fields were included: Piece");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tSf != null)
      {
        paramVarArgs.gD(2, this.tSf.btq());
        this.tSf.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tDX);
      paramVarArgs.gB(4, this.tDZ);
      if (this.til != null) {
        paramVarArgs.d(5, this.til);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label583;
      }
    }
    label583:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tSf != null) {
        i = paramInt + d.a.a.a.gA(2, this.tSf.btq());
      }
      i = i + d.a.a.a.gy(3, this.tDX) + d.a.a.a.gy(4, this.tDZ);
      paramInt = i;
      if (this.til != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.til);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tSf != null) {
          break;
        }
        throw new b("Not all required fields were included: Piece");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cdg localcdg = (cdg)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcdg.tSf = ((cdt)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcdg.tDX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcdg.tDZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcdg.til = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cdg
 * JD-Core Version:    0.7.0.1
 */