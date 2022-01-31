package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class akw
  extends blm
{
  public int kSm;
  public LinkedList<bml> kUD = new LinkedList();
  public int kUT;
  public int kUU;
  public String kUa;
  public int tgZ;
  
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
      paramVarArgs.gB(2, this.kSm);
      paramVarArgs.gB(3, this.kUT);
      paramVarArgs.gB(4, this.kUU);
      if (this.kUa != null) {
        paramVarArgs.d(5, this.kUa);
      }
      paramVarArgs.gB(6, this.tgZ);
      paramVarArgs.d(7, 8, this.kUD);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.kSm) + d.a.a.a.gy(3, this.kUT) + d.a.a.a.gy(4, this.kUU);
      paramInt = i;
      if (this.kUa != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kUa);
      }
      return paramInt + d.a.a.a.gy(6, this.tgZ) + d.a.a.a.c(7, 8, this.kUD);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.kUD.clear();
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
        akw localakw = (akw)paramVarArgs[1];
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
            localakw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localakw.kSm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localakw.kUT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localakw.kUU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localakw.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localakw.tgZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localakw.kUD.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.akw
 * JD-Core Version:    0.7.0.1
 */