package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class chd
  extends com.tencent.mm.bv.a
{
  public String tVL;
  public cgd tVQ;
  public String tWb;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tVQ == null) {
        throw new b("Not all required fields were included: base_request");
      }
      if (this.tVQ != null)
      {
        paramVarArgs.gD(1, this.tVQ.btq());
        this.tVQ.a(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.tVL != null) {
        paramVarArgs.d(3, this.tVL);
      }
      if (this.tWb != null) {
        paramVarArgs.d(4, this.tWb);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tVQ == null) {
        break label470;
      }
    }
    label470:
    for (int i = d.a.a.a.gA(1, this.tVQ.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.tVL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tVL);
      }
      paramInt = i;
      if (this.tWb != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tWb);
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
        if (this.tVQ != null) {
          break;
        }
        throw new b("Not all required fields were included: base_request");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        chd localchd = (chd)paramVarArgs[1];
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
            localObject1 = new cgd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cgd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localchd.tVQ = ((cgd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localchd.username = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localchd.tVL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localchd.tWb = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chd
 * JD-Core Version:    0.7.0.1
 */