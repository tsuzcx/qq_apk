package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ahn
  extends blm
{
  public int ndf;
  public int ndg;
  public int ndh;
  public int ndm;
  public long ndp;
  public bml svF;
  public bml svG;
  public int tfc;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svF == null) {
        throw new b("Not all required fields were included: FromUserName");
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ndm);
      if (this.svF != null)
      {
        paramVarArgs.gD(3, this.svF.btq());
        this.svF.a(paramVarArgs);
      }
      if (this.svG != null)
      {
        paramVarArgs.gD(4, this.svG.btq());
        this.svG.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.ndf);
      paramVarArgs.gB(6, this.ndg);
      paramVarArgs.gB(7, this.ndh);
      paramVarArgs.gB(8, this.tfc);
      paramVarArgs.Y(9, this.ndp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label865;
      }
    }
    label865:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndm);
      paramInt = i;
      if (this.svF != null) {
        paramInt = i + d.a.a.a.gA(3, this.svF.btq());
      }
      i = paramInt;
      if (this.svG != null) {
        i = paramInt + d.a.a.a.gA(4, this.svG.btq());
      }
      return i + d.a.a.a.gy(5, this.ndf) + d.a.a.a.gy(6, this.ndg) + d.a.a.a.gy(7, this.ndh) + d.a.a.a.gy(8, this.tfc) + d.a.a.a.X(9, this.ndp);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.svF == null) {
          throw new b("Not all required fields were included: FromUserName");
        }
        if (this.svG != null) {
          break;
        }
        throw new b("Not all required fields were included: ToUserName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ahn localahn = (ahn)paramVarArgs[1];
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
            localahn.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localahn.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localahn.svF = ((bml)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localahn.svG = ((bml)localObject1);
            paramInt += 1;
          }
        case 5: 
          localahn.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localahn.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localahn.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localahn.tfc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localahn.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ahn
 * JD-Core Version:    0.7.0.1
 */