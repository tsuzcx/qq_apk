package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class chw
  extends com.tencent.mm.bv.a
{
  public String sBP;
  public bmk sBT;
  public bmk svJ;
  public String tWv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sBT == null) {
        throw new b("Not all required fields were included: KSid");
      }
      if (this.svJ == null) {
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (this.tWv != null) {
        paramVarArgs.d(1, this.tWv);
      }
      if (this.sBT != null)
      {
        paramVarArgs.gD(2, this.sBT.btq());
        this.sBT.a(paramVarArgs);
      }
      if (this.sBP != null) {
        paramVarArgs.d(3, this.sBP);
      }
      if (this.svJ != null)
      {
        paramVarArgs.gD(4, this.svJ.btq());
        this.svJ.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tWv == null) {
        break label596;
      }
    }
    label596:
    for (int i = d.a.a.b.b.a.e(1, this.tWv) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sBT != null) {
        paramInt = i + d.a.a.a.gA(2, this.sBT.btq());
      }
      i = paramInt;
      if (this.sBP != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sBP);
      }
      paramInt = i;
      if (this.svJ != null) {
        paramInt = i + d.a.a.a.gA(4, this.svJ.btq());
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
        if (this.sBT == null) {
          throw new b("Not all required fields were included: KSid");
        }
        if (this.svJ != null) {
          break;
        }
        throw new b("Not all required fields were included: ImgBuf");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        chw localchw = (chw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localchw.tWv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localchw.sBT = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localchw.sBP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localchw.svJ = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chw
 * JD-Core Version:    0.7.0.1
 */