package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class byf
  extends com.tencent.mm.bv.a
{
  public String bGm;
  public boolean dnJ;
  public String fTF;
  public int offset;
  public LinkedList<rb> qTG = new LinkedList();
  public int scene;
  public String tNY;
  public String tOk;
  public String tOl;
  public String tOm;
  public String tOn;
  public long tOo;
  public byg tOp;
  public bse tOq;
  public boolean tOr;
  public LinkedList<byg> tOs = new LinkedList();
  public int tOt;
  public int tOu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tOk != null) {
        paramVarArgs.d(1, this.tOk);
      }
      if (this.tOl != null) {
        paramVarArgs.d(2, this.tOl);
      }
      if (this.tOm != null) {
        paramVarArgs.d(3, this.tOm);
      }
      if (this.tOn != null) {
        paramVarArgs.d(4, this.tOn);
      }
      paramVarArgs.Y(5, this.tOo);
      paramVarArgs.gB(6, this.scene);
      if (this.fTF != null) {
        paramVarArgs.d(7, this.fTF);
      }
      if (this.bGm != null) {
        paramVarArgs.d(8, this.bGm);
      }
      if (this.tOp != null)
      {
        paramVarArgs.gD(9, this.tOp.btq());
        this.tOp.a(paramVarArgs);
      }
      if (this.tOq != null)
      {
        paramVarArgs.gD(10, this.tOq.btq());
        this.tOq.a(paramVarArgs);
      }
      paramVarArgs.d(11, 8, this.qTG);
      if (this.tNY != null) {
        paramVarArgs.d(12, this.tNY);
      }
      paramVarArgs.gB(13, this.offset);
      paramVarArgs.aA(14, this.tOr);
      paramVarArgs.d(15, 8, this.tOs);
      paramVarArgs.gB(16, this.tOt);
      paramVarArgs.gB(17, this.tOu);
      paramVarArgs.aA(18, this.dnJ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tOk == null) {
        break label1344;
      }
    }
    label1344:
    for (int i = d.a.a.b.b.a.e(1, this.tOk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tOl != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tOl);
      }
      i = paramInt;
      if (this.tOm != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tOm);
      }
      paramInt = i;
      if (this.tOn != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tOn);
      }
      i = paramInt + d.a.a.a.X(5, this.tOo) + d.a.a.a.gy(6, this.scene);
      paramInt = i;
      if (this.fTF != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.fTF);
      }
      i = paramInt;
      if (this.bGm != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.bGm);
      }
      paramInt = i;
      if (this.tOp != null) {
        paramInt = i + d.a.a.a.gA(9, this.tOp.btq());
      }
      i = paramInt;
      if (this.tOq != null) {
        i = paramInt + d.a.a.a.gA(10, this.tOq.btq());
      }
      i += d.a.a.a.c(11, 8, this.qTG);
      paramInt = i;
      if (this.tNY != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tNY);
      }
      return paramInt + d.a.a.a.gy(13, this.offset) + (d.a.a.b.b.a.dQ(14) + 1) + d.a.a.a.c(15, 8, this.tOs) + d.a.a.a.gy(16, this.tOt) + d.a.a.a.gy(17, this.tOu) + (d.a.a.b.b.a.dQ(18) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qTG.clear();
        this.tOs.clear();
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
        byf localbyf = (byf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbyf.tOk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbyf.tOl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbyf.tOm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbyf.tOn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbyf.tOo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbyf.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbyf.fTF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbyf.bGm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbyf.tOp = ((byg)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bse();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bse)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbyf.tOq = ((bse)localObject1);
            paramInt += 1;
          }
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbyf.qTG.add(localObject1);
            paramInt += 1;
          }
        case 12: 
          localbyf.tNY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbyf.offset = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localbyf.tOr = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byg();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbyf.tOs.add(localObject1);
            paramInt += 1;
          }
        case 16: 
          localbyf.tOt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localbyf.tOu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbyf.dnJ = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byf
 * JD-Core Version:    0.7.0.1
 */