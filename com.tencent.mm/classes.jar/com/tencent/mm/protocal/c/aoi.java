package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aoi
  extends com.tencent.mm.bv.a
{
  public String bVO;
  public int ilo;
  public String imz;
  public String ioU;
  public aoh teh;
  public boolean tkb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.imz != null) {
        paramVarArgs.d(1, this.imz);
      }
      if (this.ioU != null) {
        paramVarArgs.d(2, this.ioU);
      }
      if (this.bVO != null) {
        paramVarArgs.d(3, this.bVO);
      }
      paramVarArgs.aA(4, this.tkb);
      paramVarArgs.gB(5, this.ilo);
      if (this.teh != null)
      {
        paramVarArgs.gD(6, this.teh.btq());
        this.teh.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.imz == null) {
        break label509;
      }
    }
    label509:
    for (int i = d.a.a.b.b.a.e(1, this.imz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ioU != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ioU);
      }
      i = paramInt;
      if (this.bVO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bVO);
      }
      i = i + (d.a.a.b.b.a.dQ(4) + 1) + d.a.a.a.gy(5, this.ilo);
      paramInt = i;
      if (this.teh != null) {
        paramInt = i + d.a.a.a.gA(6, this.teh.btq());
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aoi localaoi = (aoi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localaoi.imz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localaoi.ioU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaoi.bVO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaoi.tkb = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 5: 
          localaoi.ilo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aoh();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aoh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaoi.teh = ((aoh)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aoi
 * JD-Core Version:    0.7.0.1
 */