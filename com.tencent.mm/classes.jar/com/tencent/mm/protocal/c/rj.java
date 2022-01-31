package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class rj
  extends blm
{
  public String euK;
  public String sPn;
  public String sPo;
  public String syI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sPn == null) {
        throw new b("Not all required fields were included: DeviceId");
      }
      if (this.syI == null) {
        throw new b("Not all required fields were included: DeviceType");
      }
      if (this.sPo == null) {
        throw new b("Not all required fields were included: ClientInfo");
      }
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sPn != null) {
        paramVarArgs.d(2, this.sPn);
      }
      if (this.syI != null) {
        paramVarArgs.d(3, this.syI);
      }
      if (this.sPo != null) {
        paramVarArgs.d(4, this.sPo);
      }
      if (this.euK != null) {
        paramVarArgs.d(5, this.euK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label629;
      }
    }
    label629:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sPn != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sPn);
      }
      i = paramInt;
      if (this.syI != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.syI);
      }
      paramInt = i;
      if (this.sPo != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sPo);
      }
      i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.euK);
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
        if (this.sPn == null) {
          throw new b("Not all required fields were included: DeviceId");
        }
        if (this.syI == null) {
          throw new b("Not all required fields were included: DeviceType");
        }
        if (this.sPo == null) {
          throw new b("Not all required fields were included: ClientInfo");
        }
        if (this.euK != null) {
          break;
        }
        throw new b("Not all required fields were included: AppId");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        rj localrj = (rj)paramVarArgs[1];
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
            localrj.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localrj.sPn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localrj.syI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localrj.sPo = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localrj.euK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rj
 * JD-Core Version:    0.7.0.1
 */