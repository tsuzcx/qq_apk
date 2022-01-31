package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bou
  extends blm
{
  public String hPY;
  public String kVs;
  public String tHd;
  public int tga;
  public int tvg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      if (this.kVs != null) {
        paramVarArgs.d(3, this.kVs);
      }
      paramVarArgs.gB(4, this.tvg);
      paramVarArgs.gB(5, this.tga);
      if (this.tHd != null) {
        paramVarArgs.d(6, this.tHd);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label516;
      }
    }
    label516:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.kVs != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kVs);
      }
      i = i + d.a.a.a.gy(4, this.tvg) + d.a.a.a.gy(5, this.tga);
      paramInt = i;
      if (this.tHd != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tHd);
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bou localbou = (bou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbou.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbou.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbou.kVs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbou.tvg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbou.tga = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbou.tHd = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bou
 * JD-Core Version:    0.7.0.1
 */