package com.tencent.mm.plugin.product.c;

import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public String dTF;
  public String detail;
  public String mOZ;
  public LinkedList<d> mSE = new LinkedList();
  public int mSF;
  public int mSG;
  public int mSH;
  public LinkedList<String> mSI = new LinkedList();
  public LinkedList<String> mSJ = new LinkedList();
  public LinkedList<b> mSK = new LinkedList();
  public LinkedList<String> mSL = new LinkedList();
  public int mSM;
  public int mSN;
  public LinkedList<m> mSO = new LinkedList();
  public LinkedList<a> mSP = new LinkedList();
  public k mSQ;
  public String name;
  public int version;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      paramVarArgs.d(2, 8, this.mSE);
      paramVarArgs.gB(3, this.mSF);
      paramVarArgs.gB(4, this.mSG);
      paramVarArgs.gB(5, this.mSH);
      paramVarArgs.d(6, 1, this.mSI);
      if (this.dTF != null) {
        paramVarArgs.d(7, this.dTF);
      }
      if (this.detail != null) {
        paramVarArgs.d(8, this.detail);
      }
      paramVarArgs.d(9, 1, this.mSJ);
      paramVarArgs.d(10, 8, this.mSK);
      paramVarArgs.d(11, 1, this.mSL);
      paramVarArgs.gB(12, this.mSM);
      paramVarArgs.gB(13, this.mSN);
      paramVarArgs.d(14, 8, this.mSO);
      paramVarArgs.gB(15, this.version);
      paramVarArgs.d(16, 8, this.mSP);
      if (this.mOZ != null) {
        paramVarArgs.d(17, this.mOZ);
      }
      if (this.mSQ != null)
      {
        paramVarArgs.gD(18, this.mSQ.btq());
        this.mSQ.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label1416;
      }
    }
    label1416:
    for (paramInt = d.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.mSE) + d.a.a.a.gy(3, this.mSF) + d.a.a.a.gy(4, this.mSG) + d.a.a.a.gy(5, this.mSH) + d.a.a.a.c(6, 1, this.mSI);
      paramInt = i;
      if (this.dTF != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.dTF);
      }
      i = paramInt;
      if (this.detail != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.detail);
      }
      i = i + d.a.a.a.c(9, 1, this.mSJ) + d.a.a.a.c(10, 8, this.mSK) + d.a.a.a.c(11, 1, this.mSL) + d.a.a.a.gy(12, this.mSM) + d.a.a.a.gy(13, this.mSN) + d.a.a.a.c(14, 8, this.mSO) + d.a.a.a.gy(15, this.version) + d.a.a.a.c(16, 8, this.mSP);
      paramInt = i;
      if (this.mOZ != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.mOZ);
      }
      i = paramInt;
      if (this.mSQ != null) {
        i = paramInt + d.a.a.a.gA(18, this.mSQ.btq());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mSE.clear();
        this.mSI.clear();
        this.mSJ.clear();
        this.mSK.clear();
        this.mSL.clear();
        this.mSO.clear();
        this.mSP.clear();
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
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localc.name = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new d();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((d)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localc.mSE.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localc.mSF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localc.mSG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localc.mSH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localc.mSI.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 7: 
          localc.dTF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localc.detail = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localc.mSJ.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new b();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((b)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localc.mSK.add(localObject1);
            paramInt += 1;
          }
        case 11: 
          localc.mSL.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 12: 
          localc.mSM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localc.mSN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((m)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localc.mSO.add(localObject1);
            paramInt += 1;
          }
        case 15: 
          localc.version = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new a();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localc.mSP.add(localObject1);
            paramInt += 1;
          }
        case 17: 
          localc.mOZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new k();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((k)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localc.mSQ = ((k)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.c
 * JD-Core Version:    0.7.0.1
 */