package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class avr
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String sBC;
  public String sBO;
  public bmk sBt;
  public uq syO;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sBt == null) {
        throw new b("Not all required fields were included: RandomEncryKey");
      }
      if (this.syO == null) {
        throw new b("Not all required fields were included: CliPubECDHKey");
      }
      if (this.sBt != null)
      {
        paramVarArgs.gD(1, this.sBt.btq());
        this.sBt.a(paramVarArgs);
      }
      if (this.syO != null)
      {
        paramVarArgs.gD(2, this.syO.btq());
        this.syO.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(3, this.hPY);
      }
      if (this.sBC != null) {
        paramVarArgs.d(4, this.sBC);
      }
      if (this.sBO != null) {
        paramVarArgs.d(5, this.sBO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sBt == null) {
        break label651;
      }
    }
    label651:
    for (int i = d.a.a.a.gA(1, this.sBt.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syO != null) {
        paramInt = i + d.a.a.a.gA(2, this.syO.btq());
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.hPY);
      }
      paramInt = i;
      if (this.sBC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sBC);
      }
      i = paramInt;
      if (this.sBO != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sBO);
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
        if (this.sBt == null) {
          throw new b("Not all required fields were included: RandomEncryKey");
        }
        if (this.syO != null) {
          break;
        }
        throw new b("Not all required fields were included: CliPubECDHKey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        avr localavr = (avr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localavr.sBt = ((bmk)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localavr.syO = ((uq)localObject1);
            paramInt += 1;
          }
        case 3: 
          localavr.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localavr.sBC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localavr.sBO = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avr
 * JD-Core Version:    0.7.0.1
 */