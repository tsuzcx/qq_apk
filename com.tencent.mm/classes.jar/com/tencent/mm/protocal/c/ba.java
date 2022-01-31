package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bv.a
{
  public String kRX;
  public String kSM;
  public String kVn;
  public String suA;
  public String sut;
  public String suu;
  public String suv;
  public String suw;
  public String sux;
  public String suy;
  public cno suz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRX != null) {
        paramVarArgs.d(1, this.kRX);
      }
      if (this.sut != null) {
        paramVarArgs.d(2, this.sut);
      }
      if (this.suu != null) {
        paramVarArgs.d(3, this.suu);
      }
      if (this.kSM != null) {
        paramVarArgs.d(4, this.kSM);
      }
      if (this.kVn != null) {
        paramVarArgs.d(5, this.kVn);
      }
      if (this.suv != null) {
        paramVarArgs.d(6, this.suv);
      }
      if (this.suw != null) {
        paramVarArgs.d(7, this.suw);
      }
      if (this.sux != null) {
        paramVarArgs.d(8, this.sux);
      }
      if (this.suy != null) {
        paramVarArgs.d(9, this.suy);
      }
      if (this.suz != null)
      {
        paramVarArgs.gD(10, this.suz.btq());
        this.suz.a(paramVarArgs);
      }
      if (this.suA != null) {
        paramVarArgs.d(11, this.suA);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRX == null) {
        break label835;
      }
    }
    label835:
    for (int i = d.a.a.b.b.a.e(1, this.kRX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sut != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sut);
      }
      i = paramInt;
      if (this.suu != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.suu);
      }
      paramInt = i;
      if (this.kSM != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kSM);
      }
      i = paramInt;
      if (this.kVn != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kVn);
      }
      paramInt = i;
      if (this.suv != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.suv);
      }
      i = paramInt;
      if (this.suw != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.suw);
      }
      paramInt = i;
      if (this.sux != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sux);
      }
      i = paramInt;
      if (this.suy != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.suy);
      }
      paramInt = i;
      if (this.suz != null) {
        paramInt = i + d.a.a.a.gA(10, this.suz.btq());
      }
      i = paramInt;
      if (this.suA != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.suA);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localba.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localba.sut = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localba.suu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localba.kSM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localba.kVn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localba.suv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localba.suw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localba.sux = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localba.suy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cno();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cno)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localba.suz = ((cno)localObject1);
            paramInt += 1;
          }
        }
        localba.suA = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ba
 * JD-Core Version:    0.7.0.1
 */