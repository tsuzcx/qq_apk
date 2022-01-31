package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class azo
  extends bly
{
  public String dRQ;
  public String sLy;
  public LinkedList<azs> tvI = new LinkedList();
  public String tvJ;
  public boolean tvK;
  public boolean tvL;
  public boolean tvM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.d(3, 8, this.tvI);
      if (this.dRQ != null) {
        paramVarArgs.d(4, this.dRQ);
      }
      if (this.tvJ != null) {
        paramVarArgs.d(5, this.tvJ);
      }
      if (this.sLy != null) {
        paramVarArgs.d(6, this.sLy);
      }
      paramVarArgs.aA(8, this.tvK);
      paramVarArgs.aA(9, this.tvL);
      paramVarArgs.aA(10, this.tvM);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label715;
      }
    }
    label715:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(3, 8, this.tvI);
      paramInt = i;
      if (this.dRQ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.dRQ);
      }
      i = paramInt;
      if (this.tvJ != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tvJ);
      }
      paramInt = i;
      if (this.sLy != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sLy);
      }
      return paramInt + (d.a.a.b.b.a.dQ(8) + 1) + (d.a.a.b.b.a.dQ(9) + 1) + (d.a.a.b.b.a.dQ(10) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tvI.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        azo localazo = (azo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 2: 
        case 7: 
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azs();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localazo.tvI.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localazo.dRQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localazo.tvJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localazo.sLy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localazo.tvK = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 9: 
          localazo.tvL = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localazo.tvM = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azo
 * JD-Core Version:    0.7.0.1
 */