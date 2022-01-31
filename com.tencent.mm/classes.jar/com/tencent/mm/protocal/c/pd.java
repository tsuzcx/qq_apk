package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class pd
  extends blm
{
  public String bIW;
  public String fileid;
  public String sMP;
  public int sMQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.fileid == null) {
        throw new b("Not all required fields were included: fileid");
      }
      if (this.bIW == null) {
        throw new b("Not all required fields were included: md5");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.d(2, this.fileid);
      }
      if (this.bIW != null) {
        paramVarArgs.d(3, this.bIW);
      }
      if (this.sMP != null) {
        paramVarArgs.d(4, this.sMP);
      }
      paramVarArgs.gB(5, this.sMQ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label541;
      }
    }
    label541:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.fileid);
      }
      i = paramInt;
      if (this.bIW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bIW);
      }
      paramInt = i;
      if (this.sMP != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sMP);
      }
      return paramInt + d.a.a.a.gy(5, this.sMQ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.fileid == null) {
          throw new b("Not all required fields were included: fileid");
        }
        if (this.bIW != null) {
          break;
        }
        throw new b("Not all required fields were included: md5");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        pd localpd = (pd)paramVarArgs[1];
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
            localpd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localpd.fileid = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localpd.bIW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localpd.sMP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localpd.sMQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pd
 * JD-Core Version:    0.7.0.1
 */