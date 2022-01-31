package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class mt
  extends blm
{
  public int amount;
  public int bUR;
  public int nxO;
  public String nze;
  public String nzf;
  public String sKq;
  public String sKr;
  public String swc;
  public String swd;
  
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
      if (this.swc != null) {
        paramVarArgs.d(2, this.swc);
      }
      if (this.swd != null) {
        paramVarArgs.d(3, this.swd);
      }
      paramVarArgs.gB(4, this.amount);
      if (this.nzf != null) {
        paramVarArgs.d(5, this.nzf);
      }
      if (this.nze != null) {
        paramVarArgs.d(6, this.nze);
      }
      paramVarArgs.gB(7, this.bUR);
      paramVarArgs.gB(8, this.nxO);
      if (this.sKq != null) {
        paramVarArgs.d(9, this.sKq);
      }
      if (this.sKr != null) {
        paramVarArgs.d(10, this.sKr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label728;
      }
    }
    label728:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.swc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.swc);
      }
      i = paramInt;
      if (this.swd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.swd);
      }
      i += d.a.a.a.gy(4, this.amount);
      paramInt = i;
      if (this.nzf != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.nzf);
      }
      i = paramInt;
      if (this.nze != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nze);
      }
      i = i + d.a.a.a.gy(7, this.bUR) + d.a.a.a.gy(8, this.nxO);
      paramInt = i;
      if (this.sKq != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sKq);
      }
      i = paramInt;
      if (this.sKr != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sKr);
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
        mt localmt = (mt)paramVarArgs[1];
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
            localmt.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localmt.swc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localmt.swd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localmt.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localmt.nzf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localmt.nze = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localmt.bUR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localmt.nxO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localmt.sKq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localmt.sKr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mt
 * JD-Core Version:    0.7.0.1
 */