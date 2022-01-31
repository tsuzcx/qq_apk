package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class nd
  extends com.tencent.mm.bv.a
{
  public nc sKP;
  public nc sKQ;
  public nc sKR;
  public nc sKS;
  public nc sKT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sKP != null)
      {
        paramVarArgs.gD(1, this.sKP.btq());
        this.sKP.a(paramVarArgs);
      }
      if (this.sKQ != null)
      {
        paramVarArgs.gD(2, this.sKQ.btq());
        this.sKQ.a(paramVarArgs);
      }
      if (this.sKR != null)
      {
        paramVarArgs.gD(3, this.sKR.btq());
        this.sKR.a(paramVarArgs);
      }
      if (this.sKS != null)
      {
        paramVarArgs.gD(4, this.sKS.btq());
        this.sKS.a(paramVarArgs);
      }
      if (this.sKT != null)
      {
        paramVarArgs.gD(5, this.sKT.btq());
        this.sKT.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sKP == null) {
        break label861;
      }
    }
    label861:
    for (int i = d.a.a.a.gA(1, this.sKP.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sKQ != null) {
        paramInt = i + d.a.a.a.gA(2, this.sKQ.btq());
      }
      i = paramInt;
      if (this.sKR != null) {
        i = paramInt + d.a.a.a.gA(3, this.sKR.btq());
      }
      paramInt = i;
      if (this.sKS != null) {
        paramInt = i + d.a.a.a.gA(4, this.sKS.btq());
      }
      i = paramInt;
      if (this.sKT != null) {
        i = paramInt + d.a.a.a.gA(5, this.sKT.btq());
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        nd localnd = (nd)paramVarArgs[1];
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
            localObject1 = new nc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localnd.sKP = ((nc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localnd.sKQ = ((nc)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localnd.sKR = ((nc)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((nc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localnd.sKS = ((nc)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nc();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((nc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localnd.sKT = ((nc)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nd
 * JD-Core Version:    0.7.0.1
 */