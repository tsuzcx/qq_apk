package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class kp
  extends com.tencent.mm.bv.a
{
  public String hRf;
  public String kRP;
  public bof sFA;
  public kx sFB;
  public kr sFx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hRf == null) {
        throw new b("Not all required fields were included: NickName");
      }
      if (this.sFA == null) {
        throw new b("Not all required fields were included: ContactItem");
      }
      if (this.hRf != null) {
        paramVarArgs.d(1, this.hRf);
      }
      if (this.sFx != null)
      {
        paramVarArgs.gD(2, this.sFx.btq());
        this.sFx.a(paramVarArgs);
      }
      if (this.sFA != null)
      {
        paramVarArgs.gD(3, this.sFA.btq());
        this.sFA.a(paramVarArgs);
      }
      if (this.sFB != null)
      {
        paramVarArgs.gD(4, this.sFB.btq());
        this.sFB.a(paramVarArgs);
      }
      if (this.kRP != null) {
        paramVarArgs.d(5, this.kRP);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hRf == null) {
        break label745;
      }
    }
    label745:
    for (int i = d.a.a.b.b.a.e(1, this.hRf) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sFx != null) {
        paramInt = i + d.a.a.a.gA(2, this.sFx.btq());
      }
      i = paramInt;
      if (this.sFA != null) {
        i = paramInt + d.a.a.a.gA(3, this.sFA.btq());
      }
      paramInt = i;
      if (this.sFB != null) {
        paramInt = i + d.a.a.a.gA(4, this.sFB.btq());
      }
      i = paramInt;
      if (this.kRP != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.kRP);
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
        if (this.hRf == null) {
          throw new b("Not all required fields were included: NickName");
        }
        if (this.sFA != null) {
          break;
        }
        throw new b("Not all required fields were included: ContactItem");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        kp localkp = (kp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localkp.hRf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((kr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localkp.sFx = ((kr)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bof();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bof)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localkp.sFA = ((bof)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((kx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localkp.sFB = ((kx)localObject1);
            paramInt += 1;
          }
        }
        localkp.kRP = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kp
 * JD-Core Version:    0.7.0.1
 */