package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bwt
  extends com.tencent.mm.bv.a
{
  public String svu;
  public String tMY;
  public cna tNb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tMY == null) {
        throw new b("Not all required fields were included: WxaUserName");
      }
      if (this.tMY != null) {
        paramVarArgs.d(1, this.tMY);
      }
      if (this.tNb != null)
      {
        paramVarArgs.gD(2, this.tNb.btq());
        this.tNb.a(paramVarArgs);
      }
      if (this.svu != null) {
        paramVarArgs.d(3, this.svu);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tMY == null) {
        break label415;
      }
    }
    label415:
    for (int i = d.a.a.b.b.a.e(1, this.tMY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tNb != null) {
        paramInt = i + d.a.a.a.gA(2, this.tNb.btq());
      }
      i = paramInt;
      if (this.svu != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.svu);
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
        if (this.tMY != null) {
          break;
        }
        throw new b("Not all required fields were included: WxaUserName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bwt localbwt = (bwt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbwt.tMY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cna();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cna)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbwt.tNb = ((cna)localObject1);
            paramInt += 1;
          }
        }
        localbwt.svu = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bwt
 * JD-Core Version:    0.7.0.1
 */