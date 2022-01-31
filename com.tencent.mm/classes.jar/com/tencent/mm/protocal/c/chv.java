package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class chv
  extends com.tencent.mm.bv.a
{
  public String sBP;
  public String sBQ;
  public bmk sBT;
  public String tWv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sBT == null) {
        throw new b("Not all required fields were included: KSid");
      }
      if (this.sBP != null) {
        paramVarArgs.d(1, this.sBP);
      }
      if (this.sBQ != null) {
        paramVarArgs.d(2, this.sBQ);
      }
      if (this.tWv != null) {
        paramVarArgs.d(3, this.tWv);
      }
      if (this.sBT != null)
      {
        paramVarArgs.gD(4, this.sBT.btq());
        this.sBT.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sBP == null) {
        break label470;
      }
    }
    label470:
    for (int i = d.a.a.b.b.a.e(1, this.sBP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sBQ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sBQ);
      }
      i = paramInt;
      if (this.tWv != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tWv);
      }
      paramInt = i;
      if (this.sBT != null) {
        paramInt = i + d.a.a.a.gA(4, this.sBT.btq());
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
        if (this.sBT != null) {
          break;
        }
        throw new b("Not all required fields were included: KSid");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        chv localchv = (chv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localchv.sBP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localchv.sBQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localchv.tWv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localchv.sBT = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chv
 * JD-Core Version:    0.7.0.1
 */