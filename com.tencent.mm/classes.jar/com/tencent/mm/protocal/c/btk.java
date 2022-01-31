package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class btk
  extends com.tencent.mm.bv.a
{
  public int mPL;
  public String sxM;
  public bmk tJy;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tJy == null) {
        throw new b("Not all required fields were included: HBBuffer");
      }
      if (this.sxM != null) {
        paramVarArgs.d(1, this.sxM);
      }
      paramVarArgs.gB(2, this.mPL);
      if (this.tJy != null)
      {
        paramVarArgs.gD(3, this.tJy.btq());
        this.tJy.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sxM == null) {
        break label399;
      }
    }
    label399:
    for (paramInt = d.a.a.b.b.a.e(1, this.sxM) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.mPL);
      paramInt = i;
      if (this.tJy != null) {
        paramInt = i + d.a.a.a.gA(3, this.tJy.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tJy != null) {
          break;
        }
        throw new b("Not all required fields were included: HBBuffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        btk localbtk = (btk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbtk.sxM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbtk.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbtk.tJy = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.btk
 * JD-Core Version:    0.7.0.1
 */