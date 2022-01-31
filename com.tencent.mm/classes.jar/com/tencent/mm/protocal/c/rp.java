package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class rp
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String kSC;
  public int sPI;
  public LinkedList<awd> sPJ = new LinkedList();
  public int sPK;
  public String sPL;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kRN != null) {
        paramVarArgs.d(1, this.kRN);
      }
      paramVarArgs.gB(2, this.sPI);
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      if (this.kSC != null) {
        paramVarArgs.d(4, this.kSC);
      }
      paramVarArgs.d(5, 8, this.sPJ);
      paramVarArgs.gB(6, this.sPK);
      if (this.sPL != null) {
        paramVarArgs.d(7, this.sPL);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kRN == null) {
        break label559;
      }
    }
    label559:
    for (paramInt = d.a.a.b.b.a.e(1, this.kRN) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sPI);
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bGw);
      }
      i = paramInt;
      if (this.kSC != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kSC);
      }
      i = i + d.a.a.a.c(5, 8, this.sPJ) + d.a.a.a.gy(6, this.sPK);
      paramInt = i;
      if (this.sPL != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sPL);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sPJ.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        rp localrp = (rp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localrp.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localrp.sPI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localrp.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localrp.kSC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((awd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localrp.sPJ.add(localObject1);
            paramInt += 1;
          }
        case 6: 
          localrp.sPK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localrp.sPL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.rp
 * JD-Core Version:    0.7.0.1
 */