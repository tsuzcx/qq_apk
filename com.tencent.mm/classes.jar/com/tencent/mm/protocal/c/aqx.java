package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class aqx
  extends blm
{
  public String bIK;
  public String kRX;
  public String scope;
  public String signature;
  public String tmB;
  public String tmC;
  public b tmD;
  public int tmE;
  public String tmz;
  public String url;
  
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
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.kRX != null) {
        paramVarArgs.d(3, this.kRX);
      }
      if (this.tmz != null) {
        paramVarArgs.d(4, this.tmz);
      }
      if (this.bIK != null) {
        paramVarArgs.d(5, this.bIK);
      }
      if (this.tmB != null) {
        paramVarArgs.d(6, this.tmB);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.tmC != null) {
        paramVarArgs.d(8, this.tmC);
      }
      if (this.tmD != null) {
        paramVarArgs.b(9, this.tmD);
      }
      paramVarArgs.gB(10, this.tmE);
      if (this.scope != null) {
        paramVarArgs.d(11, this.scope);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label816;
      }
    }
    label816:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.kRX != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kRX);
      }
      paramInt = i;
      if (this.tmz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tmz);
      }
      i = paramInt;
      if (this.bIK != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.bIK);
      }
      paramInt = i;
      if (this.tmB != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tmB);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.signature);
      }
      paramInt = i;
      if (this.tmC != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tmC);
      }
      i = paramInt;
      if (this.tmD != null) {
        i = paramInt + d.a.a.a.a(9, this.tmD);
      }
      i += d.a.a.a.gy(10, this.tmE);
      paramInt = i;
      if (this.scope != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.scope);
      }
      return paramInt;
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
        aqx localaqx = (aqx)paramVarArgs[1];
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
            localaqx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaqx.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaqx.kRX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaqx.tmz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaqx.bIK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaqx.tmB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localaqx.signature = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localaqx.tmC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localaqx.tmD = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 10: 
          localaqx.tmE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaqx.scope = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqx
 * JD-Core Version:    0.7.0.1
 */