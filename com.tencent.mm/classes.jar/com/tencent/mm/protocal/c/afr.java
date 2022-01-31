package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class afr
  extends blm
{
  public String iQe;
  public String person_id;
  public String sMC;
  public int scene;
  public bdd tcE;
  public String tdA;
  public int tdD;
  public String tdE;
  public String tdF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.d(2, this.person_id);
      }
      if (this.tdA != null) {
        paramVarArgs.d(3, this.tdA);
      }
      paramVarArgs.gB(4, this.tdD);
      if (this.tdE != null) {
        paramVarArgs.d(5, this.tdE);
      }
      if (this.tdF != null) {
        paramVarArgs.d(6, this.tdF);
      }
      paramVarArgs.gB(7, this.scene);
      if (this.sMC != null) {
        paramVarArgs.d(8, this.sMC);
      }
      if (this.iQe != null) {
        paramVarArgs.d(9, this.iQe);
      }
      if (this.tcE != null)
      {
        paramVarArgs.gD(10, this.tcE.btq());
        this.tcE.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label838;
      }
    }
    label838:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.person_id);
      }
      i = paramInt;
      if (this.tdA != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tdA);
      }
      i += d.a.a.a.gy(4, this.tdD);
      paramInt = i;
      if (this.tdE != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tdE);
      }
      i = paramInt;
      if (this.tdF != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.tdF);
      }
      i += d.a.a.a.gy(7, this.scene);
      paramInt = i;
      if (this.sMC != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sMC);
      }
      i = paramInt;
      if (this.iQe != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.iQe);
      }
      paramInt = i;
      if (this.tcE != null) {
        paramInt = i + d.a.a.a.gA(10, this.tcE.btq());
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
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        afr localafr = (afr)paramVarArgs[1];
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
            localafr.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafr.person_id = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localafr.tdA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localafr.tdD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localafr.tdE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localafr.tdF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localafr.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localafr.sMC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localafr.iQe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bdd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bdd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localafr.tcE = ((bdd)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afr
 * JD-Core Version:    0.7.0.1
 */