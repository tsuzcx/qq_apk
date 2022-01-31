package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ce
  extends com.tencent.mm.bv.a
{
  public int kSW;
  public int mPL;
  public long ndp;
  public int svM;
  public bml svN;
  public int svO;
  public bml svP;
  public int svQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svN == null) {
        throw new b("Not all required fields were included: ChatRoomId");
      }
      if (this.svP == null) {
        throw new b("Not all required fields were included: DigestContent");
      }
      if (this.svN != null)
      {
        paramVarArgs.gD(1, this.svN.btq());
        this.svN.a(paramVarArgs);
      }
      paramVarArgs.Y(2, this.ndp);
      paramVarArgs.gB(3, this.svM);
      paramVarArgs.gB(4, this.mPL);
      paramVarArgs.gB(5, this.svO);
      if (this.svP != null)
      {
        paramVarArgs.gD(6, this.svP.btq());
        this.svP.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.svQ);
      paramVarArgs.gB(8, this.kSW);
      return 0;
    }
    if (paramInt == 1) {
      if (this.svN == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = d.a.a.a.gA(1, this.svN.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.ndp) + d.a.a.a.gy(3, this.svM) + d.a.a.a.gy(4, this.mPL) + d.a.a.a.gy(5, this.svO);
      paramInt = i;
      if (this.svP != null) {
        paramInt = i + d.a.a.a.gA(6, this.svP.btq());
      }
      return paramInt + d.a.a.a.gy(7, this.svQ) + d.a.a.a.gy(8, this.kSW);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.svN == null) {
          throw new b("Not all required fields were included: ChatRoomId");
        }
        if (this.svP != null) {
          break;
        }
        throw new b("Not all required fields were included: DigestContent");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
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
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localce.svN = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          localce.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localce.svM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localce.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localce.svO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localce.svP = ((bml)localObject1);
            paramInt += 1;
          }
        case 7: 
          localce.svQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localce.kSW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ce
 * JD-Core Version:    0.7.0.1
 */