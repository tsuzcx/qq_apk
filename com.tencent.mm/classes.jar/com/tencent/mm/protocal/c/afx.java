package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class afx
  extends blm
{
  public String ssG;
  public String tdL;
  public String tdM;
  public kt tdN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tdL == null) {
        throw new b("Not all required fields were included: FunctionMsgID");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tdL != null) {
        paramVarArgs.d(2, this.tdL);
      }
      if (this.tdM != null) {
        paramVarArgs.d(3, this.tdM);
      }
      if (this.ssG != null) {
        paramVarArgs.d(4, this.ssG);
      }
      if (this.tdN != null)
      {
        paramVarArgs.gD(5, this.tdN.btq());
        this.tdN.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label619;
      }
    }
    label619:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tdL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tdL);
      }
      i = paramInt;
      if (this.tdM != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tdM);
      }
      paramInt = i;
      if (this.ssG != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ssG);
      }
      i = paramInt;
      if (this.tdN != null) {
        i = paramInt + d.a.a.a.gA(5, this.tdN.btq());
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
        if (this.tdL != null) {
          break;
        }
        throw new b("Not all required fields were included: FunctionMsgID");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        afx localafx = (afx)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localafx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafx.tdL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localafx.tdM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localafx.ssG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kt();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localafx.tdN = ((kt)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afx
 * JD-Core Version:    0.7.0.1
 */