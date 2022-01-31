package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bln
  extends blm
{
  public String mOb;
  public int nvl;
  public String nvy;
  public String nvz;
  public String sxV;
  public int tEY;
  public String tEZ;
  public int tFa;
  public int tFb;
  
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
      if (this.nvy != null) {
        paramVarArgs.d(2, this.nvy);
      }
      if (this.nvz != null) {
        paramVarArgs.d(3, this.nvz);
      }
      if (this.mOb != null) {
        paramVarArgs.d(4, this.mOb);
      }
      paramVarArgs.gB(5, this.nvl);
      paramVarArgs.gB(6, this.tEY);
      if (this.tEZ != null) {
        paramVarArgs.d(7, this.tEZ);
      }
      paramVarArgs.gB(8, this.tFa);
      paramVarArgs.gB(9, this.tFb);
      if (this.sxV != null) {
        paramVarArgs.d(10, this.sxV);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label708;
      }
    }
    label708:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nvy != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nvy);
      }
      i = paramInt;
      if (this.nvz != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.nvz);
      }
      paramInt = i;
      if (this.mOb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.mOb);
      }
      i = paramInt + d.a.a.a.gy(5, this.nvl) + d.a.a.a.gy(6, this.tEY);
      paramInt = i;
      if (this.tEZ != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tEZ);
      }
      i = paramInt + d.a.a.a.gy(8, this.tFa) + d.a.a.a.gy(9, this.tFb);
      paramInt = i;
      if (this.sxV != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sxV);
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
        bln localbln = (bln)paramVarArgs[1];
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
            localbln.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbln.nvy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbln.nvz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbln.mOb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbln.nvl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbln.tEY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbln.tEZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbln.tFa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbln.tFb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbln.sxV = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bln
 * JD-Core Version:    0.7.0.1
 */