package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bot
  extends bly
{
  public String euK;
  public int hQR;
  public String kWm;
  public String kWn;
  public int mPL;
  public int ndm;
  public long ndp;
  public String sGQ;
  public String swQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.kWn != null) {
        paramVarArgs.d(3, this.kWn);
      }
      if (this.kWm != null) {
        paramVarArgs.d(4, this.kWm);
      }
      paramVarArgs.gB(5, this.ndm);
      if (this.swQ != null) {
        paramVarArgs.d(6, this.swQ);
      }
      paramVarArgs.gB(7, this.mPL);
      paramVarArgs.gB(8, this.hQR);
      paramVarArgs.Y(9, this.ndp);
      if (this.sGQ != null) {
        paramVarArgs.d(10, this.sGQ);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label744;
      }
    }
    label744:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.kWn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kWn);
      }
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kWm);
      }
      i = paramInt + d.a.a.a.gy(5, this.ndm);
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.swQ);
      }
      i = paramInt + d.a.a.a.gy(7, this.mPL) + d.a.a.a.gy(8, this.hQR) + d.a.a.a.X(9, this.ndp);
      paramInt = i;
      if (this.sGQ != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sGQ);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bot localbot = (bot)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbot.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbot.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbot.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbot.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbot.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbot.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbot.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localbot.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbot.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localbot.sGQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bot
 * JD-Core Version:    0.7.0.1
 */