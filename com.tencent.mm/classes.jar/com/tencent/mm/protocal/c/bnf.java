package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bnf
  extends bly
{
  public String dRQ;
  public String sLy;
  public LinkedList<azp> tGk = new LinkedList();
  public boolean tGl;
  public boolean tGm;
  public int tGn;
  public int tGo;
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
      paramVarArgs.d(11, 8, this.tGk);
      paramVarArgs.aA(12, this.tGl);
      paramVarArgs.aA(13, this.tGm);
      paramVarArgs.gB(14, this.tGn);
      paramVarArgs.gB(15, this.tGo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label994;
      }
    }
    label994:
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
      return paramInt + (d.a.a.b.b.a.dQ(8) + 1) + (d.a.a.b.b.a.dQ(9) + 1) + (d.a.a.b.b.a.dQ(10) + 1) + d.a.a.a.c(11, 8, this.tGk) + (d.a.a.b.b.a.dQ(12) + 1) + (d.a.a.b.b.a.dQ(13) + 1) + d.a.a.a.gy(14, this.tGn) + d.a.a.a.gy(15, this.tGo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tvI.clear();
        this.tGk.clear();
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
        bnf localbnf = (bnf)paramVarArgs[1];
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
            localbnf.tFx = ((gd)localObject1);
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
            localbnf.tvI.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localbnf.dRQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbnf.tvJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbnf.sLy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbnf.tvK = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 9: 
          localbnf.tvL = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 10: 
          localbnf.tvM = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbnf.tGk.add(localObject1);
            paramInt += 1;
          }
        case 12: 
          localbnf.tGl = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 13: 
          localbnf.tGm = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 14: 
          localbnf.tGn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbnf.tGo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnf
 * JD-Core Version:    0.7.0.1
 */