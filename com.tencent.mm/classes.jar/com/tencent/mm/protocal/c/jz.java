package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class jz
  extends blm
{
  public int amount;
  public int bUR;
  public int nxO;
  public String nxP;
  public String nxQ;
  public String nzi;
  public String nzl;
  public String sEO;
  public int sEP;
  public String swg;
  
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
      paramVarArgs.gB(2, this.amount);
      paramVarArgs.gB(3, this.bUR);
      paramVarArgs.gB(4, this.nxO);
      if (this.sEO != null) {
        paramVarArgs.d(5, this.sEO);
      }
      if (this.nzi != null) {
        paramVarArgs.d(6, this.nzi);
      }
      if (this.nxP != null) {
        paramVarArgs.d(7, this.nxP);
      }
      if (this.nzl != null) {
        paramVarArgs.d(8, this.nzl);
      }
      if (this.swg != null) {
        paramVarArgs.d(9, this.swg);
      }
      if (this.nxQ != null) {
        paramVarArgs.d(10, this.nxQ);
      }
      paramVarArgs.gB(11, this.sEP);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label763;
      }
    }
    label763:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.amount) + d.a.a.a.gy(3, this.bUR) + d.a.a.a.gy(4, this.nxO);
      paramInt = i;
      if (this.sEO != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sEO);
      }
      i = paramInt;
      if (this.nzi != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nzi);
      }
      paramInt = i;
      if (this.nxP != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.nxP);
      }
      i = paramInt;
      if (this.nzl != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.nzl);
      }
      paramInt = i;
      if (this.swg != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.swg);
      }
      i = paramInt;
      if (this.nxQ != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.nxQ);
      }
      return i + d.a.a.a.gy(11, this.sEP);
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
        jz localjz = (jz)paramVarArgs[1];
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
            localjz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localjz.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localjz.bUR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localjz.nxO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localjz.sEO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localjz.nzi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localjz.nxP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localjz.nzl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localjz.swg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localjz.nxQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localjz.sEP = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jz
 * JD-Core Version:    0.7.0.1
 */