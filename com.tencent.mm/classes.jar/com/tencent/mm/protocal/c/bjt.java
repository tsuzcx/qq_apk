package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bjt
  extends com.tencent.mm.bv.a
{
  public String bOL;
  public long bah;
  public String mTc;
  public String nickname;
  public LinkedList<mm> tDA = new LinkedList();
  public String tDB;
  public LinkedList<bmh> tDC = new LinkedList();
  public String tDy;
  public double tDz;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.mTc != null) {
        paramVarArgs.d(4, this.mTc);
      }
      paramVarArgs.Y(5, this.bah);
      if (this.tDy != null) {
        paramVarArgs.d(6, this.tDy);
      }
      paramVarArgs.b(7, this.tDz);
      paramVarArgs.d(16, 8, this.tDA);
      if (this.tDB != null) {
        paramVarArgs.d(17, this.tDB);
      }
      paramVarArgs.d(19, 8, this.tDC);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label838;
      }
    }
    label838:
    for (int i = d.a.a.b.b.a.e(1, this.bOL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.nickname);
      }
      paramInt = i;
      if (this.mTc != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.mTc);
      }
      i = paramInt + d.a.a.a.X(5, this.bah);
      paramInt = i;
      if (this.tDy != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tDy);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(7) + 8) + d.a.a.a.c(16, 8, this.tDA);
      paramInt = i;
      if (this.tDB != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.tDB);
      }
      return paramInt + d.a.a.a.c(19, 8, this.tDC);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tDA.clear();
        this.tDC.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bjt localbjt = (bjt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 18: 
        default: 
          return -1;
        case 1: 
          localbjt.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbjt.username = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbjt.nickname = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbjt.mTc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbjt.bah = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbjt.tDy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbjt.tDz = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 16: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mm();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbjt.tDA.add(localObject1);
            paramInt += 1;
          }
        case 17: 
          localbjt.tDB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmh();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbjt.tDC.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjt
 * JD-Core Version:    0.7.0.1
 */