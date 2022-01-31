package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class fl
  extends blm
{
  public long hQm;
  public int pyo;
  public int syY;
  public LinkedList<ri> syZ = new LinkedList();
  public String sza;
  public String szb;
  public String szc;
  
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
      paramVarArgs.gB(2, this.syY);
      paramVarArgs.d(3, 8, this.syZ);
      if (this.sza != null) {
        paramVarArgs.d(4, this.sza);
      }
      if (this.szb != null) {
        paramVarArgs.d(5, this.szb);
      }
      paramVarArgs.gB(6, this.pyo);
      paramVarArgs.Y(7, this.hQm);
      if (this.szc != null) {
        paramVarArgs.d(8, this.szc);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.syY) + d.a.a.a.c(3, 8, this.syZ);
      paramInt = i;
      if (this.sza != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sza);
      }
      i = paramInt;
      if (this.szb != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.szb);
      }
      i = i + d.a.a.a.gy(6, this.pyo) + d.a.a.a.X(7, this.hQm);
      paramInt = i;
      if (this.szc != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.szc);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.syZ.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        fl localfl = (fl)paramVarArgs[1];
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
            localfl.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localfl.syY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ri();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ri)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localfl.syZ.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localfl.sza = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localfl.szb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localfl.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localfl.hQm = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localfl.szc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fl
 * JD-Core Version:    0.7.0.1
 */