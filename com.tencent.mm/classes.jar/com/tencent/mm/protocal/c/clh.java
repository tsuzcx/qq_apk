package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class clh
  extends com.tencent.mm.bv.a
{
  public String jnU;
  public String sww;
  public String tXb;
  public String tYA;
  public cla tYB;
  public clg tYC;
  public int tYv;
  public int tYw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tYA == null) {
        throw new b("Not all required fields were included: EntranceDomain");
      }
      if (this.tXb == null) {
        throw new b("Not all required fields were included: Charset");
      }
      if (this.tYA != null) {
        paramVarArgs.d(4, this.tYA);
      }
      if (this.tXb != null) {
        paramVarArgs.d(12, this.tXb);
      }
      if (this.tYB != null)
      {
        paramVarArgs.gD(9, this.tYB.btq());
        this.tYB.a(paramVarArgs);
      }
      if (this.tYC != null)
      {
        paramVarArgs.gD(10, this.tYC.btq());
        this.tYC.a(paramVarArgs);
      }
      if (this.jnU != null) {
        paramVarArgs.d(5, this.jnU);
      }
      if (this.sww != null) {
        paramVarArgs.d(6, this.sww);
      }
      paramVarArgs.gB(7, this.tYv);
      paramVarArgs.gB(8, this.tYw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tYA == null) {
        break label796;
      }
    }
    label796:
    for (int i = d.a.a.b.b.a.e(4, this.tYA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tXb != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tXb);
      }
      i = paramInt;
      if (this.tYB != null) {
        i = paramInt + d.a.a.a.gA(9, this.tYB.btq());
      }
      paramInt = i;
      if (this.tYC != null) {
        paramInt = i + d.a.a.a.gA(10, this.tYC.btq());
      }
      i = paramInt;
      if (this.jnU != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.jnU);
      }
      paramInt = i;
      if (this.sww != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sww);
      }
      return paramInt + d.a.a.a.gy(7, this.tYv) + d.a.a.a.gy(8, this.tYw);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tYA == null) {
          throw new b("Not all required fields were included: EntranceDomain");
        }
        if (this.tXb != null) {
          break;
        }
        throw new b("Not all required fields were included: Charset");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        clh localclh = (clh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        default: 
          return -1;
        case 4: 
          localclh.tYA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localclh.tXb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cla();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cla)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localclh.tYB = ((cla)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localclh.tYC = ((clg)localObject1);
            paramInt += 1;
          }
        case 5: 
          localclh.jnU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localclh.sww = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localclh.tYv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localclh.tYw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.clh
 * JD-Core Version:    0.7.0.1
 */