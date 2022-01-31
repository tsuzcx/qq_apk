package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bdo
  extends bly
{
  public int bLB;
  public String bLC;
  public int lYn;
  public String qyX;
  public cie tyH;
  public cib tyI;
  public chx tyJ;
  public cic tyK;
  public boolean tyL;
  public LinkedList<String> tyM = new LinkedList();
  public chz tyN;
  
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
      paramVarArgs.gB(2, this.bLB);
      if (this.bLC != null) {
        paramVarArgs.d(3, this.bLC);
      }
      if (this.tyH != null)
      {
        paramVarArgs.gD(4, this.tyH.btq());
        this.tyH.a(paramVarArgs);
      }
      if (this.tyI != null)
      {
        paramVarArgs.gD(5, this.tyI.btq());
        this.tyI.a(paramVarArgs);
      }
      if (this.tyJ != null)
      {
        paramVarArgs.gD(6, this.tyJ.btq());
        this.tyJ.a(paramVarArgs);
      }
      if (this.tyK != null)
      {
        paramVarArgs.gD(7, this.tyK.btq());
        this.tyK.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.lYn);
      paramVarArgs.aA(9, this.tyL);
      if (this.qyX != null) {
        paramVarArgs.d(10, this.qyX);
      }
      paramVarArgs.d(11, 1, this.tyM);
      if (this.tyN != null)
      {
        paramVarArgs.gD(12, this.tyN.btq());
        this.tyN.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1329;
      }
    }
    label1329:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.bLB);
      paramInt = i;
      if (this.bLC != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bLC);
      }
      i = paramInt;
      if (this.tyH != null) {
        i = paramInt + d.a.a.a.gA(4, this.tyH.btq());
      }
      paramInt = i;
      if (this.tyI != null) {
        paramInt = i + d.a.a.a.gA(5, this.tyI.btq());
      }
      i = paramInt;
      if (this.tyJ != null) {
        i = paramInt + d.a.a.a.gA(6, this.tyJ.btq());
      }
      paramInt = i;
      if (this.tyK != null) {
        paramInt = i + d.a.a.a.gA(7, this.tyK.btq());
      }
      i = paramInt + d.a.a.a.gy(8, this.lYn) + (d.a.a.b.b.a.dQ(9) + 1);
      paramInt = i;
      if (this.qyX != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.qyX);
      }
      i = paramInt + d.a.a.a.c(11, 1, this.tyM);
      paramInt = i;
      if (this.tyN != null) {
        paramInt = i + d.a.a.a.gA(12, this.tyN.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tyM.clear();
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
        bdo localbdo = (bdo)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbdo.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbdo.bLB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbdo.bLC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cie();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cie)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbdo.tyH = ((cie)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cib();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cib)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbdo.tyI = ((cib)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbdo.tyJ = ((chx)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cic();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cic)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbdo.tyK = ((cic)localObject1);
            paramInt += 1;
          }
        case 8: 
          localbdo.lYn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbdo.tyL = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 10: 
          localbdo.qyX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbdo.tyM.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chz();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localbdo.tyN = ((chz)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdo
 * JD-Core Version:    0.7.0.1
 */