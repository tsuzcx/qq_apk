package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bav
  extends blm
{
  public int bUx;
  public String mOb;
  public String qqU;
  public String sAT;
  public String sAU;
  public boolean twL;
  public String twM;
  public String twN;
  public int twO;
  
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
      if (this.sAT != null) {
        paramVarArgs.d(2, this.sAT);
      }
      if (this.sAU != null) {
        paramVarArgs.d(3, this.sAU);
      }
      if (this.twM != null) {
        paramVarArgs.d(4, this.twM);
      }
      if (this.twN != null) {
        paramVarArgs.d(5, this.twN);
      }
      if (this.qqU != null) {
        paramVarArgs.d(6, this.qqU);
      }
      if (this.mOb != null) {
        paramVarArgs.d(7, this.mOb);
      }
      paramVarArgs.gB(8, this.bUx);
      paramVarArgs.gB(9, this.twO);
      paramVarArgs.aA(10, this.twL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label717;
      }
    }
    label717:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sAT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sAT);
      }
      i = paramInt;
      if (this.sAU != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sAU);
      }
      paramInt = i;
      if (this.twM != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.twM);
      }
      i = paramInt;
      if (this.twN != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.twN);
      }
      paramInt = i;
      if (this.qqU != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.qqU);
      }
      i = paramInt;
      if (this.mOb != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.mOb);
      }
      return i + d.a.a.a.gy(8, this.bUx) + d.a.a.a.gy(9, this.twO) + (d.a.a.b.b.a.dQ(10) + 1);
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
        bav localbav = (bav)paramVarArgs[1];
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
            localbav.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbav.sAT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbav.sAU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbav.twM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbav.twN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbav.qqU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbav.mOb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbav.bUx = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbav.twO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbav.twL = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bav
 * JD-Core Version:    0.7.0.1
 */