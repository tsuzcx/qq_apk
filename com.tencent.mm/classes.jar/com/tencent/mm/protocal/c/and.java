package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class and
  extends blm
{
  public String bOL;
  public int sEs;
  public String thh;
  public String tiV;
  public int tiW;
  public int tiX;
  public bct tiY;
  public int type;
  
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
      paramVarArgs.gB(2, this.type);
      if (this.bOL != null) {
        paramVarArgs.d(3, this.bOL);
      }
      paramVarArgs.gB(4, this.sEs);
      if (this.tiV != null) {
        paramVarArgs.d(5, this.tiV);
      }
      paramVarArgs.gB(6, this.tiW);
      paramVarArgs.gB(7, this.tiX);
      if (this.thh != null) {
        paramVarArgs.d(8, this.thh);
      }
      if (this.tiY != null)
      {
        paramVarArgs.gD(10, this.tiY.btq());
        this.tiY.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.type);
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bOL);
      }
      i = paramInt + d.a.a.a.gy(4, this.sEs);
      paramInt = i;
      if (this.tiV != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tiV);
      }
      i = paramInt + d.a.a.a.gy(6, this.tiW) + d.a.a.a.gy(7, this.tiX);
      paramInt = i;
      if (this.thh != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.thh);
      }
      i = paramInt;
      if (this.tiY != null) {
        i = paramInt + d.a.a.a.gA(10, this.tiY.btq());
      }
      return i;
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
        and localand = (and)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
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
            localand.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localand.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localand.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localand.sEs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localand.tiV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localand.tiW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localand.tiX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localand.thh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bct();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bct)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localand.tiY = ((bct)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.and
 * JD-Core Version:    0.7.0.1
 */