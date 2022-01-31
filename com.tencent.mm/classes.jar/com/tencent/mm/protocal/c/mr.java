package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class mr
  extends blm
{
  public int amount;
  public String ipb;
  public String nickname;
  public String nyK;
  public String nyV;
  public String nyW;
  public String nzl;
  public String nzo;
  public String sKn;
  
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
      if (this.ipb != null) {
        paramVarArgs.d(3, this.ipb);
      }
      if (this.nzl != null) {
        paramVarArgs.d(4, this.nzl);
      }
      if (this.sKn != null) {
        paramVarArgs.d(5, this.sKn);
      }
      if (this.nyV != null) {
        paramVarArgs.d(6, this.nyV);
      }
      if (this.nyW != null) {
        paramVarArgs.d(7, this.nyW);
      }
      if (this.nzo != null) {
        paramVarArgs.d(8, this.nzo);
      }
      if (this.nickname != null) {
        paramVarArgs.d(9, this.nickname);
      }
      if (this.nyK != null) {
        paramVarArgs.d(10, this.nyK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label760;
      }
    }
    label760:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.amount);
      paramInt = i;
      if (this.ipb != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.ipb);
      }
      i = paramInt;
      if (this.nzl != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.nzl);
      }
      paramInt = i;
      if (this.sKn != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sKn);
      }
      i = paramInt;
      if (this.nyV != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nyV);
      }
      paramInt = i;
      if (this.nyW != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.nyW);
      }
      i = paramInt;
      if (this.nzo != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.nzo);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.nickname);
      }
      i = paramInt;
      if (this.nyK != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.nyK);
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
        mr localmr = (mr)paramVarArgs[1];
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
            localmr.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localmr.amount = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localmr.ipb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localmr.nzl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localmr.sKn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localmr.nyV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localmr.nyW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localmr.nzo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localmr.nickname = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localmr.nyK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mr
 * JD-Core Version:    0.7.0.1
 */