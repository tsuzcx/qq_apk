package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ccz
  extends blm
{
  public String bJY;
  public String bOL;
  public String mOb;
  public String qyu;
  public String syB;
  public LinkedList<Integer> tHo = new LinkedList();
  public String tHp;
  public String tHr;
  
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
      if (this.bOL != null) {
        paramVarArgs.d(2, this.bOL);
      }
      paramVarArgs.d(3, 2, this.tHo);
      if (this.tHp != null) {
        paramVarArgs.d(4, this.tHp);
      }
      if (this.syB != null) {
        paramVarArgs.d(5, this.syB);
      }
      if (this.bJY != null) {
        paramVarArgs.d(6, this.bJY);
      }
      if (this.qyu != null) {
        paramVarArgs.d(7, this.qyu);
      }
      if (this.tHr != null) {
        paramVarArgs.d(8, this.tHr);
      }
      if (this.mOb != null) {
        paramVarArgs.d(9, this.mOb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label720;
      }
    }
    label720:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bOL);
      }
      i += d.a.a.a.c(3, 2, this.tHo);
      paramInt = i;
      if (this.tHp != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tHp);
      }
      i = paramInt;
      if (this.syB != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.syB);
      }
      paramInt = i;
      if (this.bJY != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.bJY);
      }
      i = paramInt;
      if (this.qyu != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.qyu);
      }
      paramInt = i;
      if (this.tHr != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tHr);
      }
      i = paramInt;
      if (this.mOb != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.mOb);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tHo.clear();
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
        ccz localccz = (ccz)paramVarArgs[1];
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
            localccz.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localccz.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localccz.tHo.add(Integer.valueOf(((d.a.a.a.a)localObject1).xpH.oD()));
          return 0;
        case 4: 
          localccz.tHp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localccz.syB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localccz.bJY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localccz.qyu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localccz.tHr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localccz.mOb = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ccz
 * JD-Core Version:    0.7.0.1
 */