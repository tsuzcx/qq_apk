package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class kj
  extends blm
{
  public co sEQ;
  public bya sFh;
  public String sFi;
  public int sFu;
  public String token;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sFh == null) {
        throw new b("Not all required fields were included: tock_mess");
      }
      if (this.sEQ == null) {
        throw new b("Not all required fields were included: after_placeorder_comm_req");
      }
      if (this.token == null) {
        throw new b("Not all required fields were included: token");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sFh != null)
      {
        paramVarArgs.gD(2, this.sFh.btq());
        this.sFh.a(paramVarArgs);
      }
      if (this.sEQ != null)
      {
        paramVarArgs.gD(3, this.sEQ.btq());
        this.sEQ.a(paramVarArgs);
      }
      if (this.sFi != null) {
        paramVarArgs.d(4, this.sFi);
      }
      paramVarArgs.gB(5, this.sFu);
      if (this.token != null) {
        paramVarArgs.d(6, this.token);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label820;
      }
    }
    label820:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sFh != null) {
        paramInt = i + d.a.a.a.gA(2, this.sFh.btq());
      }
      i = paramInt;
      if (this.sEQ != null) {
        i = paramInt + d.a.a.a.gA(3, this.sEQ.btq());
      }
      paramInt = i;
      if (this.sFi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sFi);
      }
      i = paramInt + d.a.a.a.gy(5, this.sFu);
      paramInt = i;
      if (this.token != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.token);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sFh == null) {
          throw new b("Not all required fields were included: tock_mess");
        }
        if (this.sEQ == null) {
          throw new b("Not all required fields were included: after_placeorder_comm_req");
        }
        if (this.token != null) {
          break;
        }
        throw new b("Not all required fields were included: token");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        kj localkj = (kj)paramVarArgs[1];
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
            localkj.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bya();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bya)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localkj.sFh = ((bya)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new co();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((co)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localkj.sEQ = ((co)localObject1);
            paramInt += 1;
          }
        case 4: 
          localkj.sFi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localkj.sFu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localkj.token = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kj
 * JD-Core Version:    0.7.0.1
 */