package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ko
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String mQp;
  public kr sFx;
  public ks sFy;
  public kl sFz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw == null) {
        throw new b("Not all required fields were included: Title");
      }
      if (this.kRN == null) {
        throw new b("Not all required fields were included: Desc");
      }
      if (this.mQp == null) {
        throw new b("Not all required fields were included: ThumbUrl");
      }
      if (this.sFx == null) {
        throw new b("Not all required fields were included: DetailInfo");
      }
      if (this.sFz == null) {
        throw new b("Not all required fields were included: ActionInfo");
      }
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(2, this.kRN);
      }
      if (this.mQp != null) {
        paramVarArgs.d(3, this.mQp);
      }
      if (this.sFx != null)
      {
        paramVarArgs.gD(4, this.sFx.btq());
        this.sFx.a(paramVarArgs);
      }
      if (this.sFy != null)
      {
        paramVarArgs.gD(5, this.sFy.btq());
        this.sFy.a(paramVarArgs);
      }
      if (this.sFz != null)
      {
        paramVarArgs.gD(6, this.sFz.btq());
        this.sFz.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label904;
      }
    }
    label904:
    for (int i = d.a.a.b.b.a.e(1, this.bGw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kRN);
      }
      i = paramInt;
      if (this.mQp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mQp);
      }
      paramInt = i;
      if (this.sFx != null) {
        paramInt = i + d.a.a.a.gA(4, this.sFx.btq());
      }
      i = paramInt;
      if (this.sFy != null) {
        i = paramInt + d.a.a.a.gA(5, this.sFy.btq());
      }
      paramInt = i;
      if (this.sFz != null) {
        paramInt = i + d.a.a.a.gA(6, this.sFz.btq());
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
        if (this.bGw == null) {
          throw new b("Not all required fields were included: Title");
        }
        if (this.kRN == null) {
          throw new b("Not all required fields were included: Desc");
        }
        if (this.mQp == null) {
          throw new b("Not all required fields were included: ThumbUrl");
        }
        if (this.sFx == null) {
          throw new b("Not all required fields were included: DetailInfo");
        }
        if (this.sFz != null) {
          break;
        }
        throw new b("Not all required fields were included: ActionInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ko localko = (ko)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localko.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localko.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localko.mQp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((kr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localko.sFx = ((kr)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ks();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ks)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localko.sFy = ((ks)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kl();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localko.sFz = ((kl)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ko
 * JD-Core Version:    0.7.0.1
 */