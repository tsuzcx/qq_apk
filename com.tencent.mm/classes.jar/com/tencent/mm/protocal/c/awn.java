package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class awn
  extends com.tencent.mm.bv.a
{
  public int hQR;
  public String kVs;
  public int mPL;
  public bml svG;
  public String svK;
  public int ttf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      if (this.svG != null)
      {
        paramVarArgs.gD(1, this.svG.btq());
        this.svG.a(paramVarArgs);
      }
      if (this.kVs != null) {
        paramVarArgs.d(2, this.kVs);
      }
      paramVarArgs.gB(3, this.hQR);
      paramVarArgs.gB(4, this.mPL);
      paramVarArgs.gB(5, this.ttf);
      if (this.svK != null) {
        paramVarArgs.d(6, this.svK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.svG == null) {
        break label532;
      }
    }
    label532:
    for (paramInt = d.a.a.a.gA(1, this.svG.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kVs != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kVs);
      }
      i = i + d.a.a.a.gy(3, this.hQR) + d.a.a.a.gy(4, this.mPL) + d.a.a.a.gy(5, this.ttf);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.svK);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.svG != null) {
          break;
        }
        throw new b("Not all required fields were included: ToUserName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        awn localawn = (awn)paramVarArgs[1];
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
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localawn.svG = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          localawn.kVs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localawn.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localawn.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localawn.ttf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localawn.svK = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awn
 * JD-Core Version:    0.7.0.1
 */