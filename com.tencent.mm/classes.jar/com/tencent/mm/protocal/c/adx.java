package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class adx
  extends com.tencent.mm.bv.a
{
  public int svM;
  public bml tbW;
  public int tbX;
  public int tbY;
  public int tbZ = 1;
  public int tca;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tbW == null) {
        throw new b("Not all required fields were included: ChatroomId");
      }
      if (this.tbW != null)
      {
        paramVarArgs.gD(1, this.tbW.btq());
        this.tbW.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.svM);
      paramVarArgs.gB(3, this.tbX);
      paramVarArgs.gB(4, this.tbY);
      paramVarArgs.gB(5, this.tbZ);
      paramVarArgs.gB(6, this.tca);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tbW == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = d.a.a.a.gA(1, this.tbW.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.svM) + d.a.a.a.gy(3, this.tbX) + d.a.a.a.gy(4, this.tbY) + d.a.a.a.gy(5, this.tbZ) + d.a.a.a.gy(6, this.tca);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tbW != null) {
          break;
        }
        throw new b("Not all required fields were included: ChatroomId");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        adx localadx = (adx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localadx.tbW = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          localadx.svM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localadx.tbX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localadx.tbY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localadx.tbZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localadx.tca = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.adx
 * JD-Core Version:    0.7.0.1
 */