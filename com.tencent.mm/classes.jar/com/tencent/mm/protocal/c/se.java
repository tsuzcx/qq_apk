package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class se
  extends blm
{
  public int hPS;
  public String kRZ;
  public String sQh;
  public String sQi;
  public ato sQj;
  public LinkedList<bml> sQk = new LinkedList();
  public String sQl;
  public String sQm;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sQj == null) {
        throw new b("Not all required fields were included: Loc");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(2, this.kRZ);
      }
      if (this.sQh != null) {
        paramVarArgs.d(3, this.sQh);
      }
      if (this.sQi != null) {
        paramVarArgs.d(4, this.sQi);
      }
      if (this.sQj != null)
      {
        paramVarArgs.gD(5, this.sQj.btq());
        this.sQj.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.hPS);
      paramVarArgs.d(7, 8, this.sQk);
      if (this.sQl != null) {
        paramVarArgs.d(8, this.sQl);
      }
      if (this.sQm != null) {
        paramVarArgs.d(9, this.sQm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label905;
      }
    }
    label905:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRZ);
      }
      i = paramInt;
      if (this.sQh != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sQh);
      }
      paramInt = i;
      if (this.sQi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sQi);
      }
      i = paramInt;
      if (this.sQj != null) {
        i = paramInt + d.a.a.a.gA(5, this.sQj.btq());
      }
      i = i + d.a.a.a.gy(6, this.hPS) + d.a.a.a.c(7, 8, this.sQk);
      paramInt = i;
      if (this.sQl != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sQl);
      }
      i = paramInt;
      if (this.sQm != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sQm);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sQk.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sQj != null) {
          break;
        }
        throw new b("Not all required fields were included: Loc");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        se localse = (se)paramVarArgs[1];
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
            localse.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localse.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localse.sQh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localse.sQi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ato();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ato)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localse.sQj = ((ato)localObject1);
            paramInt += 1;
          }
        case 6: 
          localse.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localse.sQk.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localse.sQl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localse.sQm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.se
 * JD-Core Version:    0.7.0.1
 */