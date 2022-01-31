package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class byb
  extends com.tencent.mm.bv.a
{
  public String bGm;
  public String bIB;
  public String bVp;
  public int bvj;
  public String fTF;
  public String lJQ;
  public int offset;
  public int pDC;
  public LinkedList<rb> qTG = new LinkedList();
  public String qTP;
  public int scene;
  public String tNY;
  public LinkedList<bye> tNZ = new LinkedList();
  public int tOa;
  public String tOb;
  public String tOc;
  public String tOd;
  public LinkedList<String> tOe = new LinkedList();
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.fTF != null) {
        paramVarArgs.d(1, this.fTF);
      }
      if (this.bIB != null) {
        paramVarArgs.d(2, this.bIB);
      }
      if (this.bVp != null) {
        paramVarArgs.d(3, this.bVp);
      }
      paramVarArgs.gB(4, this.offset);
      if (this.bGm != null) {
        paramVarArgs.d(5, this.bGm);
      }
      paramVarArgs.gB(6, this.scene);
      if (this.url != null) {
        paramVarArgs.d(7, this.url);
      }
      if (this.lJQ != null) {
        paramVarArgs.d(8, this.lJQ);
      }
      paramVarArgs.d(9, 8, this.qTG);
      if (this.tNY != null) {
        paramVarArgs.d(10, this.tNY);
      }
      paramVarArgs.d(11, 8, this.tNZ);
      paramVarArgs.gB(12, this.pDC);
      paramVarArgs.gB(13, this.bvj);
      if (this.qTP != null) {
        paramVarArgs.d(14, this.qTP);
      }
      paramVarArgs.gB(15, this.tOa);
      if (this.tOb != null) {
        paramVarArgs.d(16, this.tOb);
      }
      if (this.tOc != null) {
        paramVarArgs.d(17, this.tOc);
      }
      if (this.tOd != null) {
        paramVarArgs.d(18, this.tOd);
      }
      paramVarArgs.d(19, 1, this.tOe);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fTF == null) {
        break label1265;
      }
    }
    label1265:
    for (int i = d.a.a.b.b.a.e(1, this.fTF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bIB != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bIB);
      }
      i = paramInt;
      if (this.bVp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bVp);
      }
      i += d.a.a.a.gy(4, this.offset);
      paramInt = i;
      if (this.bGm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.bGm);
      }
      i = paramInt + d.a.a.a.gy(6, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.url);
      }
      i = paramInt;
      if (this.lJQ != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.lJQ);
      }
      i += d.a.a.a.c(9, 8, this.qTG);
      paramInt = i;
      if (this.tNY != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tNY);
      }
      i = paramInt + d.a.a.a.c(11, 8, this.tNZ) + d.a.a.a.gy(12, this.pDC) + d.a.a.a.gy(13, this.bvj);
      paramInt = i;
      if (this.qTP != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.qTP);
      }
      i = paramInt + d.a.a.a.gy(15, this.tOa);
      paramInt = i;
      if (this.tOb != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.tOb);
      }
      i = paramInt;
      if (this.tOc != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.tOc);
      }
      paramInt = i;
      if (this.tOd != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.tOd);
      }
      return paramInt + d.a.a.a.c(19, 1, this.tOe);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qTG.clear();
        this.tNZ.clear();
        this.tOe.clear();
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
        byb localbyb = (byb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbyb.fTF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbyb.bIB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbyb.bVp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbyb.offset = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbyb.bGm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbyb.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbyb.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbyb.lJQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbyb.qTG.add(localObject1);
            paramInt += 1;
          }
        case 10: 
          localbyb.tNY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bye();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bye)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbyb.tNZ.add(localObject1);
            paramInt += 1;
          }
        case 12: 
          localbyb.pDC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localbyb.bvj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localbyb.qTP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbyb.tOa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localbyb.tOb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localbyb.tOc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localbyb.tOd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbyb.tOe.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byb
 * JD-Core Version:    0.7.0.1
 */